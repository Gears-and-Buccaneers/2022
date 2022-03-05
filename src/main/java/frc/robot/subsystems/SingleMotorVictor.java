package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


// stuff for the motors
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX; // tallon
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX; // falcon
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX; // victor
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;


public class SingleMotorVictor extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private int indexx;

  public SingleMotorVictor(int indexx) {}

  VictorSPX main1 = new VictorSPX(indexx);
  @Override
  public void periodic() {
    // // This method will be called once per scheduler run
    // main1.configFactoryDefault();
    // // this should stop the browning out. this is baced on the old code.
    // main1.enableVoltageCompensation(true);
    // // this makes things brake.
    // main1.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void run(double val){
    main1.set(ControlMode.PercentOutput, val);
  }

}
