package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


// stuff for the motors
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;


public class SingleMotor extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public int indexx;

  public SingleMotor(int indexx) {}

  private final WPI_VictorSPX main1 = new WPI_VictorSPX(indexx);

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void run(double val){
    main1.set(ControlMode.PercentOutput, val);
  }

}
