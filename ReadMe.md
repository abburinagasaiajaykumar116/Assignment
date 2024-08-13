# SQL Injection Test Using Selenium

## Overview
This project is a Selenium WebDriver-based Java program designed to interact with a web application's login form and perform a controlled SQL injection attack. The target URL used for testing is [OWASP Juice Shop](https://juice-shop.herokuapp.com/#/login), a safe and legal environment for testing web security.

## Setup Instructions
1. Ensure that you have JDK installed.
2. Use Maven to manage dependencies (Selenium, WebDriverManager).
3. Clone the repository and import the Maven project into your preferred IDE.

## Assumptions
- The SQL injection payload is crafted with the assumption that the target web application might be vulnerable to a simple SQLi attack.
- The username and password fields are identified by `id` attributes (`email`, `password`), and the login button by `id` `loginButton`.

## Exception Handling
The program is designed to handle exceptions such as element not found or timeouts gracefully, ensuring that any issues during test execution are caught and reported without crashing the application.

## Running the Program
Execute the `SQLInjectionTest` class from your IDE or via the command line. Ensure that the WebDriver binary is correctly set up using WebDriverManager.

## Output
The program will print out the results of the test, including any error messages detected after the login attempt.
