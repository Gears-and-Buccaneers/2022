package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
/** An example command that uses an example subsystem. */
public class  SmartDashbordUpdate extends CommandBase {
    private final Joystick m_stick = new Joystick(0);
    /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public SmartDashbordUpdate() {
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putBoolean("1", m_stick.getRawButton(1));//a
    SmartDashboard.putBoolean("2", m_stick.getRawButton(2));//b
    SmartDashboard.putBoolean("3", m_stick.getRawButton(3));//x
    SmartDashboard.putBoolean("4", m_stick.getRawButton(4));//y
    SmartDashboard.putBoolean("5", m_stick.getRawButton(5));//l2
    SmartDashboard.putBoolean("6", m_stick.getRawButton(6));//r2
    SmartDashboard.putBoolean("7", m_stick.getRawButton(7));//start
    SmartDashboard.putBoolean("8", m_stick.getRawButton(8));//back
    SmartDashboard.putNumber("10", m_stick.getRawAxis(1));
    SmartDashboard.putNumber("11", m_stick.getRawAxis(2));
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