import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestAmazon {
    WebDriver driver;
    String url = "https://www.amazon.es/";

    public void checkInStock(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        WebElement acceptButton = driver.findElement(By.xpath("//input[contains(@id, \"sp-cc-accept\")]"));
        if(acceptButton.isDisplayed()){
            acceptButton.click();
        }
        else{
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        }
        driver.findElement(By.xpath("//a[contains(@aria-label, \"Abrir menú\")]")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[contains(@href, \"nav_em_cs_newreleases_0_1_1_3\")][contains(@class, \"hmenu-item\")]")).click();
    }


    @Test

    public void AmazonCheckTest(){
        checkInStock();
        driver.findElement(By.xpath("//a[contains(@href, \"/gp/new-releases/kitchen\")][contains(@class, \"a-link-normal\")]")).click();
        driver.findElement(By.xpath("//div[contains(@id, \"B0B28G8XCN\")]")).click();
        WebElement addToCart = driver.findElement(By.xpath("//input[contains(@id, \"add-to-cart-button\")]"));
        Assert.assertTrue(addToCart.isDisplayed());

    }

    @Test
    public void AmazonCheck2(){
        checkInStock();
        driver.findElement(By.xpath("//a[contains(@href, \"/gp/new-releases/shoes\")][contains(@class, \"a-link-normal\")]")).click();
        driver.findElement(By.xpath("//div[contains(@id, \"B0B21W9XYT\")]")).click();
        WebElement buyNow = driver.findElement(By.xpath("//input[contains(@id, \"buy-now-button\")]"));
        Assert.assertTrue(buyNow.isDisplayed());

    }


}
