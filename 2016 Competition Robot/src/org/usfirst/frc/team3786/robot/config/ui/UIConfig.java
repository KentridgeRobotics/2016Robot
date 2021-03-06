package org.usfirst.frc.team3786.robot.config.ui;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

/**
 * UIConfig is where we declare abstract methods for different button
 * We then call these methods from main file and bind commands to them
 * @author Manpreet Singh 2016
 */
public abstract class UIConfig {
	private static UIConfig instance;
		
	public static UIConfig getInstance() {
		if(instance == null){
			instance = new TankDriveWithXboxControl();
		}
		return instance;
	}
	
	//*************Config START*************
	//Joystick Objects for Advanced access
	public abstract Joystick getLeftStick();
	public abstract Joystick getRightStick();
	
	//Throttles for the Left and Right side
	public abstract double getLeftDrive();
	public abstract double getRightDrive();
	
	//Shooter Control Button
	
	public abstract Button shootBall();
	
	//Buttons to Aim the Shooter
	public abstract Button aimUpButton();
	public abstract Button aimDownButton();
	
	public abstract Button intakePositionButton();
	public abstract Button shootPositionButton();
	public abstract Button travelPositionButton();
	
	public abstract double getShootSpeed();
	public abstract double getIntakeSpeed();
	
	//Stop the whole shooter Button
	public abstract double getAIM_INCREMENT();
}
