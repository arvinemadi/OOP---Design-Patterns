import java.util.ArrayList;
import java.util.List;

abstract class component{
	abstract void Show(int tabs);
	abstract void Add(component c);
	abstract void Remove(component c);
}

class Chapter extends component{
	public String _name;
	public List<component> subchapters;
	public Chapter(String s) {
		_name = s;
		this.subchapters = new ArrayList<component>();
	}
	public void Add(component c) {
		this.subchapters.add(c);
	}
	public void Remove(component c) {
		this.subchapters.remove(c);
	}
	public void Show(int tab) {
		String spaces = "";
		if(tab > 0)
			spaces = String.format("%" + tab + "s", "").replace(' ', '\t');
		System.out.print(spaces + _name + "\n");
		for(component sub:this.subchapters) {
			sub.Show(tab + 1);
		}
	}
}

public class Composite_Pattern {
	public static void main(String[] args) {
	System.out.println("This is a simple illustration of Composite class that is typical for trees and graph"
				+ " implementations for example\n" + "This example shows a book chapter hierachy...\n\n");
		
	Chapter my_book 	= new Chapter("Arvin Book of OOP");
	Chapter into 		= new Chapter("Introduction");
	Chapter Composite	= new Chapter("Composite Pattern");
	Chapter	Strategy	= new Chapter("Strategy Pattern");
	Chapter Observer	= new Chapter("Observer Pattern");
	Chapter Conclusion	= new Chapter("Conclusions");
	Chapter CompCod		= new Chapter("Composite Pattern Code");
	Chapter StrCod		= new Chapter("Stratefy Pattern Code");
	Chapter ObsCod		= new Chapter("Observer Pattern Code");
	Chapter CompUML		= new Chapter("Composite Pattern UML");
	Chapter StrUML		= new Chapter("Stratefy Pattern UML");
	Chapter ObsUML		= new Chapter("Observer Pattern ULM");
	
	my_book.Add(into);	my_book.Add(Composite); my_book.Add(Strategy); my_book.Add(Observer); my_book.Add(Conclusion);
	Composite.Add(CompCod); Composite.Add(CompUML);
	Strategy.Add(StrCod); Strategy.Add(StrUML);
	Observer.Add(ObsCod); Observer.Add(ObsUML);
	
	my_book.Show(0);
	
	System.out.println("\nNow lets add some more chapters...\n");
	
	Chapter CompCode1 	= new Chapter("Example from Ggange of Four Book");
	Chapter CompCode2 	= new Chapter("Example from Head First book");
	Chapter ObsCode1 	= new Chapter("Example from the author");
	CompCod.Add(CompCode1);
	CompCod.Add(CompCode2);
	ObsCod.Add(ObsCode1);
	
	my_book.Show(0);
	}
}
