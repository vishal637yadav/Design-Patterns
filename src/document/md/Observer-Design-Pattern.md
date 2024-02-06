# Observer Design Pattern

The **Observer Design Pattern** is a **behavioral design pattern** that defines a **one-to-many dependency** 
between objects so that when one object (the subject) changes state, all its dependents (observers) are notified 
and updated automatically.

observers

## Important Topics for the Observer Design Pattern

* What is the Observer Design Pattern?
* Real-world analogy of the Observer Design Pattern
* Components of Observer Design Pattern
* Observer Design Pattern example
* When to use the Observer Design Pattern?
* When not to use the Observer Design Pattern?

## What is the Observer Design Pattern?
The Observer Design Pattern is a behavioral design pattern that defines a one-to-many dependency between 
objects so that when one object (the subject) changes state, all its dependents (observers) are notified 
and updated automatically.

It primarily deals with the interaction and communication between objects, specifically focusing on 
how objects behave in response to changes in the state of other objects.

The pattern is concerned with defining a mechanism for a group of objects to interact based on changes in the state of one object (the subject). The observers’ behavior is triggered by changes in the subject’s state.
It encapsulates the behavior of the dependent objects (observers) and allows for a clean separation between the subject and its observers. This separation promotes a more modular and maintainable design.
The pattern promotes loose coupling between the subject and its observers. The subject doesn’t need to know the concrete classes of its observers, and observers can be added or removed without affecting the subject.
The primary mechanism in the Observer Pattern is the notification of observers when a change occurs. This notification mechanism facilitates the dynamic and coordinated behavior of multiple objects in response to changes in the subject.
Real-world analogy of the Observer Design Pattern
Let us Imagine a scenario where the weather station is observed by various smart devices. The weather station maintains a list of registered devices. When there’s a change in weather conditions, the weather station notifies all devices about the update.

Each device, acts as a concrete observer, interprets and displays the information in its own way.
The Observer Design Pattern facilitates a flexible and scalable system where adding new devices or weather stations doesn’t disrupt the overall communication, providing real-time and location-specific weather updates to users
Components of Observer Design Pattern
Observer-(1)

1. Subject
   The subject maintains a list of observers (subscribers or listeners). It Provides methods to register and unregister observers dynamically and defines a method to notify observers of changes in its state.

2. Observer
   Observer defines an interface with an update method that concrete observers must implement and ensures a common or consistent way for concrete observers to receive updates from the subject. Concrete observers implement this interface, allowing them to react to changes in the subject’s state.

3. ConcreteSubject
   ConcreteSubjects are specific implementations of the subject. They hold the actual state or data that observers want to track. When this state changes, concrete subjects notify their observers. For instance, if a weather station is the subject, specific weather stations in different locations would be concrete subjects.

4. ConcreteObserver
   Concrete Observer implements the observer interface. They register with a concrete subject and react when notified of a state change. When the subject’s state changes, the concrete observer’s update() method is invoked, allowing it to take appropriate actions. In a practical example, a weather app on your smartphone is a concrete observer that reacts to changes from a weather station.

Observer Design Pattern Example
Consider a scenario where you have a weather monitoring system. Different parts of your application need to be updated when the weather conditions change.

Challenges or difficulties while implementing this system without Observer Design Pattern
Components interested in weather updates would need direct references to the weather monitoring system, leading to tight coupling.
Adding or removing components that react to weather changes requires modifying the core weather monitoring system code, making it hard to maintain.
How Observer Pattern helps to solve above challenges?
The Observer Pattern helps decouple the weather monitoring system from the components interested in weather updates. Each component can register as an observer, and when the weather changes, the observers are notified. This way, adding or removing components doesn’t affect the weather monitoring system.

ObserverPatternExample

Below is the code of above problem statement using Observer Pattern:
1. Subject
   The “Subject" interface outlines the operations a subject (like “WeatherStation") should support.
   "addObserver" and “removeObserver" are for managing the list of observers.
   "notifyObservers" is for informing observers about changes.
   Java

      public interface Subject {
      void addObserver(Observer observer);
      void removeObserver(Observer observer);
      void notifyObservers();
      }
2. Observer
   The “Observer" interface defines a contract for objects that want to be notified about changes in the subject (“WeatherStation" in this case).
   It includes a method “update" that concrete observers must implement to receive and handle updates.
   Java

public interface Observer {
void update(String weather);
}
3. ConcreteSubject(WeatherStation)
   "WeatherStation" is the concrete subject implementing the “Subject" interface.
   It maintains a list of observers (“observers") and provides methods to manage this list.
   "notifyObservers" iterates through the observers and calls their “update" method, passing the current weather.
   "setWeather" method updates the weather and notifies observers of the change.
   Java

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject {
private List<Observer> observers = new ArrayList<>();
private String weather;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
 
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
 
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(weather);
        }
    }
 
    public void setWeather(String newWeather) {
        this.weather = newWeather;
        notifyObservers();
    }
}
4. ConcreteObserver(PhoneDisplay)
   "PhoneDisplay" is a concrete observer implementing the “Observer" interface.
   It has a private field weather to store the latest weather.
   The “update" method sets the new weather and calls the “display" method.
   "display" prints the updated weather to the console.
   Java

