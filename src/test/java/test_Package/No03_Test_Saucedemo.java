package test_Package;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class No03_Test_Saucedemo {

        public static void main(String[] args) throws InterruptedException {

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            // 1- "https://www.saucedemo.com" Adresine gidin
            driver.get("https://www.saucedemo.com");

            // 2- Username kutusuna "standard_user" yazdirin
            driver.findElement(By.id("user-name")).sendKeys("standard_user");

            // 3- Password kutusuna "secret_sauce" yazdirin
            driver.findElement(By.id("password")).sendKeys("secret_sauce");

            // 4- Login tusuna basin
            driver.findElement(By.id("login-button")).click();

            // 5- ilk urunu kaydedin ve bu urunu sayfasina gidin
            driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();

            // 6- Add to Cart butonuna basin
            driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

            // 7- Alisveris sepetine tiklayin
            driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

            // 8- Sectiginiz urunu basarili olarak sepete eklendigini control edin
            WebElement SepettekiUrun = driver.findElement(By.id("item_4_title_link"));

            if (SepettekiUrun.isDisplayed()){
                System.out.println("Test PASSED");
            }else {
                System.out.println("Test FAILED");
            }

            // 9- Sayfayi kapatin
            Thread.sleep(2000);
            driver.close();
        }
}
