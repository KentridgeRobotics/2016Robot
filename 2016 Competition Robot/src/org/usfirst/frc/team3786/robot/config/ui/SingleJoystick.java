//package org.usfirst.frc.team3786.robot.config.ui;
//
//import javax.swing.text.Position;
//
//import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.buttons.Button;
//import edu.wpi.first.wpilibj.buttons.JoystickButton;
//
//public class SingleJoystick extends UIConfig{
//	
//	//*************Button Config*************
//	
//	private static final int SHOOT_BUTTON = 1;
//	private static final int INTAKE_BUTTON = 2;
//	
//	private static final int AIM_UP_BUTTON = 3;
//	private static final int AIM_DOWN_BUTTON = 5;
//	
//	private static final int INTAKE_POSITION_BUTTON = 4;
//	private static final int SHOOT_POSITION_BUTTON= 6;
//	
//	private static final int STOP_SHOOTER_BUTTON = 4;
//	
//	private static final int EXTEND_HOOK= 7;
//	private static final int PULL_HOOK= 8;
//	
//	private static final double AIM_INCREMENT = -.015;
//	//******************END******************
//	
//	private static final double reductionFactor = 1.0;
//	private static double speed, turn;
//	
//	private Joystick stick;
//	
//	private JoystickButton shootBallButton;
//	private JoystickButton intakeBallButton;
//	
//	private JoystickButton aimUpButton;
//	private JoystickButton aimDownButton;
//	
//	private JoystickButton intakePositionButton;
//	private JoystickButton shootPositionButton;
//	
//	private JoystickButton stopShooterButton;
//	
//	public SingleJoystick() {
//		stick = new Joystick(0);
//		
//		shootBallButton = new JoystickButton(stick, SHOOT_BUTTON);
//		intakeBallButton = new JoystickButton(stick, INTAKE_BUTTON);
//		
//		aimUpButton = new JoystickButton(stick, AIM_UP_BUTTON);
//		aimDownButton = new JoystickButton(stick, AIM_DOWN_BUTTON);
//		
//		intakePositionButton = new JoystickButton(stick, INTAKE_POSITION_BUTTON);
//		shootPositionButton = new JoystickButton(stick, SHOOT_POSITION_BUTTON);
//		
//		stopShooterButton = new JoystickButton(stick, STOP_SHOOTER_BUTTON);
//	}
//	
//	public void update() {
//		speed = stick.getX() * reductionFactor;
//		turn = -stick.getY() * reductionFactor;
//	}
//		
//	@Override
//	public double getLeftDrive() {
//		update();
//		return speed + turn;
//	}
//
//	@Override
//	public double getRightDrive() {
//		update();
//		return speed - turn;
//	}
//
//	@Override
//	public Button shootBallButton() {
//		return shootBallButton;
//	}
//
//	@Override
//	public Button intakeBallButton() {
//		return intakeBallButton;
//	}
//	
//	@Override
//	public Button aimUpButton() {
//		return aimUpButton;
//	}
//
//	@Override
//	public Button aimDownButton() {
//		return aimDownButton;
//	}
//
//	@Override
//	public Button intakePositionButton() {
//		return intakePositionButton;
//	}
//
//	@Override
//	public Button shootPositionButton() {
//		return shootPositionButton;
//	}
//	
//	@Override
//	public Button stopShooterButton() {
//		return stopShooterButton;
//	}
//	
//	@Override
//	public double getAIM_INCREMENT() {
//		return AIM_INCREMENT;
//	}
//	
//	@Override
//	public Button extendHookButton() {
//		return (new JoystickButton(stick, EXTEND_HOOK));
//	}
//
//	@Override
//	public Button pullHookButton() {
//		return (new JoystickButton(stick, PULL_HOOK));
//	}
//}
