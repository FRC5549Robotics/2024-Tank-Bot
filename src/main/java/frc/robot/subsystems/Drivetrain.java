// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.Joystick;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  WPI_VictorSPX leftFront, rightFront, leftBack, rightBack;
  //public MotorControllerGroup leftGroup, rightGroup;
  DifferentialDrive drive;
  Compressor pcmCompressor;

  DifferentialDriveOdometry m_odometry;
  CommandXboxController m_controller;

  DoubleSolenoid rightGearShift, leftGearShift;
  public MotorControllerGroup leftGroup, rightGroup;

  private static Drivetrain instance;

  public Drivetrain(CommandXboxController controller) {
    leftFront = new WPI_VictorSPX(Constants.LEFT_MOTOR1);
    leftBack = new WPI_VictorSPX(Constants.LEFT_MOTOR2);

    rightFront = new WPI_VictorSPX(Constants.RIGHT_MOTOR1);
    rightBack = new WPI_VictorSPX(Constants.RIGHT_MOTOR2);

    leftFront.setInverted(true);
    leftBack.setInverted(true);

    m_controller = controller;
/*
    leftGroup = new MotorControllerGroup(leftFront, leftBack);
    rightGroup = new MotorControllerGroup(rightFront, rightBack);

    drive = new DifferentialDrive(rightGroup, leftGroup);
*/
    instance = this;
    leftGroup = new MotorControllerGroup(leftFront, leftBack);
    rightGroup = new MotorControllerGroup(rightFront, rightBack);
    drive = new DifferentialDrive(rightGroup, leftGroup);
/*
    resetEncoders();
    rightBackE.setPositionConversionFactor(Constants.POSITION_TO_METERS);
    rightFrontE.setPositionConversionFactor(Constants.POSITION_TO_METERS);
    leftFrontE.setPositionConversionFactor(Constants.POSITION_TO_METERS);
    leftBackE.setPositionConversionFactor(Constants.POSITION_TO_METERS);
  */
    // getPosition now returns distance.
  }
/*
  public void resetEncoders() {
    rightBackE.setPosition(0);
    rightFrontE.setPosition(0);
    leftBackE.setPosition(0);
    leftFrontE.setPosition(0);
  }
*/
  public void tankDriveMethod(double leftJoystickAxis, double rightJoystickAxis) {
    drive.tankDrive(leftJoystickAxis, rightJoystickAxis);
    // drive.tankDrive(leftJoystickAxis * left.getRawAxis(3), rightJoystickAxis *
    // right.getRawAxis(3));
  }

  public void arcadeDriveMethod(double leftJoystickAxis, double rightJoystickAxis) {
    drive.arcadeDrive(leftJoystickAxis, rightJoystickAxis);
  }

  public void changeGear() {
    rightGearShift.toggle();
    leftGearShift.toggle();
  }

  // public void autoDrive(double speed1, double speed2) {
  //   drive.tankDrive(-speed1 * Constants.LEFT_SCALING_FACTOR, -speed2 * Constants.RIGHT_SCALING_FACTOR);
  //   //drive.arcadeDrive(speed1, speed2, true);
  // }
/*
  public DifferentialDriveWheelSpeeds getWheelSpeeds() {
    double rightV = ((rightFrontE.getVelocity() + leftBackE.getVelocity()) / 2);
    double leftV = ((leftFrontE.getVelocity() + leftBackE.getVelocity()) / 2);
    return new DifferentialDriveWheelSpeeds((rightV * Constants.ROTATION_TO_METERS),
        (leftV * Constants.ROTATION_TO_METERS));
  }
*/
  public Pose2d getPose() {
    return m_odometry.getPoseMeters();
  }

/*
  public double getAverageEncoderDistance() {
    double leftd = (leftBackE.getPosition() + leftFrontE.getPosition()) / 2.0;
    double rightd = (rightBackE.getPosition() + rightFrontE.getPosition()) / 2.0;
    return (leftd + rightd) / 2.0;
  }
*/
  public void setMaxOutput(double maxOutput) {
    drive.setMaxOutput(maxOutput);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    /*
    SmartDashboard.putNumber("LeftFront", leftFrontE.getVelocity());
    SmartDashboard.putNumber("LeftBack", leftBackE.getVelocity());
    SmartDashboard.putNumber("RightFront", rightFrontE.getVelocity());
    SmartDashboard.putNumber("RightBack", rightBackE.getVelocity());
    */
    // pcmCompressor.getPressure();
  }

  public static Drivetrain getInstance() {
    return instance;
  }

}
