package org.usfirst.frc.team3786.robot.subsystems;

import org.usfirst.frc.team3786.robot.commands.shooting.IntakeBall;
import org.usfirst.frc.team3786.robot.config.robot.RobotConfig;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem{
	
	private static Shooter instance;
	
	private static final double SHOOT_SPEED = 0.5;
	private static final double INTAKE_SPEED = 0.3;
	private static DigitalInput haveBall;
	
	private Talon shooterWheels;
		
	public Shooter() {
		shooterWheels = new Talon(RobotConfig.getInstance().getShooterWheels());
		haveBall = new DigitalInput(RobotConfig.getInstance().ballEngagementID());
	}
	
	public static Shooter getInstance() {
		if(instance == null)
			instance = new Shooter();
		return instance;
	}
	
	public void fullSpeedAhead() {
		shooterWheels.set(1);
	}
	
	public DigitalInput checkForBall() {
		return haveBall;
	}
	
	public void spinToIntakeSpeed() {
		shooterWheels.set(INTAKE_SPEED);
	}
	
	public void spinToShootSpeed() {
		shooterWheels.set(SHOOT_SPEED);
	}
	
	public void STOP() {
		shooterWheels.set(0);
	}
		
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new IntakeBall());
	}

}
