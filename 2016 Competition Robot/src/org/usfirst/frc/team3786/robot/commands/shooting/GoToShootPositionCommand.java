package org.usfirst.frc.team3786.robot.commands.shooting;

import org.usfirst.frc.team3786.robot.subsystems.ShooterAim;

import edu.wpi.first.wpilibj.command.Command;

public class GoToShootPositionCommand extends Command{
	
	public GoToShootPositionCommand() {
		requires(ShooterAim.getInstance());
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		ShooterAim.getInstance().moveDown();
	}

	@Override
	protected boolean isFinished() {
		return ShooterAim.getInstance().atShootPosition();
	}

	@Override
	protected void end() {
		ShooterAim.getInstance().retainCurrentPosition();
	}

	@Override
	protected void interrupted() {
		ShooterAim.getInstance().retainCurrentPosition();
	}
}
