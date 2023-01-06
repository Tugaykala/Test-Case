package testNG;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Arabam_comPage;
import utilities.Driver;
import utilities.ReusbleMethods;

public class Test01_ArabamCom {

    @Test
    public void test(){

        // https://www.arabam.com Adresine gidin
        Driver.getDriver().get("https://www.arabam.com");

        // giriş yap butonuna tıklayin
        Arabam_comPage arabam_comPage = new Arabam_comPage();
        arabam_comPage.girisButonu.click();

        // Email kutusuna email adresinizi yazin
        arabam_comPage.emailKutusu.sendKeys("kala_tugay@hotmail.com");

        // Password kutusuna password'ünüzü yazin
        arabam_comPage.passworsKutusu.sendKeys("Tk.1234567");

        // Giris Yap butonuna tiklayin
        arabam_comPage.girisYapButtonu.click();

        // Giris yaptiginizi test edin
        Assert.assertTrue(arabam_comPage.anasayfaKontrol.isDisplayed());

        // Otomobil kutucuğuna tiklayin
        arabam_comPage.otomobilKutusu.click();
        ReusbleMethods.bekle(2);

        // sol tarafdaki otomobillerden "Porsche" görünene kadar asağı in
        WebElement porscheKutusu = Driver.getDriver().findElement(By.xpath("//a[@href='otomobil/bmw']"));
        porscheKutusu.sendKeys(Keys.PAGE_DOWN);
        ReusbleMethods.bekle(1);
        porscheKutusu.sendKeys(Keys.PAGE_DOWN);
        ReusbleMethods.bekle(1);
        porscheKutusu.sendKeys(Keys.PAGE_DOWN);
        ReusbleMethods.bekle(1);
        porscheKutusu.sendKeys(Keys.PAGE_DOWN);
        ReusbleMethods.bekle(1);
        porscheKutusu.sendKeys(Keys.PAGE_DOWN);
        ReusbleMethods.bekle(1);
        porscheKutusu.sendKeys(Keys.PAGE_DOWN);
        ReusbleMethods.bekle(1);

        // Porsche Kutucuğunun göründüğünü test edip tıklayiniz
        Assert.assertTrue(arabam_comPage.porscheKutusu.isDisplayed());
        arabam_comPage.porscheKutusu.click();

        // 911 tıklayip ekran görüntüsü aliniz
        arabam_comPage.p911Kutusu.click();

        ReusbleMethods.sayfaScrenshotCek(Driver.getDriver());

        ReusbleMethods.bekle(2);

        Driver.closeDriver();

    }
}
