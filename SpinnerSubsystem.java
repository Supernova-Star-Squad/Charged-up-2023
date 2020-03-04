/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class SpinnerSubsystem extends SubsystemBase {
  /**
   * Creates a new SpinnerSubsystem.
   */
  public SpinnerSubsystem() {

  }
  public WPI_VictorSPX spinnerController = new WPI_VictorSPX(RobotMap.spinnerMotor);

  public void left(){
    spinnerController.set(-1*RobotMap.spinnerThrottle);
  }
  public void right(){
    spinnerController.set(1*RobotMap.spinnerThrottle);
  }
  public void stop(){
    spinnerController.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
