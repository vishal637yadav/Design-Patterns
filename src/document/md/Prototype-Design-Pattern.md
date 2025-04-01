# Prototype Design Pattern : Creational Design Pattern

* Prototype is a Creational Design Pattern.
* Prototype DP Allows **cloning objects**, even complex ones, **without coupling** to their **specific** classes.

All prototype classes should have a common interface that makes it possible to copy objects even if their concrete classes are unknown.<br> 
Prototype objects can produce full copies since objects of the same class can access each other’s private fields.

## Usage examples: 
* The Prototype pattern is available in Java out of the box with a **Cloneable** interface.
* Any class can implement this interface to become cloneable.

**java.lang.Object#clone()** (class should implement the java.lang.Cloneable interface)<br>
**Identification:** The prototype can be easily recognized by a clone or copy methods, etc.

### Example
#### Address class:
    class Address {
        String city;
    
        // Constructor
        Address(String city) {
            this.city = city;
        }
    }

#### Person class (which is clonable)
    class Person implements Cloneable {
        String name; // Primitive field
        Address address; // Reference-type field
    
        // Constructor
        Person(String name, Address address) {
            this.name = name;
            this.address = address;
        }
        
        // clone() method is inherited from Object class and must be Overriden 
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();  // Shallow copy
        }
    }
#### Main Class
    class Main {
        
        public static void main(String[] args) throws CloneNotSupportedException {
            Address address = new Address("Mumbai");
            Person person = new Person("Rahul", address);
    
            Person clonedPerson = (Person) person.clone(); // Cloning person
    
            // Modifying the address in the cloned object
            clonedPerson.address.city = "New Delhi";
    
            // Output to check if changes are reflected in the original
            System.out.println(person.name + " lives in " + person.address.city);  // New Delhi
            System.out.println(clonedPerson.name + " lives in " + clonedPerson.address.city);  // New Delhi
        }
    }

## Problem
We have an **object**, and we **want to create an exact copy of it**. 
<br>How would you do it? <br>First, you have to **create a new object** of the same class.<br> 
Then you have to go through all the fields of the original object and copy their values over 
to the new object.<br>

Nice! But **there’s a catch**. <br>Not all objects can be copied that way because some of the object’s fields may be private and not visible from outside of the object itself.

There’s one more problem with the direct approach. Since you have to know the object’s class to create a duplicate, your code becomes dependent on that class. If the extra dependency doesn’t scare you, there’s another catch. Sometimes you only know the interface that the object follows, but not its concrete class, when, for example, a parameter in a method accepts any objects that follow some interface

## Solution
* The Prototype pattern delegates the cloning process to the actual objects that are being cloned. 
* The pattern declares a common interface for all objects that support cloning. 
* This interface lets you clone an object without coupling your code to the class of that object. 
* Usually, such an interface contains just a single clone method.

1. The implementation of the clone method is very similar in all classes. 
2. The method creates an object of the current class and carries over all of the field values of the old object into the new one. 
3. You can even copy private fields because most programming languages let objects access private fields of other objects that belong to the same class.

An object that supports cloning is called a prototype. When your objects have dozens of fields and hundreds of possible configurations, cloning them might serve as an alternative to subclassing.