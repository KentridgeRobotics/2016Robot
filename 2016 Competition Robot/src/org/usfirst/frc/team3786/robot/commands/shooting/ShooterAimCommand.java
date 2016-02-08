package org.usfirst.frc.team3786.robot.commands.shooting;

import org.usfirst.frc.team3786.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

public class ShooterAimCommand extends Command{
	
	private static boolean goUp;
	
	public ShooterAimCommand(boolean goUp) {
		this.goUp = goUp;
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		requires(Shooter.getInstance());
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		Shooter.getInstance().stopShooterWheels();
	}

	@Override
	protected void interrupted() {
		Shooter.getInstance().stopShooterWheels();
	}

}
