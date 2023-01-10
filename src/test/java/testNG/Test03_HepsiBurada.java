package testNG;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HepsiBuradaPage;
import utilities.ConfingReader;
import utilities.Driver;


public class Test03_HepsiBurada {

    @DataProvider
    public static Object[][] HepsiBuradaAranacakKelimeler() {

        Object[][] aranacakKelimelerArr =
                {{"Porsche 911"},{"Bmw"},{"Noluya Ya"},{"Türk Kahvesi"},{"Apple"},{"Samsung"},{"Koltuk L"}};

        return aranacakKelimelerArr;
    }

    @Test (dataProvider = "HepsiBuradaAranacakKelimeler")
    public void test01(String aranacakKelime){

        Driver.getDriver().get(ConfingReader.getProperty("HepsiBuradaUrl"));

        HepsiBuradaPage hepsiBuradaPage = new HepsiBuradaPage();

        hepsiBuradaPage.cookies.click();

        hepsiBuradaPage.aramaKutusu.sendKeys(aranacakKelime + Keys.ENTER);

        String actualKelime = hepsiBuradaPage.aramaSonucElementi.getText();

        Assert.assertTrue(actualKelime.contains(aranacakKelime));

        Driver.closeDriver();


    }
}
