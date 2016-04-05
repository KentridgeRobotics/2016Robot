package org.usfirst.frc.team3786.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LowBarAutonomousCommandGroup extends CommandGroup{
	public LowBarAutonomousCommandGroup() {
		addSequential(new AutonomousDriveCommand(AutonomousDriveCommand.Direction.Forwards), .8);
		addSequential(new AutonomousDriveCommand(AutonomousDriveCommand.Direction.Backwards), .8);
		addSequential(new AutonomousDriveCommand(AutonomousDriveCommand.Direction.Forwards), .8);
	}
}
