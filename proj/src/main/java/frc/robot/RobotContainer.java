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
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

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
  public static Shooter m_Shooter = new Shooter();
  public static DriveTrain m_drivetrain = new DriveTrain();
  public static BallStorage m_climbers1 = new BallStorage();
  public static TelescopingArms m_TelescopingArm = new TelescopingArms();
  public static AngleArms m_AngleArm = new AngleArms();
  public static Interfaces m_interfaces = new Interfaces();
  public static BallStorage m_ballStorage = new BallStorage();


  //declaring hids
  private Joystick driverController;
  private XboxController coDriverController; 
  private Joystick buttonBoard;

  int pov = -1;
  int _pov = -1;
  int _smoothing = 0;


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer()
  {
    CommandScheduler.getInstance().registerSubsystem(m_AngleArm);
    CommandScheduler.getInstance().setDefaultCommand(m_AngleArm, new AngleArmDefault(m_AngleArm));;
   
    CommandScheduler.getInstance().registerSubsystem(m_ballStorage);

    CommandScheduler.getInstance().registerSubsystem(m_drivetrain);
    CommandScheduler.getInstance().setDefaultCommand(m_drivetrain, new DriveCommand(m_drivetrain));
  
    CommandScheduler.getInstance().registerSubsystem(m_interfaces);
  
    CommandScheduler.getInstance().registerSubsystem(m_jaws);
    CommandScheduler.getInstance().setDefaultCommand(m_jaws, new JawsDefault(m_jaws, m_interfaces));

    CommandScheduler.getInstance().registerSubsystem(m_pneumatics);

    CommandScheduler.getInstance().registerSubsystem(m_Shooter);
    CommandScheduler.getInstance().setDefaultCommand(m_Shooter, new ShooterDefault(m_Shooter, m_pneumatics, m_interfaces));

    CommandScheduler.getInstance().registerSubsystem(m_TelescopingArm);
    CommandScheduler.getInstance().setDefaultCommand(m_TelescopingArm, new TelescopingArmManual(m_TelescopingArm, m_interfaces));


  
    

 

    // init hids \\
    driverController = new Joystick(Constants.portDriverController); // sets joystick variables to joysticks
    coDriverController = new XboxController(Constants.portCoDriverController);

    // Configure the button bindings
    configureButtonBindings();
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


    JoystickButton buttonA = new JoystickButton(coDriverController, XboxController.Button.kA.value);
    JoystickButton buttonB = new JoystickButton(coDriverController, XboxController.Button.kB.value);
    JoystickButton buttonY = new JoystickButton(coDriverController, XboxController.Button.kY.value);
    JoystickButton buttonX = new JoystickButton(coDriverController, XboxController.Button.kX.value);
    JoystickButton bumperLeft = new JoystickButton(coDriverController, XboxController.Button.kLeftBumper.value);
    JoystickButton bumperRight = new JoystickButton(coDriverController, XboxController.Button.kRightBumper.value);
    JoystickButton joystickLeftButton = new JoystickButton(coDriverController, XboxController.Button.kLeftStick.value);
    JoystickButton joystickRightButton = new JoystickButton(coDriverController, XboxController.Button.kRightStick.value);
    JoystickButton triggerLeft = new JoystickButton(coDriverController, XboxController.Axis.kLeftTrigger.value);
    JoystickButton triggerRight = new JoystickButton(coDriverController, XboxController.Axis.kRightTrigger.value);
    JoystickButton backButton = new JoystickButton(coDriverController, XboxController.Button.kBack.value);
    JoystickButton startButton = new JoystickButton(coDriverController, XboxController.Button.kStart.value);



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



    //BUTTON BOARD
    //1 Jaws default      JawsDefault.java 
    //2 Jaws pos 1        JawsShooter.java
    //3 Jaws pos 2        JawsForwardLowGoal.java

    //4 climber default   climber lock + climberS1Default.java
    //5 climber pos 1     climber unlock + climberS1Extended.java 
    //6 climber pos 2     wait for climb then climberlock + climberS1Endgame.java

    //7 eat               JawsShooter + intakeEat + index eat 
    //8 barf              intakeBard (high speed) + index barf 
    //9 barf low          ShooterBarf (low speed) + index barf 

    //10 grab Jaws in 
    //11 grab Jaws out


    //BUTTON BOARD
    button1.whenPressed(new JawsDefault(m_jaws, m_interfaces));
    button2.whenPressed(new JawsIntake(m_jaws));
    button3.whenPressed(new JawsForwardLowGoal(m_jaws));

    button4.whenPressed(new TelescopingArmRetract(m_TelescopingArm, m_interfaces));//TODO
    button5.whenPressed(new TelescopingArmExtend(m_TelescopingArm, m_interfaces));//TODO
    button6.whenPressed(new TelescopingArmEndGame(m_TelescopingArm, m_interfaces));//TODO

    button7.whenPressed(new JawsIntake(m_jaws));
    button7.whenPressed(new ShooterIntake(m_Shooter, m_pneumatics, m_ballStorage));
   
    button8.whenPressed(new ShooterForwardLowShot(m_Shooter, m_pneumatics, m_interfaces, m_ballStorage));
    button9.whenPressed(new ShooterForwardLowShot(m_Shooter, m_pneumatics, m_interfaces, m_ballStorage));

    //button10.whenPressed(new lockJawsToTelescopingArm());
    //button10.whenPressed(new unlockTelescopingArm());

    //button11.whenPressed(new TelescopingArmIn());
    //button12.whenPressed(new grabOut());





//CO Driver Controller. 
//left stick Jaws
//right stick climber 
//left bumper eat
//Right bumper barf
//A + rightStick grabber
//B pneumatics 1
//C pneumatics 2
//D pneumatics 3 
//Start index 1
//Menu index 2 

    //CODRIVER CONTROLLER 
    //left stick Jaws (schedule)
    //right stick climber (schedule)
    //left trigger Shooter (schedule )
    //right trigger shoot (schedule)
    //TODO grabber stuff
    /*
    buttonA.whenPressed(new TelescopingArmLock());
    buttonB.whenPressed(new grabberUnlock());
    buttonX.whenPressed(new JawsGrabberLock());
    buttonY.whenPressed(new JawsGrabberUnlock());

    joystickLeftButton.whenPressed(new indexEat());
    joystickRightButton.whenPressed(new ShooterBarf());

    */

    /*TODO
    Engages/disengages top angle arm pneumatics solenoids
    buttonY.whenPressed(new );

    Engages/disengages bottom angle arm pneumatics solenoids
    buttonB.whenPressed(new );

    Intake and store ball at set speed at stage one motor control */
    bumperLeft.whenPressed(new JawsIntake(m_jaws));
    bumperLeft.whenPressed(new ShooterIntake(m_Shooter, m_pneumatics, m_ballStorage));
    
    //Shoot ball at set speed at stage one motor control 
    bumperRight.whenPressed(new ShooterForwardLowShot(m_Shooter, m_pneumatics, m_interfaces, m_ballStorage));
    /*
    Jaws up and down at variable speed
    joystickLeftButton.whenPressed(new );

    Telescoping arm up and down at variable speed
    joystickRightButton.whenPressed(new );

    Intake ball at variable speed
    triggerLeft.whenPressed(new );

    Shoot ball at variable speed
    triggerRight.whenPressed(new );

    Intake and store ball at set speed at stage two motor control */
    backButton.whenPressed(new JawsIntake(m_jaws));
    backButton.whenPressed(new ShooterIntake(m_Shooter, m_pneumatics, m_ballStorage));
    
    //Shoot ball at set speed at stage two motor control 
    bumperRight.whenPressed(new ShooterForwardLowShot(m_Shooter, m_pneumatics, m_interfaces, m_ballStorage));
    


    // D-Pad Stuff \\

    double pov = coDriverController.getPOV();
    System.out.println(pov);


    // joystick fun stuff \\
    double joystickThrottleValue = driverController.getThrottle();


  }

  

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  //public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    //return m_autoCommand;
  }

