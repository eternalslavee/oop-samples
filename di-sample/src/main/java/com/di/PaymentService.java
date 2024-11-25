package com.di;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.google.inject.Inject;

public class PaymentService {
    private final Connection connection;

    // Конструктор з ін'єкцією з'єднання
    @Inject
    public PaymentService(Connection connection) {
        this.connection = connection;
    }

    // Метод для збереження об'єкта Paycheck
    public void savePaycheck(Paycheck paycheck) {
        String sql = "INSERT INTO paychecks (amount, pay_date) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, paycheck.getAmount());
            statement.setString(2, paycheck.getPayDate());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to save paycheck", e);
        }
    }
}