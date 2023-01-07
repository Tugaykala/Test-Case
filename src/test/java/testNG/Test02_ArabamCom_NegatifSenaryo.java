package testNG;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Arabam_comPage;
import utilities.ConfingReader;
import utilities.Driver;
import utilities.ReusbleMethods;

public class Test02_ArabamCom_NegatifSenaryo {

    // 3  Adet test metodu olusturun.
    // 1. de yanlis e mail dogru sifre
    // 2. de dogru email yanlis sifre
    // 3. yanlis email yanlis sifre ile giris yapmayi deneyin.
    //    giris yapilamadigini test edin

    Arabam_comPage arabam_comPage = new Arabam_comPage();

    @Test (priority = 5)
    public void yanlisEmail (){

        Driver.getDriver().get(ConfingReader.getProperty("ArabamComUrl"));
        arabam_comPage.girisButonu.click();
        arabam_comPage.emailKutusu.sendKeys(ConfingReader.getProperty("ArabamGecersizEmail"));
        arabam_comPage.passworsKutusu.sendKeys(ConfingReader.getProperty("ArabamGecerliPassword"));
        arabam_comPage.girisYapButtonu.click();

        Assert.assertTrue(arabam_comPage.emailKutusu.isDisplayed(),"giris yapilmadi");

        ReusbleMethods.bekle(2);
        Driver.closeDriver();
    }

    @Test (priority = 7)
    public void yanlisPassword (){

        Driver.getDriver().get(ConfingReader.getProperty("ArabamComUrl"));
        arabam_comPage = new Arabam_comPage();
        arabam_comPage.girisButonu.click();
        arabam_comPage.emailKutusu.sendKeys(ConfingReader.getProperty("ArabamGecerliEmail"));
        arabam_comPage.passworsKutusu.sendKeys(ConfingReader.getProperty("ArabamGecersizPassword"));
        arabam_comPage.girisYapButtonu.click();

        Assert.assertTrue(arabam_comPage.emailKutusu.isDisplayed(),"giris yapilmadi");

        ReusbleMethods.bekle(2);
        Driver.closeDriver();
    }

    @Test (priority = 8)
    public void yanlisEmailYanlisPassword (){

        Driver.getDriver().get(ConfingReader.getProperty("ArabamComUrl"));
        arabam_comPage = new Arabam_comPage();
        arabam_comPage.girisButonu.click();
        arabam_comPage.emailKutusu.sendKeys(ConfingReader.getProperty("ArabamGecersizEmail"));
        arabam_comPage.passworsKutusu.sendKeys(ConfingReader.getProperty("ArabamGecersizPassword"));
        arabam_comPage.girisYapButtonu.click();

        Assert.assertTrue(arabam_comPage.emailKutusu.isDisplayed(),"giris yapilmadi");

        ReusbleMethods.bekle(2);
        Driver.closeDriver();
    }
}
