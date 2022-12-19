package soni.informed;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class Level3 {
    public WebDriver driver;
    public Level3(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    // Find element xpath
    @FindBy(xpath = "//input[@type='text']")
    List<WebElement> form1;

}
