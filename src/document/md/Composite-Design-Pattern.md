## [Design Pattern : List](https://github.com/vishal637yadav/DesignPatterns/blob/master/README.md)

# Composite Method | Structural Design Pattern

Composite Pattern is a **structural design pattern** that allows you to **_compose objects into tree structures_** to represent _part-whole hierarchies_. 
The main idea behind the Composite Pattern is to build a tree structure of objects, where **individual objects** and **composite objects** **_share a common interface_**. 
This common interface allows clients to interact with both types of objects without needing to distinguish between them.

## Important Topics for the Composite Method Design Patterns

* What are Part-Whole or Whole-Part Object hierarchies?
* Use Cases of Composite Pattern
* Example for Composite Design Pattern
* Advantages of the Composite Design Patterns
* Disadvantages of Composite Design Patterns
* Potential Pitfalls
* Conclusion

## What are Part-Whole or Whole-Part Object hierarchies?
Example:

In a graphic design application, you might have shapes as individual elements (like circles and rectangles), and you can combine these shapes to create more complex shapes (like a smiley face with eyes and a mouth). The Composite Pattern lets you work with both simple shapes and complex shapes using the same set of operations, making it easier to manage and manipulate them.

**In this context:**

* The **parts** are individual shapes (like circles, rectangles).
* The **wholes** are the complex shapes (like a smiley face composed of circles and rectangles).

## Use Cases of Composite Pattern :
The Composite Pattern is useful in various scenarios, such as:

1. **Graphics and GUI Libraries:** Building complex graphical structures like shapes and groups.
2. **File Systems:** Representing files, directories, and their hierarchical relationships.
1. **Organization Structures:** Modeling hierarchical organizational structures like departments, teams and employees.

## Example for Composite Design Pattern :
_You are tasked with developing a software component **to manage a hierarchical file system structure**. The goal is to implement the **Composite Pattern** to seamlessly **work with individual files and directories** as part of a unified hierarchy._

## Implementing the Composite Pattern for File System Hierarchy :
Let’s understand the components of the Composite Pattern using file system hierarchy example:

## Key Component in the Composite Pattern
1. **Component:** The Component is the common interface for all objects in the composition. It defines the methods that are common to both leaf and composite objects.
2. **Leaf:** The Leaf is the individual object that does not have any children. It implements the component interface and provides the specific functionality for individual objects.
3. **Composite:** The Composite is the container object that can hold Leaf objects as well as the other Composite objects. It implements the Component interface and provides methods for adding, removing and accessing children.
4. **Client:** The Client is responsible for using the Component interface to work with objects in the composition. It treats both Leaf and Composite objects uniformly.

## Step Wise Implementation of Composite Design Pattern
1. Component
   In the file system hierarchy example, the Component is represented by the FileSystemComponenet interface. This interface defines the common interface for both leaf and composite objects. It declares a method, display(), which all classes in the hierarchy must implement.

    class FileSystemComponent {
    public:
    virtual void display() const = 0;
    };

The Component serves as the foundation for all objects within the hierarchy. Whether it’s file or a directory, they all must adhere to this common interface.

2. Leaf
   In the context of our file system hierarchy example, Leaf objects are the individual files. These are the objects that do not have any children. Here is an implementation of a leaf object, a file:


    class File : public FileSystemComponent {
    public:
    File(const std::string& name, int size) : name(name), size(size) {}
    
        void display() const override { 
            std::cout << "File: " << name << " (" << size << " bytes)" << std::endl; 
        } 
    private:
    std::string name;
    int size;
    };
Here, File is a leaf object. It implements the FileSystemComponent interface by providing a display method. It contains data specific to files, such as their name and size.

3. Composite
   In the file system hierarchy example, Composite objects are directories. These are objects that contain other components, including both leaf objects (files) and other composite objects (subdirectories). Here’s an implementation of a composite object, a directory:


    class Directory : public FileSystemComponent {
    public:
    Directory(const std::string& name) : name(name) {}
    
        void display() const override { 
            std::cout << "Directory: " << name << std::endl; 
            for (const auto& component : components) { 
                component->display(); 
            } 
        } 
      
        void addComponent(FileSystemComponent* component) { 
            components.push_back(component); 
        } 
    private:
    std::string name;
    std::vector<FileSystemComponent*> components;
    };
In this example, Directory is a composite object. Like the File class, it also implements the FileSystemComponent interface by providing a display method. Additionally it, contains a vector of FileSystemComponent to store child components (files or subdirectories). The addComponent method allows adding components to the directory.

4. Client
   The Client code interacts with the components through the Component interface, and it doesn’t need to be aware of whether it’s working with a leaf or a composite object.

    
    int main() {
    // Create leaf objects (files)
    FileSystemComponent* file1 = new File("document.txt", 1024);
    FileSystemComponent* file2 = new File("image.jpg", 2048);
    
        // Create a composite object (directory) 
        Directory* directory = new Directory("My Documents"); 
      
        // Add leaf objects to the directory 
        directory->addComponent(file1); 
        directory->addComponent(file2); 
      
        // Display the directory (including its contents) 
        directory->display(); 
      
        return 0; 
    }
