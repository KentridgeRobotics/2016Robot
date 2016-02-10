
package org.usfirst.frc.team3786.robot.subsystems;

import org.usfirst.frc.team3786.robot.commands.drive.Drive;
import org.usfirst.frc.team3786.robot.config.robot.RobotConfig;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
    
	private static final double ACCEL_FACTOR = 1.0;
	
	private static DriveTrain instance;
	private static long lastLoop = System.currentTimeMillis();
	private static double currentValue;
	
	private Jaguar leftMotor, rightMotor;
	
	private Encoder leftEncoder, rightEncoder;
	
	public DriveTrain() {
		currentValue = 0.0;
		leftEncoder = new Encoder(RobotConfig.getInstance().leftEncoderChan()[0], 
				RobotConfig.getInstance().leftEncoderChan()[1]);
		
		rightEncoder = new Encoder(RobotConfig.getInstance().rightEncoderChan()[0],
				RobotConfig.getInstance().rightEncoderChan()[1]);
		
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
	
	public void rampDrive(double left_speed, double right_speed) {
		leftMotor.set(ramp(left_speed));
		rightMotor.set(ramp(right_speed));
	}
	
	//TODO Test This
	public double ramp(double desiredValue) {
		long currentLoop = System.currentTimeMillis();
		double delta = (double)(lastLoop - currentLoop)/1000.0;
		double error = desiredValue - currentValue;
		currentValue += error*delta*ACCEL_FACTOR;
		if((currentValue > desiredValue && error > 0) || (currentValue < desiredValue && error < 0))
			currentValue = desiredValue;
		return currentValue;
	}
	
	/**
	 * Get distance traveled by the left side of robot
	 */
	public double getLeftDistance() {
		return leftEncoder.getDistance();
	}
	
	/**
	 * Get distance traveled by the right side of robot
	 */
	public double getRightDistance() {
		return rightEncoder.getDistance();
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

