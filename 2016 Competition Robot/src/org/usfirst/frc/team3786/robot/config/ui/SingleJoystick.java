package org.usfirst.frc.team3786.robot.config.ui;

import edu.wpi.first.wpilibj.Joystick;

public class SingleJoystick extends UIConfig{
	
	private static final double reductionFactor = 1.0;
	private static double speed, turn;
	
	private Joystick stick;
	
	public SingleJoystick() {
		stick = new Joystick(0);
		speed = stick.getX() * reductionFactor;
		turn = stick.getY() * reductionFactor;
	}
	
	@Override
	public double getLeftDrive() {
		return speed + turn;
	}

	@Override
	public double getRightDrive() {
		return speed - turn;
	}

}
