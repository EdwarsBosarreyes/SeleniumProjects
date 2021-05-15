package org.EBTech.Basico;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsExpample {

    static WebDriver driver;

    public static void main(String[] args){
        String chromePath = System.getProperty("user.dir")+"/drivers/chromedriver";
        System.setProperty("webdriver.chrome.driver", chromePath);
        String baseURL = "http://www.facebook.com/";

        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

        try{

            WebElement txtuser = driver.findElement(By.id("email"));

            Actions builder = new Actions(driver);

            Action seriesOfActions = builder
                    .moveToElement(txtuser)
                    .click()
                    .keyDown(Keys.SHIFT)
                    .sendKeys("hello")
                    .keyUp(Keys.SHIFT)
                    .doubleClick()
                    .contextClick(txtuser)
                    .build();

            seriesOfActions.perform();
            Thread.sleep(2000);
            System.out.println("Test Aceptado!");
        }catch (NoSuchElementException ne){
            System.err.println("Test Fallido! : Element was not found");
        }catch (Exception e){
            System.err.println("Test Fallido! :"+e.getMessage());
        }finally {
            driver.close();
        }
    }
}
