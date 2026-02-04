# Selenium Automation Framework (Java)

**Author:** Vinay
**Project:** openSourceDemo

---

## 🚀 Overview

A robust and scalable Selenium automation framework built with **Java**, featuring the **Page Object Model (POM)** design pattern, **data-driven testing**, **parallel execution**, **advanced reporting**, and **cloud grid integration**.

---

## 🛠️ Tech Stack

| Component            | Technology               |
| -------------------- | ------------------------ |
| Programming Language | Java (JDK > 22)          |
| Automation Tool      | Selenium WebDriver       |
| Testing Framework    | TestNG                   |
| Build Tool           | Maven                    |
| Assertion Library    | AssertJ                  |
| Design Pattern       | Page Object Model (POM)  |
| Reporting            | Allure Report            |
| Test Data Management | Apache POI (Excel)       |
| Configuration        | Properties File          |
| Thread Safety        | Thread Local Support     |
| Cloud Platforms      | BrowserStack, LambdaTest |
| Code Quality         | SonarLint                |
| Container Grid       | Selenoid Integration     |

---

## 📁 Project Structure

```
openSourceDemo/
│
├── .idea/                          # IDE configuration files
├── .mvn/                           # Maven wrapper files
├── screenshot/                     # Test execution screenshots
│   └── verifyValidLogin_17700236534
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── api/               # API testing utilities
│   │   │   ├── base/              # Base classes for test setup
│   │   │   ├── driver/            # WebDriver management
│   │   │   ├── listeners/         # TestNG listeners
│   │   │   ├── pages/             # Page Object Model classes
│   │   │   ├── retry/             # Retry logic for flaky tests
│   │   │   └── utils/             # Helper utilities
│   │   └── resources/             # Configuration files, test data
│   │
│   └── test/                      # Test classes
│
├── target/                        # Build output directory
├── .gitignore                     # Git ignore file
├── pom.xml                        # Maven configuration
├── README.md                      # Project documentation
└── testng.xml                     # TestNG suite configuration
```

---

## ✨ Key Features

* ✅ Page Object Model (POM) – Maintainable and reusable page classes
* ✅ Thread-Safe Execution – Parallel execution using ThreadLocal
* ✅ Data-Driven Testing – Excel integration via Apache POI
* ✅ Smart Reporting – Allure reports with screenshots on failure
* ✅ Cloud Grid Support – BrowserStack & LambdaTest ready
* ✅ Local Grid – Selenoid integration
* ✅ Retry Mechanism – Automatic retry for flaky tests
* ✅ Custom Listeners – Enhanced logging & reporting
* ✅ Configuration Management – Centralized properties file
* ✅ Code Quality – SonarLint integration

---

## 🔧 Prerequisites

Ensure the following are installed:

* Java Development Kit (JDK) **22+**
* Maven **3.6+**
* IDE: IntelliJ IDEA / Eclipse / VS Code
* Git

---

## 📦 Installation & Setup

### 1️⃣ Clone the Repository

```bash
git clone <repository-url>
cd openSourceDemo
```

### 2️⃣ Install Dependencies

```bash
mvn clean install
```

### 3️⃣ Configure Properties File

Update configuration values:

* Application URL
* Username & Password
* Cloud grid credentials (BrowserStack / LambdaTest)
* Browser & environment settings

### 4️⃣ Verify Setup

```bash
mvn clean compile
```

---

## 🧪 Test Execution

### ▶️ Run All Tests

```bash
mvn test -Dsurefire.suiteXmlFiles=testng.xml
```

### ▶️ Run Specific Test Group

```bash
mvn test -DsuiteXmlFile=testng.xml -Dgroups=smoke
```

### ▶️ Parallel Execution

Configure `testng.xml`:

```xml
<suite name="Test Suite" parallel="tests" thread-count="3">
    <!-- Test configurations -->
</suite>
```

### ▶️ Run on Local Grid (Selenoid)

```bash
mvn test -Denvironment=selenoid
```

### ▶️ Run on Cloud Grid

**BrowserStack**

```bash
mvn test -Denvironment=browserstack
```

**LambdaTest**

```bash
mvn test -Denvironment=lambdatest
```

---

## 📊 Reporting

### Generate Allure Report

```bash
mvn allure:report
mvn allure:serve
```

### Screenshots

* Automatically captured on test failure
* Stored under `screenshot/` directory
* Naming format: `testMethodName_timestamp`

Example:

```
verifyValidLogin_17700236534
```

---

## 📝 Framework Components

### Base Package

* Test initialization & teardown
* WebDriver setup
* Common utilities

### Driver Package

* Driver Factory pattern
* Thread-safe WebDriver management
* Browser capabilities handling

### Pages Package

* One class per page
* Encapsulated elements
* Reusable actions

### Listeners Package

* Execution logging
* Screenshot capture on failure
* Reporting hooks

### Retry Package

* Retry analyzer
* Configurable retry count
* Smart failure handling

### Utils Package

* Excel utilities (Apache POI)
* Properties reader
* Wait helpers
* Common actions

---

## 🔄 Data-Driven Testing

### Excel Integration

* Test data stored in Excel
* Apache POI used for reading
* TestNG DataProvider for parameterization

```java
@DataProvider(name = "loginData")
public Object[][] getLoginData() {
    return ExcelUtils.readExcelData("testdata.xlsx", "LoginSheet");
}

@Test(dataproviders = "loginData")
public void testLogin(String username, String password) {
    // Test implementation
}
```

---

## ⚙️ Configuration Management

### Sample `config.properties`

```properties
# Browser Configuration
browser=chrome
headless=false

# Application URL
app.url=https://example.com

# Credentials
username=testuser
password=testpass

# Cloud Grid Configuration
browserstack.username=your_username
browserstack.accesskey=your_accesskey

lambdatest.username=your_username
lambdatest.accesskey=your_accesskey

# Timeout Configuration
implicit.wait=10
explicit.wait=20
```

---

## 🔒 Thread Safety

ThreadLocal is used for:

* WebDriver instances
* Test data
* Configuration handling

Ensures safe parallel execution without conflicts.

---

## 🌐 Cross-Browser Testing

Supported browsers:

* Chrome
* Firefox
* Safari
* Edge
* Opera

Override browser at runtime:

```bash
mvn test -Dbrowser=firefox
```

---

## 📈 Best Practices Implemented

* ✔️ Single Responsibility Principle
* ✔️ DRY (Reusable utilities)
* ✔️ Explicit waits for stability
* ✔️ Meaningful naming conventions
* ✔️ Robust exception handling
* ✔️ SonarLint code quality checks
* ✔️ Git version control

---

## 🐛 Troubleshooting

### WebDriver Not Found

```bash
mvn clean install -U
```

### Timeout Issues

Increase wait times:

```properties
implicit.wait=15
explicit.wait=30
```

### Allure Report Not Generating

* Ensure Allure CLI is installed

---

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch

   ```bash
   git checkout -b feature/AmazingFeature
   ```
3. Commit changes

   ```bash
   git commit -m "Add AmazingFeature"
   ```
4. Push to branch
5. Open a Pull Request

---

## 📄 License

This project is licensed under the **MIT License**.

---

## 📧 Contact

**Author:** Vinay
**Project:** openSourceDemo

---

## 🙏 Acknowledgments

* Selenium WebDriver Team
* TestNG Community
* Apache POI Contributors
* Allure Framework Team

---

### Happy Testing! 🚀

**Last Updated:** 2026
