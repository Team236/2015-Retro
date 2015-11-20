package org.usfirst.frc.team236.robot.subsystems;

import org.usfirst.frc.team236.robot.commands.DriveWithJoysticks;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

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

    public Drive() {
        leftFrontMotor = new Talon(0);
        leftBackMotor = new Talon(1);

        rightFrontMotor = new Talon(2);
        rightBackMotor = new Talon(3);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new DriveWithJoysticks());
    }

    public void setLeftSpeed(double speed) {
        leftFrontMotor.set(speed);
        leftBackMotor.set(speed);
    }

    public void setRightSpeed(double speed) {
        rightFrontMotor.set(-speed);
        rightBackMotor.set(-speed);
    }

    public void stop() {
        setLeftSpeed(0);
        setRightSpeed(0);
    }
    
    public void setMotors(double leftSpeed, double rightSpeed) {
        setLeftSpeed(leftSpeed);
        setRightSpeed(rightSpeed);
    }
}
