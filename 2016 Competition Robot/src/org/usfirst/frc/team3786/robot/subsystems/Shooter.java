package org.usfirst.frc.team3786.robot.subsystems;

import org.usfirst.frc.team3786.robot.commands.shooting.IntakeBall;
import org.usfirst.frc.team3786.robot.config.robot.RobotConfig;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem{
	
	private static Shooter instance;
	
	private Talon shooterWheels;
	
	//**************POSITIONS**************
	public static final double DOWN_POS = 0;
	public static final double UP_POS = 0;
	
	public Shooter() {
		shooterWheels = new Talon(RobotConfig.getInstance().getShooterWheels());
	}
	
	public static Shooter getInstance() {
		if(instance == null)
			instance = new Shooter();
		return instance;
	}
	
	public void setShooterWheelSpeed(double speed) {
		shooterWheels.set(speed);
	}
		
	public void stopShooterWheels() {
		shooterWheels.set(0);
	}
		
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new IntakeBall());
	}

}
