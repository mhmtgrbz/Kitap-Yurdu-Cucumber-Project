package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class CokSatanKitaplar_Hakan {

    public CokSatanKitaplar_Hakan(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//li[@class='has-open-menu']/child::span)[1]")
    public WebElement cokSatanKitaplar;


}
