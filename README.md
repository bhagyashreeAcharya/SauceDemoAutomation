# SauceDemo Automation Framework (Selenium + TestNG + Maven)

## Overview

This project is a professional UI automation framework built using **Java, Selenium WebDriver, TestNG, and Maven** to automate and validate core e-commerce workflows on the SauceDemo application.

The framework demonstrates real-world automation practices including stable element handling, explicit waits, modular test structure, and complete end-to-end transaction coverage.

This project is designed as part of a QA Automation portfolio to showcase automation skills and framework design understanding.

---

## Tech Stack

**Language:** Java 21
** Automation Tool:** Selenium WebDriver
** Test Framework:** TestNG
** Build Tool:** Maven
** IDE:** IntelliJ IDEA
** Version Control:** Git + GitHub
** Browser:** Google Chrome
** Wait Strategy **: Explicit Wait (WebDriverWait)
** CI/CD: **  GitHub Actions

--

## Framework Structure

```
SauceDemoAutomation
│
├── src/test/java
│   ├── base
│   │   └── BaseTest.java
│   │
│   └── tests
│       ├── LoginTest.java
│       ├── InvalidLoginTest.java
│       ├── LockedUserLoginTest.java
│       ├── PerformanceLoginTest.java
│       ├── LogoutTest.java
│       ├── AddToCartTest.java
│       ├── AddMultipleProductsTest.java
│       ├── RemoveProductTest.java
│       └── CheckoutTest.java
│
├── pom.xml
├── .gitignore
└── README.md
```

---

## Key Features

* TestNG-based test execution and assertions
* Explicit wait implementation for stable execution
* BaseTest class for centralized driver setup and teardown
* Independent, modular test classes
* Real-world e-commerce workflow automation
* Clean and maintainable project structure
* Maven dependency management
* GitHub version control integration

---

## Automated Test Scenarios

### Login Scenarios

* Valid login using standard_user
* Invalid login using incorrect credentials
* Locked user login validation (locked_out_user)
* Performance glitch user login validation

---

### Cart Functionality

* Add single product to cart
* Add multiple products to cart
* Remove product from cart
* Verify cart badge count updates correctly

---

### Checkout Flow

Complete end-to-end checkout validation including:

* Add product to cart
* Navigate to cart
* Enter checkout details
* Complete checkout
* Verify order confirmation message

---

### Logout Functionality

* Verify successful logout
* Validate user redirected to login page

---

## Wait Strategy

Explicit waits are implemented using WebDriverWait to ensure:

* Elements are visible before interaction
* Elements are clickable before action
* UI state is properly validated

Example:

```
wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
```

This improves test stability and prevents flaky tests.

---

## ▶️ How to Run Tests

### Prerequisites

- Java 17 or above
- Maven installed
- Google Chrome browser

### Clone Repository

```
git clone https://github.com/bhagyashreeAcharya/SauceDemoAutomation.git
cd SauceDemoAutomation
```

### Run All Tests

```
mvn clean test
```

### Run Specific Test Class

```
mvn -Dtest=LoginTest test
```

---

## 🔁 Continuous Integration (CI)

This project is CI-enabled using **GitHub Actions**.

On every push or pull request to the `master` branch:

- Java environment is set up
- Chrome is installed
- Maven build runs
- All tests execute automatically
- Results are visible in the **Actions** tab

---

## Test Coverage Summary

| Feature           | Status  |
| ----------------- | ------- |
| Login             | Covered |
| Logout            | Covered |
| Add to Cart       | Covered |
| Remove from Cart  | Covered |
| Multiple Products | Covered |
| Checkout          | Covered |

---

## Automation Concepts Demonstrated

- Selenium WebDriver automation  
- TestNG test lifecycle management  
- Assertion-based validation  
- Explicit wait handling  
- Stable locator strategies  
- Modular framework structure  
- Maven dependency management  
- Git workflow  
- CI/CD pipeline integration
  
---

## Author

Bhagyashree Acharya
QA Automation Portfolio Project

GitHub: https://github.com/YOUR_USERNAME/SauceDemoAutomation

---

## Future Enhancements

* Page Object Model implementation
* TestNG XML suite configuration
* Parallel test execution
* CI/CD integration using GitHub Actions
* Test reporting integration

---
