package org.usfirst.frc.team3786.robot.config.util;

import org.usfirst.frc.team3786.robot.commands.drive.Drive;
import org.usfirst.frc.team3786.robot.commands.shooting.GoToIntakePositionCommand;
import org.usfirst.frc.team3786.robot.commands.shooting.GoToShootPositionCommand;
import org.usfirst.frc.team3786.robot.commands.shooting.GoToTravelPosition;
import org.usfirst.frc.team3786.robot.commands.shooting.ReleaseBall;
import org.usfirst.frc.team3786.robot.commands.shooting.ShooterAimCommand;
import org.usfirst.frc.team3786.robot.commands.shooting.ShooterCommand;
import org.usfirst.frc.team3786.robot.config.ui.UIConfig;

import edu.wpi.first.wpilibj.command.Scheduler;

public class Commands {
	private static Commands instance;
	
	private ShooterAimCommand aimUpCommand;
	private ShooterAimCommand aimDownCommand;
	
	private ReleaseBall releaseBall;
	
	private GoToIntakePositionCommand goToIntakePosition;
	private GoToShootPositionCommand goToShootPosition;
	private GoToTravelPosition goToTravelPosition;
	
	private ShooterCommand shooterCommand;
	private Drive drive;
	public static Commands getInstance() {
		if(instance == null)
			instance = new Commands();
		return instance;
	}
	
	public Commands() {
		aimUpCommand = new ShooterAimCommand(ShooterAimCommand.Mode.UP);
    	aimDownCommand = new ShooterAimCommand(ShooterAimCommand.Mode.DOWN);
    	
    	releaseBall = new ReleaseBall();
    	
    	goToIntakePosition = new GoToIntakePositionCommand();
    	goToShootPosition = new GoToShootPositionCommand();
    	goToTravelPosition = new GoToTravelPosition();
    	
    	shooterCommand = new ShooterCommand();
    	
    	drive = new Drive();
	}
	
	public void BindCommands(Scheduler scheduler) {
		UIConfig.getInstance().aimDownButton().whileHeld(aimDownCommand);
        UIConfig.getInstance().aimUpButton().whileHeld(aimUpCommand);
        
        UIConfig.getInstance().shootPositionButton().whenPressed(goToShootPosition);
        UIConfig.getInstance().intakePositionButton().whenPressed(goToIntakePosition);
        UIConfig.getInstance().travelPositionButton().whenPressed(goToTravelPosition);
        
        UIConfig.getInstance().shootBallButton().whileHeld(releaseBall);
        
        scheduler.add(shooterCommand);
        scheduler.add(drive);
	}
}
