// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatorCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class intake extends SubsystemBase {
  
  
  private WPI_TalonFX motor = new WPI_TalonFX(Constants.intakeMotorLeft);
  private WPI_TalonFX right = new WPI_TalonFX(Constants.intakeMotorRight);

	final int kUnitsPerRevolution = 2048; /* this is constant for Talon FX */

/** Creates a new intake. */
  public intake() {
    motor.configFactoryDefault();
    right.follow(motor);
    right.setInverted(true);
    
    motor.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, Constants.kPIDLoopIdx,
    Constants.kTimeoutMs);

    motor.setSensorPhase(false);
    motor.setInverted(false);

    motor.configNeutralDeadband(0.001, Constants.kTimeoutMs);

    
    motor.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, Constants.kTimeoutMs);
    motor.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, Constants.kTimeoutMs);

    		/* Set the peak and nominal outputs */
		motor.configNominalOutputForward(0, Constants.kTimeoutMs);
		motor.configNominalOutputReverse(0, Constants.kTimeoutMs);
		motor.configPeakOutputForward(1, Constants.kTimeoutMs);
		motor.configPeakOutputReverse(-1, Constants.kTimeoutMs);

    motor.selectProfileSlot(Constants.kSlotIdx, Constants.kPIDLoopIdx);
    motor.config_kF(Constants.kSlotIdx, Constants.kGains.kF, Constants.kTimeoutMs);
    motor.config_kP(Constants.kSlotIdx, Constants.kGains.kP, Constants.kTimeoutMs);
    motor.config_kI(Constants.kSlotIdx, Constants.kGains.kI, Constants.kTimeoutMs);
    motor.config_kD(Constants.kSlotIdx, Constants.kGains.kD, Constants.kTimeoutMs);

    //motor.setNeutralMode(NeutralMode.Brake);

    //motor.configMotionCruiseVelocity(30000, Constants.kTimeoutMs);
    //motor.configMotionAcceleration(30000, Constants.kTimeoutMs);

    // current limit enabled | Limit(amp) | Trigger Threshold(amp) | Trigger
    // Threshold Time(s) */
    motor.configStatorCurrentLimit(new StatorCurrentLimitConfiguration(false, 20, 25, 1.0));

    // left.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
  }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void eat(double speed){
    motor.set(TalonFXControlMode.PercentOutput, speed);
  }

  public void barf(double speed){
    motor.set(TalonFXControlMode.PercentOutput, speed);
  }

  public void defualt(){
    motor.set(TalonFXControlMode.PercentOutput, Constants.intakeDefualt);
  }
}
