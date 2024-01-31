// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Indexer extends SubsystemBase {
  /** Creates a new Indexer. */
  CANSparkMax IndexerMotor;
  public Indexer() {
    IndexerMotor = new CANSparkMax(Constants.INDEXER_MOTOR, MotorType.kBrushless);
  }

  public void test(){
    System.out.println("Buttons");
  }
  public void index() {
    IndexerMotor.set(Constants.INDEXER_SPEED);
  }

  public void reverse() {
    IndexerMotor.set(-Constants.INDEXER_SPEED);
  }

  public void off(){
    IndexerMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
