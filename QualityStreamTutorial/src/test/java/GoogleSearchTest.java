import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class GoogleSearchTest {
    private WebDriver chromeDriver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();

        chromeDriver.get("https://www.google.com");
    }

    @Test
    public void testGooglePage(){
        WebElement searchBox = chromeDriver.findElement(By.name("q"));
        searchBox.clear();
        searchBox.sendKeys("Prueba");

        searchBox.submit();

        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        assertEquals("Prueba - Buscar con Google", chromeDriver.getTitle());
    }

    @After
    public void tearDown(){
        chromeDriver.quit();
    }
}
