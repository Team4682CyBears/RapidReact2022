// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {


 // hid ports \\ 
   public static int portDriverController = 0;
   public static int portCoDriverController = 1;

 //motor ports \\  //TODO 
	 public static int climberS1MotorLeft = -1;
   public static int climberS1MotorRight = -1;

   public static int climberS2MotorLeft = -1;
   public static int climberS2MotorRight = -1;

   public static int JawsPort = -1;
   
   public static final int ShooterMotorLeft = -1;
   public static final int ShooterMotorRight = -1;



  // Jaws reach points \\
   public static int JawsDefualt = 0;
   public static int JawsShooter = 2048 * 1;//TODO the mathh to find some good points depending on the gearing 
   public static int JawsForwardLowGoal = 2048 * 2;
   
  // climber reach points \\
   public static int s1Defualt = 0;
   public static int s1Extended = 1; //TODO need to calculate top of climber
   public static int s1EndGame = 2; //TODO should be just less then double "s1Extended"
   
   public static int s2Defualt = 0; 
   public static int s2Extended = 4062 * 1; //TODO need to calculate top of climber 
   public static int s2EndGame = 4062 * 2; //TODO should be just less then double "s2Extended"



  // AngleArm timing \\
  public static final double AngleArmTiming = 0.3;





  // substystem motor speeds \\
   public static final double ShooterEatSpeed = 0.5;
   public static final double ShooterBarfSpeed = 0.5;
   public static final double ShooterDefualt = 0.5;



 // xbox buttons \\
    public final static int buttonA = 1;
    public final static int buttonB = 2;
    public final static int buttonX = 3; 
    public final static int buttonY = 4;
    public final int buttonO1 = -1;
    public final int buttonO2 = 8;
    public final int stickLeftDown = 9;
    public final int stickRightDown = 10;
    public final static int bumperLeft = 5;
    public final static int bumperRight = 6;

  //joystick axis lables 
   public static final int joystickX = 0;
   public static final int joystickY = 1;
   public static final int joystickZ = 2;




 // util \\ //TODO if needed 
 public static final int kPIDLoopIdx = 0;
 public static final int kTimeoutMs = 30;
 public static final int kSlotIdx = 0;

 public static final Gains kGains = new Gains(0.2, 0.0, 0.0, 0.2, 0, 1.0);




  



}
