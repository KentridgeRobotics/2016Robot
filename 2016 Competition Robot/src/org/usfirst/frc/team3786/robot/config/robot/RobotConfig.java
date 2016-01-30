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
			instance = new PracticeRobotConfig();
		return instance;
	}
	
	//***************Drive PID Values***************
	public abstract int getDRIVE_P();
	public abstract int getDRIVE_I();
	public abstract int getDRIVE_D();
	public abstract int getCODES_PER_REV();
	
	//************Shooter AIM PID Values************
	public abstract int getSHOOTER_P();
	public abstract int getSHOOTER_I();
	public abstract int getSHOOTER_D();
	
	
	//************Motor Channels and IDS************
	
	//------------Drive Motor IDs------------
	public abstract int getLeftDriveMotorOne();
	public abstract int getLeftDriveMotorTwo();
	
	public abstract int getRightDriveMotorOne();
	public abstract int getRightDriveMotorTwo();
	
	
	//-------Shooter Mechanism Channels-------
	public abstract int getLeftShooterFlyWheel();
	public abstract int getRightShooterFlyWheel();
		
	public abstract int releaseServoLeft();
	public abstract int releaseServoRight();
	
	public abstract int ballEngagementID();
	
	//------Shooter Elevation Mechanisms------
	public abstract int ShooterAimRightChannel();
	public abstract int ShooterAimLeftChannel();
	
	public abstract int elevatationUpperLimitID();
	public abstract int elevatationBottomLimitID();
	
	//-------------Lift Mechanism-------------
	public abstract int getLiftOneChan();
	public abstract int getLifttwoChan();
	
	
}
