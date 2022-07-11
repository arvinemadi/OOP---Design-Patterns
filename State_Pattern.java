
abstract class IState {
	public abstract void Act();
	public abstract IState BlueButton();
	public abstract IState GreenButton();
}

class Walk extends IState {
	public void Act() {
		System.out.println("Robot is at walking...");
	}
	public IState BlueButton() {
		return new Run();
	}
	public IState GreenButton() {
		return new Stand();
	}
}

class Run extends IState {
	public void Act() {
		System.out.println("Robot is at running...");
	}
	public IState BlueButton() {
		return this;
	}
	public IState GreenButton() {
		return new Walk();
	}
}

class Sit extends IState {
	public void Act() {
		System.out.println("Robot is at sitting...");
	}
	public IState BlueButton() {
		return new Stand();
	}
	public IState GreenButton() {
		return this;
	}
}

class Stand extends IState {
	public void Act() {
		System.out.println("Robot is at standing...");
	}
	public IState BlueButton() {
		return new Walk();
	}
	public IState GreenButton() {
		return new Sit();
	}
}


class Robot {
	IState state;
	Robot (IState initial_state) {
		state = initial_state;
	}
	public void Act() {
		state.Act();;
	}
	public void BlueButton() {
		state = state.BlueButton();
	}
	public void GreenButton() {
		state = state.GreenButton();
	}
}

public class State_Pattern {

	public static void main(String[] args) {
		Robot iRobot = new Robot(new Sit());
		iRobot.Act();
		iRobot.Act();
		iRobot.GreenButton();
		iRobot.Act();
		iRobot.BlueButton();
		iRobot.Act();
		iRobot.BlueButton();
		iRobot.Act();
		iRobot.BlueButton();
		iRobot.Act();
		iRobot.BlueButton();
		iRobot.Act();
		iRobot.BlueButton();
		iRobot.Act();
		iRobot.GreenButton();
		iRobot.Act();
		iRobot.GreenButton();
		iRobot.Act();
		iRobot.GreenButton();
		iRobot.Act();
	}
}

/* Result of the running the code

Robot is at sitting...
Robot is at sitting...
Robot is at sitting...
Robot is at standing...
Robot is at walking...
Robot is at running...
Robot is at running...
Robot is at running...
Robot is at walking...
Robot is at standing...
Robot is at sitting...

 */
  
