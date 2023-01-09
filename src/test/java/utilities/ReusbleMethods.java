package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReusbleMethods {

    public static void bekle (int saniye){

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {

        }

    }
    public static void sayfaScrenshotCek (WebDriver driver){

        TakesScreenshot tss = (TakesScreenshot) driver;

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        String tarih = ldt.format(dtf);
        String dosyaYolu = "target/EkranResimleri/EkranSS"+tarih+".jpeg";

        File sayfaScreenshot = new File(dosyaYolu);
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciDosya,sayfaScreenshot);
        } catch (IOException e) {

        }

    }
}
