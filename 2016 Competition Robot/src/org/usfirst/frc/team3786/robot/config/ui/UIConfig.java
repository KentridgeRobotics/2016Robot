package org.usfirst.frc.team3786.robot.config.ui;

import edu.wpi.first.wpilibj.Joystick;

public abstract class UIConfig {
	private static UIConfig instance;
	
	public static UIConfig get() {
		if(instance == null)
			instance = new SingleJoystick();
		return instance;
	}
	
	public abstract Joystick getStickOne();
	
	public abstract Joystick getStickTwo();
}
