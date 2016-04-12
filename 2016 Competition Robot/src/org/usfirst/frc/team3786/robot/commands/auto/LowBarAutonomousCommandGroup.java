package org.usfirst.frc.team3786.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Untested Low Bar Auto
 * <p>
 * 
 * Brings the shooter down, and drives forward and backwards across the Low bar to kill the defense
 * 
 * <h2>WARNING:</h2>
 * This has <b>NOT</b> been tested
 * @author Manpreet Singh 2016
 */
public class LowBarAutonomousCommandGroup extends CommandGroup{
	
	private final double downPosition = 0.23;
	
	public LowBarAutonomousCommandGroup() {
		//Bring down the shooter
		addSequential(new AutonomousShooterCommand(downPosition), 0.5);
		
		//Let's haul some robot ass
		addSequential(new AutonomousDriveCommand(AutonomousDriveCommand.Direction.Forwards), .8);
		addSequential(new AutonomousDriveCommand(AutonomousDriveCommand.Direction.Backwards), .8);
		addSequential(new AutonomousDriveCommand(AutonomousDriveCommand.Direction.Forwards), .8);
	}
}
