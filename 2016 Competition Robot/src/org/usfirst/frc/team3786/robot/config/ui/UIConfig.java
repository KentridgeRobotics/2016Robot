package org.usfirst.frc.team3786.robot.config.ui;

import edu.wpi.first.wpilibj.buttons.Button;

/**
 * UIConfig is where we declare abstract methods for different button
 * We then call these methods from main file and bind commands to them
 * @author Manpreet Singh 2016
 */
public abstract class UIConfig {
	private static UIConfig instance;
		
	public static UIConfig getInstance() {
		if(instance == null)
			instance = new SingleJoystick();
		return instance;
	}
	
	//*************Config START*************
	
	public abstract double getLeftDrive();
	public abstract double getRightDrive();
	
	public abstract Button shootBallButton();
	public abstract Button intakeBallButton();
	
	public abstract Button aimUpButton();
	public abstract Button aimDownButton();
	
	public abstract Button intakePositionButton();
	public abstract Button shootPositionButton();
	
	public abstract double getShooterWheelSpeed();
	public abstract double getAIM_INCREMENT();
	
	public abstract Button extendHookButton();
	public abstract Button pullHookButton();
}
