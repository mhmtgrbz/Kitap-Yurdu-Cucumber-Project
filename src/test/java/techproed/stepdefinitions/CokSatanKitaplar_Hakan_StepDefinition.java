package techproed.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.Select;
import techproed.pages.CokSatanKitaplar_EDebiyat_Hakan;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;

public class CokSatanKitaplar_Hakan_StepDefinition {

    CokSatanKitaplar_EDebiyat_Hakan locate = new CokSatanKitaplar_EDebiyat_Hakan();

    @Given("kullanici cok satan kitaplar menusu ustune gelir")
    public void kullaniciCokSatanKitaplarMenusuUstuneGelir() {
        ReusableMethods.moveToElementWithAction(locate.cokSatanKitaplar);
    }

    @Then("acilan menude cok satan edebiyat kitaplari linki oldugunu dogrular")
    public void acilanMenudeCokSatanEdebiyatKitaplariLinkiOldugunuDogrular() {
        assertTrue(locate.cokSatanEdebiyat.isDisplayed());
    }

    @And("cok satan edebiyat kitaplari linkini tiklar")
    public void cokSatanEdebiyatKitaplariLinkiniTiklar() {
        locate.cokSatanEdebiyat.click();
    }

    @When("kullanici cok satan kitaplar sayfasinda oldugunu dogrular")
    public void kullaniciCokSatanKitaplarSayfasindaOldugunuDogrular() {
        assertTrue(Driver.getDriver().getTitle().contains("Edebiyat"));
    }

    @And("edebiyat butonunun secilmis oldugunu dogrular")
    public void edebiyatButonununSecilmisOldugunuDogrular() {
        assertTrue(locate.edebiyatButonu.isSelected());
        
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



}
