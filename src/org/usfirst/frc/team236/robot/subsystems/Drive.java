package org.usfirst.frc.team236.robot.subsystems;

import org.usfirst.frc.team236.robot.RobotMap;
import org.usfirst.frc.team236.robot.commands.DriveWithJoysticks;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Drive extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private SpeedController leftFrontMotor;
    private SpeedController leftBackMotor;

    private SpeedController rightFrontMotor;
    private SpeedController rightBackMotor;

    private Encoder leftEncoder;
    private Encoder rightEncoder;

    public Drive() {
        leftFrontMotor = new Talon(RobotMap.DriveMap.PWM_LEFT_FRONT);
        leftBackMotor = new Talon(RobotMap.DriveMap.PWM_LEFT_BACK);

        rightFrontMotor = new Talon(RobotMap.DriveMap.PWM_RIGHT_FRONT);
        rightBackMotor = new Talon(RobotMap.DriveMap.PWM_RIGHT_BACK);

        leftEncoder = new Encoder(RobotMap.DriveMap.DIO_ENCODER_LEFT_A, RobotMap.DriveMap.DIO_ENCODER_LEFT_B);
        rightEncoder = new Encoder(RobotMap.DriveMap.DIO_ENCODER_RIGHT_A, RobotMap.DriveMap.DIO_ENCODER_RIGHT_B);

        leftEncoder.setDistancePerPulse(RobotMap.DriveMap.DISTANCE_PER_PULSE);
        rightEncoder.setDistancePerPulse(RobotMap.DriveMap.DISTANCE_PER_PULSE);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new DriveWithJoysticks());
    }

    public void setLeftSpeed(double speed) {
        leftFrontMotor.set(speed);
        leftBackMotor.set(speed);
        SmartDashboard.putNumber("Left Speed", speed);
    }

    public void setRightSpeed(double speed) {
        rightFrontMotor.set(-speed);
        rightBackMotor.set(-speed);
        SmartDashboard.putNumber("Right Speed", -speed);
    }

    public void stop() {
        setLeftSpeed(0);
        setRightSpeed(0);
    }

    public void setMotors(double leftSpeed, double rightSpeed) {
        setLeftSpeed(leftSpeed);
        setRightSpeed(rightSpeed);
    }

    public double getLeftEncoder() {
        return leftEncoder.getDistance();
    }

    public double getRightEncoder() {
        return rightEncoder.getDistance();
    }

    public int getLeftEncoderRaw() {
        return leftEncoder.getRaw();
    }

    public int getRightEncoderRaw() {
        return rightEncoder.getRaw();
    }

    public void zeroEncoders() {
        leftEncoder.reset();
        rightEncoder.reset();
    }
}
