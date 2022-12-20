package soni.informed;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Level10 {
    public WebDriver driver;
    public Level10(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void screenshot(){
        try {
            File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(f, new File("D:/Revature/Soni_Informed/src/main/resources/screenshot01.png"));
            inputFile.sendKeys(f.getAbsolutePath());
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(60))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoAlertPresentException.class);
            wait.until(driver -> {
                return review;
            }).click();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @FindBy(xpath = "//input[@type='file']")
    public WebElement inputFile;
    @FindBy(tagName = "button")
    public WebElement review;
}
