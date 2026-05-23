package Internship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class DemoApps {
    public static void main(String[] args) throws IOException, InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // IMPORTANT: create JS executor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://demoapps.qspiders.com/");

        // UI Testing Concepts
        driver.findElement(By.xpath("//p[text()='UI Testing Concepts']")).click();

        // Register
        driver.findElement(By.xpath("//button[contains(text(),'Register')]")).click();
        driver.findElement(By.id("name")).sendKeys("Ganesh");
        driver.findElement(By.id("email")).sendKeys("ganeshdevadig7343@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Ganesh@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Login
        wait.until(ExpectedConditions.elementToBeClickable(By.id("email"))).sendKeys("ganeshdevadig7343@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Ganesh@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Button → Yes
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[text()='Button']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Yes']"))).click();

        // Link → Men
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[text()='Link']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Men']"))).click();

        // Check Box
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[text()='Check Box']"))).click();

       driver.findElement(By.id("domain_a")).click();
       driver.findElement(By.id("mode_b")).click();
       driver.findElement(By.id("mode_f")).click();
       
       driver.findElement(By.id("mode_g")).click();
       
       //Togglers
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(@class,relative)])[2]"))).click();
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(@class,relative)])[4]"))).click();
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(@class,relative)])[6]"))).click();
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(@class,relative)])[8]"))).click();
       driver.findElement(By.id("togglers")).click();
       
       //Screenshot
       Thread.sleep(2000);
       TakesScreenshot ts = (TakesScreenshot) driver;
       File temp = ts.getScreenshotAs(OutputType.FILE);	
       File perm = new File("./screenshots/Demoapps1.png");
       FileHandler.copy(temp, perm);
    }
}