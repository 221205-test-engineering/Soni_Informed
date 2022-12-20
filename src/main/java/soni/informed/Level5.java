package soni.informed;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Level5 {
    public WebDriver driver;
    public Level5(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void hundredCharLong(){
        for (int i = 0; i < 100; i++) {
            textInput.sendKeys("H");
            driver.switchTo().alert().accept();
        }
        textInput.submit();
        if(driver.switchTo().alert().getText().contains("SUCCESS")){
            System.out.println("Level5 SUCCESS");
        }else System.out.println("Level5 FAILED");
        driver.switchTo().alert().accept();
    }


    @FindBy(tagName = "input")
    public WebElement textInput;

}
