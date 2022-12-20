package soni.informed;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class Level3 {
    public WebDriver driver;
    public Level3(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void flickeringInput(){
        WebElement[] inputs = {input2, input2, input3, input4};
        for(WebElement input:inputs){
            new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(30)) // how long in total to wait for the page/DOM to load
                    .pollingEvery(Duration.ofNanos(1)) // during those 10 seconds - we are looking at the DOM every 2 seconds
                    .ignoring(ElementNotInteractableException.class) // if any exception occurs - we ignore it and keep polling
                    .until(ExpectedConditions.visibilityOf(input));
                    input.sendKeys("Soni");
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
    @FindBy(xpath = "/html/body/form/input[1]")
    WebElement input1;
    @FindBy(xpath = "/html/body/form/input[2]")
    WebElement input2;
    @FindBy(xpath = "/html/body/form/input[3]")
    WebElement input3;
    @FindBy(xpath = "/html/body/form/input[4]")
    WebElement input4;
}
