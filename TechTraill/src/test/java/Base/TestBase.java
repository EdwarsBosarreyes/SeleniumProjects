package Base;
//Driver Manager
import io.github.bonigarcia.wdm.WebDriverManager;
//Selenium
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.util.concurrent.TimeUnit;


public class TestBase {
    public WebDriver chromeDriver;
    public WebDriverWait generateWait;

    @BeforeSuite
    public void DriverSetup() {
        WebDriverManager.chromedriver().setup();

        //Opciones
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("disable-infobars");
        //options.addArguments("--headless");
        chromeDriver = new ChromeDriver(options);
        generateWait = new WebDriverWait(chromeDriver, 30);

    }

    @AfterSuite
    public void CloseDriver() {
        chromeDriver.close();
    }

    @BeforeMethod
    public void NavigateToForm() {
        chromeDriver.get("https://demoqa.com/automation-practice-form");
        chromeDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void TakeScreenshotAfterRun (ITestResult result){
        TakeScreenshot(result);
    }

    public void TakeScreenshot(ITestResult result){
        File file = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
        file.renameTo(new File("/Users/EdwarsBosarreyes/IdeaProjects/TechTraill/src/test/Resultados", String.format("%s.png", result.getMethod().getMethodName())));
    }
}
