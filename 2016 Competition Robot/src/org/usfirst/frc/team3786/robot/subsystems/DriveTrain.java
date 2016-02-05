
package org.usfirst.frc.team3786.robot.subsystems;

import org.usfirst.frc.team3786.robot.commands.Drive;
import org.usfirst.frc.team3786.robot.config.robot.RobotConfig;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
    
	private static DriveTrain instance;
	
	private Jaguar leftMotor, rightMotor;
	
	private Encoder leftEncoder, rightEncoder;
	
	public DriveTrain() {
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
	
	public double getLeftDistance() {
		return leftEncoder.getDistance();
	}
	
	public double getRightDistance() {
		return rightEncoder.getDistance();
	}
	
	public void STOP() {
		leftMotor.set(0);
		
		rightMotor.set(0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new Drive());
    }
}

