package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.SingleMotor;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.Button;
/** An example command that uses an example subsystem. */
public class Climberr extends CommandBase {

  private final SingleMotor m_singleMotor;

  private final Joystick m_stick = new Joystick(0);
  // Button X_Button = new JoystickButton(m_stick, 3);
  // Button Y_Button = new JoystickButton(m_stick, 4);
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public Climberr(SingleMotor singleMotor) {
    m_singleMotor = singleMotor;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(singleMotor);
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_stick.getRawButton(1)) {
      m_singleMotor.run(50);
    } else {
      m_singleMotor.run(50);
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