public class PhoneDisplay implements Observer {
private String weather;

    @Override
    public void update(String weather) {
        this.weather = weather;
        display();
    }
 
    private void display() {
        System.out.println("Phone Display: Weather updated - " + weather);
    }
}
5. ConcreteObserver(TVDisplay)
   "TVDisplay" is another concrete observer similar to “PhoneDisplay".
   It also implements the “Observer" interface, with a similar structure to “PhoneDisplay".
   Java

/*package whatever //do not write package name here */

import java.io.*;

class GFG {
public static void main (String[] args) {
System.out.println("GFG!");
}
}
6. Usage
   In “WeatherApp", a “WeatherStation" is created.
   Two observers (“PhoneDisplay" and “TVDisplay") are registered with the weather station using “addObserver".
   The “setWeather" method simulates a weather change to “Sunny,” triggering the “update" method in both observers.
   The output shows how both concrete observers display the updated weather information.
   Java

public class WeatherApp {
public static void main(String[] args) {
WeatherStation weatherStation = new WeatherStation();

        Observer phoneDisplay = new PhoneDisplay();
        Observer tvDisplay = new TVDisplay();
 
        weatherStation.addObserver(phoneDisplay);
        weatherStation.addObserver(tvDisplay);
 
        // Simulating weather change
        weatherStation.setWeather("Sunny");
 
        // Output:
        // Phone Display: Weather updated - Sunny
        // TV Display: Weather updated - Sunny
    }
}
Complete code for the above example
Below is the complete code for the above example:

Java

import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface Observer {
void update(String weather);
}

// Subject Interface
interface Subject {
void addObserver(Observer observer);
void removeObserver(Observer observer);
void notifyObservers();
}

// ConcreteSubject Class
class WeatherStation implements Subject {
private List<Observer> observers = new ArrayList<>();
private String weather;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
 
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
 
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(weather);
        }
    }
 
    public void setWeather(String newWeather) {
        this.weather = newWeather;
        notifyObservers();
    }
}

// ConcreteObserver Class
class PhoneDisplay implements Observer {
private String weather;

    @Override
    public void update(String weather) {
        this.weather = weather;
        display();
    }
 
    private void display() {
        System.out.println("Phone Display: Weather updated - " + weather);
    }
}

// ConcreteObserver Class
class TVDisplay implements Observer {
private String weather;

    @Override
    public void update(String weather) {
        this.weather = weather;
        display();
    }
 
    private void display() {
        System.out.println("TV Display: Weather updated - " + weather);
    }
}

// Usage Class
public class WeatherApp {
public static void main(String[] args) {
WeatherStation weatherStation = new WeatherStation();

        Observer phoneDisplay = new PhoneDisplay();
        Observer tvDisplay = new TVDisplay();
 
        weatherStation.addObserver(phoneDisplay);
        weatherStation.addObserver(tvDisplay);
 
        // Simulating weather change
        weatherStation.setWeather("Sunny");
 
        // Output:
        // Phone Display: Weather updated - Sunny
        // TV Display: Weather updated - Sunny
    }
}
Output

Phone Display: Weather updated - Sunny
TV Display: Weather updated - Sunny
When to use the Observer Design Pattern?
One-to-Many Dependence:
Use the Observer pattern when there is a one-to-many relationship between objects, and changes in one object should notify multiple dependent objects.
This is particularly useful when changes in one object need to propagate to several other objects without making them tightly coupled.
Decoupling:
Use the Observer pattern to achieve loose coupling between objects.
This allows the subject (publisher) and observers (subscribers) to interact without being aware of each other’s specific details. It promotes a flexible and maintainable system.
Change Propagation:
When changes in the state of one object should automatically trigger updates in other objects, the Observer pattern is beneficial.
This helps ensure that all dependent objects are informed and can respond accordingly to changes in the subject.
Dynamic Composition:
If you need to support dynamic composition of objects with runtime registration and deregistration of observers, the Observer pattern is suitable.
New observers can be added or existing ones removed without modifying the subject.
Event Handling:
The Observer pattern is often used in event handling systems.
When events occur in a system, observers (listeners) can react to those events without requiring the source of the events to have explicit knowledge of the observers.
When not to use the Observer Design Pattern?
Performance Overhead:
In scenarios where performance is critical and there is a concern about the overhead of managing and notifying multiple observers, the Observer pattern might not be the best choice.
It adds some runtime overhead due to maintaining the list of observers and notifying them.
Complexity for Simple Scenarios:
For simple scenarios where there are only a few objects that need to be notified of changes, using the Observer pattern might introduce unnecessary complexity.
In such cases, a direct approach might be more straightforward.
Unintended Broadcasts:
If there’s a risk of unintentionally broadcasting changes to a large number of observers and you need more control over which observers should be notified, consider alternative patterns that provide more fine-grained control.
Overuse in Small Systems:
In small applications where the benefits of decoupling and dynamic composition are not crucial, using the Observer pattern might be overkill.
Simpler mechanisms or direct communication between objects might be more appropriate.

Feeling lost in the vast world of System Design? It's time for a transformation! Enroll in our Mastering System Design From Low-Level to High-Level Solutions - Live Course and embark on an exhilarating journey to efficiently master system design concepts and techniques.
What We Offer:

Comprehensiv