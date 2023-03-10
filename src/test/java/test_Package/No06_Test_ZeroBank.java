package test_Package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReusbleMethods;
import utilities.TestBase;

public class No06_Test_ZeroBank extends TestBase {

    // 1- "https://www.http://zero.webappsecurity.com" Adresine gidin
    // 2- Sign in butonuna basin
    // 3- Login kutusuna "username" yazin
    // 4- Password kutusuna "password" yazin.
    // 5- Sign in tusuna basin
    // 6- Onlıne Banking den tiklayip PayBills sayfasina gidin
    // 7- "Purchase Foreign Currency" tusuna basin
    // 8- "Currency drop down menusunden Eurozone'u secin
    // 9- "amaount" kutusuna bir sayi girin
    // 10- "US Dolars" in secilmedigini test edin
    // 11- "Selected currency" butonunu secin
    // 12- "Calculate Costs" butonuna basin sonra "purchase" butonuna basin
    // 13- "Foreign currency cash was successfully purshased" yazisinin ciktigini kontrol edin


    @Test
    public void test01 () throws InterruptedException {
        // 1- "https://www.zero.webappsecurity.com" Adresine gidin
        driver.get("http://zero.webappsecurity.com");

        // 2- Sign in butonuna basin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        // 3- Login kutusuna "username" yazin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");

        // 4- Password kutusuna "password" yazin.
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");

        // 5- Sign in tusuna basin
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();
        driver.navigate().back();

        // 6- Onlıne Banking den tiklayip PayBills sayfasina gidin
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();

        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();

        // 7- "Purchase Foreign Currency" tusuna basin
        driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();

        // 8- "Currency drop down menusunden Eurozone'u secin
        WebElement currency = driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select = new Select(currency);
        select.selectByVisibleText("Eurozone (euro)");
        ReusbleMethods.bekle(2);

        // 9- "amaount" kutusuna bir sayi girin
        driver.findElement(By.xpath("//input[@id='pc_amount']")).sendKeys("100");
        ReusbleMethods.bekle(2);

        // 10- "US Dolars" in secilmedigini test edin
        WebElement dolarsKontrol = driver.findElement(By.id("pc_inDollars_true"));
        if (dolarsKontrol.isDisplayed());
        ReusbleMethods.bekle(2);

        // 11- "Selected currency" butonunu secin
        WebElement selectButon = driver.findElement(By.id("pc_inDollars_false"));
        if (!selectButon.isSelected()){
            selectButon.click();
        }
        ReusbleMethods.bekle(2);

        Assert.assertTrue(selectButon.isSelected());

        // 12- "Calculate Costs" butonuna basin sonra "purchase" butonuna basin
        driver.findElement(By.id("purchase_cash")).click();

        // 13- "Foreign currency cash was successfully purshased" yazisinin ciktigini kontrol edin
        WebElement gorunurTest = driver.findElement(By.id("alert_content"));

        Assert.assertTrue(gorunurTest.isDisplayed());

        ReusbleMethods.bekle(2);

    }
}

