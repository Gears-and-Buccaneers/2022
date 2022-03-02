package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


// stuff for the motors
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants.Controller;
import frc.robot.Constants.DriveConstants;

public class DriveTrainNew extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public int indexx;
  private final WPI_TalonFX leftParent = new WPI_TalonFX(DriveConstants.kLeftParent);
  private final WPI_TalonFX leftChild = new WPI_TalonFX(DriveConstants.kLeftChild);

  // right side motors
  private final WPI_TalonFX rightParent = new WPI_TalonFX(DriveConstants.kRightParent);
  private final WPI_TalonFX rightChild = new WPI_TalonFX(DriveConstants.kRightChild);

  private final SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftParent, leftChild);
  private final SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightParent, rightChild);

  private final DifferentialDrive m_drive = new DifferentialDrive(leftMotors, rightMotors);


  public DriveTrainNew() {
    // this is to set the falcons to factory defalt. so this is needed to make it work
    leftParent.configFactoryDefault();
    leftChild.configFactoryDefault();
    rightParent.configFactoryDefault();
    rightChild.configFactoryDefault();
    // this should stop the browning out. this is baced on the old code.
    leftParent.configVoltageCompSaturation(DriveConstants.kVoltageCompLevel);
    leftParent.enableVoltageCompensation(true);
    leftParent.configOpenloopRamp(DriveConstants.kRampCoefficient);
    leftChild.configVoltageCompSaturation(DriveConstants.kVoltageCompLevel);
    leftChild.enableVoltageCompensation(true);
    leftChild.configOpenloopRamp(DriveConstants.kRampCoefficient);
    rightParent.configVoltageCompSaturation(DriveConstants.kVoltageCompLevel);
    rightParent.enableVoltageCompensation(true);
    rightParent.configOpenloopRamp(DriveConstants.kRampCoefficient);    
    rightChild.configVoltageCompSaturation(DriveConstants.kVoltageCompLevel);
    rightChild.enableVoltageCompensation(true);
    rightChild.configOpenloopRamp(DriveConstants.kRampCoefficient);
    // this makes things brake.
    rightParent.setNeutralMode(NeutralMode.Brake);
    rightChild.setNeutralMode(NeutralMode.Brake);
    leftParent.setNeutralMode(NeutralMode.Brake);
    leftChild.setNeutralMode(NeutralMode.Brake);

    rightParent.setInverted(true);
    rightChild.setInverted(true);
    leftParent.setInverted(false);
    leftChild.setInverted(false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void arcadeDrive(double fwd, double rot) {
    
    m_drive.arcadeDrive(fwd*.8, rot*.6, true); // Squaring values
    
  }

  

  public void stop(){
    leftParent.set(ControlMode.PercentOutput, 0);
    rightParent.set(ControlMode.PercentOutput, 0);
  }

}
