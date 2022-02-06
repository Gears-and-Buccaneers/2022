package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.ArrayList;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;
//import io.github.oblarg.oblog.annotations.Log;

public class Drivetrain {
  // left side motors
  private final WPI_TalonFX leftMaster = new WPI_TalonFX(DriveConstants.kLeftMaster);
  private final WPI_TalonFX leftSlave = new WPI_TalonFX(DriveConstants.kLeftSlave);

  // right side motors
  private final WPI_TalonFX rightMaster = new WPI_TalonFX(DriveConstants.kRightMaster);
  private final WPI_TalonFX rightSlave = new WPI_TalonFX(DriveConstants.kRightSlave);

  private final SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftMaster, leftSlave);
  private final SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightMaster, rightMaster);

  // the drivebase
  private final DifferentialDrive m_drive = new DifferentialDrive(leftMotors, rightMotors);

  private boolean swapDrive;

  public Drivetrain() {
    //reset talons to factory defaults just in case of a swap or a setting changed in phoenix tuner
    leftMaster.configFactoryDefault();
    leftSlave.configFactoryDefault();
    rightMaster.configFactoryDefault();
    rightSlave.configFactoryDefault();

    // all of this is to prevent battery brownouts
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
		
		/* Configure output and sensor direction */
    leftMaster.setInverted(false);
    leftSlave.setInverted(false);
    rightMaster.setInverted(false);
    rightSlave.setInverted(false);

    //make sure all of the motors brake when no input is applied
    rightMaster.setNeutralMode(NeutralMode.Brake);
    rightSlave.setNeutralMode(NeutralMode.Brake);
    leftMaster.setNeutralMode(NeutralMode.Brake);
    leftSlave.setNeutralMode(NeutralMode.Brake);

    m_drive.setSafetyEnabled(false); //motor safety was getting mad because we are overrunning loop times, so i tunred it off -J
    //m_drive.setRightSideInverted(false); //we are doing motor inverts above manually, so changing it in wpilib is redundant

    swapDrive = false;
    SmartDashboard.putBoolean("drive swapped?", swapDrive); //for telling the driver if he has engaged drive swapped

  }

  public void arcadeDrive(double fwd, double rot) {
    //drive swap logic
    if(swapDrive){
      m_drive.arcadeDrive(-fwd, (-1)*(rot-0));
    }
    else{
      m_drive.arcadeDrive(fwd, (-1)*(rot+0), true); // Squaring values
    }
  }

  //drive each side individually (for auto)
  public void drive(double left, double right) {
    m_drive.tankDrive(left, right);
  }

  public void stop(){
    leftMaster.set(ControlMode.PercentOutput, 0);
    rightMaster.set(ControlMode.PercentOutput, 0);
  }

  // public void log(){
  // }

  // public void toggleSwap(){
  //   if(swapDrive){
  //     swapDrive = false;
  //     SmartDashboard.putBoolean("drive swapped?", swapDrive);
  //   }
  //   else{
  //     swapDrive = true;
  //     SmartDashboard.putBoolean("drive swapped?", swapDrive);
  //   }
  // }

  /**
   * Controls the left and right sides of the drive directly with voltages.
   *
   * @param leftVolts  the commanded left output
   * @param rightVolts the commanded right output
   */
  // public void tankDriveVolts(double leftVolts, double rightVolts) {
  //   leftMaster.setVoltage(leftVolts);
  //   rightMaster.setVoltage(-rightVolts);
  //   m_drive.feed();
  // }

  /**
   * Sets the max output of the drive.  Useful for scaling the drive to drive more slowly.
   *
   * @param maxOutput the maximum output to which the drive will be constrained
   */
  // public void setMaxOutput(double maxOutput) {
  //   m_drive.setMaxOutput(maxOutput);
  // }
}
