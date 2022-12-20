package soni.informed;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Level6b {
    public WebDriver driver;
    public Level6b(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void approvalGate1(){
        button.click();

        if(driver.switchTo().alert().getText().contains("GATE")){
            System.out.println("Level6 Success");
        }else{
            System.out.println("Level6 Failed");
        }
        driver.switchTo().alert().accept();
    }

    @FindBy(xpath = "/html/body/button")
    WebElement button;
}
