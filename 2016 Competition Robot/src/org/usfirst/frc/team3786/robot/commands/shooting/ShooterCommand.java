package org.usfirst.frc.team3786.robot.commands.shooting;

import org.usfirst.frc.team3786.robot.config.ui.UIConfig;
import org.usfirst.frc.team3786.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

public class ShooterCommand extends Command{
	
	public ShooterCommand() {
		requires(Shooter.getInstance());
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		if(UIConfig.getInstance().getIntakeSpeed() <= -.05)
			Shooter.getInstance().setSpeed(UIConfig.getInstance().getIntakeSpeed());
		else if(UIConfig.getInstance().getShootSpeed() >= .05)
			Shooter.getInstance().setSpeed(UIConfig.getInstance().getShootSpeed());
		else
			Shooter.getInstance().STOP();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Shooter.getInstance().STOP();
	}

	@Override
	protected void interrupted() {
		end();
	}
	
}
