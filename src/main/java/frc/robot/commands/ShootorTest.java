// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.SingleMotor;
// import frc.robot.RobotContainer;
public class ShootorTest extends CommandBase {
  private final SingleMotor m_singlemotor1;
  private final SingleMotor m_singlemotor2;
  private final int m_motorSpeed;
  private final int m_fliped;

  private double m_speed;
  // private RobotContainer m_RobotContainer;
  /** Creates a new runMotor. */
  public ShootorTest(SingleMotor singleMotor1, SingleMotor singleMotor2, int motorSpeed, int fliped) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_singlemotor1 = singleMotor1;
    m_singlemotor2 = singleMotor2;
    m_motorSpeed = motorSpeed;
    m_fliped = fliped;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_speed = m_motorSpeed;
    m_singlemotor1.run(m_speed);
    m_singlemotor2.run(m_speed * m_fliped);
  }
  // public void updateSpeed() {
  //   m_speed = m_RobotContainer.m_driveController.getLeftY();
  // }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
