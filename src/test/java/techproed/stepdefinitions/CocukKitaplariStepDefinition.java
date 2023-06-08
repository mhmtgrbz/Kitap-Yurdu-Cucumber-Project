package techproed.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import techproed.pages.CocukKitaplari_Ayse;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import static org.junit.Assert.*;
import static techproed.utilities.ReusableMethods.*;


public class CocukKitaplariStepDefinition {
    CocukKitaplari_Ayse page = new CocukKitaplari_Ayse();


    @Then("Uye ola tiklar")
    public void uyeOlaTiklar() {
        page.uyeOl.click();
    }


    @And("Cookiesi kabul eder")
    public void cookiesiKabulEder() {
        page.cookies.click();
    }

    @Then("uye olmak icin sahte hesaptan mail alir bu yuzden fakemail adresine gider")
    public void uyeOlmakIcinSahteHesaptanMailAlirBuYuzdenFakemailAdresineGider() {
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get(ConfigReader.getProperty("fake"));
        String mail = page.fakeCopyAlma.getText();
        switchToWindow(0);
        sendKeysJS(page.adTextBox, ConfigReader.getProperty("adAyse"));
        bekle(1);
        sendKeysJS(page.soyadTextBox, ConfigReader.getProperty("soyadAyse"));
        bekle(1);
        sendKeysJS(page.emailTextBox, mail);
        bekle(1);
        sendKeysJS(page.sifre1TextBox, ConfigReader.getProperty("sifreAyse"));
        bekle(1);
        sendKeysJS(page.sifre2TextBox, ConfigReader.getProperty("sifreAyse"));
        bekle(1);
    }

//    @And("Hesap olusturmak icin adini ve bilgileri girer")
//    public void hesapOlusturmakIcinAdiniVeBilgileriGirer() {
//        sendKeysJS(page.adTextBox, ConfigReader.getProperty("adAyse"));
//        sendKeysJS(page.soyadTextBox, ConfigReader.getProperty("soyadAyse"));
//        sendKeysJS(page.emailTextBox, mail);
//        sendKeysJS(page.sifre1TextBox, ConfigReader.getProperty("sifreAyse"));
//        sendKeysJS(page.sifre2TextBox, ConfigReader.getProperty("sifreAyse"));

    @And("Kisisel verilerin korunmasi checkboxini tiklar")
    public void kisiselVerilerinKorunmasiCheckboxiniTiklar() {
        page.kisiselVerilenKorunmasiCheckbox.click();
    }

    @Then("sayfada oldugunu dogrular")
    public void sayfadaOldugunuDogrular() {
        assertTrue(page.kitapyurduLogosu.isDisplayed());
        bekle(3);
    }

    @Then("Uye olma buttonuna basar")
    public void uyeOlmaButtonunaBasar() {
        page.uyeOlButton.click();

    }


    @Then("cok satan {string} linkine tiklar")
    public void cokSatanLinkineTiklar(String cocukKitaplari) {
        click(page.cokSatanCocukKitaplarilinki);
    }

    @And("uyari mesajni gorur")
    public void uyariMesajniGorur() {
        assertTrue(page.warning.isDisplayed());
    }

    @Then("Gelen maili onaylamak icin eski pencereye gider")
    public void gelenMailiOnaylamakIcinEskiPencereyeGider() {
        window(1);

        bekle(30);
    }

    @And("gelen maili onaylar")
    public void gelenMailiOnaylar() {
        bekle(3);
        Driver.getDriver().navigate().refresh();
        click(page.clickMail);
        Driver.getDriver().switchTo().frame(1);
        click(page.adresiDogrula);
    }

    @And("yeni pencereye gecer")
    public void yeniPencereyeGecer() {
        window(2);
    }

    @Then("yeni pencerede oldugunu dogrular")
    public void yeniPenceredeOldugunuDogrular() {
        assertTrue(page.dogrulamaMesaji.isDisplayed());

    }

    @And("Anasayfaya gider")
    public void anasayfayaGider() {
        click(page.anasayfayaGit);
    }

    @Then("Hesap olusturuldu yazisini gorur")
    public void hesapOlusturulduYazisiniGorur() {
        assertTrue(page.hesabinizOlusturuldu.isDisplayed());
        bekle(2);
    }

