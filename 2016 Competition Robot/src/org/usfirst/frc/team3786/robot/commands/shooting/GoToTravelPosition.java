package org.usfirst.frc.team3786.robot.commands.shooting;

import org.usfirst.frc.team3786.robot.subsystems.ShooterAim;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This Command moves the shooter to Travel position, other wise known as the UP position
 * @author Manpreet Singh 2016
 *
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
