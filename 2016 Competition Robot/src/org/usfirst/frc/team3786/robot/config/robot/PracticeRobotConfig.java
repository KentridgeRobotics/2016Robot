package org.usfirst.frc.team3786.robot.config.robot;

public class PracticeRobotConfig extends RobotConfig{
	//***************START***************
	
	//Drive Motors
	private static final int LEFT_DRIVE_MOTOR_ONE = 0;
	private static final int LEFT_DRIVE_MOTOR_TWO = 0;
	
	private static final int RIGHT_DRIVE_MOTOR_ONE = 0;
	private static final int RIGHT_DRIVE_MOTOR_TWO = 0;
	
	//Drive PID
	private static final int DRIVE_P = 0;
	private static final int DRIVE_I = 0;
	private static final int DRIVE_D = 0;
	private static final int ENCODER_CODES_PER_REVOLUTION = 360;
	
	//Shooter Mechanisms
	private static final int LEFT_SHOOTER_FLY_WHEEL = 0;
	private static final int RIGHT_SHOOTER_FLY_WHEEL =0;
	
	private static final int RELEASE_MECH_LEFT = 0;
	private static final int RELEASE_MECH_RIGHT = 0;
	
	private static final int BALL_ENGAGEMENT = 0;
	private static final int BALL_RELEASE = 0;
	
	private static final int ELEVATION_LEFT = 0;
	private static final int ELEVATION_RIGHT = 0;
	
	private static final int ELEVATION_LIMIT_TOP = 0;
	private static final int ELEVATION_LIMIT_BOTTOM = 0;
	
	//Shooter PID
	private static final int SHOOTER_P = 0;
	private static final int SHOOTER_I = 0;
	private static final int SHOOTER_D = 0;
	
	//Lifter Mechanisms
	private static final int LIFT_ONE = 0;
	private static final int LIFT_TWO = 0;
	
	//****************END****************
	
	@Override
	public int getDRIVE_P() {
		return DRIVE_P;
	}
	
	@Override
	public int getDRIVE_I() {
		return DRIVE_I;
	}
	
	@Override
	public int getDRIVE_D() {
		return DRIVE_D;
	}
	
	@Override
	public int getSHOOTER_P() {
		return SHOOTER_P;
	}
	
	@Override
	public int getSHOOTER_I() {
		return SHOOTER_I;
	}
	
	@Override
	public int getSHOOTER_D() {
		return SHOOTER_D;
	}
	
	@Override
	public int getCODES_PER_REV() {
		return ENCODER_CODES_PER_REVOLUTION;
	}
	
	@Override
	public int getLeftDriveMotorOne() {
		return LEFT_DRIVE_MOTOR_ONE;
	}

	@Override
	public int getLeftDriveMotorTwo() {
		return LEFT_DRIVE_MOTOR_TWO;
	}

	@Override
	public int getRightDriveMotorOne() {
		return RIGHT_DRIVE_MOTOR_ONE;
	}

	@Override
	public int getRightDriveMotorTwo() {
		return RIGHT_DRIVE_MOTOR_TWO;
	}

	@Override
	public int getLeftShooterFlyWheel() {
		return LEFT_SHOOTER_FLY_WHEEL;
	}

	@Override
	public int getRightShooterFlyWheel() {
		return RIGHT_SHOOTER_FLY_WHEEL;
	}

	@Override
	public int releaseServoLeft() {
		return RELEASE_MECH_LEFT;
	}

	@Override
	public int releaseServoRight() {
		return RELEASE_MECH_RIGHT;
	}

	@Override
	public int ballEngagementID() {
		return BALL_ENGAGEMENT;
	}

	@Override
	public int ShooterAimRightChannel() {
		return ELEVATION_RIGHT;
	}

	@Override
	public int ShooterAimLeftChannel() {
		return ELEVATION_LEFT;
	}

	@Override
	public int elevatationUpperLimitID() {
		return ELEVATION_LIMIT_TOP;
	}

	@Override
	public int elevatationBottomLimitID() {
		return ELEVATION_LIMIT_BOTTOM;
	}

	@Override
	public int getLiftOneChan() {
		return LIFT_ONE;
	}

	@Override
	public int getLifttwoChan() {
		return LIFT_TWO;
	}
		
}
