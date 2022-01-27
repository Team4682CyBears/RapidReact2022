// ************************************************************
// Bischop Blanchet Robotics
// Historic home of the 'BraveBots'
// FRC - Rapid React - 2022
// File: TelescopingArmRetract.java
// Intent: Forms a command to drive the telescoping arms to their retracted position.
// ************************************************************

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Interfaces;
import frc.robot.subsystems.TelescopingArms;


public class TelescopingArmRetract extends CommandBase {
  public TelescopingArms telescopingArmSubsystem;
  public Interfaces interfaceSubsystem;
  double imput;
  int pov;
  int _smoothing;
  int _pov;

  public TelescopingArmRetract(TelescopingArms telescopingArmSubsystem, Interfaces interfaceSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.telescopingArmSubsystem = telescopingArmSubsystem;
    addRequirements(telescopingArmSubsystem);

    this.interfaceSubsystem = interfaceSubsystem;
    addRequirements(interfaceSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
 
    //TODO add retract method for in the pit 
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