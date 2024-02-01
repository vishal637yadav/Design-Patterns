# Facade Method Design Pattern
# Object Structural: Facade **Gang of Four design patterns**

# Intent
**Provide a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level interface that makes the subsystem easier to use.**
---
## _In Other Words_
_**Facade**_ **hides the complexity** of the **underlying system** and **provides a simple interface** that **clients can use to interact with the system**.

---

# Motivation 
**Structuring a system into subsystems** helps **reduce complexity**. A **common design goal** is to **minimize the communication** and **dependencies** between **subsystems**. One way to achieve this goal is to **introduce a facade object** that **provides a single, simplified interface to the more general facilities of a subsystem**.
![img](https://github.com/vishal637yadav/DesignPatterns/blob/master/src/common/images/FacadeDesignPatter-Example5.JPG)

## Example 1
Imagine a Building, the **facade is the outer wall** that people see, but **behind** it is **a complex network of wires, pipes**, and **other systems** that make the building function. 
The **facade pattern** is like that **outer wall**. 

![img](https://github.com/vishal637yadav/DesignPatterns/blob/master/src/common/images/FacadeDesignPatter-Example1.JPG)


## Important Topics for the **Facade Method Design Pattern**

* What is the Facade Method Design Pattern?
* When to use Facade Method Design Pattern
* Key Component of Facade Method Design Pattern
* Problem Statement for the Facade Method Design Pattern
* Use Cases of Facade Method Design Pattern
* Advantages of Facade Method Design Pattern
* Disadvantages of Facade Method Design Pattern
---
## 1. What is the Facade Method Design Pattern?
**Facade Method** Design Pattern **provides** a **unified interface** to **a set of interfaces in a subsystem**. 
**Facade** defines a **high-level interface** that **makes the subsystem easier to use**.
---

![img](https://github.com/vishal637yadav/DesignPatterns/blob/master/src/common/images/FacadeDesignPatter-Example2.JPG)

### In the above diagram,

* Structuring a system into subsystems helps reduce complexity.
* A common design goal is to minimize the communication and dependencies between subsystems.
* One way to achieve this goal is to **introduce** a **_Facade object_** that provides a _single simplified interface_ 
to the more general **facilities of a subsystem**.

## 2. When to use Facade Method Design Pattern
* A Facade provide a simple default view of the subsystem that is good enough for most clients. Only clients needing more customizability will need to look beyond the facade.
* There are many dependencies between clients and the implementation classes of an abstraction.
* A Facade to decouple the subsystem from clients and other subsystems, thereby promoting subsystem independence and portability.
* Facade define an entry point to each subsystem level. If subsystem are dependent, then you can simplify the dependencies between them by making them communicate with each other solely through their facades.
---

## 3. Key Component of Facade Method Design Pattern
![Component-of-Facade-Method-Design-Pattern](https://github.com/vishal637yadav/DesignPatterns/blob/master/src/common/images/FacadeDesignPatter-Example3.JPG)

In the above diagram,

* Consider for example a programming environment that gives applications access to its compiler subsystem.
  * This subsystem contains classes such as Scanner,Parser, ProgramNode, BytecodeStream, and ProgramNodeBuilder that implement the compiler.
* Compiler class acts as a facade: It offers clients a single, simple interface to the compilersubsystem. It glues together the classes that implement compilerfunctionality without hiding themcompletely.
* The compiler facade makes life easier for most programmers without hiding the lower-level functionality from the few that need it.
  
## Facade (Compiler)
* Facade knows which subsystem classes are responsible for a request.
* It delegate client requests to appropriate subsystem objects.
  
## Subsystem classes (Scanner, Parser, ProgramNode, etc.)
* It implement subsystem functionality.
* It handle work assigned by the Facade object.
* It have no knowledge of the facade; that is, they keep no references to it.

## Facade Method Design Pattern collaborate in different way
* Client communicate with the subsystem by sending requests to Facade, which forwards them to the appropriate subsystem objects.
* The Facade may have to do work of its own to translate it inheritance to subsystem interface.
* Clients that use the Facade don’t have to access its subsystem objects directly.
## 4. Problem Statement for the Facade Method Design Pattern
   
Problem-Statement-of-Facade-Method-Design-Pattern
![Img](https://github.com/vishal637yadav/DesignPatterns/blob/master/src/common/images/FacadeDesignPatter-Example4.JPG)

   _Let’s consider a hotel. This hotel has a hotel keeper. There are a lot of restaurants inside the hotel e.g. Veg restaurants, Non-Veg restaurants, and Veg/Non Both restaurants. You, as a client want access to different menus of different restaurants. You do not know what are the different menus they have. You just have access to a hotel keeper who knows his hotel well. Whichever menu you want, you tell the hotel keeper and he takes it out of the respective restaurants and hands it over to you._

So here, **Hotel-Keeper** is **Facade** and respective **Restaurants is system**.

---
## 4.1 Step wise Step Implementation of above problem
#### Interface of Hotel
      package structural.facade;
      public interface Hotel {
      public Menus getMenus();
      }

The hotel interface only returns Menus. Similarly, the Restaurant are of three types and can implement the hotel interface. Let’s have a look at the code for one of the Restaurants.

#### NonVegRestaurant.java

      package structural.facade;
   
      public class NonVegRestaurant implements Hotel {
      
       public Menus getMenus()
       {
           NonVegMenu nv = new NonVegMenu();
           return nv;
       }
      }

#### VegRestaurant.java

      package structural.facade;
      
      public class VegRestaurant implements Hotel {
      
          public Menus getMenus()
          {
              VegMenu v = new VegMenu();
              return v;
          }
      }

#### VegNonBothRestaurant.java

      package structural.facade;
      
      public class VegNonBothRestaurant implements Hotel {
      
          public Menus getMenus()
          {
              Both b = new Both();
              return b;
          }
      }

Now let’s consider the facade,

#### HotelKeeper.java
   
      /*package whatever //do not write package name here */
      
      package structural.facade;
      
      public interface HotelKeeper {
      
      
      public VegMenu getVegMenu();
      public NonVegMenu getNonVegMenu();
      public Both getVegNonMenu();
      
      }

#### HotelKeeperImplementation.java
   
      package structural.facade;
      
      public class HotelKeeperImplementation implements HotelKeeper {
      
          public VegMenu getVegMenu()
          {
              VegRestaurant v = new VegRestaurant();
              VegMenu vegMenu = (VegMenu)v.getMenus();
              return vegMenu;
          }
       
          public NonVegMenu getNonVegMenu()
          {
              NonVegRestaurant v = new NonVegRestaurant();
              NonVegMenu NonvegMenu = (NonVegMenu)v.getMenus();
              return NonvegMenu;
          }
       
          public Both getVegNonMenu()
          {
              VegNonBothRestaurant v = new VegNonBothRestaurant();
              Both bothMenu = (Both)v.getMenus();
              return bothMenu;
          }
      }

From this, It is clear that the complex implementation will be done by HotelKeeper himself. The client will just access the HotelKeeper and ask for either Veg, NonVeg or VegNon Both Restaurant menu.

### 4.2 How will the client program access this façade?

      package structural.facade;
      
      public class Client
      {
      public static void main (String[] args)
      {
      HotelKeeper keeper = new HotelKeeperImplementation();
      
              VegMenu v = keeper.getVegMenu();
              NonVegMenu nv = keeper.getNonVegMenu();
              Both = keeper.getVegNonMenu();
       
          }
      }

In this way, the implementation is sent to the façade. The client is given just one interface and can access only that. This hides all the complexities.

## 5. Use Cases of Facade Method Design Pattern
* **Simplifying Complex External Systems:**
  * A facade encapsulates database connection, query execution, and result processing, offering a clean interface to the application.
  * A facade simplifies the usage of external APIs by hiding the complexities of authentication, request formatting, and response parsing.
  * A facade can create a more user-friendly interface for complex or poorly documented libraries.
* **Layering Subsystems:**
  * Decoupling subsystems: Facades define clear boundaries between subsystems, reducing dependencies and promoting modularity.
  * Providing high-level views: Facades offer simplified interfaces to lower-level subsystems, making them easier to understand and use.
* **Providing a Unified Interface to Diverse Systems:**
 Integrating multiple APIs: A facade can combine multiple APIs into a single interface, streamlining interactions and reducing code duplication.
 Bridging legacy systems: A facade can create a modern interface for older, less accessible systems, facilitating their integration with newer components.
 Protecting Clients from Unstable Systems:
 Isolating clients from changes: Facades minimize the impact of changes to underlying systems by maintaining a stable interface.
 Managing third-party dependencies: Facades can protect clients from changes or issues in external libraries or services.
6. Advantages of Facade Method Design Pattern
   Simplified Interface:
   Provides a clear and concise interface to a complex system, making it easier to understand and use.
   Hides the internal details and intricacies of the system, reducing cognitive load for clients.
   Promotes better code readability and maintainability.
   Reduced Coupling:
   Decouples clients from the underlying system, making them less dependent on its internal structure.
   Promotes modularity and reusability of code components.
   Facilitates independent development and testing of different parts of the system.
   Encapsulation:
   Encapsulates the complex interactions within a subsystem, protecting clients from changes in its implementation.
   Allows for changes to the subsystem without affecting clients, as long as the facade interface remains stable.
   Improved Maintainability:
   Easier to change or extend the underlying system without affecting clients, as long as the facade interface remains consistent.
   Allows for refactoring and optimization of the subsystem without impacting client code.
7. Disadvantages of Facade Method Design Pattern
   Increased Complexity:
   Introducing a facade layer adds an extra abstraction level, potentially increasing the overall complexity of the system.
   This can make the code harder to understand and debug, especially for developers unfamiliar with the pattern.
   Reduced Flexibility:
   The facade acts as a single point of access to the underlying system.
   This can limit the flexibility for clients who need to bypass the facade or access specific functionalities hidden within the subsystem.
   Overengineering:
   Applying the facade pattern to very simple systems can be overkill, adding unnecessary complexity where it’s not needed.
   Consider the cost-benefit trade-off before implementing a facade for every situation.
   Potential Performance Overhead:
   Adding an extra layer of indirection through the facade can introduce a slight performance overhead, especially for frequently used operations.
   This may not be significant for most applications, but it’s worth considering in performance-critical scenarios.
8. Conclusion
   The facade pattern is appropriate when you have a complex system that you want to expose to clients in a simplified way, or you want to make an external communication layer over an existing system that is incompatible with the system. Facade deals with interfaces, not implementation. Its purpose is to hide internal complexity behind a single interface that appears simple on the outside.

Other Articles:

Software Design Pattern Tutorial
Java Design Patterns Tutorial
Modern C++ Design Patterns Tutorial
JavaScript Design Patterns Tutorial
Python Design Patterns Tutorial

Feeling lost in the vast world of System Design? It's time for a transformation! Enroll in our Mastering System Design From Low-Level to High-Level Solutions - Live Course and embark on an exhilarating journey to efficiently master system design concepts and techniques.
What We Offer:

Comprehensive Course Coverage
Expert Guidance for Efficient Learning
Hands-on Experience with Real-world System Design Project
Proven Track Record with 100,000+ Successful Enthusiasts
