// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.DriveTrainNew;
import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj.Joystick;
/** An example command that uses an example subsystem. */
public class drivetrainC extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveTrainNew m_driveTrain;
//   private final double  m_movingForward;
//   private final double  m_turning;
  private final Joystick m_stick = new Joystick(0);
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public drivetrainC(DriveTrainNew driveTrain) {
    // m_movingForward = forward;
    // m_turning = turning;
    m_driveTrain = driveTrain;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // m_movingForward = m_stick.getY();
    // m_turning = m_stick.getX();
    m_driveTrain.arcadeDrive(m_stick.getX(), m_stick.getY());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
