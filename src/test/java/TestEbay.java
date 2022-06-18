import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestEbay {
    WebDriver driver;
    String url = "https://www.ebay.es/";


    @Test
    public void getProduct(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);

        driver.findElement(By.cssSelector("#gh-ac.gh-tb")).sendKeys("electronica");
        driver.findElement(By.cssSelector("#gh-btn")).click();
        driver.findElement(By.xpath("//input[contains(@id, \"s0-50-12-0-1-2-6-0-6[3]-0-textrange-beginParamValue-textbox\")]")).sendKeys("1");
        driver.findElement(By.xpath("//input[contains(@id, \"s0-50-12-0-1-2-6-0-6[3]-0-textrange-endParamValue-textbox\")]")).sendKeys("1");
        driver.findElement(By.cssSelector(".x-textrange__button")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement amount1evro = driver.findElement(By.cssSelector("div h1.srp-controls__count-heading span.BOLD:first-child"));
        Assert.assertTrue(amount1evro.isDisplayed());

        String quantity = amount1evro.getText();
        System.out.println(quantity);
    }
}
