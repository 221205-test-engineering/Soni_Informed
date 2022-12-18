package soni.infromed;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;
import java.util.List;

public class Level2 {
    // Website loading
    static WebDriver driver;
    public static void level2Web() {
        driver.get("http://127.0.0.1:5500/level-2.html");
    }
    // Selecting from dropdown
    public static void selectDropdown() {
        WebElement selectOne = driver.findElement(By.xpath("/html/body/dl/dd[1]"));
        Select selectNum = new Select(driver.findElement(By.name("input1")));
        selectNum.selectByVisibleText(selectOne.getAttribute("innerHTML"));
    }

    // Selected all checkbox
    public static void selectCheckbox() {
        List<WebElement> AllCheckboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        int size = AllCheckboxes.size();
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            AllCheckboxes.get(i).click();
        }
    }

    // Radio button click
    public static void clickRadio() {
        WebElement radioValue = driver.findElement(By.xpath("/html/body/dl/dd[3]"));

        WebElement radio1 = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement radio2 = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement radio3 = driver.findElement(By.xpath("//input[@value='3']"));
        System.out.println(radioValue.getText());

        if (radioValue.equals(1)) {
            radio1.click();
        } else if (radioValue.equals(2)) {
            radio2.click();
        } else {
            radio3.click();
        }
    }

    // Date picker
    public static void datePicker() {
        WebElement pickDate = driver.findElement(By.xpath("/html/body/dl/dd[4]"));
        WebElement fillDate = driver.findElement(By.name("dateInput"));
        // Using send method to sent particular date to the calendar field
        fillDate.sendKeys(pickDate.getAttribute("innerHTML"));
    }

    // Submit button
    public static void submitButton() {
        WebElement pickButton = driver.findElement(By.xpath("/html/body/dl/dd[5]"));
        WebElement button1 = driver.findElement(By.xpath("/html/body/form/button[1]"));
        WebElement button2 = driver.findElement(By.xpath("/html/body/form/button[2]"));
        WebElement button3 = driver.findElement(By.xpath("/html/body/form/button[3]"));
        if (pickButton.equals(1)) {
            button1.submit();
        } else if (pickButton.equals(2)) {
            button2.submit();
        } else {
            button3.submit();
        }
        driver.switchTo().alert().accept();
    }
}

