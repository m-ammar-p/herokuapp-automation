# HerokuApp Automation Assessment

This project is built using:
- Java 21
- Selenium WebDriver
- Cucumber BDD
- JUnit 5
- Maven
- Allure Reporting

---

## 🔧 Prerequisites

- Java 21+
- Maven installed
- Chrome browser

---

## ⚙️ Project Setup

Install dependencies and compile the project:

```bash
mvn clean
mvn compile
```
## ▶️ How to Run Tests

Run all scenarios:

```bash
mvn clean test
```

Run specific tagged scenarios:
```bash
mvn clean test -D"cucumber.filter.tags=@Regression"
```
## 📊 View Allure Report

```bash
mvn allure:serve
```