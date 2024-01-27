// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants;
import frc.robot.subsystems.Shooter;

public class Shoot extends Command {
  /** Creates a new Shoot. */
  Shooter m_shooter;
  CommandXboxController m_controller;
  public Shoot(Shooter shooter, CommandXboxController controller) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_shooter = shooter;
    m_controller = controller;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_shooter.shoot(m_controller.getRightTriggerAxis()*Constants.SHOOTER_SCALING_FACTOR);
    System.out.println("command runs");
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_shooter.off();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
