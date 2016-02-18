package org.usfirst.frc.team3786.robot.commands.shooting;

import org.usfirst.frc.team3786.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

public class SpinToShootSpeed extends Command {
	
	public SpinToShootSpeed() {
		requires(Shooter.getInstance());
	}
	
	protected void initialize() {
		Shooter.getInstance().spinToShootSpeed();
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Shooter.getInstance().STOP();
	}

	protected void interrupted() {
		end();
	}

}
