package org.usfirst.frc.team3786.robot.config.ui;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TankDriveWithXboxController extends UIConfig{
	
	//*************Button Config*************
	
	private static final int SHOOTER_AXIS = 0;
	private static final int RELEASE_BALL_BUTTON = 0;
	private static final int INTAKE_AXIS = 0;
	
	private static final int STOP_SHOOTER_BUTTON = 0;
	
	private static final int AIM_UP_BUTTON = 0;
	private static final int AIM_DOWN_BUTTON = 0;
	
	private static final int INTAKE_POSITION_BUTTON = 0;
	private static final int SHOOT_POSITION_BUTTON = 0;
	private static final int TRAVEL_POSITION_BUTTON = 0;
	
	private static final double AIM_INCREMENT = -.005;
	//******************END******************
	
	Joystick leftStick, rightStick, xbox;
	
	private JoystickButton releaseBallButton;
	
	private JoystickButton aimUpButton;
	private JoystickButton aimDownButton;
	
	private JoystickButton intakePositionButton;
	private JoystickButton shootPositionButton;
	private JoystickButton travelPositionButton;
	
	private static double leftOut, rightOut;
	
	public TankDriveWithXboxController() {
		releaseBallButton = new JoystickButton(xbox, RELEASE_BALL_BUTTON);
		
		aimUpButton = new JoystickButton(xbox, AIM_UP_BUTTON);
		aimDownButton = new JoystickButton(xbox, AIM_DOWN_BUTTON);
		
		intakePositionButton = new JoystickButton(xbox, INTAKE_POSITION_BUTTON);
		shootPositionButton = new JoystickButton(xbox, SHOOT_POSITION_BUTTON);
		travelPositionButton = new JoystickButton(xbox, TRAVEL_POSITION_BUTTON);
	}
	
	@Override
	public Joystick getLeftStick() {
		return leftStick;
	}
	
	public Joystick getRightStick() {
		return rightStick;
	}
	
	@Override
	public double getLeftDrive() {
		leftOut = -leftStick.getY();
		SmartDashboard.putNumber("Left Stick", leftOut);
		return Math.tan((Math.PI/4) * leftOut);
	}

	@Override
	public double getRightDrive() {
		rightOut = rightStick.getY();
		SmartDashboard.putNumber("Right Out", rightOut);
		return Math.tan((Math.PI/4) * rightOut);
	}

	@Override
	public Button shootBallButton() {
		return null;
	}

	@Override
	public Button intakeBallButton() {
		return null;
	}

	@Override
	public Button spinToShooterSpeed() {
		return null;
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
		return shootPositionButton;
	}

	@Override
	public Button travelPositionButton() {
		return travelPositionButton;
	}

	@Override
	public Button stopShooterButton() {
		return null;
	}

	@Override
	public double getAIM_INCREMENT() {
		return AIM_INCREMENT;
	}

	@Override
	public Button extendHookButton() {
		return null;
	}

	@Override
	public Button pullHookButton() {
		return null;
	}

	@Override
	public double getShootSpeed() {
		return xbox.getRawAxis(SHOOTER_AXIS);
	}

	@Override
	public double getIntakeSpeed() {
		return xbox.getRawAxis(INTAKE_AXIS);
	}

}
