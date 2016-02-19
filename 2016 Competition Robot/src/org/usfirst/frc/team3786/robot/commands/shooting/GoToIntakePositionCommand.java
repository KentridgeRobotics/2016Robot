package org.usfirst.frc.team3786.robot.commands.shooting;

import org.usfirst.frc.team3786.robot.subsystems.ShooterAim;

import edu.wpi.first.wpilibj.command.Command;

public class GoToIntakePositionCommand extends Command{
	
	public GoToIntakePositionCommand() {
		requires(ShooterAim.getInstance());
	}
	
	@Override
	protected void initialize() {
		ShooterAim.getInstance();
		ShooterAim.getInstance().intakePosition();
	}

	@Override
	protected void execute() {
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
