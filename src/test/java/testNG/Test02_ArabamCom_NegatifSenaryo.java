package testNG;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Arabam_comPage;
import utilities.Driver;
import utilities.ReusbleMethods;

public class Test02_ArabamCom_NegatifSenaryo {

    // 3  Adet test metodu olusturun.
    // 1. de yanlis e mail dogru sifre
    // 2. de dogru email yanlis sifre
    // 3. yanlis email yanlis sifre ile giris yapmayi deneyin.
    //    giris yapilamadigini test edin

    Arabam_comPage arabam_comPage = new Arabam_comPage();

    @Test
    public void yanlisEmail (){

        Driver.getDriver().get("https://www.arabam.com");
        arabam_comPage.girisButonu.click();
        arabam_comPage.emailKutusu.sendKeys("tugay@gmail.com");
        arabam_comPage.passworsKutusu.sendKeys("Tk.1234567");
        arabam_comPage.girisYapButtonu.click();

        Assert.assertTrue(arabam_comPage.emailKutusu.isDisplayed(),"giris yapilmadi");

        ReusbleMethods.bekle(2);
        Driver.closeDriver();
    }

    @Test
    public void yanlisPassword (){

        Driver.getDriver().get("https://www.arabam.com");
        arabam_comPage.girisButonu.click();
        arabam_comPage.emailKutusu.sendKeys("kala_tugay@hotmail.com");
        arabam_comPage.passworsKutusu.sendKeys("Tk.1234000");
        arabam_comPage.girisYapButtonu.click();

        Assert.assertTrue(arabam_comPage.emailKutusu.isDisplayed(),"giris yapilmadi");

        ReusbleMethods.bekle(2);
        Driver.closeDriver();
    }

    @Test
    public void yanlisEmailYanlisPassword (){

        Driver.getDriver().get("https://www.arabam.com");
        arabam_comPage.girisButonu.click();
        arabam_comPage.emailKutusu.sendKeys("tugay@gmail.com");
        arabam_comPage.passworsKutusu.sendKeys("Tk.1234000");
        arabam_comPage.girisYapButtonu.click();

        Assert.assertTrue(arabam_comPage.emailKutusu.isDisplayed(),"giris yapilmadi");

        ReusbleMethods.bekle(2);
        Driver.closeDriver();
    }
}
