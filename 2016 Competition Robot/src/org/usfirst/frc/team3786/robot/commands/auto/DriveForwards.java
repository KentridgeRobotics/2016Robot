package org.usfirst.frc.team3786.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * If you don't know what this class does, then I would try bashing your head against the keyboard
 * @author Manpreet Singh 2016
 */
public class DriveForwards extends CommandGroup{
	public DriveForwards() {
		addSequential(new AutonomousDriveCommand(AutonomousDriveCommand.Direction.Forwards), 2.0);
	}
}
	