package org.usfirst.frc.team3786.robot.config.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public abstract class RobotConfig {
	
	public static RobotConfig instance;
	
	public static RobotConfig get() {
		if(instance == null)
			instance = new PracticeConfig();
		return instance;
	}
	
	//------------Drive Motor IDs------------
	public abstract int getLeftDriveMotorOne();
	public abstract int getLeftDriveMotorTwo();
	
	public abstract int getRighDrivetMotorOne();
	public abstract int getRightDriveMotorTwo();
	
	
	//-------Shooter Mechanism Channels-------
	public abstract int getLeftShooterFlyWheel();
	public abstract int getRightShooterFlyWheel();
		
	public abstract int releaseServoLeft();
	public abstract int releaseServoRight();
	
	public abstract int ballEngagementID();
	
	//------Shooter Elevation Mechanisms------
	public abstract int elevatationRightChannel();
	public abstract int elevatationLeftChannel();
	
	public abstract int elevatationUpperLimitID();
	public abstract int elevatationBottomLimitID();
	
	//-------------Lift Mechanism-------------
	public abstract int getLiftOneChan();
	public abstract int getLifttwoChan();
	
	
}
