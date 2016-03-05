package org.usfirst.frc.team3786.robot.commands.auto;

import org.usfirst.frc.team3786.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousDriveCommand extends Command{
	
	private final double leftTurnSpeed = .2;
	private final double rightTurnSpeed = .2;
	
	private final double leftDriveSpeed = 1;
	private final double rightDriveSpeed = -1;
	
	public enum Direction { Forwards, Backwards , Left, Right}
	
	private Direction desiredDirection;
	
	public AutonomousDriveCommand(Direction direction) {
		 this.desiredDirection = direction;
		 
		 requires(DriveTrain.getInstance());
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		switch(desiredDirection) {
		case Forwards:
			DriveTrain.getInstance().drive(leftDriveSpeed, rightDriveSpeed);
			break;
		case Backwards:
			DriveTrain.getInstance().drive(-leftDriveSpeed, -rightDriveSpeed);
			break;
		case Left:
			DriveTrain.getInstance().drive(-leftTurnSpeed, rightTurnSpeed);
			break;
		case Right:
			DriveTrain.getInstance().drive(leftTurnSpeed, -rightTurnSpeed);
			break;
		}
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		DriveTrain.getInstance().STOP();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
