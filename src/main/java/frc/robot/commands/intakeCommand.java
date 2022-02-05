// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SingleMotor;

public class intakeCommand extends CommandBase {
  private final SingleMotor m_singlemotor;
  private final int m_motorSpeed;
  /** Creates a new runMotor. */
  public intakeCommand(SingleMotor singleMotor, int motorSpeed) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_singlemotor = singleMotor;
    m_motorSpeed = motorSpeed;
    addRequirements(singleMotor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_singlemotor.run(m_motorSpeed/100);
  }

  public void somethignRanodm() {
    m_singlemotor.run(m_motorSpeed/100);
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