In this client code, you can see how the client interacts with both leaf (file) and composite (directory) objects uniformly, without needing to know the specific type of each object. The display method of the FileSystemComponent interface is used to display the entire hierarchy.

## Diagrammatic representation of the Composite Design Pattern

![img](https://github.com/vishal637yadav/DesignPatterns/blob/master/src/document/images/Composite-ClassStructure.JPG)

---

# Composite-Design-Pattern
UML Diagram: Composite Design Pattern
***
Code Implementation of the above Problem:

    #include <bits/stdc++.h>
    class FileSystemComponent {
    public:
    virtual void display() const = 0;
    };
    class File : public FileSystemComponent {
    public:
    File(const std::string& name, int size)
    : name(name)
    , size(size)
    {
    }

    void display() const override 
    { 
        std::cout << "File: " << name << " (" << size 
                  << " bytes)" << std::endl; 
    } 

    private:
    std::string name;
    int size;
    };
    class Directory : public FileSystemComponent {
    public:
    Directory(const std::string& name)
    : name(name)
    {
    }

    void display() const override 
    { 
        std::cout << "Directory: " << name << std::endl; 
        for (const auto& component : components) { 
            component->display(); 
        } 
    } 
  
    void addComponent(FileSystemComponent* component) 
    { 
        components.push_back(component); 
    } 

    private:
    std::string name;
    std::vector<FileSystemComponent*> components;
    };
    int main()
    {
    // Create leaf objects (files)
    FileSystemComponent* file1
    = new File("document.txt", 1024);
    FileSystemComponent* file2
    = new File("image.jpg", 2048);

    // Create a composite object (directory) 
    Directory* directory = new Directory("My Documents"); 
  
    // Add leaf objects to the directory 
    directory->addComponent(file1); 
    directory->addComponent(file2); 
  
    // Display the directory (including its contents) 
    directory->display(); 
  
    return 0; 
    }

## **Output**
Directory: My Documents
File: document.txt (1024 bytes)
File: image.jpg (2048 bytes)



## Advantages of the Composite Design Pattern
1. **Hierarchical Structure:** The Composite Pattern provides a way to represent complex hierarchical structures of objects. You can create tree-like structures where both individual objects and composite objects (objects that contain other objects) can be treated uniformly.
2. **Simplified Client Code:** Clients (code that uses the composite structure) can work both with individual objects and composites without needing to know the difference. This simplifies client code, making it more intuitive and easier to maintain.
3. **Flexibility:** The pattern allows you to add and remove objects in the hierarchy without affecting the client code. This flexibility makes it easy to modify the structure of the tree.
4. **Scalability:** You can easily create more complex structures by nesting composites within composites, making it a scalable solution for modeling part-whole hierarchies.
5. **Code Reusability:** The pattern encourages the reuse of code. You can apply the same operations to both individual objects and composites, reducing duplication of code.

## Disadvantages of Composite Design Pattern
1. Complex Implementation: Implementing the Composite Pattern can be more complex compared to a non-composite approach. It involves creating a common interface for both individual objects and compositions, which can make the code more intricate.
2. Performance Overhead: In some cases, traversing and performing operations on a composite structure can result in performance overhead, especially when dealing with deep and complex hierarchies. This is because you may need to navigate through multiple layers of objects.
3. Limited Type Safety: Since the Composite Pattern involves a common interface for both leaf and composite objects, it can lead to a lack of type safety. It’s possible to call methods on composite objects that are not applicable, leading to runtime errors. This requires careful handling to ensure that only relevant operations are performed on objects.
4. Reduced Clarity: While the pattern provides flexibility for building complex structures, it can also reduce the clarity of the code. It might be less obvious when you’re working with a composite structure, and this can make the code harder to understand, especially for developers who are not familiar with the pattern.
5. Extra Memory Usage: Composite structures can consume additional memory due to the need to store references to child objects within composite objects. This can be a concern when dealing with large hierarchies.

## Potential Pitfalls
While the Composite Pattern is a powerful tool, it’s important to be aware of some potential pitfalls:

1. Complexity: While the Composite Pattern simplifies client code, it can make the implementation of the composite structure more complex. Managing the hierarchy and dealing with different types of objects within the hierarchy can be challenging.
2. Performance Overhead: The pattern can introduce performance overhead, especially when dealing with deep or large hierarchies. Traversing and performing operations on composite structures may be slower than working with individual objects directly.
3. Type Safety: In languages that do not provide strong type checking, it can be challenging to ensure type safety, as the client code may inadvertently attempt operations on incompatible objects within the hierarchy.
4. Design Complexity: The Composite Pattern is not suitable for all scenarios. In some cases, it may be an overkill and make the design overly complex. It’s essential to carefully consider whether the pattern is appropriate for the specific problem at hand.
5. Limited Use Cases: The Composite Pattern is primarily used for part-whole hierarchies. It may not be the best choice for situations where you need more specialized behavior or interactions between objects that do not fit this structure.

## Conclusion
The Composite Pattern is a fundamental design pattern for building complex hierarchical structures. It provides a uniform interface for both individual and composite objects, enabling flexible and dynamic hierarchies. By understanding its structure, advantages, use cases and potential pitfalls, you can effectively apply the Composite Pattern in your projects to create maintainable and extensible code.

---
