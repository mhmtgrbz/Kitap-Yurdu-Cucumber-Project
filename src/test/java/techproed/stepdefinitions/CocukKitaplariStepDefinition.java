package techproed.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
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
        page.cokSatanCocukKitaplarilinki.click();
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
        click( page.adresiDogrula);
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
}
