package test_Package;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReusbleMethods;
import utilities.TestBase;

import java.util.Set;

public class No07_Test_Trendyol extends TestBase {


    // https://www.trendyol.com adresine gidin
    // cerezleri kabul et
    // Nutella aratın ve nutella yazdiğini dogrulayin
    // ilk ürünü tıklayin
    // daha sonra ürünün göründüğünü test edin
    // sepete gönderip sepette oldugunu test edin
    // sonra ilk sayfaya donus yapip anasayfaya tiklayin

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
        ReusbleMethods.bekle(2);

        // Nutella aratın ve nutella yazdiğini dogrulayin
        String exceptedKelime = "Nutella";
        String actualKelime = driver.findElement(By.tagName("h1")).getText();
        ReusbleMethods.bekle(2);

        Assert.assertEquals(exceptedKelime,actualKelime);

        // ilk ürünü tıklayin
        driver.findElement(By.xpath("//div[@data-id='38082609']")).click();
        ReusbleMethods.bekle(2);

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

        ReusbleMethods.bekle(2);

        // sepete gönderip sepette oldugunu test edin
        driver.findElement(By.xpath("//div[text()='Sepete Ekle']")).click();
        ReusbleMethods.bekle(1);

        driver.findElement(By.xpath("//p[text()='Sepetim']")).click();
        ReusbleMethods.bekle(2);

        WebElement sepettekiUrun = driver.findElement(By.xpath("//div[@class='pb-basket-item']"));

        Assert.assertTrue(sepettekiUrun.isDisplayed());

        // sonra ilk sayfaya donus yapip anasayfaya tiklayin
        driver.switchTo().window(ilkSayfaWHD);
        driver.findElement(By.xpath("//a[@id='logo']")).click();

        ReusbleMethods.bekle(2);

    }
}


