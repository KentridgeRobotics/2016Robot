package org.usfirst.frc.team3786.robot.commands.shooting;

import org.usfirst.frc.team3786.robot.subsystems.ReleaseMechanism;
import org.usfirst.frc.team3786.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

public class ShootBall extends Command{
	
	public ShootBall() {
		requires(ReleaseMechanism.getInstance());
	}
	
	@Override
	protected void initialize() {
		//Shooter.getInstance().spinToShootSpeed();
		ReleaseMechanism.getInstance().extend();
		System.out.println("Trying to Shoot Ball");
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		ReleaseMechanism.getInstance().retract();
	}

	@Override
	protected void interrupted() {
		ReleaseMechanism.getInstance().retract();
	}
}
