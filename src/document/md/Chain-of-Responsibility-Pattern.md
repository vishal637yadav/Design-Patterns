[Desing Pattern List](https://github.com/vishal637yadav/DesignPatterns/tree/master/README.md)

# Chain of Responsibility Design Pattern

**Chain of responsibility pattern** is used **to achieve loose coupling in software design** 
where a request from the client is passed to a chain of objects to process them. 
Later, the _object in the chain will decide themselves who will be processing the request_ 
and whether _**the request is required to be sent to the next object in the chain or not**_.

## **Where and When Chain of Responsibility pattern is applicable :**

* When you want to decouple a request’s sender and receiver
* Multiple objects, determined at runtime, are candidates to handle a request
* When you don’t want to specify handlers explicitly in your code
* When you want to issue a request to one of several objects without specifying the receiver explicitly.


This pattern is **recommended** when **multiple objects can handle a request** and the **handler doesn’t have to 
be a specific object**. Also, the handler is determined at **runtime**. 

> [!NOTE]
> A request **not handled** at all by **any handler** is a **valid use case**.


![img](https://github.com/vishal637yadav/DesignPatterns/blob/master/src/document/images/ChainOfResponsibility.JPG)

## Key Components in Chain of Responsibilities Pattern.
1. **Handler :** This can be an interface which will **primarily receive the request** and **dispatches the request to a chain of handlers**. 
It **has reference** to the **only first handler** in the chain and **does not know anything** about the **rest of the handlers**.
2. **Concrete handlers :** These are **actual handlers** of the request **chained in some sequential order**.
3. **Client :** Originator of request and this will access the handler to handle it.


## How to send a request in the application using the Chain of Responsibility

The Client in need of a request to be handled sends it to the chain of handlers which are classes that extend the Handler class.
Each of the handlers in the chain takes its turn trying to handle the request it receives from the client.
If ConcreteHandler1 can handle it, then the request is handled, if not it is sent to the handler ConcreteHandler2, the next one in the chain.

# Example of Chain of Responsibility Design Pattern:

## Chain.java

    public class Chain
    {
        Processor chain;
    
        public Chain(){
        buildChain();
        }
    
        private void buildChain(){
        chain = new NegativeProcessor(new ZeroProcessor(new PositiveProcessor(null)));
        }
        
        public void process(Number request) {
        chain.process(request);
        }
    
    }

## Processor.java

    abstract class Processor  
    {  
    private Processor nextProcessor;
    
        public Processor(Processor nextProcessor){ 
            this.nextProcessor = nextProcessor; 
        }; 
          
        public void process(Number request){ 
            if(nextProcessor != null) 
                nextProcessor.process(request); 
        };  
    }

## Number.java

    class Number  
    {  
    private int number;
    
        public Number(int number)  
        {  
            this.number = number;  
        }  
      
        public int getNumber()  
        {  
            return number;  
        }  
    
    }

## NegativeProcessor.java

    class NegativeProcessor extends Processor  
    {  
        public NegativeProcessor(Processor nextProcessor)
        {
            super(nextProcessor);
    
        } 
      
        public void process(Number request)  
        {  
            if (request.getNumber() < 0)  
            {  
                System.out.println("NegativeProcessor : " + request.getNumber());  
            }  
            else
            {  
                super.process(request);  
            }  
        }  
    }

## ZeroProcessor.java

    class ZeroProcessor extends Processor  
    {  
        public ZeroProcessor(Processor nextProcessor){
            super(nextProcessor);
        }
    
        public void process(Number request)  
        {  
            if (request.getNumber() == 0)  
            {  
                System.out.println("ZeroProcessor : " + request.getNumber());  
            }  
            else
            {  
                super.process(request);  
            }  
        }  
    }


## PositiveProcessor.java

    class PositiveProcessor extends Processor  
    {
        public PositiveProcessor(Processor nextProcessor){ 
            super(nextProcessor); 
        } 
      
        public void process(Number request)  
        {  
            if (request.getNumber() > 0)  
            {  
                System.out.println("PositiveProcessor : " + request.getNumber());  
            }  
            else
            {  
                super.process(request);  
            }  
        }  
    }

## TestChain.java

    class TestChain  
    {  
        public static void main(String[] args) 
        {  
            Chain chain = new Chain();
        
            //Calling chain of responsibility  
            chain.process(new Number(90));  
            chain.process(new Number(-50));  
            chain.process(new Number(0));  
            chain.process(new Number(91));  
        }  
    }


### Output:
**PositiveProcessor : 90</br>
NegativeProcessor : -50</br>
ZeroProcessor : 0</br>
PositiveProcessor : 91</br>**
---

## Advantages of Chain of Responsibility Design Pattern

1. To **reduce** the **coupling degree**. Decoupling it will request the sender and receiver.
2. **Simplified object**. The object does not need to know the **chain structure**.
3. **Enhance flexibility** of object assigned duties. **By changing** the **members within the chain** or **change their order**,
**allow dynamic adding** or **deleting responsibility**.
4. Increase the request processing new class of very convenient.

## DisAdvantages of Chain of Responsibility Design Pattern

1. The request must be received not guarantee.
2. The **performance of the system will be affected**, but also in the **code debugging is not easy may cause cycle call**.
3. It may not be easy to observe the characteristics of operation, due to debug.

