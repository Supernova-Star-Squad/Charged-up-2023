/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.VictorSP;

public class IntakeSubsystem extends SubsystemBase {
  /**
   * Creates a new IntakeSubsystem.
   */
  public IntakeSubsystem() {

  }
  public VictorSP intakeController = new VictorSP(RobotMap.intakeMotor);

  public void forward(){
    intakeController.set(RobotMap.intakeThrottle);    
 }

 public void back(){
   intakeController.set(-RobotMap.intakeThrottle);
 }
 
 public void stop(){
   intakeController.set(0);
 }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}