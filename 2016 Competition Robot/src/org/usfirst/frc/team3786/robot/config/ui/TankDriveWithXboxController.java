package org.usfirst.frc.team3786.robot.config.ui;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TankDriveWithXboxController extends UIConfig{
	
	//*************Button Config*************
	
	private static final int SHOOTER_AXIS = 3;
	private static final int RELEASE_BALL_BUTTON = 6;
	private static final int INTAKE_AXIS = 2;
		
	private static final int AIM_UP_BUTTON = 4;
	private static final int AIM_DOWN_BUTTON = 1;
	
	private static final int INTAKE_POSITION_BUTTON = 2;
	private static final int SHOOT_POSITION_BUTTON = 7;
	private static final int TRAVEL_POSITION_BUTTON = 3;
	
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
		
		leftStick = new Joystick(0);
		rightStick = new Joystick(1);
		xbox = new Joystick(0);
		
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
		return releaseBallButton;
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
	public double getShootSpeed() {
		return xbox.getRawAxis(SHOOTER_AXIS);
	}

	@Override
	public double getIntakeSpeed() {
		return xbox.getRawAxis(INTAKE_AXIS);
	}

}
