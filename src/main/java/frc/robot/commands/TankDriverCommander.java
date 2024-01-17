
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

public class TankDriverCommander extends Command {
  /** Creates a new TankDrive. */
  private final Drivetrain m_drivetrain;
  private final CommandXboxController m_controller;

  public TankDriverCommander(Drivetrain drivetrain, CommandXboxController xbox) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_drivetrain = drivetrain;
    m_controller = xbox;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // slide = Math.abs(m_axis1.getRawAxis(3));
    m_drivetrain.arcadeDriveMethod(m_controller.getLeftY()*Constants.FORWARD_SCALING_FACTOR, m_controller.getRightX()*Constants.ROTATION_SCALING_FACTOR);/// , m_axis1.getRawAxis(3), m_axis2.getRawAxis(3));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}