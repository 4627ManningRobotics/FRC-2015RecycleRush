package org.usfirst.frc.team4627.robot.commands;

import org.usfirst.frc.team4627.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetElToroFeeders extends Command {
	private int direction;
	private boolean right, left;

    public SetElToroFeeders() {
        // Use requires() here to declare subsystem dependencies
    	// this.direction = direction;
         requires(Robot.elToro);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	this.right = Robot.oi.getRightBumper();
    	this.left = Robot.oi.getLeftBumper();
    	
    	if(right && left){
    		this.direction = 2;
    	}else if(!right && left){
    		this.direction = 0;
    	}else if(right && !left){
    		this.direction = 1;
    	}else{
    		this.direction = 2;
    	}
    	
    	switch(this.direction){
    	case 0:
    		Robot.elToro.setElToroArm(-1);
    		break;
    	case 1:
    		Robot.elToro.setElToroArm(1);
    		break;
    	default:
    		Robot.elToro.setElToroArm(0);
    	}
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
