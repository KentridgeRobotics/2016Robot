package org.usfirst.frc.team3786.robot.commands.shooting;

import org.usfirst.frc.team3786.robot.subsystems.ShooterAim;

import edu.wpi.first.wpilibj.command.Command;

public class GoToTravelPosition extends Command {
	
	public GoToTravelPosition() {
		requires(ShooterAim.getInstance());
	}
	
	protected void initialize() {
	}

	protected void execute() {
		ShooterAim.getInstance().setPosition(ShooterAim.getInstance().getPosition() - .1);
	}

	protected boolean isFinished() {
		return !ShooterAim.getInstance().motor().getReverseLimitOK();
	}

	protected void end() {
		// TODO Auto-generated method stub

	}

	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
