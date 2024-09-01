import java.util.ArrayList;
import java.util.List;

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

// Paycheck class
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

// Payroll class with aggregation relationship
class Payroll {
    private List<Person> employees; // Aggregation: Payroll uses a list of Person
    private Paycheck paycheck;      // Composition: Payroll owns Paycheck

    // Constructor
    public Payroll(List<Person> employees, Paycheck paycheck) {
        this.employees = employees;
        this.paycheck = paycheck;
    }

    public static void main(String[] args) {
        // Using the constructors with bonus
        Employee employee1 = new Employee("John Doe", 12000.00);
        Employee employee2 = new Employee("Jane Smith", 15000.00);

        // Creating a list of employees
        List<Person> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);

        // Creating a paycheck and processing payroll
        Paycheck paycheck = new Paycheck(17000.00, "2024-09-15");
        Payroll payroll = new Payroll(employeeList, paycheck);
        payroll.processPayroll(5000.00);

        // Display paycheck details
        paycheck.displayPaycheckInfo();
    }

    void processPayroll(double salary) {
        for (Person employee : employees) {
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
}
