package techproed.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import techproed.pages.CokSatanKitaplar_Edebiyat_Hakan;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import static org.junit.Assert.*;

public class CokSatanKitaplar_Hakan_StepDefinition {

    CokSatanKitaplar_Edebiyat_Hakan locate = new CokSatanKitaplar_Edebiyat_Hakan();
    Select select;
    String selectZaman;
    @Then("Sayfanin resmini ceker")
    public void sayfaninResminiCeker() {
        ReusableMethods.tumSayfaResmi();
    }
    @Given("kullanici cok satan kitaplar menusu ustune gelir")
    public void kullaniciCokSatanKitaplarMenusuUstuneGelir() {
        WebElement element=ReusableMethods.webelementJavaScript("document.querySelector(\"#mainNav > div.nav-content > ul > li.book.has-menu.active > div.lvl2.js-bookCr > ul > li:nth-child(1)\")");
        ReusableMethods.moveToElementWithAction(element);
    }
     @Then("acilan menude cok satan edebiyat kitaplari linki oldugunu dogrular")
    public void acilanMenudeCokSatanEdebiyatKitaplariLinkiOldugunuDogrular() {
        ReusableMethods.assertIsEnabled("document.querySelector(\"#mainNav > div.nav-content > ul > li.book.has-menu.active > div.lvl2.js-bookCr > ul > li.has-open-menu.selected > div > div.open-menu-ct.bookBestSeller > div.subCategories > ul:nth-child(2) > li:nth-child(1) > a\")");

    }

    @And("cok satan edebiyat kitaplari linkini tiklar")
    public void cokSatanEdebiyatKitaplariLinkiniTiklar() {
        ReusableMethods.webelementJavaScript("document.querySelector(\"#mainNav > div.nav-content > ul > li.book.has-menu.active > div.lvl2.js-bookCr > ul > li:nth-child(1) > div > div.open-menu-ct.bookBestSeller > div.subCategories > ul:nth-child(2) > li:nth-child(1) > a > strong\")").click();
    }

  
    @When("kullanici cok satan edebiyat kitaplari sayfasinda oldugunu dogrular")
    public void kullaniciCokSatanEdebiyatKitaplariSayfasindaOldugunuDogrular() {
     
        assertTrue(Driver.getDriver().getTitle().contains("Çok Satan Kitaplar"));
    }

    @And("edebiyat butonunun secilmis oldugunu dogrular")
    public void edebiyatButonununSecilmisOldugunuDogrular() {
        assertTrue(locate.edebiyatButonu.getAttribute("class").equals("button"));
        
    }
    @Then("edebiyat butonunun resmini ceker")
    public void edebiyatButonununResminiCeker() {
        ReusableMethods.webElementResmi(locate.edebiyatButonu);
    }

    @And("satista olanlar checkboxinin secili oldugunu dogrular")
    public void satistaOlanlarCheckboxininSeciliOldugunuDogrular() {
        assertTrue(locate.satistaOlanlar.isSelected());
    }

    @Then("yirmi urun dropdownina tiklar")
    public void yirmiUrunDropdowninaTiklar() {
        locate.yirmiUrun.click();
    }

    @And("yuz urunu secer")
    public void yuzUrunuSecer() {
        Select select=new Select(locate.yirmiUrun);
        select.selectByVisibleText("100 Ürün");
    }

    @And("yuz urun seceneginin secildigini dogrular")
    public void yuzUrunSecenegininSecildiginiDogrular() {
        assertTrue(locate.yuzUrun.isEnabled());
    }

    @And("sayfada yuz urun gorundugunu dogrular")
    public void sayfadaYuzUrunGorundugunuDogrular() {
        int expectedKitapSayisi=100;
       int actualKitapSayisi=Driver.getDriver().findElements(By.xpath("//div[@class='image']")).size();

        assertTrue(expectedKitapSayisi==actualKitapSayisi);

    }


    @And("{int} saniye bekleme yapar")
    public void saniyeBeklemeYapar(int arg0) {
        ReusableMethods.bekle(3);
    }


    @Then("kullanici zaman araligi dropdown'inin secilebilir oldugunu dogrular")
    public void kullaniciZamanAraligiDropdownIninSecilebilirOldugunuDogrular() {
        assertTrue(locate.zamanAraligi.isEnabled());
    }


    @And("kullanici zaman araligi dropdown'inindan {string} secenegini secer")
    public void kullaniciZamanAraligiDropdownInindanSeceneginiSecer(String str) {
        select=new Select(locate.zamanAraligi);
        select.selectByVisibleText(str);
        selectZaman=str;
    }

    @Then("kullanici secim sonucu goruntulenen kitaplarin degistigini dogrular")
    public void kullaniciSecimSonucuGoruntulenenKitaplarinDegistiginiDogrular() {
        String ilkKitap= "";
        String ikinciKitap= "";
        String ucuncuKitap= "";
        if (selectZaman.equals("Haftalık")){
            ilkKitap= locate.kitaplar.getText();
            System.out.println("ilkKitap = " + ilkKitap);
        } else if (selectZaman.equals("Aylık")){
            ikinciKitap= locate.kitaplar.getText();
            System.out.println("ikinciKitap = " + ikinciKitap);
        }else {
            ucuncuKitap= locate.kitaplar.getText();
            System.out.println("ucuncuKitap = " + ucuncuKitap);
        }



        if(ikinciKitap!=null){
            assertFalse(ilkKitap.equals(ikinciKitap));
            assertFalse(ilkKitap.equals(ucuncuKitap));
            assertFalse(ikinciKitap.equals(ilkKitap));
            assertFalse(ikinciKitap.equals(ucuncuKitap));
        }
        if(ucuncuKitap!=null){
            assertFalse(ucuncuKitap.equals(ilkKitap));
            assertFalse(ikinciKitap.equals(ikinciKitap));
        }


    }
}
