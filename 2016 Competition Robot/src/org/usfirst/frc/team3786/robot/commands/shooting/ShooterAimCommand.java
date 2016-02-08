package org.usfirst.frc.team3786.robot.commands.shooting;

import org.usfirst.frc.team3786.robot.subsystems.Shooter;
import org.usfirst.frc.team3786.robot.subsystems.ShooterAim;

import edu.wpi.first.wpilibj.command.Command;

public class ShooterAimCommand extends Command{
	
	private static boolean goUp;
	
	public ShooterAimCommand(boolean goUp) {
		this.goUp = goUp;
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		requires(ShooterAim.getInstance());
	}

	@Override
	protected void execute() {
		if(Shooter.getInstance().checkForBall().get() == true) {
			
		}
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}

}
