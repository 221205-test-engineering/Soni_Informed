package test.informed;

import org.openqa.selenium.*;
import soni.informed.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InformedTest {
    public static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        try {
            // Loading level1 page
            driver.get("file:///D:/Revature/Soni_Informed/src/main/resources/level-1.html");
            Level1 l1 = new Level1(driver);
            l1.nameInput();

            // Loading level2 page
            driver.get("file:///D:/Revature/Soni_Informed/src/main/resources/level-2.html");
            Level2 l2 = new Level2(driver);
            l2.formSubmission();

            // Loading Level3 page
            driver.get("file:///D:/Revature/Soni_Informed/src/main/resources/level-3.html");
            Level3 l3 = new Level3(driver); // Object created
            l3.flickeringInput();

            // Loading level4 page
            driver.get("file:///D:/Revature/Soni_Informed/src/main/resources/level-4.html");
            Level4 l4 = new Level4(driver);
            l4.hundredCharText();

            // Level 5 loading
            driver.get("file:///D:/Revature/Soni_Informed/src/main/resources/level-5.html");
            Level5 l5 = new Level5(driver);
            l5.hundredCharLong();

            // Level 6a loading
            driver.get("file:///D:/Revature/Soni_Informed/src/main/resources/level-6a.html");
            Level6a l6a = new Level6a(driver);
            l6a.checkBox();

            // Level 6b loading
            driver.get("file:///D:/Revature/Soni_Informed/src/main/resources/level-6b.html");
            Level6b l6b = new Level6b(driver);
            l6b.approvalGate1();

            // Level 6c loading
            driver.get("file:///D:/Revature/Soni_Informed/src/main/resources/level-6c.html");
            Level6c l6c = new Level6c(driver);
            l6c.approvalGate2();

            // Level 7 loading
            driver.get("file:///D:/Revature/Soni_Informed/src/main/resources/level-7.html");
            Level7 l7 = new Level7(driver);
            l7.windowResize();

            // Level 8 loading
            driver.get("file:///D:/Revature/Soni_Informed/src/main/resources/level-8.html");
            Level8 l8 = new Level8(driver);
            l8.fileWriting();

            // Level9 loading
            driver.get("file:///D:/Revature/Soni_Informed/src/main/resources/level-9.html");
            Level9 l9 = new Level9(driver);
            l9.inputString();

            // Level-10 loading
            driver.get("file:///D:/Revature/Soni_Informed/src/main/resources/level-10.html");
            Level10 l10 = new Level10(driver);
            l10.screenshot();

            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
