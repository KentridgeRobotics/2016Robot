package org.usfirst.frc.team3786.robot.config.robot;

public class CompetitionRobotConfig extends RobotConfig{
	//***************START***************
	
	//Drive Motors - PWM Channels
	private static final int LEFT_DRIVE_MOTOR = 0;
	private static final int RIGHT_DRIVE_MOTOR = 1;
	
	//Drive PID
	private static final double DRIVE_P = 0;
	private static final double DRIVE_I = 0;
	private static final double DRIVE_D = 0;
	private static final int ENCODER_CODES_PER_REVOLUTION = 360;
	
	//DIO Channels
	private static final int[] LEFT_ENCODER_CHANS = {0,1}; //{A CHANNEL, B CHANNEL}
	private static final int[] RIGHT_ENCODER_CHANS = {2,3};//{A CHANNEL, B CHANNEL}
	
	//Shooter Mechanisms
	private static final int SHOOTER_FLY_WHEEL = 2;
	
	private static final int RELEASE_MECH_LEFT = 3;
	private static final int RELEASE_MECH_RIGHT = 4;
	
	private static final int BALL_ENGAGEMENT = 4;
	
	private static final int ELEVATION_MOTOR = 18;
	
	private static final int ELEVATION_LIMIT_TOP = 0;
	private static final int ELEVATION_LIMIT_BOTTOM = 0;
	
	//Shooter PID
	private static final double SHOOTER_P = 350;
	private static final double SHOOTER_I = 0;
	private static final double SHOOTER_D = 200;
	
	//Lifter Mechanisms
	private static final int LIFT_ONE = 0;
	private static final int LIFT_TWO = 0;
	
	//****************END****************
	
	@Override
	public double getDRIVE_P() {
		return DRIVE_P;
	}
	
	@Override
	public double getDRIVE_I() {
		return DRIVE_I;
	}
	
	@Override
	public double getDRIVE_D() {
		return DRIVE_D;
	}
	
	@Override
	public double getSHOOTER_P() {
		return SHOOTER_P;
	}
	
	@Override
	public double getSHOOTER_I() {
		return SHOOTER_I;
	}
	
	@Override
	public double getSHOOTER_D() {
		return SHOOTER_D;
	}
	
	@Override
	public int getCODES_PER_REV() {
		return ENCODER_CODES_PER_REVOLUTION;
	}
	
	@Override
	public int[] leftEncoderChan() {
		return LEFT_ENCODER_CHANS;
	}
	
	@Override
	public int[] rightEncoderChan() {
		return RIGHT_ENCODER_CHANS;
	}
	
	@Override
	public int getLeftDriveMotor() {
		return LEFT_DRIVE_MOTOR;
	}

	@Override
	public int getRightDriveMotor() {
		return RIGHT_DRIVE_MOTOR;
	}

	@Override
	public int getShooterWheels() {
		return SHOOTER_FLY_WHEEL;
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
	public int ShooterAimChannel() {
		return ELEVATION_MOTOR;
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
