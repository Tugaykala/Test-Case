package test_Package;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class No4_Test_SahibindenAssertion {

    // "https://www.sahibinden.com" Adresine gidin farkli test method'lari olsuturun
    //      -- Sayfa Url'nin => "https://www.sahibinden.com" a esit oldugunu test edin
    //      -- titleTest => sayfa basliginin "Otomobil" icermedigini test edin
    //      -- logoTest => Sahibinden.com logosunun görüntülendigini test edin
    //      -- MotosikletLinkTest => Motosiklet Linkinin görüntülendigini test edin

    static WebDriver driver;

    @BeforeClass
    public static void setUp (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.sahibinden.com");
    }
    @AfterClass
    public static void teardown (){
        driver.close();
    }

    @Test
    public void Urltest01 (){
        // -- Sayfa Url'nin => "https://www.sahibinden.com" a esit oldugunu test edin

        String expectedUrl = "https://www.sahibinden.com/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @Test
    public void TitleTest02 () {
        // -- titleTest => sayfa basliginin "Otomobil" icermedigini test edin

        String expectedtitle = "Araba";
        String actualTitle = driver.getTitle();

        Assert.assertFalse(actualTitle.contains(expectedtitle));

    }

    @Test
    public void LogoTest03 () {
        // -- logoTest => Sahibinden.com logosunun görüntülendigini test edin

        WebElement logo = driver.findElement(By.xpath("//a[@class='logo']"));

        Assert.assertTrue(logo.isDisplayed());

    }

    @Test
    public void MotosikletLink () {
        // -- MotosikletLinkTest => Motosiklet Linkinin görüntülendigini test edin

        WebElement link = driver.findElement(By.xpath("//a[@title='Motosiklet']"));

        Assert.assertTrue(link.isDisplayed());

    }

}
