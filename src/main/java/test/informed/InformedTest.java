package test.informed;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import soni.informed.Level1;
import soni.informed.Level2;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import soni.informed.Level3;
import soni.informed.Level4;
import java.time.Duration;
import java.util.List;


public class InformedTest {
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        // Loading level1 page
        driver.get("file:///D:/Revature/Soni_Informed/src/main/resources/level-1.html");
        new Level1(driver);

        WebElement inputType = driver.findElement(By.id("nameInput"));
        String inputText = driver.findElement(By.id("randomString")).getText();
        inputType.sendKeys(inputText);
        inputType.submit();
        if(driver.switchTo().alert().getText().contains("SUCCESS")){
            System.out.println("Level1 SUCCESS");
        }else System.out.println("Level1 FAILED");
        driver.switchTo().alert().accept();

        // Loading level2 page
        driver.get("file:///D:/Revature/Soni_Informed/src/main/resources/level-2.html");
        new Level2(driver);

        // Selecting from dropdown menu
        WebElement selectOne = driver.findElement(By.xpath("/html/body/dl/dd[1]"));
        Select selectNum = new Select(driver.findElement(By.name("input1")));
        selectNum.selectByVisibleText(selectOne.getAttribute("innerHTML"));

        // Select all checkboxes
        List<WebElement> AllCheckboxes =  driver.findElements(By.xpath("//input[@type='checkbox']"));
        for(WebElement boxes:AllCheckboxes) {
            boxes.click();
//            boxes.isSelected();
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

        // Submit
        String buttonNum = driver.findElement(By.xpath("/html/body/dl/dd[5]")).getText();
        WebElement buttons = driver.findElement(By.xpath("/html/body/form/button["+buttonNum+"]"));
        buttons.submit();
        if(driver.switchTo().alert().getText().contains("SUCCESS")){
            System.out.println("Level2 SUCCESS");
        }else System.out.println("Level2 FAILED");
        driver.switchTo().alert().accept();

        // Loading Level3 page
        driver.get("file:///D:/Revature/Soni_Informed/src/main/resources/level-3.html");
        new Level3(driver); // Object created

        List<WebElement> form1 = driver.findElements(By.xpath("//input[@type='text']"));
        for (int i=1; i<=4; i++) {
            // Explicit wait used to load the page
            WebElement forms = new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                    ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/input[" + i + "]")));
            forms.sendKeys("Hello");
            System.out.println(forms.isDisplayed());
        }
        //Submit forms and message printing
        driver.findElement(new By.ByTagName("button")).submit();
        if(driver.switchTo().alert().getText().contains("SUCCESS")){
            System.out.println("Level3 SUCCESS");
        }else System.out.println("Level3 FAILED");
        driver.switchTo().alert().accept();

        // Loading level4 page
        driver.get("file:///D:/Revature/Soni_Informed/src/main/resources/level-4.html");
        new Level4(driver);

        WebElement longText = driver.findElement(By.xpath("//input[@type='text']"));
        for(int i=0; i<100; i++){
            longText.sendKeys("S");
            driver.switchTo().alert().accept();
        }
        longText.submit();
        if(driver.switchTo().alert().getText().contains("SUCCESS")){
            System.out.println("Level4 SUCCESS");
        }else System.out.println("Level4 FAILED");
        driver.switchTo().alert().accept();

        Thread.sleep(1000);
        driver.close();
        driver.quit();
    }
}
