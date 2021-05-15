package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Form1 {

    public WebDriver driver;
    public WebElement firstName;
    public WebElement phoneNumber;
    public WebElement gender;
    public WebElement title;
    public WebElement submit;

    public By lastName = By.id("lastName");

    public Form1(WebDriver driver){
        this.driver = driver;
        firstName = driver.findElement(By.id("firstName"));
        phoneNumber = driver.findElement(By.id("userNumber"));
        gender = driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label"));
        submit = driver.findElement(By.cssSelector("#submit"));
        title = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/div"));
    }
}
