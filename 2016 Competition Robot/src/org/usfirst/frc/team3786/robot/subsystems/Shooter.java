package org.usfirst.frc.team3786.robot.subsystems;

import org.usfirst.frc.team3786.robot.commands.ShootCommand;
import org.usfirst.frc.team3786.robot.config.robot.RobotConfig;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem{
	
	private Talon shooterWheels;
	private CANJaguar shooterAimMotor;
	
	//**************POSITIONS**************
	public static final double DOWN_POS = 0;
	public static final double UP_POS = 0;
	
	public Shooter() {
		shooterWheels = new Talon(RobotConfig.get().getShooterWheels());
		
		shooterAimMotor = new CANJaguar(RobotConfig.get().ShooterAimLeftChannel());
		
		shooterAimMotor.setPositionMode(CANJaguar.kQuadEncoder, 
				RobotConfig.get().getCODES_PER_REV(), 
				RobotConfig.get().getSHOOTER_P(), 
				RobotConfig.get().getSHOOTER_I(), 
				RobotConfig.get().getSHOOTER_D());
		
		shooterAimMotor.enable();
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
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ShootCommand());
	}

}
