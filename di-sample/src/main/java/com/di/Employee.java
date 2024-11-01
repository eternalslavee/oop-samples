package com.di;

// Employee class implementing Person and BonusEligible
public class Employee extends Person implements BonusEligible {
    private double bonus;

    // Constructors
    public Employee() {
        super();
        this.bonus = DEFAULT_BONUS; // Set default bonus
    }

    public Employee(String name) {
        super(name);
        this.bonus = DEFAULT_BONUS; // Set default bonus
    }

    public Employee(String name, double bonus) {
        super(name);
        setBonus(bonus); // Set bonus through the setter method
    }

    // Implementing BonusEligible interface methods
    @Override
    public double getBonus() {
        return bonus;
    }

    @Override
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void displayInfo() {
        System.out.println(getFullDetails() + ", Bonus: " + getBonus());
    }
}