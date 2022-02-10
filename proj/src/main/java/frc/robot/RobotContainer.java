// ************************************************************
// Bishop Blanchet Robotics
// Historic home of the 'BraveBots'
// FRC - Rapid React - 2022
// File: RobotContainer.java
// Intent: Forms the key command initiation logic of the robot.
// ************************************************************

// ʕ •ᴥ•ʔ ʕ•ᴥ•  ʔ ʕ  •ᴥ•ʔ ʕ •`ᴥ´•ʔ ʕ° •° ʔ ʕ •ᴥ•ʔ ʕ•ᴥ•  ʔ ʕ  •ᴥ•ʔ ʕ •`ᴥ´•ʔ ʕ° •° ʔ 

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kForward;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kReverse;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {


  //declaring and init subsystems  
  public static Jaws m_jaws = new Jaws();
  public static Pneumatics m_pneumatics  = new Pneumatics();
  public static Shooter m_shooter = new Shooter();
  public static DriveTrain m_drivetrain = new DriveTrain();
  public static BallStorage m_climbers1 = new BallStorage();
  public static TelescopingArms m_telescopingArm = new TelescopingArms();
  public static AngleArms m_angleArm = new AngleArms();
  public static Interfaces m_interfaces = new Interfaces();
  public static BallStorage m_ballStorage = new BallStorage();

  // sets joystick variables to joysticks
  private XboxController driverController = new XboxController(Constants.portDriverController); 
  private XboxController coDriverController = new XboxController(Constants.portCoDriverController);
  private Joystick buttonBoard = new Joystick(Constants.buttonBoardPort);

  int pov = -1;
  int _pov = -1;
  int _smoothing = 0;


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer()
  {
    // Configure the button bindings
//    configureButtonBindings();

    CommandScheduler.getInstance().registerSubsystem(m_angleArm);
    m_angleArm.setDefaultCommand(
        new RunCommand(
          () ->
          m_angleArm.manualChassisConnection(driverController.getBButtonPressed() ? Value.kForward : Value.kOff),
          m_angleArm));
   
    CommandScheduler.getInstance().registerSubsystem(m_ballStorage);
    // TODO - add the default command for ballStorage

    CommandScheduler.getInstance().registerSubsystem(m_drivetrain);
    // Set the default drive command to split-stick arcade drive
    m_drivetrain.setDefaultCommand(
        new RunCommand(
          () ->
          m_drivetrain.arcadeDrive(
            driverController.getLeftX(),
            driverController.getLeftY()),
          m_drivetrain));
  
    CommandScheduler.getInstance().registerSubsystem(m_interfaces);
    // TODO - add the default command for interfaces ??????????????????????????????
  
    CommandScheduler.getInstance().registerSubsystem(m_jaws);
    // Set the jaws command to use right stick y componet
    m_jaws.setDefaultCommand(
        new RunCommand(
          () ->
          m_jaws.setJawsSpeedManual(driverController.getRightX()),
          m_jaws));

    CommandScheduler.getInstance().registerSubsystem(m_pneumatics);
    // TODO - add the default command for pneumatics ??????????????????????????????
    /*
    m_pneumatics.setDefaultCommand(
        new RunCommand(
          () ->
          m_pneumatics.compressorOn(),
          m_pneumatics));
    */

    CommandScheduler.getInstance().registerSubsystem(m_shooter);
    m_shooter.setDefaultCommand(
        new RunCommand(
          () ->
          m_shooter.shooterManual(
            (driverController.getLeftTriggerAxis() > driverController.getRightTriggerAxis() ? 
            -1.0 * driverController.getLeftTriggerAxis() : 
            driverController.getRightTriggerAxis())),
          m_shooter));

    CommandScheduler.getInstance().registerSubsystem(m_telescopingArm);
    m_telescopingArm.setDefaultCommand(
        new RunCommand(
          () ->
          m_telescopingArm.setTelescopingArmsSpeedManual(driverController.getRightY()),
          m_telescopingArm));

  }

  
  //gets the joystick axis value where ever you want, 
  //for y use Robot.m_robotContainer.getJoystickRawAxis(Constants.joystickY); 
  //for x use Robot.m_robotContainer.getJoystickRawAxis(Constants.joystickX);
  public double getJoystickRawAxis(int axis){
    return driverController.getRawAxis(axis);
  }

  public double getXboxRawAxis(int axis){
    return coDriverController.getRawAxis(axis);
  }


  private void configureButtonBindings() {

    JoystickButton buttonA = new JoystickButton(coDriverController, 1);
    JoystickButton buttonB = new JoystickButton(coDriverController, 2);
    JoystickButton buttonY = new JoystickButton(coDriverController, 3);
    JoystickButton buttonX = new JoystickButton(coDriverController, 4);
    JoystickButton bumperLeft = new JoystickButton(coDriverController, XboxController.Button.kLeftBumper.value);
    JoystickButton bumperRight = new JoystickButton(coDriverController, XboxController.Button.kRightBumper.value);
    JoystickButton joystickLeftButton = new JoystickButton(coDriverController, XboxController.Button.kLeftStick.value);
    JoystickButton joystickRightButton = new JoystickButton(coDriverController, XboxController.Button.kRightStick.value);

    JoystickButton button0 = new JoystickButton(buttonBoard, 0);
    JoystickButton button1 = new JoystickButton(buttonBoard, 1);
    JoystickButton button2 = new JoystickButton(buttonBoard, 2);
    JoystickButton button3 = new JoystickButton(buttonBoard, 3);
    JoystickButton button4 = new JoystickButton(buttonBoard, 4);
    JoystickButton button5 = new JoystickButton(buttonBoard, 5);
    JoystickButton button6 = new JoystickButton(buttonBoard, 6);
    JoystickButton button7 = new JoystickButton(buttonBoard, 7);
    JoystickButton button8 = new JoystickButton(buttonBoard, 8);
    JoystickButton button9 = new JoystickButton(buttonBoard, 9);
    JoystickButton button10 = new JoystickButton(buttonBoard, 10);
    JoystickButton button11 = new JoystickButton(buttonBoard, 11);

    //testing
    buttonA.whenPressed(new JawsIntake(m_jaws));
    buttonB.whenPressed(new JawsForwardLowGoal(m_jaws));
    buttonY.whenPressed(new JawsForwardHighGoal(m_jaws));
    buttonX.whenPressed(new RobotCalibration(m_jaws, m_telescopingArm));
  
    //BUTTON BOARD
    //0 disable button board?   ??.java

    //1 Jaws pos 1        JawsIntake.java
    //2 Jaws pos 2        JawsForwardLowGoal.java
    //3 Jaws default      JawsForwardHighGoal.java

    //4 climber default   climber lock + climberS1Default.java
    //5 climber pos 1     climber unlock + climberS1Extended.java 
    //6 climber pos 2     wait for climb then climberlock + climberS1Endgame.java

    //7 eat               JawsShooter + intakeEat + index eat 
    //8 barf              intakeBard (high speed) + index barf 
    //9 barf low          ShooterBarf (low speed) + index barf 

    //10 grab Jaws in 
    //11 grab Jaws out


    //BUTTON BOARD
    button1.whenPressed(new JawsIntake(m_jaws));
    button2.whenPressed(new JawsForwardLowGoal(m_jaws));
    button3.whenPressed(new JawsForwardHighGoal(m_jaws));

    button4.whenPressed(new TelescopingArmRetract(m_telescopingArm));
    button5.whenPressed(new TelescopingArmExtendMiddle(m_telescopingArm));
    button6.whenPressed(new TelescopingArmExtendHigh(m_telescopingArm));

    button7.whenPressed(new JawsIntake(m_jaws));
    button7.whenPressed(new ShooterIntake(m_shooter, m_ballStorage));
   
    button8.whenPressed(new ShooterForwardLowShot(m_shooter, m_ballStorage));
    button9.whenPressed(new ShooterForwardHighShot(m_shooter, m_ballStorage));
    button10.whenPressed(new ShooterReverseHighShot(m_shooter, m_ballStorage));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    // TODO - fix this stub below!!!
    return new RunCommand(
      () ->
      m_drivetrain.arcadeDrive(0.1, 0.0),
      m_drivetrain);
  }

}
