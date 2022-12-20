package soni.informed;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Level4 {
    public WebDriver driver;
    public Level4(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void hundredCharText(){

        for(int i=0; i<100; i++){
            longText.sendKeys("S");
            driver.switchTo().alert().accept();
        }
        longText.submit();
        if(driver.switchTo().alert().getText().contains("SUCCESS")){
            System.out.println("Level4 SUCCESS");
        }else System.out.println("Level4 FAILED");
        driver.switchTo().alert().accept();
    }

    @FindBy(xpath = "//input[@type='text']")
    public WebElement longText;

}
