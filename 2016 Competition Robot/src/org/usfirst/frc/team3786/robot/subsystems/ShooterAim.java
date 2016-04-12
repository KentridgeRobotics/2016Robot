package org.usfirst.frc.team3786.robot.subsystems;

import org.usfirst.frc.team3786.robot.config.robot.RobotConfig;
import org.usfirst.frc.team3786.robot.config.ui.UIConfig;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The Class that holds methods to aim the shooter
 * @author Manpreet Singh 2016
 */
public class ShooterAim extends Subsystem{

	private static ShooterAim instance;
	
	private CANJaguar aimMotor;
	
	//**************POSITIONS**************
	public static final double DOWN_POS = 0.5;
	public static final double UP_POS = 0.0;
	public static final double SHOOT_POS = 0.2;
	
	private static double currentPosition;
		
	private ShooterAim() {
		
		aimMotor = new CANJaguar(RobotConfig.getInstance().ShooterAimChannel());
		
		aimMotor.setPositionMode(CANJaguar.kPotentiometer,  
				RobotConfig.getInstance().getSHOOTER_P(), 
				RobotConfig.getInstance().getSHOOTER_I(), 
				RobotConfig.getInstance().getSHOOTER_D());
		
		aimMotor.configLimitMode(CANJaguar.LimitMode.SwitchInputsOnly);
		
		aimMotor.enableControl();
	}
	
			
	public static ShooterAim getInstance() {
		if(instance == null)
			instance = new ShooterAim();
		return instance;
	}
	
	/**
	 * Aim Motor getter object for advanced access 
	 * @return The Aim Motor object
	 */
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
	 * <h1>Tells Shooter to retain current position/angle</h1>
	 * <p>
	 * This method of retaining position will only work if the encoder
	 * reading values properly and return them on the controller
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
		
	@Override
	protected void initDefaultCommand() {
		//This line of code is EVIL, it's sheared like 2 sets of gearbox pins, I'm gonna leave it here for shits and giggles
		//setDefaultCommand(new ShooterAimCommand(ShooterAimCommand.Mode.RETAIN_POSITION));
	}
}
