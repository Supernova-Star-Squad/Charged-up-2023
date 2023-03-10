/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.cameraserver.CameraServer;
import frc.robot.Atlas;
import frc.robot.DriveSubsystem;
import frc.robot.ElevatorSubsystem;
import frc.robot.ForkliftSubsystem;
import frc.robot.IntakeSubsystem;
import frc.robot.ShooterSubsystem;

//ATM This is ctrl+C then V, no idea if it works
Pixy2 pixy = Pixy2.createInstance(SPI)
pixy.init(1) //placeholder was arg
//This is ment to turn some LEDs on
  public class PixyCameraexample {

	private static final Pixy2 pixy;

	public static void initialize() {
		pixy = Pixy2.createInstance(new SPILink(1)); // Creates a new Pixy2 camera using SPILink
		pixy.init(); // Initializes the camera and prepares to send/receive data
		pixy.setLamp((byte) 1, (byte) 1); // Turns the LEDs on
		pixy.setLED(200, 30, 255); // Sets the RGB LED to purple
	}
}

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
  public static ElevatorSubsystem elevatorSubsystem = new ElevatorSubsystem();
  public static ForkliftSubsystem forkliftSubsystem = new ForkliftSubsystem();
  public static ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  public static IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  public static DriveSubsystem driveSubsystem = new DriveSubsystem();
  public Joystick logitech;
  

  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
    logitech = new Joystick(Atlas.joystickPort);
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
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() 
  {
    drive();
  }

  public void drive()
  {
    
    // throttle mapping from 0 to 1 for full range instead of //
    // forwards and reverse //
    double throttle = 1 -((logitech.getThrottle()+1)/2);
    double move = -logitech.getY()*throttle;
    double turn = logitech.getX()*throttle;
    // remove creeping robot by creating a 'deadzone' of + and - 0.1 //
    if (Math.abs(turn) < 0.1)
    {
      turn = 0;
    }
    if (Math.abs(move) < 0.1)
    {
      move = 0;
    }
    // driving //
    driveSubsystem.teleopDrive(move, turn);
    // joystick madness //
    if (logitech.getRawButton(Atlas.ElevatorButtonDown))
    {
      elevatorSubsystem.down();
    }
    else if (logitech.getRawButton(Atlas.ElevatorButtonUp))
    {
      elevatorSubsystem.up();
    }
    else if (logitech.getRawButton(Atlas.IntakeLoadButton))
    {
      intakeSubsystem.load();
    }
    else if (logitech.getRawButton(Atlas.IntakeUnloadButton))
    {
      intakeSubsystem.unload();
    }
    else if (logitech.getRawButton(Atlas.ForkliftButtonUp))
    {
      forkliftSubsystem.up();
    }
    else if (logitech.getRawButton(Atlas.ForkLiftButtonDown))
    {
      forkliftSubsystem.down();
    }
   }
  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
