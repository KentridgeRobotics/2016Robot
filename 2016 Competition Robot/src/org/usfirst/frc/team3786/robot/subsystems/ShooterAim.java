package org.usfirst.frc.team3786.robot.subsystems;

import org.usfirst.frc.team3786.robot.config.robot.RobotConfig;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ShooterAim extends Subsystem{

	private static ShooterAim instance;
	
	private CANJaguar aimMotor;
	
	//**************POSITIONS**************
	public static final double DOWN_POS = 0;
	public static final double UP_POS = 0;
	public static final double SHOOT_POS = 0;
		
	public ShooterAim() {
		aimMotor = new CANJaguar(RobotConfig.getInstance().ShooterAimChannel());
		
		aimMotor.setPositionMode(CANJaguar.kQuadEncoder, 
				RobotConfig.getInstance().getCODES_PER_REV(), 
				RobotConfig.getInstance().getSHOOTER_P(), 
				RobotConfig.getInstance().getSHOOTER_I(), 
				RobotConfig.getInstance().getSHOOTER_D());
		
		aimMotor.enable();
	}
	
	public static ShooterAim getInstance() {
		if(instance == null)
			instance = new ShooterAim();
		return instance;
	}
	
	public void setPosition(double position) {
		aimMotor.set(position);
	}
	
	public void upPosition() {
		aimMotor.set(UP_POS);
	}
	
	public void shootPosition() {
		aimMotor.set(SHOOT_POS);
	}
	
	public void intakePosition() {
		aimMotor.set(DOWN_POS);
	}
	
	public void retainCurrentPosition() {
		aimMotor.set(aimMotor.getPosition());
	}
	
	public double getPosition() {
		return aimMotor.getPosition();
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}
