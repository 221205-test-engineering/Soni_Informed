package soni.informed;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

public class Level2 {
    // Website loading
    public static WebDriver driver;
    public Level2(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    // Select Dropdown
    @FindBy(xpath = "/html/body/dl/dd[1]")
    WebElement selectOne;
    @FindBy(name = "input1")
    Select selectNum;
    // Select all checkboxes
    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement AllCheckboxes;

    // Radio button click
    @FindBy(xpath = "/html/body/dl/dd[3]")
    String radioValue;

    // Date picker
    @FindBy(xpath = "/html/body/dl/dd[4]")
    WebElement pickDate;
    @FindBy(name = "dateInput")
    WebElement fillDate;

    // Submit
    @FindBy(xpath = "/html/body/dl/dd[5]")
    String buttonNum;
}

