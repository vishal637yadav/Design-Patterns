# Mediator design pattern

The Mediator design pattern is a behavioral pattern that defines an object, the mediator, 
to centralize communication between various components or objects in a system. 
This promotes loose coupling by preventing direct interactions between components, 
instead of having them communicate through the mediator, facilitating better maintainability and 
flexibility in the system architecture.

# Important Topics for the Mediator Design Pattern

* What is the Mediator Design Pattern?
* Real-Life Analogy of the Mediator Design Pattern
* Components of the Mediator Design Pattern
* How components are interacting with each other?
* Mediator Design Pattern example
* When to use the Mediator Design Pattern
* When not to use the Mediator Design Pattern
* What is the Mediator Design Pattern?

A mediator design pattern is one of the important and widely used behavioral design patterns. 
Mediator enables the decoupling of objects by introducing a layer in between so that the interaction 
between objects happens via the layer. Real Life

If the objects interact with each other directly, the system components are tightly coupled with each 
other making higher maintainability cost and not hard to extend.
The mediator pattern focuses on providing a mediator between objects for communication and helps in 
implementing loose coupling between objects.
It defines how a mediator object facilitates the interaction between other objects, guiding their behavior and communication without them being directly aware of each other. This pattern emphasizes the behavior and communication patterns among objects.


Real-Life Analogy of the Mediator Design Pattern
Let’s imagine a group project in a classroom:

Colleagues (Students):
Each student in the class is like a colleague. They have their tasks but need to work together on a project.
Mediator (Teacher):
The teacher is like the mediator. Instead of students talking directly to each other, they talk to the teacher.
Communication Flow:
If a student needs information from another, they tell the teacher.
The teacher figures out how to get the needed information from the other students.
The teacher then relays the information back to the requesting student.
Students communicate indirectly through the teacher, keeping things organized and preventing chaos in the classroom.
Student talks to Teacher, Teacher manages the communication, and the information goes back through the Teacher to the requesting student. This way, everyone collaborates effectively, and individual students don’t have to directly deal with all the details of each other’s work.

## Components of the Mediator Design Pattern
1. Mediator
   The Mediator interface defines the communication contract, specifying methods that concrete mediators should implement to facilitate interactions among colleagues.. It encapsulates the logic for coordinating and managing the interactions between these objects, promoting loose coupling and centralizing control over their communication.

2. Colleague
   Colleague classes are the components or objects that interact with each other. They communicate through the Mediator, and each colleague class is only aware of the mediator, not the other colleagues. This isolation ensures that changes in one colleague do not directly affect others.

3. Concrete Mediator
   Concrete Mediator is a specific implementation of the Mediator interface. It coordinates the communication between concrete colleague objects, handling their interactions and ensuring a well-organized collaboration while keeping them decoupled.

4. Concrete colleague
   Concrete Colleague classes are the specific implementations of the Colleague interface. They rely on the Mediator to communicate with other colleagues, avoiding direct dependencies and promoting a more flexible and maintainable system architecture.

How components are interacting with each other ?
MediatorPatternClassDiagram
Below is the communication flow between components:

A Concrete Colleague object sends a message or notification to the Concrete Mediator when it needs to communicate with another colleague.
The Concrete Mediator receives the message and determines how to coordinate the interaction between the specific Concrete Colleague objects involved.
The Concrete Mediator may then invoke methods on the Concrete Colleague objects to facilitate their communication.
Colleague objects interact indirectly through the Concrete Mediator, maintaining loose coupling and avoiding direct dependencies.
Mediator Design Pattern example
In an airport, there are multiple airplanes that need to communicate and coordinate their movements to avoid collisions and ensure safe takeoffs and landings. Without a centralized system, direct communication between airplanes could lead to chaos and increased risk.

What can be the challenges while implementing this system?
Air Traffic Complexity: Direct communication between airplanes might result in complex and error-prone coordination, especially when dealing with multiple aircraft in the same airspace.
Collision Risks: Without a centralized control mechanism, the risk of collisions between airplanes during takeoffs, landings, or mid-flight maneuvers increases.
How Mediator Pattern help to solve above challenges?
The Mediator pattern helps in managing the complex communication and coordination between airplanes and air traffic controllers, ensuring a safer and more organized aviation system. The centralized control provided by the mediator simplifies interactions, reduces the risk of errors, and promotes a scalable and maintainable solution in the aviation domain.

