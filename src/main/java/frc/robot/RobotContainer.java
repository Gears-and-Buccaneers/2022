// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import javax.imageio.ImageIO;

import com.ctre.phoenix.sensors.Pigeon2;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.simulation.JoystickSim;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.intakeCommand;
import frc.robot.subsystems.DriveTrainNew;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.SingleMotor;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardContainer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants.Controller;
import frc.robot.Constants.DriveConstants;
import edu.wpi.first.wpilibj2.command.RunCommand;

import frc.robot.commands.drivetrainC;
import frc.robot.commands.Climberr;
import frc.robot.commands.Shooter;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  // this is a list of all the subsystems
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem(); //this is just an example
  //public XboxController m_stick = new XboxController(Controller.kDriverControllerPort);

  // this is a list of all the commans

  //public final ShootorTest m_shooter = new ShootorTest(m_SingleMotor1, m_SingleMotor2, 10,-1);
  private final ExampleCommand m_autoCommand = new ExampleCommand(); //this is just an example
  public final DriveTrainNew m_drivetrain = new DriveTrainNew();
  public final SingleMotor m_climberMotor = new SingleMotor(10);
  
  // final JoystickButton l2 = new JoystickButton(m_driveController, 1);
  // final JoystickButton l1 = new JoystickButton(m_driveController, 2);
  // more cool stuff


  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    
    m_drivetrain.setDefaultCommand(new drivetrainC(m_drivetrain, m_climberMotor));//m_stick.getRawAxis(1),m_stick.getRawAxis(2)));
    // new Climberr(m_climberMotor);
    
    //SmartDashboard.putNumber("3", m_stick.getY());//a
    //new RunCommand(() -> m_drivetrain.arcadeDrive(m_driverController.getRawAxis(1),m_driverController.getRawAxis(2)), m_drivetrain);
    // this is truly somehting randome to see what will hapen when i did it. i am keeping this in for so i rember
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  //private final Joystick m_stick = new Joystick(0);
  private void configureButtonBindings() {
    // m_drive.arcadeDrive(m_stick.getX(), m_stick.getY());
    //new JoystickButton(m_driveController, 1).whenActive(m_shooter); // this would be like button a or somehting else like that
    //l2.whenPressed(m_shooter);

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
