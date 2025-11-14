A simple Java console application for calculating grades using multiple grading systems.  
The project provides a clean, interactive interface and supports Letter Grade, Percent Grade, and GPA calculations.

---

## Features

- Supports multiple grading types:
    - Letter Grade
    - Percent Grade
    - GPA
- User-friendly console interface.
- Input validation to prevent invalid entries.
- Modular structure for easy extension.
- Lightweight and fast.

---

## Getting Started

### Prerequisites

- Java 21+
- Maven (optional, if you want to build via Maven)
- A terminal or IDE such as IntelliJ IDEA

---

## Running the Project

### Option 1: Using Maven

```bash
git clone https://github.com/mahmoud2617/GradingCalculator
cd GradingCalculator
mvn compile
mvn exec:java
```


### Option 2: Compile & Run Manually

~~~bash
javac Main.java 
java Main
~~~

Make sure you run the correct main class if your project is structured into packages.

---

## Project Structure

~~~markdown
src/
 └── main/
     ├── java/
     │    └── com/mahmoud/GradingCalculator
     └── resources/
~~~

---

## How It Works

The application prompts the user to select a grading system, then collects grade values and calculates the final score according to the chosen type.  
The design is kept simple so it can be extended later with new grading systems or UI improvements.

---

## Author

Developed by ___Mahmoud Mohammed___.
