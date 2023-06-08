package techproed.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import techproed.pages.Locate_X;
import techproed.pages.Login;
import techproed.utilities.ConfigReader;

import static techproed.utilities.ReusableMethods.bekle;

public class Login_StepDefinition {

    Login locate= new Login();

    @Then("giris yap linkini tiklar")
    public void girisYapLinkiniTiklar() {
        locate.girisYap.click();
    }


    @And("eposta kutusuna mailini girer")
    public void epostaKutusunaMailiniGirer() {
        locate.eposta.sendKeys(ConfigReader.getProperty("epostaHakan"));

    }

    @And("sifre kutusuna sifresini girer")
    public void sifreKutusunaSifresiniGirer() {
        locate.password.sendKeys(ConfigReader.getProperty("sifreHakan"));
    }

    @And("giris yap butonunu tiklar")
    public void girisYapButonunuTiklar() {
        locate.girisYapButonu.click();
        bekle(3);
    }


}
