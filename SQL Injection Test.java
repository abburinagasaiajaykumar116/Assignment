import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SQLInjectionTest {
    public static void main(String[] args) {
        // Setup WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the OWASP Juice Shop login page
            driver.get("https://juice-shop.herokuapp.com/#/login");

            // Explicit wait for the login elements to be present
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));

            // Locate the username and password fields
            WebElement usernameField = driver.findElement(By.id("email"));
            WebElement passwordField = driver.findElement(By.id("password"));

            // Craft the SQL injection payload
            String sqlInjectionPayload = "' OR '1'='1";
            String validPassword = "password123"; // Change to a valid password

            // Enter the payload into the username field
            usernameField.sendKeys(sqlInjectionPayload);
            passwordField.sendKeys(validPassword);

            // Locate and click the login button
            WebElement loginButton = driver.findElement(By.id("loginButton"));
            loginButton.click();

            // Wait and analyze the response
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error")));
            WebElement errorElement = driver.findElement(By.cssSelector(".error"));

            // Output the result of the test
            if (errorElement != null) {
                System.out.println("Test completed. Error message detected: " + errorElement.getText());
            } else {
                System.out.println("Test completed. No error message detected.");
            }

        } catch (Exception e) {
            System.out.println("An error occurred during the test: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
