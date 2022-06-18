import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestAmazon {

    @Test

    public void AmazonCheckTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.es/");
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
        driver.findElement(By.xpath("//a[contains(@href, \"/gp/new-releases/kitchen\")][contains(@class, \"a-link-normal\")]")).click();
        driver.findElement(By.xpath("//div[contains(@id, \"B0B28G8XCN\")]")).click();
        WebElement enStock = driver.findElement(By.xpath("//span[contains(@class, \"a-size-medium a-color-success\")]"));
        Assert.assertTrue(enStock.isDisplayed());

    }
}
