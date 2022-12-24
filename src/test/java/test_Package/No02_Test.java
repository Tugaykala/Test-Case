package test_Package;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class No02_Test {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1- https://youtube.com sayfasina git
        driver.get("https://www.youtube.com");

        // 2- başlıklardan "Futbol" a tiklayalim
        driver.findElement(By.xpath("//yt-formatted-string[text()='Futbol']")).click();
        Thread.sleep(1500);

        // 3- "Trend" kutucuguna tiklayalim
        driver.findElement(By.xpath("//a[@title='Trendler']")).click();

        // 4- Ana sayfaya gelelim
        driver.findElement(By.xpath("(//div[@class='style-scope ytd-topbar-logo-renderer'])[1]")).click();
        Thread.sleep(1500);

        // 5- Sayfayi yenileyelim
        driver.navigate().refresh();

        // 6- sayfadan çıkalım
        Thread.sleep(2000);
        driver.close();






    }
}


