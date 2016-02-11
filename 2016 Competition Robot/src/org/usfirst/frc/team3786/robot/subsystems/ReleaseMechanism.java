package org.usfirst.frc.team3786.robot.subsystems;

import org.usfirst.frc.team3786.robot.commands.shooting.ShootBall;
import org.usfirst.frc.team3786.robot.config.robot.RobotConfig;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ReleaseMechanism extends Subsystem{
	
	private static boolean isExtended;
	
	private Servo[] releaseServo = new Servo[2];
	private static ReleaseMechanism instance;
	
	
	public ReleaseMechanism() {
		releaseServo[0] = new Servo(RobotConfig.getInstance().releaseServoLeft());
		releaseServo[1] = new Servo(RobotConfig.getInstance().releaseServoRight());
		
		releaseServo[0].set(90);
		releaseServo[1].set(90);
		isExtended = false;
	}
	
	public static ReleaseMechanism getInstance() {
		if(instance == null)
			instance = new ReleaseMechanism();
		return instance;
	}
	
	/**
	 * Retract the release mechanism
	 */
	public void retract() {
		releaseServo[0].set(90);
		releaseServo[1].set(90);
		isExtended = true;
	}
	
	/**
	 * Extend the release mechanism
	 */
	public void extend() {
		releaseServo[0].set(0);
		releaseServo[1].set(180);
		isExtended = false;
	}
	
	/**
	 * @return True if extended, false if retracted
	 */
	public boolean isExtended() {
		return isExtended;
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ShootBall());
	}
}