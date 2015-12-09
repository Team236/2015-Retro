package org.usfirst.frc.team236.robot.commands;

import org.usfirst.frc.team236.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Leg2 extends Command {

    double avgDistance;
    double goal;

    public Leg2() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.drive.stop();
        Robot.drive.zeroEncoders();

        goal = 5;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.drive.setMotors(0.5, 0.5);
        avgDistance = (Robot.drive.getLeftEncoder() + Robot.drive.getRightEncoder()) / 2;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (avgDistance >= goal) {
            return true;
        }
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.drive.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

}