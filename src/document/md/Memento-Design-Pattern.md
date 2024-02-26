# Memento Design Pattern
The Memento design pattern is a **behavioral design pattern** used to **capture and restore** the **internal state** of an **object without** exposing 
its **implementation details**.

## Important Topics for the Memento Design Pattern

* What is the Memento Design Pattern?
* Components of Memento Design Pattern
* Communication between the components
* Real-World Analogy of Memento Design Pattern
* Memento Design Pattern Example
* When to use Memento Design Pattern
* When not to use Memento Design Pattern
* 
## What is the Memento Design Pattern?
* The Memento design pattern is a behavioral pattern.
* It is used to capture and restore an object’s internal state without violating encapsulation. 
* It allows you to save and restore the state of an object to a previous state, providing the ability to undo or roll back changes made to the object.

  * As your application progresses, you may want to save checkpoints in your application and restore them to those checkpoints later.
  * The intent of the Memento Design pattern is without violating encapsulation, to capture and externalize an object’s internal state so that the object can be restored to this state later.
## Components of Memento Design Pattern
1. **Originator :**
   This component is responsible for creating and managing the state of an object. It has methods to set and get the object’s state, and it can create Memento objects to store its state. The Originator communicates directly with the Memento to create snapshots of its state and to restore its state from a snapshot.

2. **Memento :**
   The Memento is an object that stores the state of the Originator at a particular point in time. It only provides a way to retrieve the state, without allowing direct modification. This ensures that the state remains

3. **Caretaker :**
   The Caretaker is responsible for keeping track of Memento objects. It doesn’t know the details of the state stored in the Memento but can request Mementos from the Originator to save or restore the object’s state.

4. **Client :**
   Typically represented as the part of the application or system that interacts with the Originator and Caretaker to achieve specific functionality. The client initiates requests to save or restore the state of the Originator through the Caretaker.

Communication between the components

![img](./../document/images/Momento-Design-Pattern.JPG)

1. **Client:** The client initiates the process by requesting the Originator to perform some operation that may modify its state or require the state to be saved. For example, the client might trigger an action like “save state” or “restore state.”
2. **Originator:** Upon receiving a request from the client, the Originator either creates a Memento to save its current state (if the request is to save state) or retrieves a Memento to restore its previous state (if the request is to restore state).
   *    If the request is to save state:
        The Originator creates a Memento object that captures its current state.
        It returns the Memento to the client or Caretaker for storage.
   *   If the request is to restore state:
       * The Originator retrieves the desired Memento containing the state it wants to restore.
       * It restores its state using the state stored in the Memento.
3. **Caretaker:** The Caretaker acts as an intermediary between the client and the Originator, managing the Memento objects.
       If the client requests to save state:
       The Caretaker receives the Memento from the Originator.
       It stores the Memento for future use.
       If the client requests to restore state:
       The Caretaker retrieves the appropriate Memento from its storage.
       It provides the Memento to the Originator for state restoration.
       ComponentDiagramMementoNew

The caretaker calls the createMemento() method on the originator asking the originator to pass it a memento object.
At this point the originator creates a memento object saving its internal state and passes the memento to the caretaker.
The caretaker maintains the memento object and performs the operation. In case of the need to undo the operation, the caretaker calls the setMemento() method on the originator passing the maintained memento object.
The originator would accept the memento, using it to restore its previous state.
Real-World Analogy of Memento Design Pattern
Imagine you’re an artist painting a picture (Originator). You have a beautiful painting that you’ve been working on, and you want to make sure you can save its progress and go back to previous versions if needed.

Originator (The Artist):
You, the artist, represent the Originator.
You’re responsible for creating and managing the state of your painting (object).
As you work on your painting, you can create snapshots or “Mementos” of its current state.
Memento (The Photograph):
A Memento in this analogy could be likened to a photograph of your painting at a specific point in time.
Just like taking a picture captures the appearance of your painting at that moment, a Memento captures the state of your painting.
You could take a photograph of your painting at various stages of completion to have snapshots of its progress.
Caretaker (The Art Collector):
The Caretaker is like an art collector who helps you manage your paintings and their snapshots.
They don’t paint the pictures themselves (like the Originator), but they’re responsible for keeping track of the snapshots (Mementos) and ensuring they’re stored safely.
They might label each photograph with a date or description to help you remember which stage of the painting it represents.
When you want to revisit an earlier version of your painting, you ask the art collector (Caretaker) to retrieve the corresponding photograph (Memento) for you to study or restore.
So, in this analogy, you, the artist, create and manage your painting (Originator), take photographs to capture its progress (Memento), and rely on an art collector (Caretaker) to organize and store those photographs for future reference or restoration. This illustrates how the components of the Memento pattern work together in a real-life scenario.

