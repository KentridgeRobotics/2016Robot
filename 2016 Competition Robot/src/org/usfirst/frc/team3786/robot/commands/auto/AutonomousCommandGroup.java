package org.usfirst.frc.team3786.robot.commands.auto;

import org.usfirst.frc.team3786.robot.commands.shooting.GoToShootPositionCommand;
import org.usfirst.frc.team3786.robot.commands.shooting.ShootBall;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCommandGroup extends CommandGroup{
	public AutonomousCommandGroup() {
		addSequential(new GoToShootPositionCommand(), 3);
		addSequential(new ShootBall());
	}
}
