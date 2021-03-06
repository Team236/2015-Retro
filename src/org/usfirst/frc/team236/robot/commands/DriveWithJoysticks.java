package org.usfirst.frc.team236.robot.commands;

import org.usfirst.frc.team236.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveWithJoysticks extends Command {

    public DriveWithJoysticks() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.drive.stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double leftSpeed = Robot.oi.leftStick.getY();
        double rightSpeed = Robot.oi.rightStick.getY();
        Robot.drive.setLeftSpeed(leftSpeed);
        Robot.drive.setRightSpeed(rightSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
