# oop-samples
Build: `mvn clean install`
Run: `mvn exec:java -Dexec.mainClass="com.di.Payroll"`

Output:
```
payroll1 == payroll2: Посилання на різні екземпляри об'єктів класу Payroll
connection1 == connection2: Посилання на один і той самий екземпляр об'єкту класу Connection, тому що застосовано шаблон проектування 'Singleton'Обробка заробітної плати для: John Doe
Включаючи бонус: 12000.0
Paycheck - Amount: 17000.0, Date: 2024-09-15
Загальна сума виплати: 17000.0
Обробка заробітної плати для: Jane Smith
Включаючи бонус: 15000.0
Paycheck - Amount: 20000.0, Date: 2024-09-15
Загальна сума виплати: 20000.0
```