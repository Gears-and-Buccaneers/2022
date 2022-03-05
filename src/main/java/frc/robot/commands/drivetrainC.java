package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.DriveTrainNew;

import java.lang.reflect.Array;
import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.Controller;
import frc.robot.subsystems.SingleMotor;
/** An example command that uses an example subsystem. */
public class drivetrainC extends CommandBase {
  private final DriveTrainNew m_driveTrain;
//   private final double  m_movingForward;
//   private final double  m_turning;
  private final Joystick m_stick = new Joystick(0);
  
  // private final  pastJoystics = new[];

  // this is somehting taht is prety cool
  
  /*
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
  double[] intArray = new double[Controller.kArrayLength];
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    for (int j = 0; j < intArray.length; j++)
      intArray[j] = 0 ;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // m_movingForward = m_stick.getY();
    // m_turning = m_stick.getX();
    m_driveTrain.arcadeDrive(LagArray(m_stick.getY(), Controller.kArrayLength)*.8, m_stick.getX()*0.6);
    // if (m_stick.getRawButton(1)) {
    //   m_singleMotor.run(.5);
    //   m_singleMotor2.run(.5);
    // } else if (m_stick.getRawButton(3)) {
    //   m_singleMotor.run(-.5);
    //   m_singleMotor2.run(.5);
    // } else {
    //   m_singleMotor.run(0);
    //   m_singleMotor2.run(.5);
    // }
  }

  

  public double LagArray(double joysick, int arrayLength) {

    for (int i = 0; i < arrayLength-1; i++) {
      intArray[i+1] = intArray[i];
    }
    intArray[0] = joysick;
    return (sum(intArray)/Controller.kArrayLength);
  }

  public static double sum(double[] arr) {
    // getting sum of array values
    double sum = 0;
    
    for (int i = 0; i < arr.length; i++)
      sum += arr[i];
    
    return sum;
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
