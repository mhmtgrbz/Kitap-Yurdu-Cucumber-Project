package techproed.stepdefinitions;

import com.sun.source.tree.AssertTree;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.sl.In;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import techproed.pages.LocatesMali_yeniCikanKitaplar;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class StepsYeniCikanKitaplar {
    LocatesMali_yeniCikanKitaplar locate = new LocatesMali_yeniCikanKitaplar();
    Select select;

    @Given("Kullanici {string} e gider")
    public void kullaniciEGider(String url) {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.bekle(2);
    }

    @Then("yeni cikan kitaplar linkini tiklar")
    public void yeniCikanKitaplarLinkiniTiklar() {
        locate.yeniCikanKitaplarLink.click();
        ReusableMethods.bekle(1);
    }

    @Then("haftalik yeni cikan kitaplar linkini tiklar")
    public void haftalikYeniCikanKitaplarLinkiniTiklar() {
        locate.haftalikYeniKitaplar.click();
        ReusableMethods.bekle(1);
    }

    @Given("Kullanici zaman olarak sonikiay secer")
    public void kullanici_zaman_olarak_sonikiay_secer() {
        select = new Select(locate.haftalikDDM);
        select.selectByIndex(1);
        ReusableMethods.bekle(1);


    }

    @Given("Kullanici varsayilan olarak pahalidanucuza secer")
    public void kullanici_varsayilan_olarak_pahalidanucuza_secer() {
        select = new Select(locate.varsayilanDDM);
        select.selectByVisibleText("Pahalıdan > Ucuza");
        ReusableMethods.bekle(1);
    }

    @Given("Kullanici satistaolanlar alanini isaretler")
    public void kullanici_satistaolanlar_alanini_isaretler() {
        locate.satistaOlanCheckBox.click();
        ReusableMethods.bekle(1);

    }

    @Given("Kullanici stoktaolanlar alanini isaretler")
    public void kullanici_stoktaolanlar_alanini_isaretler() {
        locate.stoktaOlanCheckBox.click();
        ReusableMethods.bekle(1);
    }

    @Given("Kullanici urun sayfa gorunumunu elli olarak isaretler")
    public void kullanici_urun_sayfa_gorunumunu_elli_olarak_isaretler() {
        select = new Select(locate.sayfadaelliDDM);
        select.selectByVisibleText("50 Ürün");
        ReusableMethods.bekle(1);
    }

    @Then("kullanici varsayilan olarak {string} aratir")
    public void kullaniciVarsayilanOlarakAratir(String arg0) {
        select = new Select(locate.varsayilanDDM);
        select.selectByVisibleText(arg0);

    }

    @And("{int} saniye bekler")
    public void saniyeBekler(int saniye) throws InterruptedException {
        Thread.sleep(saniye * 1000);

    }

    @Then("basligin {string} icerdigini dogrular")
    public void basliginIcerdiginiDogrular(String arg0) {
        Assert.assertTrue(locate.varsayilanDDM.getText().contains(arg0));
        ReusableMethods.bekle(3);
    }

    @And("sayfada elli adet urun oldugunu dogrular")
    public void sayfadaElliAdetUrunOldugunuDogrular() {
        Assert.assertEquals(Driver.getDriver().
                findElements(By.xpath("//div[@class='product-cr']")).size(), 50);
        System.out.println("size :" + Driver.getDriver().
                findElements(By.xpath("//div[@class='product-cr']")).size());
    }

    @Given("kullanici ingilizce kitaplar secenegini isaretler")
    public void kullaniciIngilizceKitaplarSeceneginiIsaretler() {
        ReusableMethods.scroll(locate.oylama);
        locate.ingCheckbox.click();
        ReusableMethods.bekle(2);

    }

    @And("kulanici turkce kitaplar secenegini isaretler")
    public void kulaniciTurkceKitaplarSeceneginiIsaretler() {
        locate.turkceCheckbox.click();
        ReusableMethods.bekle(1);

    }


    @And("isaretlemelerin goruldugu test edilir")
    public void isaretlemelerinGorulduguTestEdilir() {
        Assert.assertTrue(locate.turkceCheckbox.isSelected());
        Assert.assertTrue(locate.ingCheckbox.isSelected());
    }

    @Given("Kullanici urun fiyat aralıgını dusuk {int} yuksek {int} TL olarak secer")
    public void kullaniciUrunFiyatAralıgınıDusukYuksekTLOlarakSecer(int min, int max) {
        locate.minprice.sendKeys(String.valueOf(min));
        ReusableMethods.bekle(1);
        locate.maxprice.sendKeys(String.valueOf(max));
        ReusableMethods.bekle(1);

    }

    @And("goruntulenen ilk kitabın fiyatının {int} ile {int}  TL aralıgında oldugu test edilir")
    public void goruntulenenIlkKitabınFiyatınınIleTLAralıgındaOlduguTestEdilir(double min, double max) {
        String[] priceS = locate.price.getText().split(",");
        //java double ı . ile ayırıyor, site ise , ile ayırmış .Bu yüzden küsürlü kısım ignore edildi
        int price = Integer.parseInt(priceS[0]);
        System.out.println("price = " + price);
        Assert.assertTrue(min <= price && max >= price);

    }

    @And("guncelle butonunu tiklar")
    public void guncelleButonunuTiklar() {
        locate.guncelleButton.click();
    }

    @Given("Kullanici searchbox alanında exceldeki kitapları arar")
    public void kullaniciSearchboxAlanındaExceldekiKitaplarıArar() {

        ExcelUtils excelUtils = new ExcelUtils("src/test/resources/kitapyurdu.xlsx", "sayfa1");//excel sayfa yolu ve işlem yapılacak sayfa ismi
        for (int i = 1; i <= excelUtils.rowCount(); i++) {
            String kitapadi = excelUtils.getCellData(i, 0);
            locate.searchBox.sendKeys(kitapadi, Keys.ENTER);
            ReusableMethods.bekle(1);
            locate.searchBox.clear();
            ReusableMethods.bekle(2);

        }
    }

    @And("kullanici searchbox alaninda exceldeki yayinevlerini arar")
    public void kullaniciSearchboxAlanindaExceldekiYayinevleriniArar() {
        ExcelUtils excelUtils = new ExcelUtils("src/test/resources/kitapyurdu.xlsx", "sayfa1");//excel sayfa yolu ve işlem yapılacak sayfa ismi
        for (int i = 1; i <= excelUtils.rowCount(); i++) {

            String yayinevi = excelUtils.getCellData(i, 2);

            locate.searchBox.sendKeys(yayinevi, Keys.ENTER);
            ReusableMethods.bekle(1);
            locate.searchBox.clear();
            ReusableMethods.bekle(2);


        }

    }

    @And("kullanici searchbox alaninda exceldeki yazarlari arar")
    public void kullaniciSearchboxAlanindaExceldekiYazarlariArar() {
        ExcelUtils excelUtils = new ExcelUtils("src/test/resources/kitapyurdu.xlsx", "sayfa1");//excel sayfa yolu ve işlem yapılacak sayfa ismi
        for (int i = 1; i <= excelUtils.rowCount(); i++) {
            String yazaradi = excelUtils.getCellData(i, 1);
            locate.searchBox.sendKeys(yazaradi, Keys.ENTER);
            ReusableMethods.bekle(1);
            locate.searchBox.clear();
            ReusableMethods.bekle(2);
        }
    }


}