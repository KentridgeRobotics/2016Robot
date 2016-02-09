package org.usfirst.frc.team3786.robot.commands.shooting;

import org.usfirst.frc.team3786.robot.subsystems.ShooterAim;

import edu.wpi.first.wpilibj.command.Command;

public class GoToShootPositionCommand extends Command{
	
	public GoToShootPositionCommand() {
		requires(ShooterAim.getInstance());
	}
	
	@Override
	protected void initialize() {
		ShooterAim.getInstance();
	}

	@Override
	protected void execute() {
		ShooterAim.getInstance().shootPosition();
	}

	@Override
	protected boolean isFinished() {
		if(ShooterAim.getInstance().getPosition() == ShooterAim.SHOOT_POS)
			return true;
		else
			return false;
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
