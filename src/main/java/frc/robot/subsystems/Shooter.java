// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.Trigger;

import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Ultrasonic;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  CANSparkFlex LeftMotor, RightMotor;
  public boolean movement = false;

  /** Creates a new Shooter. */
  public Shooter() {
    LeftMotor = new CANSparkFlex(Constants.SHOOT_MOTOR_LEFT, MotorType.kBrushless);
    RightMotor = new CANSparkFlex(Constants.SHOOT_MOTOR_RIGHT, MotorType.kBrushless);
  }

  public void shoot(double speed) {//make dependent on trigger
    LeftMotor.set(-speed*Constants.SHOOTER_SCALING_FACTOR);
    RightMotor.set(speed*Constants.SHOOTER_SCALING_FACTOR);
    movement = true;
    System.out.println("shoot");
  }

  public void intake() {
    LeftMotor.set(Constants.SHOOTER_INTAKE_SPEED);
    RightMotor.set(-Constants.SHOOTER_INTAKE_SPEED);
    System.out.println("intake");
  }

  public void off(){
    LeftMotor.set(0);
    RightMotor.set(0);
    System.out.println("sadfkbsadfjk");
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
