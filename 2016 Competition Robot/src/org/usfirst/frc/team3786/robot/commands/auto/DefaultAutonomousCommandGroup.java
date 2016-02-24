package org.usfirst.frc.team3786.robot.commands.auto;

import org.usfirst.frc.team3786.robot.commands.shooting.ShootBall;
import org.usfirst.frc.team3786.robot.commands.shooting.SpinToShootSpeed;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DefaultAutonomousCommandGroup extends CommandGroup{
	public DefaultAutonomousCommandGroup() {
		addSequential(new SpinToShootSpeed(), 2);
		addSequential(new ShootBall());
	}
}
