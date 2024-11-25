package com.di;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;

import java.util.ArrayList;
import java.util.List;

public class PayrollModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Double.class)
            .annotatedWith(Names.named("Minimum Salary"))
            .toInstance(5000.00);
        
        bind(Double.class)
            .annotatedWith(Names.named("Maximum Salary"))
            .toInstance(10000.00);
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
}
