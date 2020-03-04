/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2020 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// Imports //
// wpilib imports //
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
// import edu.wpi.first.wpilibj.buttons.*;
// RobotMap //
import frc.robot.RobotMap;


// Subsystems //
import frc.robot.DriveSubsystem;
import frc.robot.ShooterSubsystem;
import frc.robot.SpinnerSubsystem;
import frc.robot.IntakeSubsystem;
import frc.robot.ForkliftSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  // ShooterSubsystem //
  public ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  // IntakeSubsystem //
  public IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  // SpinnerSubsystem //
  public SpinnerSubsystem spinnerSubsystem = new SpinnerSubsystem();
  // ForkliftSUbsystem //
  public ForkliftSubsystem forkliftSubsystem = new ForkliftSubsystem();
  // drive and joystick //
  public static DriveSubsystem driveSubsystem = new DriveSubsystem();
  


  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }

  /**
   * This function is called once when teleop is enabled.
   */
  @Override
  public void teleopInit() {
   
  }
  public Joystick logitech = new Joystick(RobotMap.joystickPort);
  JoystickButton shootButton = new JoystickButton(logitech,1);

  public void drive(){
    double throttle = 1-((logitech.getThrottle()+1)/2);
    double move = -logitech.getY()*throttle;
    double turn = logitech.getX()*throttle;

    // removing creep //
    if (Math.abs(turn)<0.1){
      turn = 0;
    }
    if (Math.abs(move)<0.1){
      move = 0;
    }
    // Driving //
    driveSubsystem.teleopDrive(move*throttle, turn*throttle);
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    drive();

 // can't make this line work
 // shootButton.whileHeld(shooterSubsystem.fire());
 //
    
    if (logitech.getRawButton(1)){
      shooterSubsystem.fire();
    }
    else if (logitech.getRawButtonReleased(1)){
      shooterSubsystem.stop();
    }
     else if (logitech.getRawButton(2)){
      shooterSubsystem.unfire();
    }
    else if (logitech.getRawButtonReleased(2)){
        shooterSubsystem.stop();
    }
    else if (logitech.getRawButton(7)){
      spinnerSubsystem.left();
    }
    else if (logitech.getRawButtonReleased(7)){
      spinnerSubsystem.stop();
    }
    else if (logitech.getRawButton(8)){
      spinnerSubsystem.right();
    }
    else if (logitech.getRawButtonReleased(8)){
      spinnerSubsystem.stop();
    }
    else if (logitech.getRawButton(3)){
      intakeSubsystem.load();
    }
    else if (logitech.getRawButtonReleased(3)){
      intakeSubsystem.stop();
    }
    else if (logitech.getRawButton(4)){
      intakeSubsystem.unload();
    }
    else if (logitech.getRawButtonReleased(4)){
      intakeSubsystem.stop();
    }
    else if (logitech.getRawButton(11)){
      forkliftSubsystem.raise();
    }
    else if (logitech.getRawButtonReleased(11)){
      forkliftSubsystem.stop();
    }
    else if (logitech.getRawButton(12)){
      forkliftSubsystem.lower();
    }
    else if (logitech.getRawButtonReleased(12)){
      forkliftSubsystem.stop();
    }

    
    
    

  }
  /**
   * This function is called once when the robot is disabled.
   */

  @Override
  public void disabledInit() {
  }

  /**
   * This function is called periodically when disabled.
   */
  @Override
  public void disabledPeriodic() {
  }

  /**
   * This function is called once when test mode is enabled.
   */
  @Override
  public void testInit() {
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