Memento Design Pattern Example
Imagine you’re building a text editor application, and you want to implement an undo feature that allows users to revert changes made to a document. The challenge is to store the state of the document at various points in time and restore it when needed without exposing the internal implementation of the document.

Benefit of Using Memento Pattern in this scenario:

Using the Memento pattern in this scenario provides several benefits:

Encapsulation: The Memento pattern allows you to encapsulate the state of the document within Memento objects, preventing direct access and manipulation of the document’s state.
Undo Functionality: By storing snapshots of the document’s state at different points in time, the Memento pattern enables the implementation of an undo feature, allowing users to revert changes and restore previous document states.
Separation of Concerns: The Memento pattern separates the responsibility of state management from the document itself, promoting cleaner and more maintainable code.

![img](./../document/images/Momento-Design-Pattern2.JPG)

Below is the code of above problem statement using Interpreter Pattern:

Let’s break down into the component wise code:

1. **Originator (Document)**

        package code.dp.behavioral.memento;
        
        public class Document {
        
            private String content;
        
            public Document(String content) {
                this.content = content;
            }
        
            public void write(String text) {
                this.content += text;
            }
        
            public String getContent() {
                return this.content;
            }
        
            public DocumentMemento createMemento() {
                return new DocumentMemento(this.content);
            }
        
            public void restoreFromMemento(DocumentMemento memento) {
                this.content = memento.getSavedContent();
            }
        }


2. **Memento**

        package code.dp.behavioral.memento;
        
        public class DocumentMemento {
        
            private String content;
        
            public DocumentMemento(String content) {
                this.content = content;
            }
        
            public String getSavedContent() {
                return this.content;
            }
        
        }


3. **Caretaker (History.java)**

        package code.dp.behavioral.memento;
        
        import java.util.ArrayList;
        import java.util.List;
        
        public class History {
        
            private List<DocumentMemento> mementos;
        
            public History() {
                this.mementos = new ArrayList<>();
            }
        
            public void addMemento(DocumentMemento memento) {
                this.mementos.add(memento);
            }
        
            public DocumentMemento getMemento(int index) {
                return this.mementos.get(index);
            }
        
        }

### Main.java
    package code.dp.behavioral.memento;
    
    public class Main {
    
        public static void main(String[] args) {
            Document document = new Document("Initial content\n");
            History history = new History();
    
            // Write some content
            document.write("Additional content\n");
            history.addMemento(document.createMemento());
    
            // Write more content
            document.write("More content\n");
            history.addMemento(document.createMemento());
    
            // Restore to previous state
            document.restoreFromMemento(history.getMemento(1));
    
            // Print document content
            System.out.println(document.getContent());
        }
    
    }

### Output :
Initial content<br>
Additional content<br>
More content<br>

## When to use Memento Design Pattern
1. **Undo functionality:** When you need to implement an undo feature in your application that allows users to revert changes made to an object’s state.
2. **Snapshotting:** When you need to save the state of an object at various points in time to support features like versioning or checkpoints.
3. **Transaction rollback:** When you need to rollback changes to an object’s state in case of errors or exceptions, such as in database transactions.
4. **Caching:** When you want to cache the state of an object to improve performance or reduce redundant computations.

## When not to use Memento Design Pattern
1. **Large object state:** If the object’s state is large or complex, storing and managing multiple snapshots of its state can consume a significant amount of memory and processing resources.
2. **Frequent state changes:** If the object’s state changes frequently and unpredictably, storing and managing snapshots of its state may become impractical or inefficient.
3. **Immutable objects:** If the object’s state is immutable or easily reconstructible, there may be little benefit in using the Memento pattern to capture and restore its state.
4. **Overhead:** Introducing the Memento pattern can add complexity to the codebase, especially if the application does not require features like undo functionality or state rollback.

---