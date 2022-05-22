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
