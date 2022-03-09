/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

public class IntakeSubsystem {
  
    public VictorSP intakeController;

    public IntakeSubsystem()
    {
      intakeController = new VictorSP(RobotMap.intakeMotor);
    }

  public void forward(){
    intakeController.set(RobotMap.intakeThrottle);    
 }

 public void back(){
   intakeController.set(-RobotMap.intakeThrottle);
 }
 
 public void stop(){
   intakeController.set(0);
 }
}