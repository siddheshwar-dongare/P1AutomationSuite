# Overview
P1AutomationSuite is a Hybrid Test Automation Framework designed for web application testing using Selenium WebDriver, Java, TestNG, and Cucumber.
This framework follows the Page Object Model (POM) for maintainability and integrates with GitHub Actions for CI/CD. 
Test execution results are logged and generated in Extent Reports.

# Tech Stack
Programming Language: Java
Testing Framework: TestNG + Cucumber
Automation Tool: Selenium WebDriver
Build Tool: Maven
Data Handling: Apache POI (Excel for test data management)
Logging: Log4j
Reporting: Extent Reports
Version Control: GitHub
CI/CD: GitHub Actions //next update will be with jenkins integration

# Folder Structure
P1AutomationSuite/
│-- .github/             # GitHub Actions for CI/CD
│-- extent-reports/      # ExtentReport.html files (Test Execution Reports)
│-- reports/             # Additional test execution reports
│-- screenshots/         # Screenshots for failed tests
│-- src/
│   ├── main/java/
│   │   ├── pages/       # Page Object Model (POM) classes
│   │   ├── utilities/   # Utility classes (Excel Reader, Logger, etc.)
│   ├── test/java/
│   │   ├── tests/       # Test classes with TestNG & Cucumber
│-- target/              # Compiled output files
│-- pom.xml              # Maven dependencies and configurations
│-- README.md            # Project documentation
