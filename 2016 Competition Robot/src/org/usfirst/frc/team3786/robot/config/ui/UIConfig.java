package org.usfirst.frc.team3786.robot.config.ui;

public abstract class UIConfig {
	private static UIConfig instance;
	
	public static UIConfig get() {
		if(instance == null)
			instance = new SingleJoystick();
		return instance;
	}
	
	public abstract double getLeftDrive();
	public abstract double getRightDrive();
}
