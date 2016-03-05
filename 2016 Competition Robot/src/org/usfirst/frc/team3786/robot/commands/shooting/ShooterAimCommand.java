package org.usfirst.frc.team3786.robot.commands.shooting;

import org.usfirst.frc.team3786.robot.config.ui.UIConfig;
import org.usfirst.frc.team3786.robot.subsystems.ShooterAim;

import edu.wpi.first.wpilibj.command.Command;

public class ShooterAimCommand extends Command{
	
	public enum Mode { UP, DOWN, RETAIN_POSITION }
	private Mode currentMode;
	
	public ShooterAimCommand(Mode mode) {
		requires(ShooterAim.getInstance());
		this.currentMode = mode;
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		switch(currentMode) {
			case UP:
				ShooterAim.getInstance().motor().setP(800);
				ShooterAim.getInstance().setPosition(ShooterAim.getInstance().getPosition() + UIConfig.getInstance().getAIM_INCREMENT());
				System.out.println("Moving UP ++");
				break;
			case DOWN:
				ShooterAim.getInstance().motor().setP(400);
				ShooterAim.getInstance().setPosition(ShooterAim.getInstance().getPosition() - UIConfig.getInstance().getAIM_INCREMENT());
				System.out.println("Moving DOWN --");
				break;
			case RETAIN_POSITION:
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
