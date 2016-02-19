package org.usfirst.frc.team3786.robot.commands.shooting;

import org.usfirst.frc.team3786.robot.config.ui.UIConfig;
import org.usfirst.frc.team3786.robot.subsystems.ShooterAim;

import edu.wpi.first.wpilibj.command.Command;

public class ShooterAimCommand extends Command{
	
	
	private static final int UP_MODE = 0;
	private static final int DOWN_MODE = 1;
		
	private static int CURRENT_MODE;
	
	public ShooterAimCommand(boolean goUp) {
		requires(ShooterAim.getInstance());
		if(goUp){
			CURRENT_MODE = UP_MODE;
			System.out.println("::UP Mode Engaged::");
		}
		else {
			CURRENT_MODE = DOWN_MODE;
			System.out.println("::DOWN Mode Engaged::");
		}
	}
	
	public ShooterAimCommand() {
		requires(ShooterAim.getInstance());
		CURRENT_MODE = -1;
		System.out.println("NO Mode Specified");
	}
	
	@Override
	protected void initialize() {
		System.out.println("Targeting System Engaged: " + CURRENT_MODE); 
	}

	@Override
	protected void execute() {
		switch(CURRENT_MODE) {
			case UP_MODE:
				ShooterAim.getInstance().setPosition(ShooterAim.getInstance().getPosition() + UIConfig.getInstance().getAIM_INCREMENT());
				System.out.println("Moving UP");
				break;
			case DOWN_MODE:
				ShooterAim.getInstance().setPosition(ShooterAim.getInstance().getPosition() - UIConfig.getInstance().getAIM_INCREMENT());
				System.out.println("Moving DOWN");
				break;
			default:
				ShooterAim.getInstance().retainCurrentPosition();
				break;
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
		end();
	}
}
