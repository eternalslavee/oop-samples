package com.di;

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