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

import frc.robot.Constants.DriveConstants;

public class DriveTrainNew extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public int indexx;
  private final WPI_TalonFX leftMaster = new WPI_TalonFX(DriveConstants.kLeftMaster);
  private final WPI_TalonFX leftSlave = new WPI_TalonFX(DriveConstants.kLeftSlave);

  // right side motors
  private final WPI_TalonFX rightMaster = new WPI_TalonFX(DriveConstants.kRightMaster);
  private final WPI_TalonFX rightSlave = new WPI_TalonFX(DriveConstants.kRightSlave);

  private final SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftMaster, leftSlave);
  private final SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightMaster, rightSlave);

  private final DifferentialDrive m_drive = new DifferentialDrive(leftMotors, rightMotors);


  public DriveTrainNew() {
    // this is to set the falcons to factory defalt. so this is needed to make it work
    leftMaster.configFactoryDefault();
    leftSlave.configFactoryDefault();
    rightMaster.configFactoryDefault();
    rightSlave.configFactoryDefault();
    // this should stop the browning out. this is baced on the old code.
    leftMaster.configVoltageCompSaturation(DriveConstants.kVoltageCompLevel);
    leftMaster.enableVoltageCompensation(true);
    leftMaster.configOpenloopRamp(DriveConstants.kRampCoefficient);
    leftSlave.configVoltageCompSaturation(DriveConstants.kVoltageCompLevel);
    leftSlave.enableVoltageCompensation(true);
    leftSlave.configOpenloopRamp(DriveConstants.kRampCoefficient);
    rightMaster.configVoltageCompSaturation(DriveConstants.kVoltageCompLevel);
    rightMaster.enableVoltageCompensation(true);
    rightMaster.configOpenloopRamp(DriveConstants.kRampCoefficient);    
    rightSlave.configVoltageCompSaturation(DriveConstants.kVoltageCompLevel);
    rightSlave.enableVoltageCompensation(true);
    rightSlave.configOpenloopRamp(DriveConstants.kRampCoefficient);
    // this makes things brake.
    rightMaster.setNeutralMode(NeutralMode.Brake);
    rightSlave.setNeutralMode(NeutralMode.Brake);
    leftMaster.setNeutralMode(NeutralMode.Brake);
    leftSlave.setNeutralMode(NeutralMode.Brake);

    rightMaster.setInverted(true);
    rightSlave.setInverted(true);
    leftMaster.setInverted(true);
    leftSlave.setInverted(true);
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
    //drive swap logic

    m_drive.arcadeDrive(fwd, (-1)*(rot+0), true); // Squaring values
  }

  public void stop(){
    leftMaster.set(ControlMode.PercentOutput, 0);
    rightMaster.set(ControlMode.PercentOutput, 0);
  }

}
