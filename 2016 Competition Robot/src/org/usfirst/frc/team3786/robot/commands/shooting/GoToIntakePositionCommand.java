package org.usfirst.frc.team3786.robot.commands.shooting;

import org.usfirst.frc.team3786.robot.subsystems.ShooterAim;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Class/Command to move the shooter all the way down, or to the 'Intake Position'
 * @author Manpreet Singh 2016
 */
public class GoToIntakePositionCommand extends Command{
	
	public GoToIntakePositionCommand() {
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
		return !ShooterAim.getInstance().motor().getReverseLimitOK();
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
