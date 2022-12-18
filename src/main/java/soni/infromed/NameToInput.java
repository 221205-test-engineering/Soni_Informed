package soni.infromed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.List;

public class NameToInput {
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        level1();
        level2();
        level3();
        driver.quit();
    }

    public static void level1(){
        driver.get("http://127.0.0.1:5500/level-1.html");
        WebElement inputType = driver.findElement(By.id("nameInput"));
        String inputText = driver.findElement(By.id("randomString")).getText();
        inputType.sendKeys(inputText);
        inputType.submit();
        driver.switchTo().alert().accept();
    }
    public static void level2(){
        // Website loading
        driver.get("http://127.0.0.1:5500/level-2.html");

        // Selecting from dropdown
        WebElement selectOne = driver.findElement(By.xpath("/html/body/dl/dd[1]"));
        Select selectNum = new Select(driver.findElement(By.name("input1")));
        selectNum.selectByVisibleText(selectOne.getAttribute("innerHTML"));

        // Selected all checkbox
        List<WebElement> AllCheckboxes =  driver.findElements(By.xpath("//input[@type='checkbox']"));
        for(WebElement boxes:AllCheckboxes) {
            boxes.click();
        }

        // Radio button click
        String radioValue = driver.findElement(By.xpath("/html/body/dl/dd[3]")).getText();
        WebElement radio1 = driver.findElement(By.xpath("//input[@value='"+radioValue+"']"));
        System.out.println(radioValue);
        radio1.click();

        // Date picker
        WebElement pickDate = driver.findElement(By.xpath("/html/body/dl/dd[4]"));
        WebElement fillDate = driver.findElement(By.name("dateInput"));
        // Using send method to sent particular date to the calendar field
        fillDate.sendKeys(pickDate.getAttribute("innerHTML"));

        // Submit button
        String buttonNum = driver.findElement(By.xpath("/html/body/dl/dd[5]")).getText();
        WebElement buttons = driver.findElement(By.xpath("/html/body/form/button["+buttonNum+"]"));
        buttons.submit();
        driver.switchTo().alert().accept();
    }

    public static void level3() throws InterruptedException {
        driver.get("http://127.0.0.1:5500/level-3.html");
        driver.manage().window().maximize();
        for (int i=1;i<=4;i++) {
            WebElement forms = new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                    ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/input["+i+"]")));
            forms.sendKeys("Hello");
            System.out.println(forms.isDisplayed());
        }
        driver.findElement(new By.ByTagName("button")).submit();
        driver.switchTo().alert().accept();
        Thread.sleep(20000);
    }
}
