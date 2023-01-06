package test_Package;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReusbleMethods;
import utilities.TestBase;

public class No08_Test_TeslaScreenshot extends TestBase {


    @Test
    public void test01 (){

        // 1- https://www.tesla.com adresine gidin
        driver.get("https://www.tesla.com");
        ReusbleMethods.bekle(4);

        // 2- Model S kutucuguna tiklayin
        WebElement modelS = driver.findElement(By.xpath("//a[@title='Model S']"));
        modelS.click();

        // 3- Model S sayfasinda gittiğinizi test edin
        String exceptedUrl = "tesla";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(exceptedUrl));

        // 4- Tikladiginiz sayfanin ekran görüntüsünü alin

        ReusbleMethods.sayfaScrenshotCek(driver);

        ReusbleMethods.bekle(3);















    }
}
