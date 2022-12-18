package soni.infromed;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Level3 {
    static WebDriver driver;
    public static void inputText(){
        driver.get("http://127.0.0.1:5500/level-3.html");
        driver.manage().window().maximize();
        WebElement form1 = new WebDriverWait(driver, Duration.ofSeconds(30)).until(
            ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/input[1]")));
        form1.sendKeys("Hello");
        System.out.println(form1.isDisplayed());
        WebElement form2 = new WebDriverWait(driver, Duration.ofSeconds(30)).until(
            ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/input[2]")));
        form2.sendKeys("Dan");
        System.out.println(form2.isDisplayed());
        WebElement form3 = new WebDriverWait(driver, Duration.ofSeconds(30)).until(
            ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/input[3]")));
        form3.sendKeys("How");
        System.out.println(form3.isDisplayed());
        WebElement form4 = new WebDriverWait(driver, Duration.ofSeconds(30)).until(
            ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/input[4]")));
        form4.sendKeys("are you?");
        System.out.println(form4.isDisplayed());

        driver.findElement(new By.ByTagName("button")).submit();
        driver.switchTo().alert().accept();
    }
}
