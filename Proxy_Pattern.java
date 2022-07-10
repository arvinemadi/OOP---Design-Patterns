import java.util.ArrayList;
abstract class data_generator {
	public abstract Long get_data(int index);
}


class Fibonacci extends data_generator {
	ArrayList<Long> f;
	Fibonacci () {
		this.f = new ArrayList<Long>();
		f.add(1L);
		f.add(1L);
		for(int i = 2; i <= 1000; i++) {
			f.add(f.get(i-1) + f.get(i-2));
		}
	}
	public Long get_data(int index) {
		if (index > 1000)	return -1L;
		return f.get(index);
	}
}


class F_proxy extends data_generator {
	data_generator my_Fibonacci;
	public Long get_data(int index) {
		if (my_Fibonacci == null)	my_Fibonacci = new Fibonacci();
		return my_Fibonacci.get_data(index);
	}
}


public class Proxy_Pattern {

	public static void main(String[] args) {
		System.out.println("This is an example of Proxy Pattern!");
		System.out.println("Since it is expensive to create a Fibonacci array we want to ensure it is done once through a Proxy");
		System.out.println("This is a simple example to show the concept, we can further limit direction creation...");
		System.out.println("of Fibonacci onject by for example requestion a code when calling the constructor");
		
		data_generator Fibonacci_calculator = new F_proxy();
		for(int i = 0; i < 75; i++) {
		System.out.println("i = " + i + "\t F(i) = " + Fibonacci_calculator.get_data(i));
		}
	}
}
