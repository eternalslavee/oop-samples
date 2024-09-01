// Interface to handle bonuses
public interface BonusEligible {
    // Static constant
    double MAX_BONUS = 10000.00;

    double getBonus();
    void setBonus(double bonus);
}

// Abstract class Person
public abstract class Person {
    private String name;
    private String address;

    // Constructors
    public Person() {
        this.name = "Unknown";
        this.address = "Unknown";
    }

    public Person(String name) {
        this.name = name;
        this.address = "Unknown";
    }

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Abstract method
    public abstract void displayInfo();

    // Final method
    public final String getFullDetails() {
        return "Name: " + getName() + ", Address: " + getAddress();
    }

    // Static method to print person's info
    public static void printPersonInfo(Person person) {
        System.out.println("Person Info: " + person.getFullDetails());
    }
}

// Employee class implementing Person and BonusEligible
public class Employee extends Person implements BonusEligible {
    private double bonus;

    // Constructors
    public Employee() {
        super();
    }

    public Employee(String name) {
        super(name);
    }

    public Employee(String name, String address) {
        super(name, address);
    }

    // Implementing BonusEligible interface methods
    @Override
    public double getBonus() {
        return bonus;
    }

    @Override
    public void setBonus(double bonus) {
        if (bonus > MAX_BONUS) {
            this.bonus = MAX_BONUS;
        } else {
            this.bonus = bonus;
        }
    }

    @Override
    public void displayInfo() {
        System.out.println(getFullDetails() + ", Bonus: " + getBonus());
    }
}

// Payroll class
public class Payroll {
    private Person employee;

    // Constructor
    public Payroll(Person employee) {
        this.employee = employee;
    }

    public static void main(String[] args) {
        // Using the constructors
        Employee employee = new Employee("John Doe", "123 Main St");

        // Attempt to set a bonus greater than MAX_BONUS
        employee.setBonus(12000.00);
        System.out.println("Attempted to set bonus to 12000.00. Actual bonus set: " + employee.getBonus());
        System.out.println("Maximum allowable bonus is: " + BonusEligible.MAX_BONUS);

        // Print employee's information using the static method
        Person.printPersonInfo(employee);

        Payroll payroll = new Payroll(employee);
        payroll.processPayroll(5000.00);
    }

    public void processPayroll(double salary) {
        double totalPay = salary;
        System.out.println("Processing payroll for: " + employee.getName());

        // Check if the employee is bonus eligible
        if (employee instanceof BonusEligible) {
            BonusEligible bonusEligible = (BonusEligible) employee;
            totalPay += bonusEligible.getBonus();
            System.out.println("Including bonus: " + bonusEligible.getBonus());
        }

        System.out.println("Total pay: " + totalPay);
        // Additional payroll processing logic
    }
}
