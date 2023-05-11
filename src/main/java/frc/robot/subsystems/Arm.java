// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
  private Spark servo;
  /** Creates a new Arm. */
  public Arm() {
    // Using a Spark for now to work around a HALSim problem where Servo values weren't getting
    // set on the simulated hardware
    servo = new Spark(4);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setAngle(double degrees) {
    servo.set(((degrees / 180.0) * 2.0) - 1.0);
  }
}
