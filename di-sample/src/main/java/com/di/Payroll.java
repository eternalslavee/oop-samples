package com.di;

import java.util.List;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;

// Payroll class with aggregation relationship
public class Payroll {
    private List<Person> employees; // Aggregation: Payroll uses a list of Person
    private Paycheck paycheck;      // Composition: Payroll owns Paycheck

    private double minimumSalary;
    private double maximumSalary;

    // Впровадження залежності через конструктор
    @Inject
    public Payroll(List<Person> employees, 
                   @Named("Minimum Salary") double minimumSalary, 
                   @Named("Maximum Salary") double maximumSalary) {
        this.employees = employees;
        this.minimumSalary = minimumSalary;
        this.maximumSalary = maximumSalary;
    }

    // Метод для впровадження залежності через setter
    @Inject
    public void setEmployees(List<Person> employees) {
        this.employees = employees;
    }

    public void setMinimumSalary(@Named("Minimum Salary") double minimumSalary) {
        this.minimumSalary = minimumSalary;
    }

    public void setMaximumSalary(@Named("Maximum Salary") double maximumSalary) {
        this.maximumSalary = maximumSalary;
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new PayrollModule());
        Payroll payroll = injector.getInstance(Payroll.class);

        // Process payroll for each employee
        payroll.processMaximumPayroll();
    }

    void processMinimumPayroll() {
        processPayroll(minimumSalary);
    }

    void processMaximumPayroll() {
        processPayroll(maximumSalary);
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

            // Create a paycheck for each employee
            paycheck = new Paycheck(totalPay, "2024-09-15");
            paycheck.displayPaycheckInfo();
            System.out.println("Total pay: " + totalPay);
            // Additional payroll processing logic
        }
    }
}