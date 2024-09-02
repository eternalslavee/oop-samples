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
    private List<Animal> animals;

    public PolymorphismExample() {
        animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void makeAllSounds() {
        for (Animal animal : animals) {
            animal.makeSound();  // Polymorphism in action
        }
    }

    public static void main(String[] args) {
        PolymorphismExample example = new PolymorphismExample();
        
        // Add different types of animals to the list
        example.addAnimal(new Dog());
        example.addAnimal(new Cat());
        
        // Make all animals sound
        example.makeAllSounds();
    }
}
