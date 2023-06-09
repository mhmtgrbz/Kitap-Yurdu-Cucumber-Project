package techproed.stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import techproed.pages.LocatesMali_yeniCikanKitaplar;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.util.List;

public class StepsYeniCikanKitaplar_Mali {
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
            ReusableMethods.bekle(1);


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
            ReusableMethods.bekle(1);
        }
    }


    @And("goruntulenen tum kitaplarin fiyatinin {int} ile {int}  TL araliginda oldugu test edilir")
    public void goruntulenenTumKitaplarinFiyatininIleTLAraligindaOlduguTestEdilir(double min, double max) {

        //bütün ürünler için
        List<WebElement> prices=Driver.getDriver().findElements(By.xpath("//span[@class='value']"));
        System.out.println("ürün sayisi : "+prices.size());
        for (int i = 0; i < prices.size(); i++) {
            if(prices.get(i).getText().isEmpty()){continue;}
            Double priceS=Double.valueOf(prices.get(i).getText().replace(",","."));
            System.out.println("urunler :"+priceS);
            Assert.assertTrue(min <= priceS && max >= priceS);
        }
    }

    @Given("Kullanici sayfa sonuna kaydirma butonuna tiklar")
    public void kullaniciSayfaSonunaKaydirmaButonunaTiklar() {
        locate.goPageDownButton.click();
    }

    @And("sayfa resmini alir")
    public void sayfaResminiAlir() {
        ReusableMethods.tumSayfaResmi();
    }

    @Given("Kullanici oneri form ikonunu tiklar")
    public void kullaniciOneriFormIkonunuTiklar() {
        ReusableMethods.bekle(1);
        locate.suggestButton.click();
    }

    @And("Acilan pencerede isim alanını doldurur")
    public void acilanPenceredeIsimAlanınıDoldurur() {
        locate.suggestFormName.sendKeys(Faker.instance().name().fullName());
        ReusableMethods.bekle(1);

    }

    @And("e posta alanını doldurur")
    public void ePostaAlanınıDoldurur() {
        locate.suggestFormEmail.sendKeys(Faker.instance().internet().emailAddress());
        ReusableMethods.bekle(1);
    }

    @And("Konu alanına Oneri seklinde giris yapar")
    public void konuAlanınaOneriSeklindeGirisYapar() {
        select=new Select(locate.subjectDDM);
        select.selectByValue("1");

        ReusableMethods.bekle(1);
    }


    @And("Gorus alanina dokuzchar gorusunu yazar")
    public void gorusAlaninaDokuzcharGorusunuYazar() {
        locate.gorus.sendKeys("Abcdefgh9");
        ReusableMethods.bekle(1);

    }

    @And("Kabul edilmeyen karakter sayisi uyarisini goruntuler")
    public void kabulEdilmeyenKarakterSayisiUyarisiniGoruntuler() {

        Assert.assertTrue(locate.errorMessageCommend.isDisplayed());
        ReusableMethods.bekle(1);
    }

    @And("Gorus alanına ONchar gorusunu yazar")
    public void gorusAlanınaONcharGorusunuYazar() {
        locate.gorus.sendKeys(Faker.instance().letterify("Abcdefgh10"));
    }

    @Given("Kullanici dogrulama alanına yanlıs bir deger girer")
    public void kullaniciDogrulamaAlanınaYanlısBirDegerGirer() {
        ReusableMethods.bekle(1);
        locate.feedbackCaptcha.sendKeys(Faker.instance().code().ean8());

    }

    @And("dogrulama kodu hatalidir mesajini goruntuler")
    public void dogrulamaKoduHatalidirMesajiniGoruntuler() {
        Assert.assertTrue(locate.errorMessageCode.isDisplayed());
    }

    @Then("Kullanici gonder butonunu tiklar")
    public void kullaniciGonderButonunuTiklar() {
        locate.submitForm.click();
    }
}





