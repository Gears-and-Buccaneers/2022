package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.SingleMotorVictor;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.Button;
/** An example command that uses an example subsystem. */
public class Shooter extends CommandBase {

  private final SingleMotorVictor m_shooterOne;
  private final SingleMotorVictor m_shooterTwo;

  // Button X_Button = new JoystickButton(m_stick, 3);
  // Button Y_Button = new JoystickButton(m_stick, 4);
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public Shooter(SingleMotorVictor singleMotor1, SingleMotorVictor singleMotor2) {
    m_shooterOne = singleMotor1;
    m_shooterTwo = singleMotor2;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(singleMotor1, singleMotor2);
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_shooterOne.run(.5);
    m_shooterTwo.run(.5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_shooterOne.run(0);
    m_shooterTwo.run(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
