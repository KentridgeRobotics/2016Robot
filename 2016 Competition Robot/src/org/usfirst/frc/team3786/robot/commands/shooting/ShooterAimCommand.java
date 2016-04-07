package org.usfirst.frc.team3786.robot.commands.shooting;

import org.usfirst.frc.team3786.robot.subsystems.ShooterAim;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This Command/Class handles moving the shooter up, down, and holding position.
 * @author Manpreet Singh 2016
 *
 */
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
				ShooterAim.getInstance().moveUp();
				break;
			case DOWN:
				ShooterAim.getInstance().moveDown();
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
