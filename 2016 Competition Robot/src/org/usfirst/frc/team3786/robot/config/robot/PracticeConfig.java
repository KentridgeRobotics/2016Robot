package org.usfirst.frc.team3786.robot.config.robot;

public class PracticeConfig extends RobotConfig{
	
	//Drive Motors
	private final int LEFT_DRIVE_MOTOR_ONE = 0;
	private final int LEFT_DRIVE_MOTOR_TWO = 0;
	
	private final int RIGHT_DRIVE_MOTOR_ONE = 0;
	private final int RIGHT_DRIVE_MOTOR_TWO = 0;
	
	
	//Shooter Mechanisms
	private final int LEFT_SHOOTER_FLY_WHEEL = 0;
	private final int RIGHT_SHOOTER_FLY_WHEEL =0;
	
	private final int RELEASE_MECH_LEFT = 0;
	private final int RELEASE_MECH_RIGHT = 0;
	
	private final int BALL_ENGAGEMENT = 0;
	private final int BALL_RELEASE = 0;
	
	private final int ELEVATION_LEFT = 0;
	private final int ELEVATION_RIGHT = 0;
	
	private final int ELEVATION_LIMIT_TOP = 0;
	private final int ELEVATION_LIMIT_BOTTOM = 0;
	
	//Lifter Mechanisms
	private final int LIFT_ONE = 0;
	private final int LIFT_TWO = 0;
	
	@Override
	public int getLeftDriveMotorOne() {
		return LEFT_DRIVE_MOTOR_ONE;
	}

	@Override
	public int getLeftDriveMotorTwo() {
		return LEFT_DRIVE_MOTOR_TWO;
	}

	@Override
	public int getRighDrivetMotorOne() {
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
	public int elevatationRightChannel() {
		return ELEVATION_RIGHT;
	}

	@Override
	public int elevatationLeftChannel() {
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
