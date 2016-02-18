package org.usfirst.frc.team3786.robot.config.ui;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class SingleJoystick extends UIConfig{
	
	//*************Button Config*************
	
	private static final int SHOOT_BUTTON = 1;
	private static final int INTAKE_BUTTON = 2;
	
	private static final int AIM_UP_BUTTON = 3;
	private static final int AIM_DOWN_BUTTON = 5;
	
	private static final int TRAVEL_AIM_BUTTON = 4;
	
	private static final int SHOOT_POSITION_BUTTON= 6;
	private static final int SHOOTER_WHEEL_SPEED_AXIS= 2;
	private static final int EXTEND_HOOK= 7;
	private static final int PULL_HOOK= 8;
	
	private static final double AIM_INCREMENT = -.015;
	//******************END******************
	
	private static final double reductionFactor = 1.0;
	private static double speed, turn;
	
	private Joystick stick;
	
	public SingleJoystick() {
		stick = new Joystick(0);
		
	}
	
	public void update() {
		speed = stick.getX() * reductionFactor;
		turn = -stick.getY() * reductionFactor;
	}
	
	@Override
	public double getLeftDrive() {
		update();
		return speed + turn;
	}

	@Override
	public double getRightDrive() {
		update();
		return speed - turn;
	}

	@Override
	public Button shootBallButton() {
		return (new JoystickButton(stick, SHOOT_BUTTON));
	}

	@Override
	public Button intakeBallButton() {
		return new JoystickButton(stick, INTAKE_BUTTON);
	}
	
	@Override
	public Button aimUpButton() {
		return (new JoystickButton(stick, AIM_UP_BUTTON));
	}

	@Override
	public Button aimDownButton() {
		return (new JoystickButton(stick, AIM_DOWN_BUTTON));
	}

	@Override
	public Button intakePositionButton() {
		return (new JoystickButton(stick, TRAVEL_AIM_BUTTON));
	}

	@Override
	public Button shootPositionButton() {
		return (new JoystickButton(stick, SHOOT_POSITION_BUTTON));
	}

	@Override
	public double getShooterWheelSpeed() {
		return stick.getRawAxis(SHOOTER_WHEEL_SPEED_AXIS);
	}

	@Override
	public double getAIM_INCREMENT() {
		return AIM_INCREMENT;
	}
	
	@Override
	public Button extendHookButton() {
		return (new JoystickButton(stick, EXTEND_HOOK));
	}

	@Override
	public Button pullHookButton() {
		return (new JoystickButton(stick, PULL_HOOK));
	}
}
