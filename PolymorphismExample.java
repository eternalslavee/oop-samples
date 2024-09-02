import java.util.ArrayList;
import java.util.List;

// Superclass
class Animal {
    void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

// Subclass 1
class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Woof! Woof!");
    }
}

// Subclass 2
class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Meow! Meow!");
    }
}

public class PolymorphismExample {
    public static void main(String[] args) {
        // Create a list of Animal objects
        List<Animal> animals = new ArrayList<>();

        // Add different types of animals to the list
        animals.add(new Dog());
        animals.add(new Cat());

        // Loop through the list and call makeSound() on each Animal
        for (Animal animal : animals) {
            animal.makeSound();  // Polymorphism in action
        }
    }
}