package org.usfirst.frc.team3786.robot.config.ui;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TankDrive extends UIConfig{
    
	//*************Button Config*************
	
	/* Right Joystick */
	private static final int SHOOT_BUTTON = 1;
	private static final int INTAKE_BUTTON = 2;
	
	private static final int STOP_SHOOTER_BUTTON = 4;
	
	private static final int EXTEND_HOOK= 7;
	private static final int PULL_HOOK= 8;
	
	
	/* Left Joystick */
	private static final int AIM_UP_BUTTON = 5;
	private static final int AIM_DOWN_BUTTON = 3;
	
	private static final int INTAKE_POSITION_BUTTON = 4;
	private static final int SHOOT_POSITION_BUTTON= 6;
	private static final int TRAVEL_POSITION_BUTTON = 2;
	
	private static final double AIM_INCREMENT = -.05;
	//******************END******************
	
	private Joystick leftStick, rightStick;
	
	private JoystickButton shootBallButton;
	private JoystickButton intakeBallButton;
	
	private JoystickButton spinToShooterSpeed;
	
	private JoystickButton aimUpButton;
	private JoystickButton aimDownButton;
	
	private JoystickButton intakePositionButton;
	private JoystickButton shootPositionButton;
	private JoystickButton travelPositionButton;
	
	private JoystickButton stopShooterButton;
	
	private static double leftOut, rightOut;
	
	//private static final double reductionFactor = 0.85;
	
	public TankDrive() {
		leftStick = new Joystick(0);
		rightStick = new Joystick(1);
		
		shootBallButton = new JoystickButton(rightStick, SHOOT_BUTTON);
		intakeBallButton = new JoystickButton(rightStick, INTAKE_BUTTON);
		spinToShooterSpeed = new JoystickButton(leftStick, 1);
		
		aimUpButton = new JoystickButton(leftStick, AIM_UP_BUTTON);
		aimDownButton = new JoystickButton(leftStick, AIM_DOWN_BUTTON);
		
		intakePositionButton = new JoystickButton(rightStick, INTAKE_POSITION_BUTTON);
		shootPositionButton = new JoystickButton(rightStick, SHOOT_POSITION_BUTTON);
		travelPositionButton = new JoystickButton(leftStick, TRAVEL_POSITION_BUTTON);
		
		stopShooterButton = new JoystickButton(leftStick, STOP_SHOOTER_BUTTON);
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
	public Button shootBallButton() {
		return shootBallButton;
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
		return (new JoystickButton(leftStick, EXTEND_HOOK));
	}

	@Override
	public Button pullHookButton() {
		return (new JoystickButton(leftStick, PULL_HOOK));
	}

	@Override
	public double getShootSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getIntakeSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}
}

