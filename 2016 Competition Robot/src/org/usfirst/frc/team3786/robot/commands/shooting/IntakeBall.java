package org.usfirst.frc.team3786.robot.commands.shooting;

import org.usfirst.frc.team3786.robot.subsystems.ReleaseMechanism;
import org.usfirst.frc.team3786.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Class/Command to intake a ball by spinning the shooter wheels inwards
 * @author Manpreet Singh 2016
 */
public class IntakeBall extends Command{
	
	public IntakeBall() {
		requires(Shooter.getInstance());
		requires(ReleaseMechanism.getInstance());
	}
	
	@Override
	protected void initialize() {
		Shooter.getInstance().spinToIntakeSpeed();
		System.out.println("Intaking Ball");
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		return !Shooter.getInstance().checkForBall().get();
	}

	@Override
	protected void end() {
		Shooter.getInstance().STOP();
		System.out.println("Ball Captured");
	}

	@Override
	protected void interrupted() {
		Shooter.getInstance().STOP();
	}
}
