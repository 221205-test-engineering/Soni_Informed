package soni.informed;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Level7 {
    public WebDriver driver;

    public Level7(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void windowResize(){
        driver.manage().window().setSize(new Dimension(400, 400));
        button1.click();
        driver.manage().window().setSize(new Dimension(700, 700));
        button2.click();
        System.out.println(btn.isEnabled());
    }


    @FindBy(xpath = "/html/body/button[1]")
    public WebElement button1;
    @FindBy(xpath = "/html/body/button[2]")
    public WebElement button2;
    @FindBy(xpath = "/html/body/button[3]")
    public WebElement btn;
}
