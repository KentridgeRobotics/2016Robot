package org.usfirst.frc.team3786.robot.config.ui;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class TankDrive extends UIConfig{
    
	//*************Button Config*************
	
	private static final int SHOOT_BUTTON = 1;
	private static final int INTAKE_BUTTON = 2;
	
	private static final int AIM_UP_BUTTON = 2;
	private static final int AIM_DOWN_BUTTON = 3;
	
	private static final int INTAKE_POSITION_BUTTON = 4;
	private static final int SHOOT_POSITION_BUTTON= 6;
	
	private static final int STOP_SHOOTER_BUTTON = 4;
	
	private static final int EXTEND_HOOK= 7;
	private static final int PULL_HOOK= 8;
	
	private static final double AIM_INCREMENT = -.15;
	
	//******************END******************
	
	private Joystick leftStick, rightStick;
	
	private JoystickButton shootBallButton;
	private JoystickButton intakeBallButton;
	
	private JoystickButton aimUpButton;
	private JoystickButton aimDownButton;
	
	private JoystickButton intakePositionButton;
	private JoystickButton shootPositionButton;
	
	private JoystickButton stopShooterButton;
	
	public TankDrive() {
		leftStick = new Joystick(0);
		rightStick = new Joystick(1);
		
		shootBallButton = new JoystickButton(rightStick, SHOOT_BUTTON);
		intakeBallButton = new JoystickButton(rightStick, INTAKE_BUTTON);
		
		aimUpButton = new JoystickButton(leftStick, AIM_UP_BUTTON);
		aimDownButton = new JoystickButton(leftStick, AIM_DOWN_BUTTON);
		
		intakePositionButton = new JoystickButton(leftStick, INTAKE_POSITION_BUTTON);
		shootPositionButton = new JoystickButton(leftStick, SHOOT_POSITION_BUTTON);
		
		stopShooterButton = new JoystickButton(rightStick, STOP_SHOOTER_BUTTON);
	}
	
	public Joystick getLeftStick() {
		return leftStick;
	}
	
	public Joystick getRightStick() {
		return rightStick;
	}
	
	@Override
	public double getLeftDrive() {
		return -leftStick.getY();
	}

	@Override
	public double getRightDrive() {
		return rightStick.getY();
	}

	@Override
	public Button shootBallButton() {
		return shootBallButton;
	}

	@Override
	public Button intakeBallButton() {
		return intakeBallButton;
	}
	
	@Override
	public Button aimUpButton() {
		return aimUpButton;
	}

	@Override
	public Button aimDownButton() {
		return aimDownButton;
	}

	@Override
	public Button intakePositionButton() {
		return intakePositionButton;
	}

	@Override
	public Button shootPositionButton() {
		return  shootPositionButton;
	}
	
	@Override
	public Button stopShooterButton() {
		return stopShooterButton;
	}
	
	@Override
	public double getAIM_INCREMENT() {
		return AIM_INCREMENT;
	}
	
	@Override
	public Button extendHookButton() {
		return (new JoystickButton(leftStick, EXTEND_HOOK));
	}

	@Override
	public Button pullHookButton() {
		return (new JoystickButton(leftStick, PULL_HOOK));
	}
}

