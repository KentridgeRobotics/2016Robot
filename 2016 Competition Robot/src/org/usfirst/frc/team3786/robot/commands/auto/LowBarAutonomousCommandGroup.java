package org.usfirst.frc.team3786.robot.commands.auto;

import org.usfirst.frc.team3786.robot.commands.shooting.GoToShootPositionCommand;
import org.usfirst.frc.team3786.robot.commands.shooting.ShootBall;
import org.usfirst.frc.team3786.robot.commands.shooting.SpinToShootSpeed;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LowBarAutonomousCommandGroup extends CommandGroup{
	public LowBarAutonomousCommandGroup() {
		addSequential(new AutonomousDriveCommand(AutonomousDriveCommand.Direction.Forwards), 2);
		addSequential(new AutonomousDriveCommand(AutonomousDriveCommand.Direction.Right), .5);
		
//		addSequential(new GoToShootPositionCommand(), 2);
//		addSequential(new SpinToShootSpeed(), 2);
//		addSequential(new ShootBall());
	}
}
