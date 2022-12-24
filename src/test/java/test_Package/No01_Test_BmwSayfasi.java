package test_Package;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class No01_Test_BmwSayfasi {

        public static void main(String[] args) throws InterruptedException {

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.manage().window().maximize();
            // 1- https://www.bmw.com.tr sayfasına git
            driver.get("https://www.bmw.com.tr");
            Thread.sleep(2000);

            // 2- Sayfada Modeller kutucuguna tiklayin
            driver.findElement(By.xpath("(//span[text()='Modeller'])[1]")).click();
            Thread.sleep(2000);

            // 3- Modeller de 4 serisine tiklayin
            driver.findElement(By.xpath("(//button[text()='4'])[1]")).click();

            // 4- Başligin "BMW Türkiye" oldugunu test edin

            String expectedBaslik = "BMW Türkiye";
            String actualTitle = driver.getTitle();

            if (actualTitle.contains(expectedBaslik)){
                System.out.println("test sonucu PASSED");
            }else {
                System.out.println("test sonucu FAILED");
            }

            // 5- M4 olana tıklayin
            driver.findElement(By.xpath("(//img[@alt='Yeni BMW 4 Serisi Coupé M Modelleri'])[2]"));
            Thread.sleep(2000);

            // 6- THE M4 yazisina tiklayip gorunurlugunu test edin
            driver.findElement(By.xpath("(//a[@aria-label='Yeni BMW 4 Serisi Coupé M Modelleri'])[2]")).click();
            Thread.sleep(2000);

            // 7- sayfanin gorunurlugunu test edin
            WebElement m4 = driver.findElement(By.xpath("//img[@title='BMW M4 three-quarter front view in motion']"));
            if (m4.isDisplayed()){
                System.out.println("M4 test Gorunurlugu PASSED");
            }else {
                System.out.println("M4 test Gorunurlugu FAILED");
            }

            Thread.sleep(3000);
            driver.close();



        }
}

