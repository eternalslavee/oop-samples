package com.di;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;

import java.util.ArrayList;
import java.util.List;

public class PayrollModule extends AbstractModule {
    @Override
    protected void configure() {
        // Прив'язка іменованої константи без власних залежностей
        bind(Double.class)
            .annotatedWith(Names.named("Minimum Salary"))
            .toInstance(5000.00);
        
        // альтернативний варіант прив'язки іменованої константи
        bindConstant()
            .annotatedWith(Names.named("Maximum Salary"))
            .to(10000.00);
    }

    // Метод для надання списку працівників
    @Provides
    List<Person> provideEmployees() {
        List<Person> employeeList = new ArrayList<>();
        Employee employee1 = new Employee("John Doe");
        employee1.setBonus(12000.00);

        employeeList.add(employee1);
        
        return employeeList;
    }
}
