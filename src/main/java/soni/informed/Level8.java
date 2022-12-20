package soni.informed;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Level8 {
    public WebDriver driver;
    public Level8(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fileWriting(){
        try {
            File file = File.createTempFile("input", "txt");
            FileWriter writer = new FileWriter(file);
            writer.write("Hello warriors");
            writer.close();

            fileInput.sendKeys(file.getAbsolutePath());
            subMit.click();

            if(driver.switchTo().alert().getText().contains("SUCCESS")){
                System.out.println("Level8 SUCCESS");
            }else System.out.println("Level8 FAILED");

            file.deleteOnExit();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().accept();
    }

    @FindBy(xpath="//input[@type='file']")
    public WebElement fileInput;
    @FindBy(tagName="button")
    public WebElement subMit;

}
