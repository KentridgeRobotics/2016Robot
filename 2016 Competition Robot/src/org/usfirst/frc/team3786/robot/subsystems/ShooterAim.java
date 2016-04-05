package org.usfirst.frc.team3786.robot.subsystems;

import org.usfirst.frc.team3786.robot.commands.shooting.ShooterAimCommand;
import org.usfirst.frc.team3786.robot.config.robot.RobotConfig;
import org.usfirst.frc.team3786.robot.config.ui.UIConfig;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This Class holds methods to aim the shooter
 * @author Manpreet Singh 2016
 */
public class ShooterAim extends Subsystem{
		
	private static ShooterAim instance;
	
	private static DigitalInput[] switches;
	
	private static int activeSwitch, currentSwitch;
	
	private CANJaguar aimMotor;
	//**************POSITIONS**************
	public static final double DOWN_POS = 0.5;
	public static final double UP_POS = 0.0;
	public static final double SHOOT_POS = 0.3;
	
	private static double currentPosition;
	
	private static DigitalInput aimSwitch;
	
	private ShooterAim() {
		aimSwitch = new DigitalInput(5);
		
		switches = new DigitalInput[RobotConfig.getInstance().numSwitches()];
		
		aimMotor = new CANJaguar(RobotConfig.getInstance().ShooterAimChannel());
		
		aimMotor.setPositionMode(CANJaguar.kQuadEncoder, 
				RobotConfig.getInstance().getCODES_PER_REV(), 
				RobotConfig.getInstance().getSHOOTER_P(), 
				RobotConfig.getInstance().getSHOOTER_I(), 
				RobotConfig.getInstance().getSHOOTER_D());
		
		aimMotor.configLimitMode(CANJaguar.LimitMode.SwitchInputsOnly);
		
		aimMotor.enableControl();
	}
	
	public int getActiveSwitch() {
		for(int i = 0; i < switches.length; i++) {
			if(switches[i].get())
				activeSwitch = i;
			else continue;
		}
		return activeSwitch;
	}
	
	public void goToSwitch(int desiredSwitch) {
		if(desiredSwitch < 0)
			return;
		else {
			if(desiredSwitch > currentSwitch)
				move(0.0);
			else if(desiredSwitch < currentSwitch)
				move(0.0);
		}
	}
	
	public void move(double foo) {
		aimMotor.set(foo);
	}
	
	public static ShooterAim getInstance() {
		if(instance == null)
			instance = new ShooterAim();
		return instance;
	}
	public CANJaguar motor() {
		return aimMotor;
	}
	/**
	 * @param position The position we want the shooter to be
	 */
	public void setPosition(double position) {
		aimMotor.set(position);
		currentPosition = position;
	}
	
	/**
	 * Move the shooter up
	 */
	public void moveUp() {
		aimMotor.setP(RobotConfig.getInstance().getSHOOTER_P_UP());
		aimMotor.setD(RobotConfig.getInstance().getSHOOTER_D_UP());
		setPosition(getCurrentPosition() - UIConfig.getInstance().getAIM_INCREMENT());
	}
	
	/**
	 * Move the shooter to the user defined Shoot position
	 */
	public void shootPosition() {
		setPosition(SHOOT_POS);
	}
	
	/**
	 * Move the shooter down
	 */
	public void moveDown() {
		aimMotor.setP(RobotConfig.getInstance().getSHOOTER_P_DOWN());
		aimMotor.setD(RobotConfig.getInstance().getSHOOTER_D_DOWN());
		setPosition(getCurrentPosition() + UIConfig.getInstance().getAIM_INCREMENT());
	}
	
	/**
	 * Tells Shooter to retain current position/angle
	 */
	public void retainCurrentPosition() {
		aimMotor.set(currentPosition);
	}
	
	/**
	 * @return The current Position of the shooter
	 */
	public double getPosition() {
		currentPosition = aimMotor.getPosition();
		return aimMotor.getPosition();
	}
	
	public boolean getForwardLimit() {
		return aimMotor.getForwardLimitOK();
	}
	
	public boolean getBackLimit() {
		return aimMotor.getReverseLimitOK();
	}
	
	public double getCurrentPosition() {
		return currentPosition;
	}
	
	public double getOutputVoltage() {
		return aimMotor.getOutputVoltage();
	}
	
	public boolean atShootPosition() {
		return !aimSwitch.get();
	}
	
	@Override
	protected void initDefaultCommand() {
		//This piece of code is VERY EVIL, It's sheared like 2 gear boxes, I left it here for shits and giggles
		//setDefaultCommand(new ShooterAimCommand(ShooterAimCommand.Mode.RETAIN_POSITION));
	}
}
