package org.usfirst.frc.team3786.robot.config.ui;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *  Tank Drive with an Xbox Controller for Shooter Control
 * @author Manpreet Singh 2016
 */
public class TankDriveWithXboxControl extends UIConfig{
	//*************Button Config*************
	
	private static final int AIM_UP_BUTTON = 4;
	private static final int AIM_DOWN_BUTTON = 1;
	
	private static final int SHOOT_BALL = 6;
	
	private static final int INTAKE_POSITION_BUTTON = 2;
	private static final int SHOOT_POSITION_BUTTON= 8;
	private static final int TRAVEL_POSITION_BUTTON = 3;
	
	private static final double AIM_INCREMENT = -.008;
	//******************END******************
	
	private Joystick leftStick, rightStick, xbox;
	
	
	private JoystickButton aimUpButton;
	private JoystickButton aimDownButton;
	
	private JoystickButton intakePositionButton;
	private JoystickButton shootPositionButton;
	private JoystickButton travelPositionButton;
	
	private JoystickButton shootBall;
	
	private static double leftOut, rightOut;
	
	//private static final double reductionFactor = 0.85;
	
	public TankDriveWithXboxControl() {
		leftStick = new Joystick(0);
		rightStick = new Joystick(1);
		xbox = new Joystick(2);
		
		aimUpButton = new JoystickButton(xbox, AIM_UP_BUTTON);
		aimDownButton = new JoystickButton(xbox, AIM_DOWN_BUTTON);
		
		shootBall = new JoystickButton(xbox, SHOOT_BALL);
		
		intakePositionButton = new JoystickButton(xbox, INTAKE_POSITION_BUTTON);
		shootPositionButton = new JoystickButton(xbox, SHOOT_POSITION_BUTTON);
		travelPositionButton = new JoystickButton(xbox, TRAVEL_POSITION_BUTTON);
		
	}
	
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
	public double getAIM_INCREMENT() {
		return AIM_INCREMENT;
	}

	@Override
	public double getShootSpeed() {
		return xbox.getRawAxis(2);
	}

	@Override
	public double getIntakeSpeed() {
		return xbox.getRawAxis(3);
	}

	@Override
	public Button shootBall() {
		return shootBall;
	}
}
