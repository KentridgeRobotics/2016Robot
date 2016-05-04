package org.usfirst.frc.team3786.robot.commands.shooting;

import org.usfirst.frc.team3786.robot.config.ui.UIConfig;
import org.usfirst.frc.team3786.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Class to control the shooter wheel speed
 * @author Manpreet Singh 2016
 */
public class ShooterCommand extends Command{
	
	public ShooterCommand() {
		requires(Shooter.getInstance());
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		if(UIConfig.getInstance().getShootSpeed() > 0.05)
			Shooter.getInstance().setSpeed(UIConfig.getInstance().getShootSpeed());
		else if(UIConfig.getInstance().getIntakeSpeed() > 0.05)
			Shooter.getInstance().setSpeed(-UIConfig.getInstance().getIntakeSpeed());
		else
			Shooter.getInstance().setSpeed(0);
		
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
