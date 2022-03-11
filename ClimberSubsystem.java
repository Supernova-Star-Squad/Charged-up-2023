/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP; 
//import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import edu.wpi.first.wpilibj.motorcontrol.VictorSP;


//public class ClimberSubsystem {
  /**
   * Creates a new IntakeSubsystem.
   */
public class ClimberSubsystem {
  public VictorSP climberWinch;

  //public VictorSP climbController1;
  //public VictorSP climbController2;
 // import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX


 public WPI_VictorSPX ClimbMotor_L1;
 public WPI_VictorSPX ClimbMotor_L2;
 public WPI_VictorSPX ClimbMotor_R1;
 public WPI_VictorSPX ClimbMotor_R2;
 public VictorSP ClimberWinch;

 MotorControllerGroup leftMotors;
 MotorControllerGroup rightMotors;
 
  public ClimberSubsystem()
  {
    ClimbMotor_L1 = new WPI_VictorSPX(RobotMap.ClimbMotor_L1);
    ClimbMotor_L2 = new WPI_VictorSPX(RobotMap.ClimbMotor_L2);
    ClimbMotor_R1 = new WPI_VictorSPX(RobotMap.ClimbMotor_R1);
    ClimbMotor_R2 = new WPI_VictorSPX(RobotMap.ClimbMotor_R2);

    ClimberWinch = new VictorSP(RobotMap.ClimberWinch);  
    //public WPI_TalonSRX leftMotor = new WPI_TalonSRX(RobotMap.ClimbMotor_1);
    //public WPI_TalonSRX RightMotor = new WPI_TalonSRX(RobotMap.ClimbMotor_2);

    leftMotors = new MotorControllerGroup(ClimbMotor_L1,ClimbMotor_L2 );
    rightMotors = new MotorControllerGroup(ClimbMotor_R1,ClimbMotor_R2);
  }
//winch motor for climber

    

public void forward(){

  climberWinch.set(RobotMap.winchThrottle); 
}
  
  public void back(){
    climberWinch.set(-RobotMap.winchThrottle);
  }
  
  public void stop(){
    climberWinch.set(0);
  }
 

  //public ClimberSubsystem(){}
  public void extend1(){
    leftMotors.set(RobotMap.climbThrottle);    
 }

 public void retract1(){
  leftMotors.set(-RobotMap.climbThrottle);
 }
 
 public void stop1(){
  leftMotors.set(0);
 }
  public void extend2(){
    rightMotors.set(RobotMap.climbThrottle);    
 }

 public void retract2(){
  rightMotors.set(-RobotMap.climbThrottle);
} 
 
 public void stop2(){
 rightMotors.set(0);
 }
  
}
 
