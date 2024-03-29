# OOP---Design-Patterns
Examples of Design Pattern concepts - Mostly in JAVA
I have simple examples of 12 main used design patterns mentioned in the gang of four book.
Here I have tried to make simple examples that I think are easier to follow than reading texts from the book.
I have the examples in C++ and Java but here I would probably add mostly Java as they are easier to follow.
Since this is for showing examples and learning, I tried to make a single file that has all the interface and anstract classes in that, so following the concept becomes easier and one does not have to go through multiple files.
If you have any questions please contact me.

## Example of Composite Pattern added
This example is for a book that has hierachy of chapters. You can add sub-chapters to each chapter that the main book itself is also a chapter class. Each chapter class (and also the book) has a method that shows all the sub-chapters. So after adding all the chapters and their sub-chapters, you can run the show method to see the outline of the book.

## Example of Strategy Pattern added
In this example three behavious are defined: Flying, Eating, Speaking - as abstract classes
For each of these behaviours there are several options degined as classes that extend these behaviour abstracts. For example Flying has three options: HighFly, Jump, and NoFly. Similarly the other behaviours also have three options as an example.
When we define our object that is supposed to have these behaviours, we can inject the chosen behaviour suitable for that object to that object. The beauty of using this design pattern is that later we can change the behaviour method of the already defined if we need to.
Using this approach gives a lot of flexibility in defining and modifying objects method from a set of pre-defined method of behaviour.

## Example of Observer Pattern added
In this example, you can define a stock as being a observable class. This observerable class, contain a list of observers (that with a method you can add or remove observers). When the value of the stock is changed (here through a method setValue, but could be implemented differently), the observable 'stock' object will notify its list of observers by calling its Notify() method, and this Notify method would go over the obeservers list and call their update method. When the observer update() method is called, it will pull the new value of the stock by calling the getValue method of the observable and updates its state. 
This would help a lot that the observers, dont miss a change of the value of the object that they care about and dont need to constantly check in interval times. They will be notified of the change as soon as it has been changed.

## Example of Template method
Very useful and common method. In this example it has been used for solving leetcode 1396. Design Underground System.
In this interesting problem we want to searh for a trip in O(1). A trip is define by two parts: startStation and endStation. So in principle we want to search a hashtable with two keys. This is implemented by a class using template method that takes the two parts and overrides their hashCode method and creates a new hashCode for the combined Key object. To be able to search in the hashmap the equal method has also been overriden.
The same method is also used for Value class. Although hashCode() and equals() methods are not needed.
Template T is used in this solution so that the method can be applied to other problems when searching with two keys are needed.  

## Example of Proxy Pattern
Proxy pattern is used when for example creating an object could be computationally or memory expensive. Or when permission cannot be directly granted to an object and first need some authentication. In this example, a data_generator for Fibonacci series is created through the proxy and user contact that only through the proxy. The proxy has an Fibonacci data_generator. Both proxy and concrete object of Fibonacci are extended from the same data_generator abstract class.

<img src="media/Proxy_Pattern.PNG" width="400" height="250" />

## Example of Design Pattern
Command pattern encapsulates the methods that are executed on an object and is useful for doing a series of operation and wanting to list them and be able to track back and undo them if needed.
In UML is shown below. In this example: 
- The invoker is a controller with four buttons to control up, left, down, and right movements of a robot. 
- The receiver is the robot that we want to control with the controller. 
- Using an abstract class, named Commands in the code, we create 4 different methods and their respective Undo's that move the robot object in the 4 directions. All these concrete Commands have the same robot object that has been passed to them in their constructor and all act on this same object. 
- The controller object maintains a stack of previously executed Commands. When the Undo() method of the controller is called, it picks up the last executed Command and calls its Undo() method.

Result from executing the code is shown as comment at the end of the java file.

<img src="media/Command_Pattern.PNG" width="450" height="270" />

## Example of State Pattern
State pattern is very useful to avoid a lot of 'if' statements when the object can have different states and controls to change those states. This makes the code much more flexible in case of complex state diagrams and debugging much more easier.
For this example a simple Robot with two buttons and four states is implemented using the State Pattern Concept. As the state diagram shows, the blue button moves the state of the robot one step further in the direction of Sit->Stand->Walk->Run, if the robot is already running the blue button has no effect. The green button takes the state of the robot one step backward from Run->Walk->Stand->Sit, and if it is sitting it has no effect. This is just a simple example that could become more complicated, for example we can think about a button that makes the robot to jump but it only works if the robot is running.

- The robot has three methods one for the action that depends on its state. So it has a IState that is initialized when the object is created.
- The robot has two methods for each of the buttons that set the new state depending on the current state. 

These three methods are all implemented in concrete classes of the states. The result of the executed code is shown as comment at the end of the java file.

<img src="media/State_Pattern.PNG" width="450" height="510" />

## Example of Factory Method
Factory Patterns (Factory Method and Abstract Factory Pattern) is used to control the creation of objects. For example if we want to simply count how many of an object is created or if we want to have some statistic of properties of the objects created or we want to store them somewhere. Sometimes also it may be difficult to directly create them.

In this simple example, in a game there are Zombie objects that need to be created. For example a user may call new zombies to the game. But the game setting may be only allowing a certain number of these Zombie objects for example based on the level of the game. If the level is increased for example, the setting of the game can change to allow creation of more Zombie objects. The result of the executed code is shown as comment at the end of the java file.

The UML is very simple and cannot tell the full story, the code is better to follow the concept.

<img src="media/Factory_Method.PNG" width="450" height="270" />

