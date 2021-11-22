//Сценарий на наличие стикеров
//1 товар - 1 стикер!
package ru.LiteCartShop;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Tickers {

    private WebDriver driver;
    private WebDriverWait wait;

    @Test
    public void tickers() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);

        driver.manage().window().maximize();
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("remember_me")).click();
        driver.findElement(By.name("login")).click();
        driver.findElement(By.cssSelector("[href=\"http://localhost/litecart/en/\"]")).click();

        List<WebElement> ducks = driver.findElements(By.cssSelector(".product"));

        for (WebElement element : ducks) {
            System.out.println(element.findElement(By.className("name")).getText());

            List<WebElement> stickers = element.findElements(By.cssSelector(".sticker"));

            if (stickers.size() == 1) {
                System.out.println(element.findElement(By.cssSelector(".sticker")).getText());
            } else {
                System.out.println("ERROR! Product has more one sticker!");
            }
        }
        driver.quit();
        driver = null;
    }
}
