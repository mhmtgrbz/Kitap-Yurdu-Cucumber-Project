package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class LocatesMali_yeniCikanKitaplar {
    public LocatesMali_yeniCikanKitaplar(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[text()='Yeni Çıkan Kitaplar']")
    public WebElement yeniCikanKitaplarLink;

    @FindBy(xpath = "//a[@href='yeni-cikan-kitaplar/haftalik/2.html']")
    public WebElement haftalikYeniKitaplar;

    @FindBy(xpath = "(//select[@onchange='location = this.value;'])[1]")
    public WebElement haftalikDDM;

    @FindBy(xpath = "(//select[@onchange='location = this.value;'])[2]")
    public WebElement varsayilanDDM;

    @FindBy(xpath = "(//select[@onchange='location = this.value;'])[3]")
    public WebElement sayfadaelliDDM;
    @FindBy(xpath = "(//span[@class='custom-checkmark'])[1]")
    public WebElement satistaOlanCheckBox;
    @FindBy(xpath = "(//span[@class='custom-checkmark'])[2]")
    public WebElement stoktaOlanCheckBox;
    @FindBy(xpath = "//div[@class='product-cr']")
    public WebElement numberOfProduct;

}
