// Interface to handle bonuses
interface BonusEligible {
    // Static constant
    double DEFAULT_BONUS = 5000.00;

    double getBonus();
    void setBonus(double bonus);
}

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

// New Paycheck class
class Paycheck {
    private double amount;
    private String payDate;

    // Constructor
    public Paycheck(double amount, String payDate) {
        this.amount = amount;
        this.payDate = payDate;
    }

    // Getters
    public double getAmount() {
        return amount;
    }

    public String getPayDate() {
        return payDate;
    }

    // Method to display paycheck details
    public void displayPaycheckInfo() {
        System.out.println("Paycheck - Amount: " + amount + ", Date: " + payDate);
    }
}

// Payroll class
class Payroll {
    private Person employee;
    private Paycheck paycheck; // Composition: Payroll owns Paycheck

    // Constructor
    public Payroll(Person employee, Paycheck paycheck) {
        this.employee = employee;
        this.paycheck = paycheck;
    }

    public static void main(String[] args) {
        // Using the constructors with bonus
        Employee employee = new Employee("John Doe", 12000.00);

        System.out.println("Set bonus to 12000.00. Actual bonus set: " + employee.getBonus());
        System.out.println("Default bonus is: " + BonusEligible.DEFAULT_BONUS);

        // Print employee's information using the static method
        Person.printInfo(employee);

        // Create a paycheck and process payroll
        Paycheck paycheck = new Paycheck(17000.00, "2024-09-15");
        Payroll payroll = new Payroll(employee, paycheck);
        payroll.processPayroll(5000.00);

        // Display paycheck details
        paycheck.displayPaycheckInfo();
    }

    void processPayroll(double salary) {
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
