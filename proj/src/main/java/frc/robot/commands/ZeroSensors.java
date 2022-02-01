// ************************************************************
// Bishop Blanchet Robotics
// Historic home of the 'BraveBots'
// FRC - Rapid React - 2022
// File: Level.java
// Intent: Forms a command to reset all sensors?
// ************************************************************

// ʕ •ᴥ•ʔ ʕ•ᴥ•  ʔ ʕ  •ᴥ•ʔ ʕ •`ᴥ´•ʔ ʕ° •° ʔ ʕ •ᴥ•ʔ ʕ•ᴥ•  ʔ ʕ  •ᴥ•ʔ ʕ •`ᴥ´•ʔ ʕ° •° ʔ 

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Jaws;
import frc.robot.subsystems.TelescopingArms;

public class ZeroSensors extends CommandBase {
 /*
 * @param Jaws
 * @param TelescopingArms
 */

  public Jaws jaws;
  public TelescopingArms telescopingArms;

  /** Creates a new zeroSensors.  */
  public ZeroSensors(Jaws Jaws, TelescopingArms TelescopingArms) {
    // Use addRequirements() here to declare subsystem dependencies.

    this.jaws = Jaws;
    addRequirements(Jaws);

    this.telescopingArms = TelescopingArms;
    addRequirements(TelescopingArms);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    //TODO add anyother sensors 

    jaws.zeroSensors();
    telescopingArms.zeroSensors();

    System.out.println(jaws.getPosition());
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
