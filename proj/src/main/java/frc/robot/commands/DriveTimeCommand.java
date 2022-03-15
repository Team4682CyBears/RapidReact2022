// ************************************************************
// Bishop Blanchet Robotics
// Home of the Cybears
// FRC - Rapid React - 2022
// File: DriveTimeCommand.java
// Intent: Forms a command to drive the wheels according to input parameters (encoder dead reckoning and accelormeter for rotation).
// ************************************************************

// ʕ •ᴥ•ʔ ʕ•ᴥ•  ʔ ʕ  •ᴥ•ʔ ʕ •`ᴥ´•ʔ ʕ° •° ʔ ʕ •ᴥ•ʔ ʕ•ᴥ•  ʔ ʕ  •ᴥ•ʔ ʕ •`ᴥ´•ʔ ʕ° •° ʔ 

package frc.robot.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class DriveTimeCommand extends CommandBase
{
  private DriveTrain driveTrain;
  private Timer timer = new Timer();
  private boolean done = false;
  private double powerValue = 0.0;
  private double spinValue = 0.0;
  private double durationSecondsValue = 0.0;
  
  /** 
  * Creates a new driveCommand. 
  * 
  * @param driveTrainSubsystem - the drive train subsystem
  */
  public DriveTimeCommand(
    DriveTrain driveTrainSubsystem,
    double power,
    double spin,
    double durationSeconds)
  {
    // Use addRequirements() here to declare subsystem dependencies.
    this.driveTrain = driveTrainSubsystem;
    addRequirements(driveTrain);

    powerValue = power;
    spinValue = spin;
    durationSecondsValue = durationSeconds;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize()
  {
    timer.reset();
    timer.start();
    done = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute()
  {
    this.driveTrain.arcadeDrive(powerValue, spinValue);
    if (timer.hasElapsed(this.durationSecondsValue))
    {
      done = true;
    }
}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted)
  {
    this.driveTrain.arcadeDrive(0.0, 0.0);
    if(interrupted)
    {
      done = true;      
    }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished()
  {
    return done;
  }
}
