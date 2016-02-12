package org.usfirst.frc.team3786.robot.commands.shooting;

import org.usfirst.frc.team3786.robot.subsystems.ReleaseMechanism;
import org.usfirst.frc.team3786.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

public class ShootBall extends Command{
	
	public ShootBall() {
		requires(Shooter.getInstance());
		requires(ReleaseMechanism.getInstance());
	}
	
	@Override
	protected void initialize() {
		if(ReleaseMechanism.getInstance().isExtended())
			ReleaseMechanism.getInstance().retract();
		Shooter.getInstance().spinToShootSpeed();
	}

	@Override
	protected void execute() {
		ReleaseMechanism.getInstance().extend();
		if(!Shooter.getInstance().checkForBall().get()) {
			Shooter.getInstance().STOP();
			ReleaseMechanism.getInstance().retract();
		}
	}

	@Override
	protected boolean isFinished() {
		if(!Shooter.getInstance().wheelsSpinning() && !ReleaseMechanism.getInstance().isExtended())
			return true;
		else return false;
	}

	@Override
	protected void end() {
		Shooter.getInstance().STOP();
		ReleaseMechanism.getInstance().retract();
	}

	@Override
	protected void interrupted() {
		Shooter.getInstance().STOP();
		ReleaseMechanism.getInstance().retract();
	}
}
