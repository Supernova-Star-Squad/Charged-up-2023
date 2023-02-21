/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

public class IntakeSubsystem {
  
    public VictorSP extendController;

    public IntakeSubsystem()
    {
      extendController = new VictorSP(RobotMap.extendMotor);
      liftController = new VictorSP(RobotMap.liftMotor)
    }

  public void forward(){
    extendController.set(RobotMap.extendThrottle);    
 }

 public void back(){
   extendController.set(-RobotMap.extendThrottle);
 }
 
 public void stop(){
   extendController.set(0);
 
   public VictorSP extendController;

   public IntakeSubsystem()
   {
     extendController = new VictorSP(RobotMap.extendMotor);
   }

 public void forward(){
   extendController.set(RobotMap.extendThrottle);    
}

public void back(){
  extendController.set(-RobotMap.extendThrottle);
}

public void stop(){
  extendController.set(0);
  }
}