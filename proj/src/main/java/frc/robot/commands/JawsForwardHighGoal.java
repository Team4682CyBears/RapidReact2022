// ************************************************************
// Bischop Blanchet Robotics
// Historic home of the 'BraveBots'
// FRC - Rapid React - 2022
// File: JawsForwardHighGoal.java
// Intent: Forms a command to drive the Jaws to the high goal forward position.
// ************************************************************

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Jaws;

public class JawsForwardHighGoal extends CommandBase {
  public Jaws jawsSubsystem;
  
  public JawsForwardHighGoal(Jaws jawsSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.jawsSubsystem = jawsSubsystem;
    addRequirements(jawsSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    jawsSubsystem.setJawsPosition(Constants.JawsForwardLowGoal);

    System.out.println(jawsSubsystem.getPosition());


  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}