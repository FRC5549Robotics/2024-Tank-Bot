// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Pivot extends SubsystemBase {
  /** Creates a new Pivot. */
  CANSparkMax LeftPivotMotor, RightPivotMotor;
  public Pivot() {
    LeftPivotMotor = new CANSparkMax(Constants.LEFT_PIVOT_MOTOR, MotorType.kBrushless);  
    RightPivotMotor = new CANSparkMax(Constants.RIGHT_PIVOT_MOTOR, MotorType.kBrushless);
  }

  public void pivot(double speed){
    LeftPivotMotor.set(speed);
    RightPivotMotor.set(-speed);
  }
  public void off(){
    LeftPivotMotor.set(0);
    RightPivotMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
