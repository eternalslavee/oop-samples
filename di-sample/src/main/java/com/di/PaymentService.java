package com.di;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.google.inject.Inject;

/**
 * Клас PaymentService відповідає за збереження об'єктів Paycheck у базі даних.
 * Використовує ін'єкцію залежностей для отримання з'єднання з базою даних.
 */
/**
 * Сервіс для обробки платежів.
 */
public class PaymentService {
    private final Connection connection;

    /**
     * Конструктор з впровадженням залежності від драйвера бази даних.
     *
     * @param connection з'єднання з базою даних
     */
    @Inject
    public PaymentService(Connection connection) {
        this.connection = connection;
    }

    protected Connection getConnection() {
        return connection;
    }

    /**
     * Метод для збереження об'єкта Paycheck в базі даних.
     * 
     * Цей метод приймає об'єкт Paycheck, створює SQL-запит для вставки даних
     * про зарплату в базу даних і виконує цей запит.
     *
     * @param paycheck об'єкт Paycheck, який містить дані про зарплату
     * @throws RuntimeException якщо виникає помилка під час збереження даних
     */
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