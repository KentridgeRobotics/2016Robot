package org.usfirst.frc.team3786.robot.commands.shooting;

import org.usfirst.frc.team3786.robot.subsystems.ShooterAim;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Class/Command to move the shooter all the way UP, or to the 'Travel Position'
 * @author Manpreet Singh 2016
 */
public class GoToTravelPosition extends Command {
	
	public GoToTravelPosition() {
		requires(ShooterAim.getInstance());
	}
	
	protected void initialize() {
	}

	protected void execute() {
		ShooterAim.getInstance().moveUp();
	}

	protected boolean isFinished() {
		return !ShooterAim.getInstance().motor().getForwardLimitOK();
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
