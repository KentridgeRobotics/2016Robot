package org.usfirst.frc.team3786.robot.config.ui;

import edu.wpi.first.wpilibj.buttons.Button;

public abstract class UIConfig {
	private static UIConfig instance;
		
	public static UIConfig get() {
		if(instance == null)
			instance = new SingleJoystick();
		return instance;
	}
	
	//*************Config START*************
	
	public abstract double getLeftDrive();
	public abstract double getRightDrive();
	
	public abstract Button shootButton();
	public abstract Button aimUpButton();
	public abstract Button aimDownButton();
	public abstract Button travelAimButton();
	public abstract Button shootPositionButton();
	
	public abstract double getShooterWheelSpeed();
	public abstract double getAIM_INCREMENT();
	
	public abstract Button extendHookButton();
	public abstract Button pullHookButton();
}
