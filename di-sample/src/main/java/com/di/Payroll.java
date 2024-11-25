package com.di;

import java.sql.Connection;
import java.util.List;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

// Клас Payroll
public class Payroll {
    private List<Person> employees; // Агрегація: Payroll використовує список Person
    private Paycheck paycheck;      // Композиція: Payroll володіє Paycheck

    private PaymentService paymentService;

    @Inject
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Inject
    public void setEmployees(List<Person> employees) {
        this.employees = employees;
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new PayrollModule());

        // Створення екземплярів Payroll (не Singleton)
        Payroll payroll1 = injector.getInstance(Payroll.class);
        Payroll payroll2 = injector.getInstance(Payroll.class);

        // Перевірка екземплярів Payroll
        System.out.println("payroll1 == payroll2: " + 
            ((payroll1 == payroll2) ? 
            "Посилання на один і той самий екземпляр об'єкту класу Payroll, тому що застосовано шаблон проектування 'Singleton'" : 
            "Посилання на різні екземпляри об'єктів класу Payroll"));

        // Отримання екземпляра Connection
        Connection connection1 = injector.getInstance(Connection.class);
        Connection connection2 = injector.getInstance(Connection.class);

        // Перевірка екземплярів з'єднання
        System.out.println("connection1 == connection2: " + 
            ((connection1 == connection2) ? 
            "Посилання на один і той самий екземпляр об'єкту класу Connection, тому що застосовано шаблон проектування 'Singleton'" : 
            "Посилання на різні екземпляри об'єктів класу Connection"));

        // Обробка заробітної плати для кожного працівника
        payroll1.processPayroll(5000.00);
    }

    void processPayroll(double salary) {
        for (Person employee : employees) {
            double totalPay = salary;
            System.out.println("Обробка заробітної плати для: " + employee.getName());

            // Перевірка, чи працівник має право на бонус
            if (employee instanceof BonusEligible) {
                BonusEligible bonusEligible = (BonusEligible) employee;
                totalPay += bonusEligible.getBonus();
                System.out.println("Включаючи бонус: " + bonusEligible.getBonus());
            }

            // Створення платіжної відомості для кожного працівника
            paycheck = new Paycheck(totalPay, "2024-09-15");
            paycheck.displayPaycheckInfo();

            paymentService.savePaycheck(paycheck);

            System.out.println("Загальна сума виплати: " + totalPay);
            // Додаткова логіка обробки заробітної плати
        }
    }
}