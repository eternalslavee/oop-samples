package com.di;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PayrollModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(String.class)
            .annotatedWith(Names.named("JDBC URL"))
            .toInstance("jdbc:sqlite:target/payroll.db");
    }

    // Метод для надання списку працівників
    @Provides
    List<Person> provideEmployees() {
        List<Person> employeeList = new ArrayList<>();
        Employee employee1 = new Employee("John Doe");
        employee1.setBonus(12000.00);

        Employee employee2 = new Employee("Jane Smith");
        employee2.setBonus(15000.00);

        employeeList.add(employee1);
        employeeList.add(employee2);
        
        return employeeList;
    }

    @Provides
    @Singleton
    Connection provideConnection(@Named("JDBC URL") String url) {
        try {
            Connection connection = DriverManager.getConnection(url);
            createTableIfNotExists(connection);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create database connection", e);
        }
    }

    private void createTableIfNotExists(Connection connection) {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS paychecks (" +
                                "amount REAL NOT NULL, " +
                                "pay_date TEXT NOT NULL)";

        try (Statement statement = connection.createStatement()) {
            statement.execute(createTableSQL);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create table", e);
        }
    }
}