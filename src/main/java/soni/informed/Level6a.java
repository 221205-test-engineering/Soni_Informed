package soni.informed;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Level6a {
    public WebDriver driver;
    public Level6a(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void checkBox(){
        for(WebElement check:checks){
            check.click();
        }
        for(WebElement link: links){
            link.click();
        }
    }

    @FindBy(xpath = "//input[@type='checkbox']")
    List<WebElement> checks;
    @FindBy(linkText = "link")
    List<WebElement> links;
}
