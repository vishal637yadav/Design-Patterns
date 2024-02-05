# DesignPatterns
DesignPatterns - Low Level Design

[Proxy Design Pattern :Structural Design Pattern](https://youtu.be/9MxHKlVc6ZM)


---
# Design Patterns

|<b>[**Creational**]()</b>|<b>[**Structural**]()</b>|[**Behavourial**]()</b>|
|---|---|---|
|<b>[1.Command](https://github.com/vishal637yadav/DesignPatterns/blob/master/src/document/md/Command-Design-Pattern.md)</b>|<b>[1.FacadeMethod](https://github.com/vishal637yadav/DesignPatterns/blob/master/src/document/md/FacadeMethodDesignPattern.md)</b>|<b>[1.Iterator-Behavioral-Design-Pattern.md](https://github.com/vishal637yadav/DesignPatterns/blob/master/src/document/md/Iterator-Behavioral-Design-Pattern.md)</b>|
|<b>[2.Command-Design-Pattern.md](https://github.com/vishal637yadav/DesignPatterns/blob/master/src/document/md/Command-Design-Pattern.md)</b>|<b>[1.FacadeMethod](https://github.com/vishal637yadav/DesignPatterns/blob/master/src/document/md/FacadeMethodDesignPattern.md)</b>|<b>[1.Iterator-Behavioral-Design-Pattern.md](https://github.com/vishal637yadav/DesignPatterns/blob/master/src/document/md/Iterator-Behavioral-Design-Pattern.md)</b>|
|<b>[3.Command-Design-Pattern.md](https://github.com/vishal637yadav/DesignPatterns/blob/master/src/document/md/Command-Design-Pattern.md)</b>|<b>[1.FacadeMethod](https://github.com/vishal637yadav/DesignPatterns/blob/master/src/document/md/FacadeMethodDesignPattern.md)</b>|<b>[1.Iterator-Behavioral-Design-Pattern.md](https://github.com/vishal637yadav/DesignPatterns/blob/master/src/document/md/Iterator-Behavioral-Design-Pattern.md)</b>|
|<b>[Factory Method(Class)]()</b>|<b>[Adapter(Class)]()</b>|<b>[Interpreter(Class)]()</b>|
|<b>[Abstract Factory]()</b>|<b>[Adapter(Object)]()</b>|[Template Method(Class)]()</b>|
|<b>[Builder]()</b>|<b>[Bridge]()</b>|[Chain of Responsibility]()</b>|
|<b>[Prototype]()</b>|<b>[Composite]()</b>|[<b>Command</b>](https://github.com/vishal637yadav/DesignPatterns/blob/master/src/document/md/Command-Design-Pattern.md)|
|<b>[Singleton]()</b>|<b>[Decorator]()</b>|[Iterator]()</b>|
|<b>[--]()</b>|<b>[Facade]()</b>|[Mediator]()</b>|
|<b>[--]()</b>|<b>[Flyweight]()</b>|[Memento]()</b>|
||<b>[Proxy]()</b>|[Observer]()</b>|
||<b>[--]()</b>|[State]()</b>|
||<b>[--]()</b>|[Strategy]()</b>|
||<b>[**Structural**]()</b>|[Visitor]()</b>|
||<b>[**Structural**]()</b>|[**Behavourial**]()</b>|

---

---
# Creational design patterns:
Creational design patterns abstract the instantiation process. They help make a system independent of how its objects are created, composed, and represented. A class creational pattern uses inheritance to vary the class that’s instantiated, whereas an object creational pattern will delegate instantiation to another object. Creational patterns become important as systems evolve to depend more on object composition than class inheritance. As that happens, emphasis shifts away from hard-coding a fixed set of behaviors toward defining a smaller set of fundamental behaviors that can be composed into any number of more complex ones. Thus creating objects with particular behaviors requires more than simply instantiating a class. There are two recurring themes in these patterns. First, they all encapsulate knowledge about which concrete classes the system uses. Second, they hide how instances of these classes are created and put together. All the system at large knows about the objects is their interfaces as defined by abstract classes. Consequently, the creational patterns give you a lot of flexibility in what gets created, who creates it, how it gets created, and when.

Gamma, Erich; Helm, Richard; Johnson, Ralph; Vlissides, John. Design Patterns (Addison-Wesley Professional Computing Series) (p. 127). Pearson Education. Kindle Edition. 

These are my notes in <b>Javascript</b> from a [course](https://www.educative.io/courses/grokking-the-coding-interview) that categorizes coding interview problems into a set of <b>16 patterns</b>. 
|   |   |
|---|---|
| <b>[Pattern 1: Sliding Window](./✅%20%20Pattern%2001%20:%20Sliding%20Window.md)</b>|<b>[Pattern 9: Two Heaps](./✅%20🙃%20Pattern%2009:%20Two%20Heaps.md)</b>   |
|<b>[Pattern 2: Two Pointer](./✅%20%20Pattern%2002:%20Two%20Pointers.md)</b>|<b>[Pattern 10: Subsets](./✅%20%20Pattern%2010:%20Subsets.md)</b>|
|<b>[Pattern 3: Fast & Slow pointers](./✅%20%20Pattern%2003:%20Fast%20%26%20Slow%20pointers.md)</b>|<b>[Pattern 11: Modified Binary Search](./✅%20%20Pattern%2011:%20Modified%20Binary%20Search.md)</b>|
