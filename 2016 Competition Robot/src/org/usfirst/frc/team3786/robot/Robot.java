
package org.usfirst.frc.team3786.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team3786.robot.commands.auto.AutonomousDriveCommand;
import org.usfirst.frc.team3786.robot.commands.auto.DoNothing;
import org.usfirst.frc.team3786.robot.commands.auto.DriveForwards;
import org.usfirst.frc.team3786.robot.commands.auto.LowBarAutonomousCommandGroup;
import org.usfirst.frc.team3786.robot.commands.auto.ShootAutonomousCommandGroup;
import org.usfirst.frc.team3786.robot.commands.drive.Drive;
import org.usfirst.frc.team3786.robot.commands.shooting.GoToIntakePositionCommand;
import org.usfirst.frc.team3786.robot.commands.shooting.GoToShootPositionCommand;
import org.usfirst.frc.team3786.robot.commands.shooting.IntakeBall;
import org.usfirst.frc.team3786.robot.commands.shooting.ShootBall;
import org.usfirst.frc.team3786.robot.commands.shooting.ShooterAimCommand;
import org.usfirst.frc.team3786.robot.commands.shooting.SpinToShootSpeed;
import org.usfirst.frc.team3786.robot.commands.shooting.StopShooter;
import org.usfirst.frc.team3786.robot.config.robot.RobotConfig;
import org.usfirst.frc.team3786.robot.config.ui.UIConfig;
import org.usfirst.frc.team3786.robot.subsystems.DriveTrain;
import org.usfirst.frc.team3786.robot.subsystems.NewShooter;
import org.usfirst.frc.team3786.robot.subsystems.ReleaseMechanism;
import org.usfirst.frc.team3786.robot.subsystems.Shooter;
import org.usfirst.frc.team3786.robot.subsystems.ShooterAim;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    Command autonomousCommand;
    SendableChooser chooser;
    
//    Instantiating Commands that deal with the Shooter
	final ShooterAimCommand aimUpCommand = new ShooterAimCommand(ShooterAimCommand.Mode.UP);
	final ShooterAimCommand aimDownCommand = new ShooterAimCommand(ShooterAimCommand.Mode.DOWN);
	final IntakeBall intakeBall = new IntakeBall();
	final ShootBall shootBall = new ShootBall();
	final GoToIntakePositionCommand goToIntakePosition = new GoToIntakePositionCommand();
	final GoToShootPositionCommand goToShootPosition = new GoToShootPositionCommand();
	final StopShooter stopShooter = new StopShooter();
	final SpinToShootSpeed spinToShootSpeed = new SpinToShootSpeed();
		
//	Instantiating Commands that deal with the Drive Train
	//final Drive drive = new Drive();
	
	final ShootAutonomousCommandGroup justShootAutonomous = new ShootAutonomousCommandGroup();
	final LowBarAutonomousCommandGroup lowBarAuto = new LowBarAutonomousCommandGroup();
	final DriveForwards driveForward = new DriveForwards();
	final DoNothing doNothing = new DoNothing();
//	For Testing purposes only
//	final Joystick mainStick = new Joystick(0);
//	final JoystickButton triggerButton = new JoystickButton(mainStick, 1);
//	final JoystickButton loadButton = new JoystickButton(mainStick, 2);
    
	private final String[] splash = {
			" __   __  __   __  ______   _______  ______    _______  _______ ",
			"|  |_|  ||  | |  ||      | |       ||    _ |  |   _   ||  _    |",
			"|       ||  | |  ||  _    ||       ||   | ||  |  |_|  || |_|   |",
			"|       ||  |_|  || | |   ||       ||   |_||_ |       ||       |",
			"|       ||       || |_|   ||      _||    __  ||       ||  _   | ",
			"| ||_|| ||       ||       ||     |_ |   |  | ||   _   || |_|   |",
			"|_|   |_||_______||______| |_______||___|  |_||__| |__||_______|",
			"",
			" _______  _______  ____   ___     ",
			"|       ||  _    ||    | |   |    ",
			"|____   || | |   | |   | |   |___ ",
			" ____|  || | |   | |   | |    _  |",
			"| ______|| |_|   | |   | |   | | |",
			"| |_____ |       | |   | |   |_| |",
			"|_______||_______| |___| |_______|"
	};
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	RobotConfig.getInstance();
    	DriveTrain.getInstance();
    	ReleaseMechanism.getInstance();
    	Shooter.getInstance();
    	ShooterAim.getInstance();
    	
    	//Binding Commands that deal with the New Shooter class
//    	NewShooter.getInstance();
//    	triggerButton.whileHeld(NewShooter.getInstance().triggerButton);
//    	loadButton.whileHeld(NewShooter.getInstance().loadButton);
    	        
        UIConfig.getInstance().aimDownButton().whileHeld(aimDownCommand);
        UIConfig.getInstance().aimUpButton().whileHeld(aimUpCommand);
        UIConfig.getInstance().shootPositionButton().whenPressed(goToShootPosition);
        UIConfig.getInstance().intakePositionButton().whenPressed(goToIntakePosition);
        
        UIConfig.getInstance().shootBallButton().whenPressed(shootBall);
        UIConfig.getInstance().intakeBallButton().whenPressed(intakeBall);
        
        UIConfig.getInstance().spinToShooterSpeed().whenPressed(spinToShootSpeed);
        UIConfig.getInstance().stopShooterButton().whenPressed(stopShooter);
        
        SmartDashboard.putData("Shoot Ball Command", shootBall);
        SmartDashboard.putData("Intake Ball Command", intakeBall);
    	
        SmartDashboard.putData("Shooter Aim", ShooterAim.getInstance());
        
        chooser = new SendableChooser();
        chooser.addDefault("Drive", driveForward);
        chooser.addDefault("Default Auto", justShootAutonomous);
        chooser.addDefault("Low Bar Autonomous", lowBarAuto);
        chooser.addDefault("Do Nothing", doNothing);
        
        SmartDashboard.putData("Select Autonomous", chooser);
        
        //Scheduler.getInstance().add(drive);
        
        SmartDashboard.putData(Scheduler.getInstance());
        
        for(String s : splash) 
        	System.out.println(s);
        
        System.out.println("Mudcrab 2016 - Initialized");
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
        autonomousCommand = (Command) chooser.getSelected();
        
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }
    /**
     * This function is called periodically during operator control
     */
    double currentPosition;
    public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		SmartDashboard.putNumber("Shooter Position", ShooterAim.getInstance().getPosition());	
		SmartDashboard.putNumber("Bus Output", ShooterAim.getInstance().getOutputVoltage());
		SmartDashboard.putBoolean("Forward Limit", ShooterAim.getInstance().getForwardLimit());
		SmartDashboard.putBoolean("Reverse Limit", ShooterAim.getInstance().getBackLimit());
		SmartDashboard.putBoolean("Ball Engagement", Shooter.getInstance().checkForBall().get());
		SmartDashboard.putNumber("Current Position", currentPosition);
		SmartDashboard.putNumber("Error", ShooterAim.getInstance().motor().getError());
	}
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
