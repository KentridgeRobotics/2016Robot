package org.usfirst.frc.team3786.robot.commands.auto;

import org.usfirst.frc.team3786.robot.subsystems.ShooterAim;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousShooterCommand extends Command{
	
	private double position;
	
	public AutonomousShooterCommand(double position) {
		this.position = position;
		
		requires(ShooterAim.getInstance());
	}
	
	@Override
	protected void initialize() {
		ShooterAim.getInstance().setPosition(this.position);
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
	}

	@Override
	protected void interrupted() {
	}
}
