package test_Package;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;


import java.time.Duration;

public class No05_Test_Arabam extends TestBase {

    WebDriver driver;


    @Test
    public void test ()  {

        // "https://www.arabam.com" Adresine gidip giris tusuna basin ve
        // Giriş Butonuna basip bilgileri doldurun
        // mail adresi "kala_tugay@hotmail.com" yazin
        // sifreye "Tk.1234567" bunu yazip enter tuşuna basin
        // bilgileri yazdıktan sonra giriş yap tuşuna basin
        // giriş yaptıktan sonra sayfayi yenileyip
        // arama bölümünden "Ferrari" aratın
        // arattıktan sonra Ferrari başlığı görünüyor mu onu test edin
        // testi kapatin


        // "https://www.arabam.com" Adresine gidip giris tusuna basin
        driver.get("https://www.arabam.com");

        // Giriş Butonuna basin
        driver.findElement(By.xpath("//a[@aria-label='Giriş Yap']")).click();

        // mail adresi "kala_tugay@hotmail.com" yazin
        driver.findElement(By.xpath("//input[@id='emailOrPhone']")).sendKeys("kala_tugay@hotmail.com");

        // sifreye "Tk.1234567" bunu yazip enter tuşuna basin
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Tk.1234567");

        // bilgileri yazdıktan sonra giriş yap tuşuna basin
        driver.findElement(By.xpath("//button[text()='Giriş Yap']")).click();

        // arama bölümünden "Ferrari" aratın
        driver.findElement(By.xpath("//input[@class='input']")).sendKeys("Ferrari"+Keys.ENTER);

        // giriş yaptıktan sonra sayfayi yenileyip
        driver.navigate().refresh();

        // arattıktan sonra Ferrari başlığı görünüyor mu onu test edin
        WebElement gorunme = driver.findElement(By.xpath("//span[@class='filter-value']"));

        Assert.assertTrue(gorunme.isDisplayed());

        // testi kapatin


    }

}
