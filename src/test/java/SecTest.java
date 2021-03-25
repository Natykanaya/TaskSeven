import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SecTest {
    @Test
    public void ttest(){
        System.setProperty("webdriver.chrome.driver","chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/");

        WebElement searchElement = driver.findElement(By.xpath("//input[@name='search']"));
        searchElement.sendKeys("Монитор");
        //  String searchUrl = "//*[@id=\"rso\"]/div/div[1]/div/div[1]/a/div/cite";
        WebElement searchButton= driver.findElement(By.cssSelector(".button.search-form__submit"));
        searchButton.click();
//
        WebElement firstProdElem= driver.findElement(By.xpath("/html/body/app-root/div/div[1]/rz-category/div/main/rz-catalog/div/div/section/rz-grid/ul/li[1]/app-goods-tile-default/div/div[2]/a[2]"));
        String actualRes = firstProdElem.getText();
        System.out.println(actualRes);
        Assert.assertTrue(actualRes.contains("Mонитор"), "errors");


        driver.quit();
    }
}
