package org.usfirst.frc.team3786.robot.commands.shooting;

import org.usfirst.frc.team3786.robot.subsystems.ReleaseMechanism;
import org.usfirst.frc.team3786.robot.subsystems.Shooter;
import org.usfirst.frc.team3786.robot.subsystems.ShooterAim;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeBall extends Command{
	
	public IntakeBall() {
		requires(Shooter.getInstance());
		requires(ShooterAim.getInstance());
		requires(ReleaseMechanism.getInstance());
	}
	
	@Override
	protected void initialize() {
		ReleaseMechanism.getInstance().retract();
		ShooterAim.getInstance().intakePosition();
	}

	@Override
	protected void execute() {
		Shooter.getInstance().spinToIntakeSpeed();
	}

	@Override
	protected boolean isFinished() {
		return Shooter.getInstance().checkForBall().get();
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
