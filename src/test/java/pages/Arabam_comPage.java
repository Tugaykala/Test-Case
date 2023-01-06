package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Arabam_comPage {

    public  Arabam_comPage(){
        PageFactory.initElements(Driver.getDriver(),this);


    }

    @FindBy (xpath = "//a[@aria-label='Giriş Yap']")
    public WebElement girisButonu;

    @FindBy (id = "emailOrPhone")
    public WebElement emailKutusu;

    @FindBy (id = "password")
    public WebElement passworsKutusu;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement girisYapButtonu;

    @FindBy (xpath = "//span[@class='user-name-text']")
    public WebElement anasayfaKontrol;

    @FindBy (xpath = "//span[text()='Otomobil']")
    public WebElement otomobilKutusu;

    @FindBy (xpath = "//a[@href='otomobil/porsche']")
    public WebElement porscheKutusu;

    @FindBy (xpath = "//a[@href='otomobil/porsche-911']")
    public WebElement p911Kutusu;



}
