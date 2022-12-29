package test_Package;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class No07_Test_Trendyol {


    // https://www.trendyol.com adresine gidin
    // cerezleri kabul et
    // Nutella aratın ve nutella yazdiğini dogrulayin
    // ilk ürünü tıklayin
    // daha sonra ürünün göründüğünü test edin
    // sepete gönderip sepette oldugunu test edin
    // sonra ilk sayfaya donus yapip anasayfaya tiklayin

    WebDriver driver;

    @Before
    public void setUp (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void teardown (){
        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {

        // https://www.trendyol.com adresine gidin
        driver.get("https://www.trendyol.com");

        String ilkSayfaWHD = driver.getWindowHandle();

        // cerezleri kabul et
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();

        // Nutella aratın ve nutella yazdiğini dogrulayin
        driver.findElement(By.xpath("//input[@data-testid='suggestion']"))
                .sendKeys("Nutella"+ Keys.ENTER);
        Thread.sleep(2000);

        // Nutella aratın ve nutella yazdiğini dogrulayin
        String exceptedKelime = "Nutella";
        String actualKelime = driver.findElement(By.tagName("h1")).getText();
        Thread.sleep(2000);

        Assert.assertEquals(exceptedKelime,actualKelime);

        // ilk ürünü tıklayin
        driver.findElement(By.xpath("//div[@data-id='38082609']")).click();
        Thread.sleep(2000);

        // daha sonra ürünün göründüğünü test edin
        Set<String> tumWHDegerleri = driver.getWindowHandles();

        String ikinciSayfaWHD ="";

        for (String eachWHD : tumWHDegerleri) {

            if (!eachWHD.equals(ilkSayfaWHD)){

                ikinciSayfaWHD=eachWHD;
            }
        }

        driver.switchTo().window(ikinciSayfaWHD);
        String exceptedYeniSayfaYazi = "Nutella";
        String actualYeniSayfaYazi = driver.findElement(By.xpath("//a[text()='Nutella']"))
                .getText();

        Assert.assertEquals(exceptedYeniSayfaYazi,actualYeniSayfaYazi);

        Thread.sleep(2000);

        // sepete gönderip sepette oldugunu test edin
        driver.findElement(By.xpath("//div[text()='Sepete Ekle']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//p[text()='Sepetim']")).click();
        Thread.sleep(2000);

        WebElement sepettekiUrun = driver.findElement(By.xpath("//div[@class='pb-basket-item']"));

        Assert.assertTrue(sepettekiUrun.isDisplayed());

        // sonra ilk sayfaya donus yapip anasayfaya tiklayin
        driver.switchTo().window(ilkSayfaWHD);
        driver.findElement(By.xpath("//a[@id='logo']")).click();

        Thread.sleep(2000);

    }
}


