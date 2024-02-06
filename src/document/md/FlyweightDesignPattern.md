# Flyweight Pattern
# Object Structural: Flyweight 
# Intent 
**Use sharing** to support **large numbers of fine-grained objects** efficiently. 
## Motivation 
Some applications could benefit from using objects throughout their design, 
but a naive implementation would be prohibitively expensive. 

For example, most document editor implementations have text formatting and editing facilities 
that are modularized to some extent. 
Object-oriented document editors typically use objects to represent embedded elements like tables and figures. 
However, they usually stop short of using an object for each character in the document, 
even though doing so would promote flexibility at the finest levels in the application. 
Characters and embedded elements

A **flyweight** is a **shared object** that can be used in **multiple contexts simultaneously**. 
The flyweight acts as an independent object in each context—it’s indistinguishable from 
an instance of the object that’s not shared. 
Flyweights cannot make assumptions about the context in which they operate. 
The key concept here is the distinction between **intrinsic** and **extrinsic state**. 

**Intrinsic state** is stored in the flyweight; 
it consists of information that’s independent of the flyweight’s context, thereby making it sharable. 
**Extrinsic state** depends on and varies with the flyweight’s context and therefore can’t be shared. 

**Client objects** are responsible for **passing extrinsic state to the flyweight when it needs it**. 
Flyweights model concepts or entities that are normally too plentiful to represent with objects. 

For example, a document editor can create a flyweight for each letter of the alphabet. 
Each flyweight stores a character code, but its coordinate position in the document and its typographic style 
can be determined from the text layout algorithms and formatting commands in effect wherever the character appears.
The character code is intrinsic state, while the other information is extrinsic. 
Logically there is an object for every occurrence of a given character in the document:


**Flyweight pattern** is a **structural design patterns** 
as this pattern provides ways to decrease object count thus improving application required objects structure. 
**Flyweight pattern** is used when we need to create a **large number of similar objects** (say 105). 
One important feature of **flyweight objects** is that they are **immutable**. 
This means that they cannot be modified once they have been constructed.

## Why do we care for number of objects in our program?

* Less number of objects reduces the memory usage, and it manages to keep us away from errors related to memory 
like java.lang.OutOfMemoryError.
* Although creating an object in Java is really fast, we can still reduce the execution time of our program 
by sharing objects.
In Flyweight pattern we use a HashMap that stores reference to the object which have already been created, 
every object is associated with a key. Now when a client wants to create an object, he simply has to pass a key associated with it and if the object has already been created we simply get the reference to that object else it creates a new object and then returns it reference to the client.

Intrinsic and Extrinsic States


To understand Intrinsic and Extrinsic state, let us consider an example.

Suppose in a text editor when we enter a character, an object of Character class is created, the attributes of the Character class are {name, font, size}. We do not need to create an object every time client enters a character since letter ‘B’ is no different from another ‘B’ . If client again types a ‘B’ we simply return the object which we have already created before. Now all these are intrinsic states (name, font, size), since they can be shared among the different objects as they are similar to each other.

Now we add to more attributes to the Character class, they are row and column. They specify the position of a character in the document. Now these attributes will not be similar even for same characters, since no two characters will have the same position in a document, these states are termed as extrinsic states, and they can’t be shared among objects.

Implementation : We implement the creation of Terrorists and Counter Terrorists In the game of Counter Strike. So we have 2 classes one for Terrorist(T) and other for Counter Terrorist(CT). Whenever a player asks for a weapon we assign him the asked weapon. In the mission, terrorist’s task is to plant a bomb while the counter terrorists have to diffuse the bomb.

Why to use Flyweight Design Pattern in this example? Here we use the Fly Weight design pattern, since here we need to reduce the object count for players. Now we have n number of players playing CS 1.6, if we do not follow the Fly Weight Design Pattern then we will have to create n number of objects, one for each player. But now we will only have to create 2 objects one for terrorists and other for counter terrorists, we will reuse then again and again whenever required.

Intrinsic State : Here ‘task’ is an intrinsic state for both types of players, since this is always same for T’s/CT’s. We can have some other states like their color or any other properties which are similar for all the Terrorists/Counter Terrorists in their respective Terrorists/Counter Terrorists class.

Extrinsic State :

Weapon is an extrinsic state since each player can carry any weapon of his/her choice. Weapon need to be passed as a parameter by the client itself. Class Diagram :

## Player.java(interface)

    package code.dp.structural.flyweight;
    
    public interface Player {
        void assignWeapon(String weapon);
        void mission();
    }

##  CounterTerrorist.java (Class)
    package code.dp.structural.flyweight;
    
    // CounterTerrorist must have weapon and mission
    class CounterTerrorist implements Player {
    
        // Intrinsic Attribute
        private final String TASK;
    
        // Extrinsic Attribute
        private String weapon;
    
        public CounterTerrorist() {
            TASK = "DIFFUSE BOMB";
        }
    
        public void assignWeapon(String weapon) {
            this.weapon = weapon;
        }
    
        public void mission() {
            System.out.println("Counter Terrorist with weapon "
                    + weapon + "|" + " Task is " + TASK);
        }
    
    }

