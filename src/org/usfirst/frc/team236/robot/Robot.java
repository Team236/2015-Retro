
package org.usfirst.frc.team236.robot;

import org.usfirst.frc.team236.robot.commands.Autonomous;
import org.usfirst.frc.team236.robot.commands.ZeroDriveEncoders;
import org.usfirst.frc.team236.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    public static OI oi;
    public static Drive drive = new Drive();

    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        oi = new OI();
        // instantiate the command used for the autonomous period
        // autonomousCommand = new ExampleCommand();
        autonomousCommand = new Autonomous();
    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null)
            autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null)
            autonomousCommand.cancel();

    }

    /**
     * This function is called when the disabled button is hit. You can use it
     * to reset subsystems before shutting down.
     */
    public void disabledInit() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("Left Stick Y", oi.leftStick.getY());
        SmartDashboard.putNumber("Right Stick Y", oi.rightStick.getY());
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("Left Stick Y", oi.leftStick.getY());
        SmartDashboard.putNumber("Right Stick Y", oi.rightStick.getY());

        SmartDashboard.putInt("Left Encoder", drive.getLeftEncoderRaw());
        SmartDashboard.putInt("Right Encoder", drive.getRightEncoderRaw());

        SmartDashboard.putData(new ZeroDriveEncoders());
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
