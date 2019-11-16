package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/home/essitepp/chromedriver");
        WebDriver driver = new ChromeDriver();

        //onnistunut kirjautuminen
//        driver.get("http://localhost:4567");
//
//        sleep(2);
//
//        WebElement element = driver.findElement(By.linkText("login"));
//        element.click();
//
//        sleep(2);
//
//        element = driver.findElement(By.name("username"));
//        element.sendKeys("pekka");
//        element = driver.findElement(By.name("password"));
//        element.sendKeys("akkep");
//        element = driver.findElement(By.name("login"));
//
//        sleep(2);
//        element.submit();
//
//        sleep(3);


        //epäonnistunut kirjautuminen
//        driver.get("http://localhost:4567");
//        sleep(2);
//        WebElement element = driver.findElement(By.linkText("login"));
//        element.click();
//        element = driver.findElement(By.name("username"));
//        element.sendKeys("pekka");
//        element = driver.findElement(By.name("password"));
//        element.sendKeys("password");
//        element = driver.findElement(By.name("login"));
//        sleep(2);
//        element.submit();
//        sleep(3);


        //uuden käyttäjätunnuksen luominen
        Random r = new Random();
        
        driver.get("http://localhost:4567");
        sleep(2);
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
        element = driver.findElement(By.name("username"));
        element.sendKeys("user" + r.nextInt(100000));
        element = driver.findElement(By.name("password"));
        element.sendKeys("password");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("password");
        element = driver.findElement(By.name("signup"));
        sleep(2);
        element.submit();
        sleep(3);
        
        //uloskirjautuminen käyttäjätunnuksen luomisen jälkeen
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        sleep(2);
        element = driver.findElement(By.linkText("logout"));
        element.click();
        sleep(3);
        

        driver.quit();
    }

    private static void sleep(int n) {
        try {
            Thread.sleep(n * 1000);
        } catch (Exception e) {
        }
    }

}
