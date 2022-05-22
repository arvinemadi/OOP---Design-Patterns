abstract class FlyBehavior {
	public abstract void Execute_Fly();
}

abstract class EatBehavior {
	public abstract void Execute_Eat();
}

abstract class SpeakBehavior {
	public abstract void Execute_Speak();
}

class HighFly extends FlyBehavior {
	public void Execute_Fly() {
		System.out.println("Flying really high!");
	}
}

class Jump extends FlyBehavior {
	public void Execute_Fly() {
		System.out.println("Only small jumps!");
	}
}

class NoFly extends FlyBehavior {
	public void Execute_Fly() {
		System.out.println("No flying capability!");
	}
}

class EatAlot extends EatBehavior {
	public void Execute_Eat() {
		System.out.println("Eat anything alot!");
	}
}

class Pickky extends EatBehavior {
	public void Execute_Eat() {
		System.out.println("Very picky with the food!");
	}
}

class NoFood extends EatBehavior {
	public void Execute_Eat() {
		System.out.println("Does not consume food!");
	}
}

class Loud extends SpeakBehavior {
	public void Execute_Speak() {
		System.out.println("Creates very loud noise!");
	}
}

class Good extends SpeakBehavior {
	public void Execute_Speak() {
		System.out.println("Can speak fluently!");
	}
}

class Quiet extends SpeakBehavior {
	public void Execute_Speak() {
		System.out.println("Generates small nice sound!");
	}
}

class MyObject{
	FlyBehavior _FB;
	EatBehavior _EB;
	SpeakBehavior _SB;
	public MyObject (FlyBehavior fb, EatBehavior eb, SpeakBehavior sb) {
		this._FB = fb;
		this._EB = eb;
		this._SB = sb;
	}
	public void fly() {
		this._FB.Execute_Fly();
	}
	public void eat() {
		this._EB.Execute_Eat();
	}
	public void speak() {
		this._SB.Execute_Speak();
	}
}

public class Strategy_Pattern {

	public static void main(String[] args) {
	
	MyObject Robot = new MyObject (new NoFly(), new NoFood(), new Good());
	System.out.println("A robot :");
	Robot.fly();
	Robot.eat();
	Robot.speak();
	
	MyObject Arvin = new MyObject (new NoFly(), new EatAlot(), new Good());
	System.out.println("Arvin :");
	Arvin.fly();
	Arvin.eat();
	Arvin.speak();
	
	MyObject Bear = new MyObject (new NoFly(), new EatAlot(), new Loud());
	System.out.println("Bear :");
	Bear.fly();
	Bear.eat();
	Bear.speak();
	
	MyObject Rabbit = new MyObject (new Jump(), new Pickky(), new Quiet());
	System.out.println("Rabbit :");
	Rabbit.fly();
	Rabbit.eat();
	Rabbit.speak();
	
	MyObject Eagle = new MyObject (new HighFly(), new Pickky(), new Quiet());
	System.out.println("Eagle :");
	Eagle.fly();
	Eagle.eat();
	Eagle.speak();
	
	MyObject Donkey = new MyObject (new NoFly(), new EatAlot(), new Quiet());
	System.out.println("Donkey :");
	Donkey.fly();
	Donkey.eat();
	Donkey.speak();
	
	MyObject Awl = new MyObject (new HighFly(), new EatAlot(), new Loud());
	System.out.println("Awl :");
	Awl.fly();
	Awl.eat();
	Awl.speak();
		
	}

}
