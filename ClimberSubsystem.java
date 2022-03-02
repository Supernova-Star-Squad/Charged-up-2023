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

public class ClimberSubsystem extends SubsystemBase {
  /**
   * Creates a new IntakeSubsystem.
   */
  public ClimberSubsystem() {

  }
  public VictorSP climbController1 = new VictorSP(RobotMap.ClimbMotor_1);
  public VictorSP climbController2 = new VictorSP(RobotMap.ClimbMotor_2);

  public void forward1(){
    climbController1.set(RobotMap.climbThrottle);    
 }

 public void back1(){
   climbController1.set(-RobotMap.climbThrottle);
 }
 
 public void stop1(){
   climbController1.set(0);
 }
  public void forward2(){
    climbController2.set(RobotMap.climbThrottle);    
 }

 public void back2(){
   climbController2.set(-RobotMap.climbThrottle);
 }
 
 public void stop2(){
   climbController2.set(0);
 }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}