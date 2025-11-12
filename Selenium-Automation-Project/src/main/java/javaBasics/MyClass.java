package javaBasics;

public class MyClass {
    int a = 10; // Instance variable (primitive) stored in Heap as part of the object

    // Constructor - can be used to print instance variable
    MyClass() {
        System.out.println("Constructor: example class a: " + a);
    }

    public static void main(String[] args) {
        MyClass obj = new MyClass(); // obj stored in Stack (reference), new MyClass object in Heap
        obj.example();               // Calls method → new stack frame created for example()
    }

    public void example() {
        int b = 20; // Local variable stored in Stack (inside 'example' stack frame)
        System.out.println("example method b: " + b);

        MyClass obj1 = new MyClass(); // obj1 in Stack, new object in Heap
        obj1.example1();              // New stack frame for example1()
    }

    public void example1() {
        int c = 30; // Local variable stored in Stack (inside 'example1' stack frame)
        System.out.println("example1 method c: " + c);
    }
}
