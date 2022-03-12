// ************************************************************
// Bishop Blanchet Robotics
// Home of the Cybears
// FRC - Rapid React - 2022
// File: Constants.java
// Intent: Forms all constants for the robot.
// ************************************************************

// ʕ •ᴥ•ʔ ʕ•ᴥ•  ʔ ʕ  •ᴥ•ʔ ʕ •`ᴥ´•ʔ ʕ° •° ʔ ʕ •ᴥ•ʔ ʕ•ᴥ•  ʔ ʕ  •ᴥ•ʔ ʕ •`ᴥ´•ʔ ʕ° •° ʔ 

package frc.robot;

import frc.robot.*;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

/**
 * A class devoted to installed hardware constants.  Use this to decide if hardware is enabled on the robot or not.
 * All developers to use this to protect their subsystems and commands from using hardware that is not actually installed
 * on the robot at hand.  Used to assist in development stages and make it easier to quickly remove a piece of hardware
 * from the robot.
 */
public class InstalledHardware
{
    // Installed I/O Electronic hardware

    // Hardware that is N/A - mostly because these pieces of hardware have no communication with the RoboRio
    // batteryInstalled = true;
    // voltageRegulartorModuleInstalled = true;
    // robotEnabledLightInstalled = true;
    // roboRioInstalled = true; - if it wasn't installed then the code wouldn't be running

    // Basic Hardware
    public static final boolean powerDistributionPanelInstalled = true;
    
    // Onboard Hardware - Orentation/Navigation Hardware
    public static final boolean wifiRadioInstalled = false;
    public static final boolean navxInstalled = false;
    public static final boolean limelightInstalled = false;

    // External Input Hardware
    public static final boolean highLevelButtonBoardInstalled = true;
    public static final boolean lowLevelButtonBoardInstalled = true;
    public static final boolean driverXboxControllerInstalled = true;
    public static final boolean coDriverXboxControllerInstalled = true;

    // Pnematics Hardware
    public static final boolean compressorInstalled = false;
    public static final boolean pressureReliefSwitchInstalled = false;

    // DriveTrain Related Hardware
    public static final boolean leftFrontDriveMotorInstalled = false;
    public static final boolean leftRearDriveMotorInstalled = false;
    public static final boolean rightFrontDriveMotorInstalled = false;
    public static final boolean rightRearDriveMotorInstalled = false;

    // TelescopingArms Related Hardware
    public static final boolean leftTelescopingArmsDriveMotorInstalled = true;
    public static final boolean rightTelescopingArmsDriveMotorInstalled = true;

    // Jaws Related Hardware
    public static final boolean topJawsDriveMotorInstalled = false;
    public static final boolean bottomJawsDriveMotorInstalled = false;

    // Shooter Related Hardware
    public static final boolean topShooterDriveMotorInstalled = true;
    public static final boolean bottomShooterDriveMotorInstalled = true;

    // Ball Storage Related Hardware
    public static final boolean topBallStorageMotorInstalled = true;
    public static final boolean bottomBallStorageMotorInstalled = true;

    // Angle Arms Related Hardware
    public static final boolean angleArmsMotorInstalled = false;
   
}
