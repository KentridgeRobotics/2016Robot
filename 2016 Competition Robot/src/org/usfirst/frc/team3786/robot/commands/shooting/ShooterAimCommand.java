package org.usfirst.frc.team3786.robot.commands.shooting;

import org.usfirst.frc.team3786.robot.subsystems.Shooter;
import org.usfirst.frc.team3786.robot.subsystems.ShooterAim;

import edu.wpi.first.wpilibj.command.Command;

public class ShooterAimCommand extends Command{
	
	
	private static final int UP_MODE = 0;
	private static final int DOWN_MODE = 1;
	
	private static final double INCREMENT = 1;
	
	private static int CURRENT_MODE;
	
	public ShooterAimCommand(boolean goUp) {
		requires(ShooterAim.getInstance());
		if(goUp)
			CURRENT_MODE = UP_MODE;
		else
			CURRENT_MODE = DOWN_MODE;
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		switch(CURRENT_MODE) {
			case UP_MODE:
				ShooterAim.getInstance().setPosition(ShooterAim.getInstance().getPosition() + INCREMENT);
				break;
			case DOWN_MODE:
				ShooterAim.getInstance().setPosition(ShooterAim.getInstance().getPosition() - INCREMENT);
				break;
			default:
				
		}
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		ShooterAim.getInstance().retainCurrentPosition();
	}

	@Override
	protected void interrupted() {
		ShooterAim.getInstance().retainCurrentPosition();
	}

}
