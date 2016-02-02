package org.usfirst.frc.team3786.robot.commands;

import org.usfirst.frc.team3786.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

public class AimDownCommand extends Command{

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		requires(Shooter.getInstance());
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		Shooter.getInstance().setShooterAimPosition(Shooter.getInstance().getShooterAimPosition());
	}

}
