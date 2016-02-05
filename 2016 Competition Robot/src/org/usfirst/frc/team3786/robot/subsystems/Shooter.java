package org.usfirst.frc.team3786.robot.subsystems;

import org.usfirst.frc.team3786.robot.commands.AimUpCommand;
import org.usfirst.frc.team3786.robot.config.robot.RobotConfig;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem{
	
	private static Shooter instance;
	
	private Talon shooterWheels;
	private CANJaguar shooterAimMotor;
	
	//**************POSITIONS**************
	public static final double DOWN_POS = 0;
	public static final double UP_POS = 0;
	
	public Shooter() {
		shooterWheels = new Talon(RobotConfig.getInstance().getShooterWheels());
		
		shooterAimMotor = new CANJaguar(RobotConfig.getInstance().ShooterAimChannel());
		
		shooterAimMotor.setPositionMode(CANJaguar.kQuadEncoder, 
				RobotConfig.getInstance().getCODES_PER_REV(), 
				RobotConfig.getInstance().getSHOOTER_P(), 
				RobotConfig.getInstance().getSHOOTER_I(), 
				RobotConfig.getInstance().getSHOOTER_D());
		
		shooterAimMotor.enable();
	}
	
	public static Shooter getInstance() {
		if(instance == null)
			instance = new Shooter();
		return instance;
	}
	
	public void setShooterWheelSpeed(double speed) {
		shooterWheels.set(speed);
	}
	
	public void setShooterAimPosition(double position) {
		shooterAimMotor.set(position);
	}
	
	public double getShooterAimPosition() {
		return shooterAimMotor.getPosition();
	}
	
	public void goToDown() {
		shooterAimMotor.set(DOWN_POS);
	}
	
	public void goToUp() {
		shooterAimMotor.set(UP_POS);
	}
	
	public void stopShooterWheels() {
		shooterWheels.set(0);
	}
	
	public void stopAimMotor() {
		shooterAimMotor.set(getShooterAimPosition());
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new AimUpCommand());
	}

}
