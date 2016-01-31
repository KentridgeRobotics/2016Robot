
package org.usfirst.frc.team3786.robot.subsystems;

import org.usfirst.frc.team3786.robot.commands.Drive;
import org.usfirst.frc.team3786.robot.config.robot.RobotConfig;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
    
	private static DriveTrain instance;
	
	private CANJaguar	leftMotorOne, 
						leftMotorTwo, 
						rightMotorOne, 
						rightMotorTwo;
	
		public DriveTrain() {
			
			leftMotorOne = new CANJaguar(RobotConfig.get().getLeftDriveMotorOne());
			leftMotorTwo = new CANJaguar(RobotConfig.get().getLeftDriveMotorTwo());
			
			leftMotorOne.setPositionMode(CANJaguar.kQuadEncoder, 
					RobotConfig.get().getCODES_PER_REV(),
					RobotConfig.get().getDRIVE_P(), 
					RobotConfig.get().getDRIVE_I(), 
					RobotConfig.get().getDRIVE_D());
			
			leftMotorTwo.setPositionMode(CANJaguar.kQuadEncoder, 
					RobotConfig.get().getCODES_PER_REV(),
					RobotConfig.get().getDRIVE_P(), 
					RobotConfig.get().getDRIVE_I(), 
					RobotConfig.get().getDRIVE_D());
			
			
			rightMotorOne = new CANJaguar(RobotConfig.get().getRightDriveMotorOne());
			rightMotorTwo = new CANJaguar(RobotConfig.get().getRightDriveMotorTwo());
			
			rightMotorOne.setPositionMode(CANJaguar.kQuadEncoder, 
					RobotConfig.get().getCODES_PER_REV(),
					RobotConfig.get().getDRIVE_P(), 
					RobotConfig.get().getDRIVE_I(), 
					RobotConfig.get().getDRIVE_D());
			
			rightMotorTwo.setPositionMode(CANJaguar.kQuadEncoder, 
					RobotConfig.get().getCODES_PER_REV(),
					RobotConfig.get().getDRIVE_P(), 
					RobotConfig.get().getDRIVE_I(), 
					RobotConfig.get().getDRIVE_D());
			
			leftMotorOne.enable();
			leftMotorTwo.enable();
			
			rightMotorOne.enable();
			rightMotorOne.enable();
	}
	
	public static DriveTrain get() {
		if(instance == null)
			instance = new DriveTrain();
		return instance;
	}
	
	public void setDrivePos(double left_position, double right_position) {		
		leftMotorOne.set(left_position);
		leftMotorOne.set(left_position);
		
		rightMotorOne.set(right_position);
		rightMotorOne.set(right_position);
	}
	
	public double getLeftPosition() {
		return leftMotorOne.getPosition();
	}
	
	public double getRightPosition() {
		return rightMotorOne.getPosition();
	}
		
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new Drive());
    }
}

