
package org.usfirst.frc.team3786.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team3786.robot.commands.auto.DefaultAutonomousCommandGroup;
import org.usfirst.frc.team3786.robot.commands.drive.Drive;
import org.usfirst.frc.team3786.robot.commands.shooting.GoToIntakePositionCommand;
import org.usfirst.frc.team3786.robot.commands.shooting.GoToShootPositionCommand;
import org.usfirst.frc.team3786.robot.commands.shooting.IntakeBall;
import org.usfirst.frc.team3786.robot.commands.shooting.ShootBall;
import org.usfirst.frc.team3786.robot.commands.shooting.ShooterAimCommand;
import org.usfirst.frc.team3786.robot.commands.shooting.SpinToShootSpeed;
import org.usfirst.frc.team3786.robot.commands.shooting.StopShooter;
import org.usfirst.frc.team3786.robot.config.ui.UIConfig;
import org.usfirst.frc.team3786.robot.subsystems.DriveTrain;
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
    
  //Instantiating Commands that deal with the Shooter
	final static ShooterAimCommand aimUpCommand = new ShooterAimCommand(true);
	final static ShooterAimCommand aimDownCommand = new ShooterAimCommand(false);
	final static IntakeBall intakeBall = new IntakeBall();
	final static ShootBall shootBall = new ShootBall();
	final static GoToIntakePositionCommand goToIntakePosition = new GoToIntakePositionCommand();
	final static GoToShootPositionCommand goToShootPosition = new GoToShootPositionCommand();
	
	final static StopShooter stopShooter = new StopShooter();
	final static SpinToShootSpeed spinToShootSpeed = new SpinToShootSpeed();
	
	//Instantiating Commands that deal with the Drive Train
	final Drive drive = new Drive();
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	
    	System.out.println("Initializing Subsystems");
    	
    	DriveTrain.getInstance();
    	ReleaseMechanism.getInstance();
    	Shooter.getInstance();
    	ShooterAim.getInstance();
    	
    	System.out.println("Initializing Commands");
    	    	
    	//Instantiating Commands that deal with Autonomous 	
    	final DefaultAutonomousCommandGroup defaultAutonomous = new DefaultAutonomousCommandGroup();
    	
        System.out.println("Commands Successfully Initialized");
        
        
        System.out.println("Binding Command to Buttons");
        
        //Binding Commands that deal with the Shooter
        UIConfig.getInstance().aimDownButton().whileHeld(aimDownCommand);
        UIConfig.getInstance().aimUpButton().whileHeld(aimUpCommand);
        
        //UIConfig.getInstance().shootPositionButton().whenPressed(goToShootPosition);
        //UIConfig.getInstance().intakePositionButton().whenPressed(goToIntakePosition);
        
       // UIConfig.getInstance().shootBallButton().whenPressed(shootBall);
        //UIConfig.getInstance().intakeBallButton().whenPressed(intakeBall);
        
        //new JoystickButton(new Joystick(0), 3).whenPressed(stopShooter);
        //new JoystickButton(new Joystick(0), 4).whenPressed(spinToShootSpeed);
        
        System.out.println("Command Successfully Bound to Buttons");
        
        //TODO Test the SmartDashabord Integration with subsystems and commands
        SmartDashboard.putData("Shoot Ball Command", shootBall);
        SmartDashboard.putData("Intake Ball Command", intakeBall);
        
        SmartDashboard.putData("Shooter Aim", ShooterAim.getInstance());
        
        chooser = new SendableChooser();
        chooser.addDefault("Drive", drive);
        chooser.addDefault("Default Auto", defaultAutonomous);
//        chooser.addObject("My Auto", new MyAutoCommand());
        SmartDashboard.putData("Auto mode", chooser);
        
        Scheduler.getInstance().add(drive);
        Scheduler.getInstance().add(stopShooter);
        
        Scheduler.getInstance().add(new Drive());
        
        SmartDashboard.putData(Scheduler.getInstance());
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
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		//System.out.println("Left Drive" + UIConfig.getInstance().getLeftDrive());
		//System.out.println("Right Drive" + UIConfig.getInstance().getRightDrive());
		
		System.out.println("Shooter Position: " + ShooterAim.getInstance().getPosition());
		
	}
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
