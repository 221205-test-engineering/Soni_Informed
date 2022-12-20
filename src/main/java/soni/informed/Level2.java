package soni.informed;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.util.List;

public class Level2 {
    // Website loading
    public static WebDriver driver;
    public Level2(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    // Select Dropdown

    public void formSubmission(){
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
    }
    @FindBy(xpath = "/html/body/dl/dd[1]")
    public WebElement selectOne;
    @FindBy(name = "input1")
    public Select selectNum;
    // Select all checkboxes
    @FindBy(xpath = "//input[@type='checkbox']")
    public List<WebElement> AllCheckboxes;

    // Radio button click
    @FindBy(xpath = "/html/body/dl/dd[3]")
    public String radioValue;

    // Date picker
    @FindBy(xpath = "/html/body/dl/dd[4]")
    public WebElement pickDate;
    @FindBy(name = "dateInput")
    public WebElement fillDate;

    // Submit
    @FindBy(xpath = "/html/body/dl/dd[5]")
    public String buttonNum;
}

