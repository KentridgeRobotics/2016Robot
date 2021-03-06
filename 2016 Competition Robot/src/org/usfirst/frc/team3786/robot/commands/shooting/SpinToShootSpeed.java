package org.usfirst.frc.team3786.robot.commands.shooting;

import org.usfirst.frc.team3786.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Class/Command to spin the shooter wheels to full speed forward
 * @author Manpreet Singh 2016
 */
public class SpinToShootSpeed extends Command {
	
	public SpinToShootSpeed() {
		requires(Shooter.getInstance());
		System.out.println("Shoot Command initiliazed");
	}
	
	protected void initialize() {
		Shooter.getInstance().spinToShootSpeed();
		System.out.println("TRYING TO SHOOT");
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Shooter.getInstance().STOP();
	}

	protected void interrupted() {
		end();
	}

}
