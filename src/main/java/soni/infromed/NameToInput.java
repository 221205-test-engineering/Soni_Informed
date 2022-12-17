package soni.infromed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class NameToInput {
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
//        submitFormLevel1();
//        submitFormLevel2();
        submitFormLevel3();

        driver.quit();
    }
//
//    public static void submitFormLevel1(){
//        driver.get("http://127.0.0.1:5500/level-1.html");
//        WebElement inputType = driver.findElement(By.id("nameInput"));
//        WebElement inputText = driver.findElement(By.id("randomString"));
//        inputType.sendKeys(inputText.getAttribute("innerHTML"));
//        inputType.submit();
//        driver.switchTo().alert().accept();
//    }
//    public static void submitFormLevel2(){
//        // Website loading
//        driver.get("http://127.0.0.1:5500/level-2.html");
//
//        // Selecting from dropdown
//        WebElement selectOne = driver.findElement(By.xpath("/html/body/dl/dd[1]"));
//        Select selectNum = new Select(driver.findElement(By.name("input1")));
//        selectNum.selectByVisibleText(selectOne.getAttribute("innerHTML"));
//
//        // Selected all checkbox
////
//        List<WebElement> AllCheckboxes =  driver.findElements(By.xpath("//input[@type='checkbox']"));
//        int size = AllCheckboxes.size();
//        System.out.println(size);
//        for(int i = 0; i<size; i++) {
//            AllCheckboxes.get(i).click();
//        }
//
//        // Radio button click
//        WebElement radioValue = driver.findElement(By.xpath("/html/body/dl/dd[3]"));
//
//        WebElement radio1 = driver.findElement(By.xpath("//input[@value='1']"));
//        WebElement radio2 = driver.findElement(By.xpath("//input[@value='2']"));
//        WebElement radio3 = driver.findElement(By.xpath("//input[@value='3']"));
//        System.out.println(radioValue.getText());
//        if (radioValue.equals(1)){
//            radio1.click();
//        }else if(radioValue.equals(2)){
//            radio2.click();
//        }else{
//            radio3.click();
//        }
//        // Date picker
//        WebElement pickDate = driver.findElement(By.xpath("/html/body/dl/dd[4]"));
//        WebElement fillDate = driver.findElement(By.name("dateInput"));
//        // Using send method to sent particular date to the calendar field
//        fillDate.sendKeys(pickDate.getAttribute("innerHTML"));
//
//
//        // Submit button
//        WebElement pickButton = driver.findElement(By.xpath("/html/body/dl/dd[5]"));
//        WebElement button1 = driver.findElement(By.xpath("/html/body/form/button[1]"));
//        WebElement button2 = driver.findElement(By.xpath("/html/body/form/button[2]"));
//        WebElement button3 = driver.findElement(By.xpath("/html/body/form/button[3]"));
//        if(pickButton.equals(1)){
//            button1.submit();
//        }else if(pickButton.equals(2)){
//            button2.submit();
//        }else{
//            button3.submit();
//        }
//        driver.switchTo().alert().accept();
//
//    }

    public static void submitFormLevel3() throws InterruptedException {
        driver.get("http://127.0.0.1:5500/level-3.html");
        WebElement form1 = new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));
        form1.click();
        form1.sendKeys("Hello");
        WebElement form2 = driver.findElement(By.xpath("/html/body/form/input[2]"));
        form2.click();form2.sendKeys("Hello");
        WebElement form3 = driver.findElement(By.xpath("/html/body/form/input[3]"));
        form3.click();form3.sendKeys("Hello");
        WebElement form4 = driver.findElement(By.xpath("/html/body/form/input[4]"));
        form4.click();form4.sendKeys("Hello");
        Thread.sleep(10000);

    }
}
