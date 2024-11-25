package com.di;

// Абстрактний клас Person (Людина)
abstract class Person {
    private String name;

    // Конструктори
    public Person() {
        this.name = "Невідомо";
    }

    public Person(String name) {
        this.name = name;
    }

    // Геттери та сеттери
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Абстрактний метод
    public abstract void displayInfo();

    // Фінальний метод
    public final String getFullDetails() {
        return "Ім'я: " + getName();
    }

    // Статичний метод для виведення інформації про людину
    public static void printInfo(Person person) {
        System.out.println("Інформація про людину: " + person.getFullDetails());
    }
}
