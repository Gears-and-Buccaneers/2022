package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.SingleMotor;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.Button;
/** An example command that uses an example subsystem. */
public class Shooter extends CommandBase {

  private final SingleMotor m_shooterOne;
  private final SingleMotor m_shooterTwo;
  private final SingleMotor m_Intake;
  private final SingleMotor m_Transport;

  private final Joystick m_stick = new Joystick(0);
  private boolean ToggleShooter = false;
  private boolean ToggleIntake = false;
  private boolean ToggleTransit = false;
  // Button X_Button = new JoystickButton(m_stick, 3);
  // Button Y_Button = new JoystickButton(m_stick, 4);
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public Shooter(SingleMotor singleMotor) {
    m_shooterOne = singleMotor;
    m_shooterTwo = singleMotor;
    m_Intake = singleMotor;
    m_Transport = singleMotor;
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
      ToggleShooter = ToggleShooter != true;
    }
    if (m_stick.getRawButton(2)) {
      ToggleIntake = ToggleIntake != true;
    }
    if (m_stick.getRawButton(3)) {
      ToggleTransit = ToggleTransit != true;
    }
    
    if (ToggleShooter) {
      m_shooterOne.run(50);
      m_shooterTwo.run(50);
    }
    if (ToggleIntake) {
      m_Intake.run(50);
    }
    if (ToggleTransit) {
      m_Transport.run(50);
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
