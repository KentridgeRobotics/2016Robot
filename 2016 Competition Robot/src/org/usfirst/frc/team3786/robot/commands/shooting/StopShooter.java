package org.usfirst.frc.team3786.robot.commands.shooting;

import org.usfirst.frc.team3786.robot.subsystems.ReleaseMechanism;
import org.usfirst.frc.team3786.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This Command is meant to interrupt the SpinToShootSpeed, ReleaseBall, and Intake Commands.
 * Ergo, it stops those commands from running
 * @author Manpreet Singh 2016
 */
public class StopShooter extends Command {
	
	public StopShooter() {
		requires(Shooter.getInstance());
		requires(ReleaseMechanism.getInstance());
	}
	
	protected void initialize() {
		System.out.println("Trying to STOP");
		Shooter.getInstance().STOP();
		ReleaseMechanism.getInstance().retract();
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}

}
