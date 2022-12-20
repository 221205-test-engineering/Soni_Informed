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

    public void nameInput(){
        String inputText = driver.findElement(By.id("randomString")).getText();
        inputType.sendKeys(inputText);
        inputType.submit();
        if(driver.switchTo().alert().getText().contains("SUCCESS")){
            System.out.println("Level1 SUCCESS");
        }else System.out.println("Level1 FAILED");
        driver.switchTo().alert().accept();
    }

    @FindBy(id = "nameInput")
    public WebElement inputType;
}
