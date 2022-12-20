package soni.informed;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Level9 {
    public WebDriver driver;

    public Level9(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void inputString(){
        inputName.sendKeys("Something");
        submitButton.submit();
        if(driver.switchTo().alert().getText().contains("SUCCESS")){
            System.out.println("Level9 SUCCESS");
        }else System.out.println("Level9 FAILED");
        driver.switchTo().alert().accept();
    }


    @FindBy(id = "nameInput")
    public WebElement inputName;

    @FindBy(id = "submitBtn")
    public WebElement submitButton;
}