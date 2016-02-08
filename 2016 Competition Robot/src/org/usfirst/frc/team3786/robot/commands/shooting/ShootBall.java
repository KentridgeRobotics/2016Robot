package org.usfirst.frc.team3786.robot.commands.shooting;

import org.usfirst.frc.team3786.robot.subsystems.Shooter;
import org.usfirst.frc.team3786.robot.subsystems.ShooterAim;

import edu.wpi.first.wpilibj.command.Command;

public class ShootBall extends  Command{
	
	public ShootBall() {
		requires(Shooter.getInstance());
		requires(ShooterAim.getInstance());
	}
	
	@Override
	protected void initialize() {
		if(Shooter.getInstance().checkForBall().get())
			Shooter.getInstance().STOP();
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
