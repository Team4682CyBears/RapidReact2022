// ************************************************************
// Bishop Blanchet Robotics
// Historic home of the 'BraveBots'
// FRC - Rapid React - 2022
// File: AngleArmDefault.java
// Intent: Forms a command to have the AngleArm attach to the chassis and disconnect from the Jaws.
// ************************************************************

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.AngleArms;

public class AngleArmDefault extends CommandBase {
  private AngleArms AngleArmSubsystem;
  private Timer timer = new Timer();
  //private boolean done;

  public AngleArmDefault(
    AngleArms AngleArmSubsystem
    ) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.AngleArmSubsystem = AngleArmSubsystem;
    addRequirements(AngleArmSubsystem);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
    //done = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    AngleArmSubsystem.disengageArm();
    AngleArmSubsystem.engageChassis();

    if (timer.hasElapsed(Constants.AngleArmTiming)){
      AngleArmSubsystem.disengageArm();
      //done = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {  
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
