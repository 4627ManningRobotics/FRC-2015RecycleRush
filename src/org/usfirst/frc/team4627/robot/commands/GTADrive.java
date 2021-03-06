package org.usfirst.frc.team4627.robot.commands;

import org.usfirst.frc.team4627.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GTADrive extends Command {

    public GTADrive() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double rightTrig = Robot.oi.getRightTrigger();
    	double leftTrig = Robot.oi.getLeftTrigger();
    	double x = Robot.oi.getLeftStickX();
    	
    	double lSpeed = 0;
    	double rSpeed = 0;
    	
    	rightTrig *= -1;
    	
    	if(rightTrig < 0){
    		lSpeed = rightTrig - x;
    		rSpeed = rightTrig + x;
    	}else if(leftTrig > 0){
    		lSpeed = leftTrig - x;
    		rSpeed = leftTrig + x;
    	}else if(x > 0){
    		lSpeed = -x;
    		rSpeed = x;
    	}else if(x < 0){
    		lSpeed = -x;
    		rSpeed = x;
    	}
    	
    	Robot.chassis.setLeftMotors(lSpeed);
    	Robot.chassis.setRightMotors(rSpeed);
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
