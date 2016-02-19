package org.usfirst.frc.team3786.robot.commands.auto;

import edu.wpi.first.wpilibj.command.Command;

public class DriveDistance extends Command{
	
	private double distance;
	
	public enum Direction { Forwards, Backwards; }
	
	public DriveDistance(Direction direction, double distance) {
		if(direction == Direction.Backwards)
			this.distance = -distance;
		else 
			this.distance = distance;
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
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
