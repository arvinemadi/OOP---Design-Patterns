import java.util.ArrayList;
import java.io.*;
import java.util.*;

class Robot {
	int x;
	int y;
	Robot (int x_, int y_) {
		this.x = x_;
		this.y = y_;
	}
	public void status() {
		System.out.println("Robot is at location: x = " + this.x + " & y = " + this.y );
	}
}

abstract class Commands {
	public abstract void Do();
	public abstract void Undo();
}

class MoveForward extends Commands {
	Robot robot;
	MoveForward(Robot robot) {
		this.robot = robot;
	}
	public void Do() {
		robot.x += 1;
		robot.status();
	}
	public void Undo() {
		robot.x -= 1;
		robot.status();
	}
}

class MoveBackward extends Commands {
	Robot robot;
	MoveBackward(Robot robot) {
		this.robot = robot;
	}
	public void Do() {
		robot.x -= 1;
		robot.status();
	}
	public void Undo() {
		robot.x += 1;
		robot.status();
	}
}

class MoveLeft extends Commands {
	Robot robot;
	MoveLeft(Robot robot) {
		this.robot = robot;
	}
	public void Do() {
		robot.y -= 1;
		robot.status();
	}
	public void Undo() {
		robot.y += 1;
		robot.status();
	}
}

class MoveRight extends Commands {
	Robot robot;
	MoveRight(Robot robot) {
		this.robot = robot;
	}
	public void Do() {
		robot.y += 1;
		robot.status();
	}
	public void Undo() {
		robot.y -= 1;
		robot.status();
	}
}

class Controller {
	Commands UpCommand;
	Commands DownCommand;
	Commands LeftCommand;
	Commands RightCommand;
	Stack <Commands> ExectutedCommands;
	Controller (Commands U, Commands D, Commands L, Commands R) {
		this.UpCommand = U;
		this.DownCommand = D;
		this.LeftCommand = L;
		this.RightCommand = R;
		this.ExectutedCommands = new Stack<>();
	}
	public void Up() {
		UpCommand.Do();
		ExectutedCommands.push(UpCommand);
	}
	public void Down() {
		DownCommand.Do();
		ExectutedCommands.push(DownCommand);
	}
	public void Left() {
		LeftCommand.Do();
		ExectutedCommands.push(LeftCommand);
	}
	public void Right() {
		RightCommand.Do();
		ExectutedCommands.push(RightCommand);
	}
	public void Undo() {
		if (ExectutedCommands.size() == 0) {
			System.out.println("Nothing to Undo!");
			return;
		}
		Commands lastCommand = ExectutedCommands.pop();
		lastCommand.Undo();
	}
}

public class Command_Pattern {

	public static void main(String[] args) {
		Robot iRobot = new Robot(0, 0);
		Controller iController = new Controller(new MoveForward(iRobot), new MoveBackward(iRobot),
				new MoveLeft(iRobot), new MoveRight(iRobot));
		
		//Move Up once and undo twice. Second Undo gives the message that there is nothing to Undo
		iController.Up();
		iController.Undo();
		iController.Undo();

		//Move Up -> Left -> Up -> Up -> Right -> Undo -> Left -> Left -> Undo -> Undo
		iController.Up();
		iController.Left();
		iController.Up();
		iController.Up();
		iController.Right();
		iController.Undo();
		iController.Left();
		iController.Left();
		iController.Undo();
		iController.Undo();
	}
}


/*
Robot is at location: x = 1 & y = 0
Robot is at location: x = 0 & y = 0
Nothing to Undo!
Robot is at location: x = 1 & y = 0
Robot is at location: x = 1 & y = -1
Robot is at location: x = 2 & y = -1
Robot is at location: x = 3 & y = -1
Robot is at location: x = 3 & y = 0
Robot is at location: x = 3 & y = -1
Robot is at location: x = 3 & y = -2
Robot is at location: x = 3 & y = -3
Robot is at location: x = 3 & y = -2
Robot is at location: x = 3 & y = -1
*/