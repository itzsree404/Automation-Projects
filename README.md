# Automation Testing Projects

## Overview

This repository contains **Selenium-based automation testing projects** developed using Java.
The framework is designed to validate web application functionality, ensure regression stability, and demonstrate industry‑standard automation practices suitable for course completion and interview portfolios.

---

## Tech Stack

* **Language:** Java
* **Automation Tool:** Selenium WebDriver
* **Test Framework:** TestNG
* **Build Tool:** Maven
* **Design Pattern:** Page Object Model (POM)
* **Reporting:** TestNG Reports / Extent Reports

---

## Project Structure

ChromaProject
 └── src
     └── test
        └── java
            ├── core            → Base classes, utilities, listeners, reports, retry, screenshots
            ├── pages           → Page Object Model (POM) classes
            └── tests           → TestNG test cases


## How to Run the Project

1. Clone the repository:

   bash
   git clone <your-repo-link>
   
2. Open the project in **Eclipse / IntelliJ IDEA**.
3. Update dependencies using Maven:

   bash
   mvn clean install
   
4. Run tests using:

   bash
   mvn test

   or execute the **TestNG XML file** directly from the IDE.

---

## Features Implemented

* Selenium framework structure
* Page Object Model for maintainable test design
* Reusable utilities (waits, configuration, driver management)
* Organized test execution using TestNG
* Suitable for:

  * Course final project submission
  * QA automation portfolio demonstration
  * Interview project showcase

---

## Sample Test Coverage

Typical automated scenarios may include:

* Login validation
* Product search and navigation
* Add to cart / checkout flow
* Form validation and error handling

---

## Project Report

The detailed **project documentation (PDF/DOCX)** can be placed in:
/docs
or attached in the repository **Reports** section.

---

## Future Enhancements

* Advanced reporting dashboards
* Parallel execution support

---

## Author

**Sreerag Krishnan**
Automation Testing Enthusiast | Java | Selenium

---

## License

This project is for **educational and demonstration purposes**.
