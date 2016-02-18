package org.usfirst.frc.team3786.robot.subsystems;

import org.usfirst.frc.team3786.robot.commands.shooting.ShooterAimCommand;
import org.usfirst.frc.team3786.robot.config.robot.RobotConfig;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This Class holds methods to aim the shooter
 * @author Manpreet Singh 2016
 */
public class ShooterAim extends Subsystem{

	private static ShooterAim instance;
	
	private CANJaguar aimMotor;
	
	//**************POSITIONS**************
	public static final double DOWN_POS = 0;
	public static final double UP_POS = 0;
	public static final double SHOOT_POS = 0;
		
	private ShooterAim() {
		aimMotor = new CANJaguar(RobotConfig.getInstance().ShooterAimChannel());
		
		aimMotor.setPositionMode(CANJaguar.kQuadEncoder, 
				RobotConfig.getInstance().getCODES_PER_REV(), 
				RobotConfig.getInstance().getSHOOTER_P(), 
				RobotConfig.getInstance().getSHOOTER_I(), 
				RobotConfig.getInstance().getSHOOTER_D());
		
		aimMotor.enableControl();
	}
	
	public static ShooterAim getInstance() {
		if(instance == null)
			instance = new ShooterAim();
		return instance;
	}
	
	/**
	 * @param position The position we want the shooter to be
	 */
	public void setPosition(double position) {
		aimMotor.set(position);
	}
	
	/**
	 * Move the shooter to the user defined UP position
	 */
	public void upPosition() {
		aimMotor.set(UP_POS);
	}
	
	/**
	 * Move the shooter to the user defined Shoot position
	 */
	public void shootPosition() {
		aimMotor.set(SHOOT_POS);
	}
	
	/**
	 * Move the shooter to the user defined intake position
	 */
	public void intakePosition() {
		aimMotor.set(DOWN_POS);
	}
	
	/**
	 * Tells Shooter to retain current position/angle
	 */
	public void retainCurrentPosition() {
		aimMotor.set(aimMotor.getPosition());
	}
	
	/**
	 * @return The current Position of the shooter
	 */
	public double getPosition() {
		return aimMotor.getPosition();
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new ShooterAimCommand());
	}
}
