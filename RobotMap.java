/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
// import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;

/**
 * Add your docs here.
 */
public class RobotMap {

    // Controllers //
    public static int joystickPort = 0;
    public static int xBoxPort = 1;
    public Joystick logitech = new Joystick(RobotMap.joystickPort);

    // Motors //
        // Drive Train //
    public static int leftFrontMotor = 0;
    public static int leftRearMotor = 1;
    public static int rightFrontMotor = 2;
    public static int rightRearMotor = 3;
        // Actuator Motors //
    public static int intakeMotor = 12;
    public static int spinnerMotor = 13;
    public static int forkliftMotor = 14;
    public static int shooterMotor = 15;


    // Controller Buttons //
    /* CANT GET BUTTONS TO WORK, USING RAW INPUT INSTEAD
    public static int shootButton = 1;
    public static int shootButtonReverse = 7;
    public static int elevatorUpButton = 2;
    public static int elevatorDownButton = 3;
    public static int forkliftUpButton = 4;
    public static int forkliftDownButton = 11;
    public static int intakeLoadButton = 12;
    public static int intakeUnloadButton = 9;
    */

    // Throttle Setting //
    public static double maxThrottle = 0.7;
    public static double shooterThrottle =0.4;
    public static double forkliftThrottle = 0.4;
    public static double spinnerThrottle = 0.2;
    public static double intakeThrottle = 0.4;



}
