// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class WaveArm extends CommandBase {
  private Arm arm;
  private double armDegrees = 0;
  private long lastMoveTime = 0;
  private double angleDelta = 5.0;

  /** Creates a new WaveArm. */
  public WaveArm(Arm arm) {
    this.arm = arm;
    addRequirements(arm);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    armDegrees = 0;
    lastMoveTime = System.currentTimeMillis();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (System.currentTimeMillis() - lastMoveTime > 200) {
      armDegrees += angleDelta;
      if (armDegrees > 180) {
        armDegrees = 180;
        angleDelta = -angleDelta;
      }
      if (armDegrees < 0) {
        armDegrees = 0;
        angleDelta = -angleDelta;
      }
      arm.setAngle(armDegrees);
      lastMoveTime = System.currentTimeMillis();
    }
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
