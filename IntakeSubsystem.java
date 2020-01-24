/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
public class IntakeSubsystem extends SubsystemBase {
  /**
   * Creates a new IntakeSubsystem.
   */
  public IntakeSubsystem() {

  }
  public WPI_VictorSPX intakeController = new WPI_VictorSPX(Atlas.intakeMotor);
  
  public void load()
  {
    intakeController.set(1);
  }
  public void unload()
  {
    intakeController.set(-1);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
