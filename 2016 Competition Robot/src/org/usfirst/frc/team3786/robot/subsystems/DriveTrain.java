
package org.usfirst.frc.team3786.robot.subsystems;

import org.usfirst.frc.team3786.robot.commands.drive.Drive;
import org.usfirst.frc.team3786.robot.config.robot.RobotConfig;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This Class holds methods to control the drive train
 * @author Manpreet Singh 2016
 */
public class DriveTrain extends Subsystem {
    	
	private static DriveTrain instance;
	
	private Jaguar leftMotor, rightMotor;
	
	public DriveTrain() {
		
		leftMotor = new Jaguar(RobotConfig.getInstance().getLeftDriveMotor());
		
		rightMotor = new Jaguar(RobotConfig.getInstance().getRightDriveMotor());
	}
		
	
	public static DriveTrain getInstance() {
		if(instance == null)
			instance = new DriveTrain();
		return instance;
	}
	
	public void drive(double left_speed, double right_speed) {		
		leftMotor.set(left_speed);
		rightMotor.set(right_speed);
	}
		
	/**
	 * Stop the robot
	 */
	public void STOP() {
		leftMotor.set(0);
		rightMotor.set(0);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new Drive());
    }
}