    @Then("Anasayfada oldugunu dogrular")
    public void anasayfadaOldugunuDogrular() {
        assertTrue(Driver.getDriver().getCurrentUrl().contains("home"));
    }

    @Then("Cocuk kitaplari yazisini gorur")
    public void cocukKitaplariYazisiniGorur() {
        assertTrue(page.cocukKitaplari.isDisplayed());
    }

    @And("Devam kuttonuna basar")
    public void devamKuttonunaBasar() {
        page.devam.click();
    }

    @And("Kullanici merhaba kitap kurdu yazisini gorur")
    public void kullaniciMerhabaKitapKurduYazisiniGorur() {
        assertTrue(page.merhaba.isDisplayed());
    }

    @Then("Kullanici sayfayi kapatir")
    public void kullaniciSayfayiKapatir() {
        Driver.closeDriver();
    }


    @And("{string} eposta kutusuna mailini girer")
    public void epostaKutusunaMailiniGirer(String arg0) {
        // sendKeysJS( page.eposta,ConfigReader.getProperty("aMail"))
        page.eposta.sendKeys(ConfigReader.getProperty("aMail"));
    }

    @And("{string} sifre kutusuna sifresini girer")
    public void sifreKutusunaSifresiniGirer(String arg0) {
        page.password.sendKeys(ConfigReader.getProperty("sifreAyse"), Keys.ENTER);
    }

    @And("Stokta olanlari secer")
    public void stoktaOlanlariSecer() {
        page.stoktaOlanlar.click();
        bekle(3);
    }


    @Then("Stockta kac kitap oldugunu yazdirir")
    public void stocktaKacKitapOldugunuYazdirir() {
        String kitap = page.kacKitap.getText();
        String[] kitapTexti = kitap.split("");
        String kitapSayisi = kitapTexti[6];
        System.out.println(kitapSayisi + "adet kitap vardir");
    }


    @And("Genel kutusuna tiklar")
    public void genelKutusunaTiklar() {
        page.genel.click();
    }


    @And("{int} . kitaba tiklar")
    public void kitabaTiklar(int sayi) {
        Driver.getDriver().findElement(By.xpath("(//div[@class='product-cr'])[" + sayi + "]")).click();
    }

    @When("Kitabin adini yazdirir")
    public void kitabinAdiniYazdirir() {
        String kitapAdi = page.kitap1.getText();
        System.out.println("Kitabin adi: " + kitapAdi);
    }

    @And("Kitabi sepete ekler")
    public void kitabiSepeteEkler() {
        click(page.sepet);
    }

    @Then("Onay yazisini gorur")
    public void onayYazisiniGorur() {
        bekle(1);
        assertTrue(page.onay.isDisplayed());
    }

    @Then("Bir sayfa geri gider")
    public void bir_sayfa_geri_gider() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("{int} temel eser linkine tiklar")
    public void temel_eser_linkine_tiklar(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Ziya Gokalp yazarini secer")
    public void ziya_gokalp_yazarini_secer() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Nar Cocuk yayinlarini secer")
    public void nar_cocuk_yayinlarini_secer() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Yazarin adini kontrol eder")
    public void yazarin_adini_kontrol_eder() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Sepete ekler")
    public void sepete_ekler() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("{int} sayfa geri gider")
    public void sayfa_geri_gider(Integer sayi) {
        int counter = 0;
        while (counter <= sayi) {
            Driver.getDriver().navigate().back();
            counter++;
        }
    }

    @When("ingilizce dilini secer")
    public void ingilizce_dilini_secer() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("Mark Twain i secer")
    public void mark_twain_i_secer() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("Mark Twainin {int}. kitabini secer")
    public void mark_twainin_kitabini_secer(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @Then("fiyat araligina minimum {int} yazar")
    public void fiyat_araligina_minimum_yazar(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("fiyat araligina maximum {int} yazar")
    public void fiyat_araligina_maximum_yazar(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Guncelleye basar")
    public void guncelleye_basar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Sepete gider")
    public void sepete_gider() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Son gezdiklerimi listeler")
    public void son_gezdiklerimi_listeler() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Toplam fiyati yazdirir")
    public void toplam_fiyati_yazdirir() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Kazanacaginiz Puani yazdirir")
    public void kazanacaginiz_puani_yazdirir() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Satin Al a basar")
    public void satin_al_a_basar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
