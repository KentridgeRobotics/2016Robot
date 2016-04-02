package org.usfirst.frc.team3786.robot.config.ui;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TankDriveWithShooterControlBox extends UIConfig{
	
	//*************Button Config*************
	
	private static final int SPIN_SHOOTER_BUTTON = 4;
	private static final int RELEASE_BALL_BUTTON = 9;
	private static final int INTAKE_BUTTON = 8;
	
	private static final int STOP_SHOOTER_BUTTON = 5;
	
	private static final int EXTEND_HOOK= 0;
	private static final int RETRACT_HOOK= 0;
	
	private static final int AIM_UP_BUTTON = 7;
	private static final int AIM_DOWN_BUTTON = 6;
	
	private static final int INTAKE_POSITION_BUTTON = 3;
	private static final int SHOOT_POSITION_BUTTON = 2;
	private static final int TRAVEL_POSITION_BUTTON = 1;
	
	private static final double AIM_INCREMENT = -.05;
	//******************END******************
	
	private Joystick leftStick, rightStick, shooterControlBox;
	
	private JoystickButton releaseBallButton;
	private JoystickButton spinToShooterSpeed;
	private JoystickButton intakeBallButton;
	
	private JoystickButton aimUpButton;
	private JoystickButton aimDownButton;
	
	private JoystickButton intakePositionButton;
	private JoystickButton shootPositionButton;
	private JoystickButton travelPositionButton;
	
	private JoystickButton stopShooterButton;
	
	private JoystickButton extendHook;
	private JoystickButton retractHook;
	
	private static double leftOut, rightOut;
	
	public TankDriveWithShooterControlBox() {
		
		leftStick = new Joystick(0);
		rightStick = new Joystick(1);
		shooterControlBox = new Joystick(2);
		
		releaseBallButton = new JoystickButton(shooterControlBox, RELEASE_BALL_BUTTON);
		spinToShooterSpeed = new JoystickButton(shooterControlBox, SPIN_SHOOTER_BUTTON);
		intakeBallButton = new JoystickButton(shooterControlBox, INTAKE_BUTTON);
		
		aimUpButton = new JoystickButton(shooterControlBox, AIM_UP_BUTTON);
		aimDownButton = new JoystickButton(shooterControlBox, AIM_DOWN_BUTTON);
		
		intakePositionButton = new JoystickButton(shooterControlBox, INTAKE_POSITION_BUTTON);
		shootPositionButton = new JoystickButton(shooterControlBox, SHOOT_POSITION_BUTTON);
		travelPositionButton = new JoystickButton(shooterControlBox, TRAVEL_POSITION_BUTTON);
		
		stopShooterButton = new JoystickButton(shooterControlBox, STOP_SHOOTER_BUTTON);
		
		extendHook = new JoystickButton(leftStick, EXTEND_HOOK);
		retractHook = new JoystickButton(rightStick, RETRACT_HOOK);
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
		return intakeBallButton;
	}
	
	@Override
	public Button spinToShooterSpeed() {
		return spinToShooterSpeed;
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
	public Button travelPositionButton() {
		return travelPositionButton;
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
		return extendHook;
	}

	@Override
	public Button pullHookButton() {
		return retractHook;
	}
}
