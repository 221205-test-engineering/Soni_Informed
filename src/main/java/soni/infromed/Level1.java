package soni.infromed;

import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Level1 {
    static WebDriver driver;

    public Level1(WebDriver driver, String level1Site) {
        this.driver = driver;
        driver.get(level1Site);
        PageFactory.initElements(driver, this);
    }

    public Level1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //
    @FindBy(function level1())
    public WebElement = inputType;

    @FindBy(id = "randomString")
    public String inputType;

}
