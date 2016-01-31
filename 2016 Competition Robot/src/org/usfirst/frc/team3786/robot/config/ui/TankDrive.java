package org.usfirst.frc.team3786.robot.config.ui;

import edu.wpi.first.wpilibj.Joystick;

public class TankDrive extends UIConfig{
    
	private Joystick leftStick, rightStick;
	
	public TankDrive() {
		leftStick = new Joystick(0);
		rightStick = new Joystick(1);
	}

	@Override
	public double getLeftDrive() {
		return leftStick.getY();
	}

	@Override
	public double getRightDrive() {
		return rightStick.getY();
	}
	
}

