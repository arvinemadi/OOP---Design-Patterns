import java.util.*;  
abstract class Observer {
	abstract void update();
}

abstract class Observable {
	abstract void Add (Observer A);
	abstract void Remove (Observer A);
	abstract void Notify();
	abstract int GetValue();
	abstract void SetValue(int v);
}

class Stock extends Observable {
	public int value;
	public List<Observer> StockOwners;// = new ArrayList<Observer>();
	public void Add (Observer A) {
		this.StockOwners.add(A);
	}
	public void Remove (Observer A) {
		this.StockOwners.remove(A);
	}
	public void Notify() {
		for (Observer observer:this.StockOwners){
			observer.update();
		}
	}
	public Stock(int initial_value) {
		this.StockOwners = new ArrayList<Observer>();
		this.value = initial_value;
	}
	public int GetValue() {
		return value;
	}
	public void SetValue(int new_value) {
		this.value = new_value;
		this.Notify();
	}
}

class StockOwners extends Observer {
	private String Name = "";
	public int Stock_price;
	private Observable Stock;
	public StockOwners(String name, Observable stock){
		this.Stock = stock;
		this.Name = name;
		Stock_price = Stock.GetValue();
	}
	public void update() {
		Stock_price = Stock.GetValue();
		System.out.println(this.Name + " has been notified that the price is " +  this.Stock_price);
	}
}

class TV_monitor extends Observer {
	private String Name = "";
	public int Stock_price;
	private Observable Stock;
	public TV_monitor(String name, Observable stock){
		this.Stock = stock;
		this.Name = name;
		Stock_price = Stock.GetValue();
	}
	public void update() {
		Stock_price = Stock.GetValue();
		System.out.println(this.Name + " is now showing that stock price is " +  this.Stock_price);
	}
}

public class Observer_Pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("This is an example of Observer Pattern!");
		System.out.println("And, there are several other ways to implement this..");
		System.out.println("The key thing is that Observable has a list of its observers...\n");

		Stock VOO = new Stock(100);
		Stock QQQ = new Stock(250);
		Stock AMZN = new Stock(2900);
		
		StockOwners Arvin = new StockOwners("Arvin", VOO);
		StockOwners Jim = 	new StockOwners("Jim", VOO);
		StockOwners Tim = 	new StockOwners("Tim", VOO);
		TV_monitor 	TV1 = 	new TV_monitor ("TV1", VOO);  
		VOO.Add(Arvin);
		VOO.Add(Jim);
		VOO.Add(Tim);
		VOO.Add(TV1);
		
		StockOwners Joe = 	new StockOwners("Joe", QQQ);
		StockOwners Moe = 	new StockOwners("Moe", QQQ);
		StockOwners Ali = 	new StockOwners("Ali", QQQ);
		TV_monitor 	TV2 = 	new TV_monitor ("TV1", QQQ);  
		QQQ.Add(Joe);
		QQQ.Add(Moe);
		QQQ.Add(Ali);
		QQQ.Add(TV2);
		
		StockOwners Jack = 	new StockOwners("Jack", AMZN);
		StockOwners Fred = 	new StockOwners("Fred", AMZN);
		StockOwners Mike = 	new StockOwners("Mike", AMZN);
		TV_monitor 	TV3 = 	new TV_monitor ("JeffB_TV", AMZN);  

		AMZN.Add(Jack);
		AMZN.Add(Fred);
		AMZN.Add(Mike);
		AMZN.Add(TV3);
		
		VOO.SetValue(120);
		System.out.println("\n");
		
		QQQ.SetValue(200);
		System.out.println("\n");
		
		AMZN.SetValue(AMZN.GetValue() / 2);
		System.out.println("\n");
	}
}
