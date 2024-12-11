# Automated Testing Project with Selenium and Cucumber

This project is designed to perform automated tests on a website using Selenium WebDriver and Cucumber. The main objective is to validate the login functionality on the SauceDemo website using test data stored in a properties file.

## Requirements

Before running the project, make sure you have the following:

- JDK 11 or later
- Maven (for dependency management and test execution)
- ChromeDriver (or another driver compatible with your browser)

## Installation

### Step 1: Clone the Repository

```bash
git clone https://github.com/mmuller/auto-testify.git
cd auto-testify
```

### Step 2: Install Dependencies with Maven
Ensure you have Maven installed on your machine. If you don’t, you can download it from Maven's official website.

Run the following command to install all required dependencies:

```bash
mvn install
```

### Step 3: Download ChromeDriver
If you're using Chrome as the browser, download the correct version of ChromeDriver from here. Make sure to place the chromedriver file in a directory accessible from your system PATH, or place it in the root directory of this project.

## Project Configuration

### Test Data Files
In the src/test/resources/ folder, you’ll find the test_data.json file, which contains valid and invalid user credentials for the tests. 

### Cucumber Feature Files
In the src/test/resources/features/ folder, you’ll find .feature files that define the test scenarios.

## Running the Tests
### Run from Command Line
Once you've installed all dependencies, you can run the tests using the following Maven command:

```bash
mvn test
```

This command will execute the tests defined in the .feature files using the step definitions in stepdefinitions classes.

### Run a Specific Scenario
To run a specific scenario or feature, use the following command:

```bash
mvn test -Dcucumber.options="--tags @tag_name"
```

Replace @tag_name with the tag name of the scenario or feature you want to run.

## Code Explanation
### Key Classes
LoginPage.java
This class represents the login page of SauceDemo. It contains methods to interact with elements on the page, such as entering credentials, checking if login was successful, and retrieving error messages.

### LoginStepDefs.java
This class contains the Cucumber step definitions. The methods correspond to the actions in the .feature file and use the methods from the LoginPage class to interact with the login page.

### WebDriverFactory.java
This file is responsible for creating and managing the WebDriver instance. It is currently configured to use ChromeDriver, but it can be easily modified to support other browsers.

### Cucumber Feature Files
The .feature files define the test scenarios that are executed in the step definitions (stepdefs). In this project, the scenarios are login tests with different credentials.

Enjoy!

