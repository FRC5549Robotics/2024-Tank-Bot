// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Pivot;
import frc.robot.commands.*;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj.XboxController;

import edu.wpi.first.wpilibj.SPI;
import org.ejml.simple.SimpleBase;
import org.ejml.simple.SimpleMatrix;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;


public class RobotContainer {
  public CommandXboxController m_controller = new CommandXboxController(Constants.XBOX_CONTROLLER);
  public CommandXboxController m_controller2 = new CommandXboxController(Constants.XBOX_CONTROLLER+1);
  // The robot's subsystems and commands are defined here...
  public final Drivetrain m_drivetrain = new Drivetrain(m_controller);
  public final Shooter m_shooter = new Shooter();
  public final Pivot m_pivot = new Pivot();
  public final Intake m_intake = new Intake();
  public final Indexer m_indexer = new Indexer();

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  JoystickButton shooterIntakeButton = new JoystickButton(m_controller2.getHID(), Constants.SHOOTER_INTAKE_BUTTON);
  JoystickButton intakeShooterButton = new JoystickButton(m_controller2.getHID(), Constants.INTAKE_SHOOTER_BUTTON);
  JoystickButton indexerButton = new JoystickButton(m_controller2.getHID(), Constants.INDEXER_BUTTON);
  JoystickButton reverseIndexerButton = new JoystickButton(m_controller2.getHID(), Constants.REVERSE_INDEXER_BUTTON);
  public RobotContainer() {
    // Configure the trigger bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be
   * created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with
   * an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for
   * {@link
   * CommandXboxController
   * Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or
   * {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureButtonBindings() {
    m_drivetrain.setDefaultCommand(new TankDriverCommander(m_drivetrain, m_controller, m_controller2));
    shooterIntakeButton.onTrue(new InstantCommand(m_shooter::intake)).onFalse(new InstantCommand(m_shooter::off));
    m_controller2.axisGreaterThan(Constants.SHOOT_TRIGGER, Constants.SHOOTER_DEADBAND).whileTrue(new Shoot(m_shooter, m_controller2));
    m_controller2.axisGreaterThan(Constants.PIVOT_JOYSTICK, Constants.PIVOT_DEADBAND).or(m_controller2.axisLessThan(Constants.PIVOT_JOYSTICK, -Constants.PIVOT_DEADBAND)).onTrue(new PivotIntake(m_pivot, m_controller2)).onFalse(new InstantCommand(m_pivot::off));
    m_controller2.axisGreaterThan(Constants.INTAKE_TRIGGER, Constants.INTAKE_DEADBAND).onTrue(new IntakeAnalog(m_intake, m_controller2)).onFalse(new InstantCommand(m_intake::off));
    intakeShooterButton.onTrue(new InstantCommand(m_intake::shoot)).onFalse(new InstantCommand(m_intake::off));
    indexerButton.onTrue(new InstantCommand(m_indexer::index)).onFalse(new InstantCommand(m_indexer::off));
    reverseIndexerButton.onTrue(new InstantCommand(m_indexer::reverse)).onFalse(new InstantCommand(m_indexer::off));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return null;
  }

}