Centralized Control: The air traffic control tower acts as a mediator, facilitating communication between airplanes. This ensures that all airplanes are aware of each other’s positions and intentions.
Collision Avoidance: The mediator (air traffic control tower) manages the flow of airplanes, preventing collisions by providing clear instructions and coordinating their movements.
MediatorDesignPatternExample
Below is the code of above problem statement using Command Pattern:
1. Colleague Interface(Airplane)

   // Colleague Interface

      package code.dp.behavioral.mediator;
      
      public interface Airplane {
      
          void requestTakeoff();
      
          void requestLanding();
      
          void notifyAirTrafficControl(String message);
      }


2. ConcreteColleague Class(CommercialAirplane)

// Concrete Colleague

      package code.dp.behavioral.mediator;
      
      public class CommercialAirplane implements Airplane {
      
          private AirTrafficControlTower mediator;
      
          public CommercialAirplane(AirTrafficControlTower mediator) {
              this.mediator = mediator;
          }
      
          @Override
          public void requestTakeoff() {
              mediator.requestTakeoff(this);
          }
      
          @Override
          public void requestLanding() {
              mediator.requestLanding(this);
          }
      
          @Override
          public void notifyAirTrafficControl(String message) {
              System.out.println("Commercial Airplane: " + message);
          }
      
      }
   

3. Mediator Interface(AirTrafficControlTower)

// Mediator Interface

      package code.dp.behavioral.mediator;
      
      public interface AirTrafficControlTower {
      
          void requestTakeoff(Airplane airplane);
      
          void requestLanding(Airplane airplane);
      
      }

4. ConcreteMediator Class(AirportControlTower)

// Concrete Mediator

      package code.dp.behavioral.mediator;
      
      public class AirportControlTower implements AirTrafficControlTower {
      
          @Override
          public void requestTakeoff(Airplane airplane) {
              // Logic for coordinating takeoff
              airplane.notifyAirTrafficControl("Requesting takeoff clearance.");
          }
      
          @Override
          public void requestLanding(Airplane airplane) {
              // Logic for coordinating landing
              airplane.notifyAirTrafficControl("Requesting landing clearance.");
          }
      
      }

### Main Driving Class :

      package code.dp.behavioral.mediator;
      
      public class MediatorAirplaneExample {
      
          public static void main(String[] args) {
               // Instantiate the Mediator (Airport Control Tower)
               AirTrafficControlTower controlTower = new AirportControlTower();
      
               // Instantiate Concrete Colleagues (Commercial Airplanes)
               Airplane airplane1 = new CommercialAirplane(controlTower);
               Airplane airplane2 = new CommercialAirplane(controlTower);
      
               // Set up the association between Concrete Colleagues and the Mediator
               airplane1.requestTakeoff();
               airplane2.requestLanding();
      
               // Output:
               // Commercial Airplane: Requesting takeoff clearance.
               // Commercial Airplane: Requesting landing clearance.
          }
      
      
      }


### Output :
Commercial Airplane: Requesting takeoff clearance.<br>
Commercial Airplane: Requesting landing clearance.<br>

## When to use the Mediator Design Pattern
Complex Communication: Your system involves a set of objects that need to communicate with each other in a complex manner, and you want to avoid direct dependencies between them.
Loose Coupling: You want to promote loose coupling between objects, allowing them to interact without knowing the details of each other’s implementations.
Centralized Control: You need a centralized mechanism to coordinate and control the interactions between objects, ensuring a more organized and maintainable system.
Changes in Behavior: You anticipate changes in the behavior of components, and you want to encapsulate these changes within the mediator, preventing widespread modifications.
Enhanced Reusability: You want to reuse individual components in different contexts without altering their internal logic or communication patterns.

## When not to use the Mediator Design Pattern
Simple Interactions: The interactions between components are straightforward, and introducing a mediator would add unnecessary complexity.
Single Responsibility Principle (SRP): Each component has a single responsibility, and introducing a mediator might violate the Single Responsibility Principle, leading to less maintainable code.
Performance Concerns: Introducing a mediator could introduce a performance overhead, especially in situations where direct communication between components is more efficient.
Small Scale Applications: In small-scale applications with a limited number of components, the overhead of implementing a mediator might outweigh its benefits.
Over-Engineering: Avoid using the Mediator pattern if it seems like an over-engineered solution for the specific requirements of your system. Always consider the trade-offs and the specific needs of your application.

---