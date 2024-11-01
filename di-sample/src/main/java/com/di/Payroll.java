package com.di;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

// Payroll class with aggregation relationship
public class Payroll {
    private List<Person> employees; // Aggregation: Payroll uses a list of Person
    private Paycheck paycheck;      // Composition: Payroll owns Paycheck

    // // Впровадження залежності через конструктор
    // @Inject
    // public Payroll(List<Person> employees) {
    //     this.employees = employees;
    // }

    // Метод для впровадження залежності через setter
    @Inject
    public void setEmployees(List<Person> employees) {
        this.employees = employees;
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new PayrollModule());
        Payroll payroll = injector.getInstance(Payroll.class);

        // Process payroll for each employee
        payroll.processPayroll(5000.00);
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