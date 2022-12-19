package soni.informed;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Level1 {
    public static WebDriver driver;
    //Constructor, as every page needs a WebDriver to find elements
    public Level1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "randomString")
    String inputText;
    @FindBy(id = "nameInput")
    WebElement inputType;
}
