package com.di;

// Клас Paycheck
class Paycheck {
    private double amount;
    private String payDate;

    // Конструктор
    public Paycheck(double amount, String payDate) {
        this.amount = amount;
        this.payDate = payDate;
    }

    // Геттери
    public double getAmount() {
        return amount;
    }

    public String getPayDate() {
        return payDate;
    }

    // Метод для відображення деталей зарплати
    public void displayPaycheckInfo() {
        System.out.println("Paycheck - Amount: " + amount + ", Date: " + payDate);
    }
}