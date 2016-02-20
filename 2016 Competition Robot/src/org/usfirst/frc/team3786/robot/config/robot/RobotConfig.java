package org.usfirst.frc.team3786.robot.config.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public abstract class RobotConfig {
	
	private static RobotConfig instance;
	
	public static RobotConfig getInstance() {
		if(instance == null)
			instance = new PracticeRobotConfig();
		return instance;
	}
	
	//***************Drive PID Values***************
	public abstract double getDRIVE_P();
	public abstract double getDRIVE_I();
	public abstract double getDRIVE_D();
	public abstract int getCODES_PER_REV();
	public abstract int[] leftEncoderChan();
	public abstract int[] rightEncoderChan();
	
	//************Shooter AIM PID Values************
	public abstract double getSHOOTER_P();
	public abstract double getSHOOTER_I();
	public abstract double getSHOOTER_D();
	
	
	//************Motor Channels and IDS************
	
	//------------Drive Motor IDs------------
	public abstract int getLeftDriveMotor();
	
	public abstract int getRightDriveMotor();
	
	
	//-------Shooter Mechanism Channels-------
	public abstract int getShooterWheels();
		
	public abstract int releaseServoLeft();
	public abstract int releaseServoRight();
	
	public abstract int ballEngagementID();
	
	//------Shooter Elevation Mechanisms------
	public abstract int ShooterAimChannel();
	
	public abstract int elevatationUpperLimitID();
	public abstract int elevatationBottomLimitID();
	
	//-------------Lift Mechanism-------------
	public abstract int getLiftOneChan();
	public abstract int getLifttwoChan();
	
}
