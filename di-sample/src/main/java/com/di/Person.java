package com.di;

// Abstract class Person
abstract class Person {
    private String name;

    // Constructors
    public Person() {
        this.name = "Unknown";
    }

    public Person(String name) {
        this.name = name;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Abstract method
    public abstract void displayInfo();

    // Final method
    public final String getFullDetails() {
        return "Name: " + getName();
    }

    // Static method to print person's info
    public static void printInfo(Person person) {
        System.out.println("Person Info: " + person.getFullDetails());
    }
}