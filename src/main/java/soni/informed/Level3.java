package soni.informed;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Level3 {
    public WebDriver driver;
    public Level3(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void flickeringInput(){

        for (int i=1; i<=4; i++) {
            // Explicit wait used to load the page
            WebElement forms = new WebDriverWait(driver, Duration.ofSeconds(40)).until(
                    ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/input[" + i + "]")));
            forms.sendKeys("Hello");
            forms.isDisplayed();
        }
        //Submit forms and message printing
        button.submit();
        if(driver.switchTo().alert().getText().contains("SUCCESS")){
            System.out.println("Level3 SUCCESS");
        }else System.out.println("Level3 FAILED");
        driver.switchTo().alert().accept();
    }

    // Find element xpath
    @FindBy(tagName = "button")
    public WebElement button;
}