##  Terrorist.java (Class)
    
    package code.dp.structural.flyweight;
    
    // Terrorist must have weapon and mission
    public class Terrorist implements Player {
    
        // Intrinsic Attribute
        private final String TASK;
    
        // Extrinsic Attribute
        private String weapon;
    
        public Terrorist() {
            TASK = "PLANT A BOMB";
        }
    
        public void assignWeapon(String weapon) {
            // Assign a weapon
            this.weapon = weapon;
        }
    
        public void mission() {
            //Work on the Mission
            System.out.println("Terrorist with weapon "
                    + weapon + "|" + " Task is " + TASK);
        }
    
    }

## PlayerFactory.java (Class)
Class used to get a player using HashMap (Returns an existing player if a player of given type exists.
Else creates a new player and returns it).
    
    package code.dp.structural.flyweight;
    
    import java.util.*;
    
    public class PlayerFactory {
    
        /* HashMap stores the reference to the object
           of Terrorist(TS) or CounterTerrorist(CT).  */
        private static HashMap<String, Player> hm = new HashMap<>();
    
        // Method to get a player
        public static Player getPlayer(String type) {
            Player p = null;
    
            /* If an object for TS or CT has already been
               created simply return its reference */
            if (hm.containsKey(type))
                p = hm.get(type);
            else {
                /* create an object of TS/CT  */
                switch (type) {
                    case "Terrorist":
                        System.out.println("Terrorist Created");
                        p = new Terrorist();
                        break;
                    case "CounterTerrorist":
                        System.out.println("Counter Terrorist Created");
                        p = new CounterTerrorist();
                        break;
                    default:
                        System.out.println("Unreachable code!");
                }
    
                // Once created insert it into the HashMap
                hm.put(type, p);
            }
            return p;
        }
    }

** CounterStrike.java (Client Class)

    package code.dp.structural.flyweight;
    
    import java.util.Random;
    
    // Driver class
    public class CounterStrike {
        // All player types and weapon (used by getRandPlayerType()
        // and getRandWeapon()
        private static String[] playerType = {"Terrorist", "CounterTerrorist"};
        private static String[] weapons = {"AK-47", "Maverick", "Gut Knife", "Desert Eagle"};
        
        // Driver code
        public static void main(String args[]) {
            /* Assume that we have a total of 10 players
               in the game. */
            for (int i = 0; i < 10; i++) {
                /* getPlayer() is called simply using the class
                   name since the method is a static one */
                Player p = PlayerFactory.getPlayer(getRandPlayerType());
    
                /* Assign a weapon chosen randomly uniformly
                   from the weapon array  */
                p.assignWeapon(getRandWeapon());
    
                // Send this player on a mission
                p.mission();
            }
        }
    
        // Utility methods to get a random player type and
        // weapon
        public static String getRandPlayerType() {
            Random r = new Random();
    
            // Will return an integer between [0,2)
            int randInt = r.nextInt(playerType.length);
    
            // return the player stored at index 'randInt'
            return playerType[randInt];
        }
    
        public static String getRandWeapon() {
            Random r = new Random();
    
            // Will return an integer between [0,5)
            int randInt = r.nextInt(weapons.length);
    
            // Return the weapon stored at index 'randInt'
            return weapons[randInt];
        }
    }

###  Output:

    Counter Terrorist Created
    Counter Terrorist with weapon Gut Knife| Task is DIFFUSE BOMB
    Counter Terrorist with weapon Desert Eagle| Task is DIFFUSE BOMB
    Terrorist Created
    Terrorist with weapon AK-47| Task is PLANT A BOMB
    Terrorist with weapon Gut Knife| Task is PLANT A BOMB
    Terrorist with weapon Gut Knife| Task is PLANT A BOMB
    Terrorist with weapon Desert Eagle| Task is PLANT A BOMB
    Terrorist with weapon AK-47| Task is PLANT A BOMB
    Counter Terrorist with weapon Desert Eagle| Task is DIFFUSE BOMB
    Counter Terrorist with weapon Gut Knife| Task is DIFFUSE BOMB
    Counter Terrorist with weapon Desert Eagle| Task is DIFFUSE BOMB


References:

Elements of Reusable Object-Oriented Software(By Gang Of Four)
https://en.wikipedia.org/wiki/Flyweight_pattern



Feeling lost in the vast world of System Design? It's time for a transformation! Enroll in our Mastering System Design From Low-Level to High-Level Solutions - Live Course and embark on an exhilarating journey to efficiently master system design concepts and techniques.
What We Offer:

Comprehensive Course Coverage
Expert Guidance for Efficient Learning
Hands-on Experience with Real-world System Design Project
Proven Track Record