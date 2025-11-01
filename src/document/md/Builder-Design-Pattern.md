# Builder-Design-Pattern

## Intent
Separate the construction of a complex object from its representation so that the same construction process can create 
different representations.

The Builder is a **Creational** design pattern that lets you construct complex objects step by step. 
It separates the construction of a complex object from its representation, 
allowing the same construction process to create different variations of the object.

## Problem it Solves
1. **Telescoping Constructor:** When you have an object with many optional parameters, you end up with 
a large number of constructors, each taking a different combination of parameters. This is ugly, hard to read, 
and difficult to maintain.


    // PROBLEM: Telescoping Constructors
    class HttpClient {
        // Required
        private String url;
        // Optional
        private String method;
        private String body;
        private Map<String, String> headers;
        private int timeout;
    
        public HttpClient(String url) { ... }
        public HttpClient(String url, String method) { ... }
        public HttpClient(String url, String method, String body) { ... }
        // and so on... it gets worse and worse.
        // What if you want url and timeout, but not method or body?
        // You would have to call: new HttpClient(url, null, null, null, 5000);
    }


2. **Inconsistent State** (JavaBeans approach): Another approach is to have a no-argument constructor and use setter 
methods. The problem here is that the object is mutable during its construction.
It can be in an incomplete or invalid state until all setters have been called, which can lead to bugs 
if it's used prematurely. The Builder pattern avoids this by creating the final object in one atomic step.



