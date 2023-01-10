package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HepsiBuradaPage {

    public HepsiBuradaPage (){

        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy (xpath = "//input[@placeholder='Ürün, kategori veya marka ara']")
    public WebElement aramaKutusu;

    @FindBy (xpath = "//div[@class='searchResultSummaryBar-CbyZhv5896ASVcYBLKmx']")
    public WebElement aramaSonucElementi;

    @FindBy (id = "onetrust-accept-btn-handler")
    public WebElement cookies;
}
