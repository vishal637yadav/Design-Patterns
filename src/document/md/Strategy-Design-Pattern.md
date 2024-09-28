# Object Behavioral: Strategy

## Intent 
Define a family of algorithms, encapsulate each one, and make them interchangeable. 
Strategy lets the algorithm vary independently from clients that use it. 

## Also Known As 
Policy 

## Motivation 
Many algorithms exist for breaking a stream of text into lines. 
Hard-wiring all such algorithms into the classes that require them isn’t desirable for several reasons: 
* Clients that need linebreaking get more complex if they include the line-breaking code. That makes clients bigger and harder to maintain, 
especially if they support multiple linebreaking algorithms. 
* Different algorithms will be appropriate at different times. We don’t want to support multiple linebreaking algorithms if we don’t use them all. 
* It’s difficult to add new algorithms and vary existing ones when linebreaking is an integral part of a client. 
We can avoid these problems by defining classes that encapsulate different line-breaking algorithms. 
An algorithm that’s encapsulated in this way is called a strategy.

## Applicability 
Use the Strategy pattern when 
* many related classes differ only in their behavior. Strategies provide a way to configure a class with one of many behaviors. 
* you need different variants of an algorithm. For example, you might define algorithms reflecting different space/time trade-offs. 
Strategies can be used when these variants are implemented as a class hierarchy of algorithms [HO87]. 
* an algorithm uses data that clients shouldn’t know about. Use the Strategy pattern to avoid exposing complex, algorithm-specific data structures. 
* a class defines many behaviors, and these appear as multiple conditional statements in its operations. Instead of many conditionals, move related conditional 
branches into their own Strategy class. 


> [!NOTE]
> Useful information that users should know, even when skimming content.

> [!TIP]
> Helpful advice for doing things better or more easily.

> [!IMPORTANT]
> Key information users need to know to achieve their goal.

> [!WARNING]
> Urgent info that needs immediate user attention to avoid problems.

> [!CAUTION]
> Advises about risks or negative outcomes of certain actions.


Class Diagram:
Inline-style: