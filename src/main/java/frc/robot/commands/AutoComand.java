package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.DriveTrainNew;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
/** An example command that uses an example subsystem. */
public class AutoComand extends CommandBase {
  private final DriveTrainNew m_driveTrain;
  private final Timer m_timer = new Timer();
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public AutoComand(DriveTrainNew driveTrain) {
    // m_movingForward = forward;
    // m_turning = turning;
    m_driveTrain = driveTrain;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_timer.reset();
    m_timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  //@Override
  public void run() {
    if (m_timer.get() <= 2.0) {
      m_driveTrain.arcadeDrive(.2, 0);
    } else {
      m_driveTrain.arcadeDrive(0, 0);
    }
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
