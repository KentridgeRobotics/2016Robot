package org.usfirst.frc.team3786.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveForwards extends CommandGroup{
	public DriveForwards() {
		addSequential(new AutonomousDriveCommand(AutonomousDriveCommand.Direction.Forwards), 2.0);
	}
}
	