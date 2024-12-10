package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.saucedemo.com/");
    }

    public void enterCredentials(String username, String password) {
        try {
            WebElement usernameInput = driver.findElement(By.id("user-name"));
            usernameInput.sendKeys(username);

            WebElement passwordInput = driver.findElement(By.id("password"));
            passwordInput.sendKeys(password);

            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();
        } catch (Exception e) {
            System.err.println("Unexpected error while entering credentials.");
            e.printStackTrace();
            throw new RuntimeException("Unexpected error", e);
        }
    }

    public String getPageTitle() {
        try {
            return driver.findElement(By.className("title")).getText();
        } catch (NoSuchElementException e) {
            return "Title not found";
        }
    }

    public boolean isLoginSuccessful() {
        return getPageTitle().equals("Products");
    }


    public String getErrorMessage() {
        try {
        return driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
        } catch (NoSuchElementException e) {
            System.err.println("Error: The error message element was not found.");
            e.printStackTrace();
            throw new RuntimeException("Error message element not found", e);
        }
    }

    public void signOut() {
        try {
        driver.findElement(By.id("react-burger-menu-btn")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
        driver.findElement(By.id("logout_sidebar_link")).click();
        } catch (Exception e) {
            System.err.println("Unexpected error occurred while signing out.");
            e.printStackTrace();
            throw new RuntimeException("Unexpected error during sign-out", e);
        }
    }
}