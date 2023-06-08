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
    @FindBy(xpath = "//input[@value='TÜRKÇE']")
    public WebElement turkceCheckbox;
    @FindBy(xpath = "//input[@value='İNGİLİZCE']")
    public WebElement ingCheckbox;
    @FindBy(xpath = "//input[@name='selected_sell_price_min']")
    public WebElement minprice;
    @FindBy(xpath = "//input[@name='selected_sell_price_max']")
    public WebElement maxprice;
    @FindBy(xpath = "//span[text()='Oylama']")
    public WebElement oylama;
    @FindBy(xpath = "//a[@onclick='postPriceInterval();']")
    public WebElement guncelleButton;
    @FindBy(xpath = "//span[@class='value']")
    public WebElement price;
    @FindBy(xpath = "//input[@id='search-input']")
    public WebElement searchBox;

    @FindBy(id= "bottom-button")
    public WebElement goPageDownButton;

    @FindBy(id= "suggest-button")
    public WebElement suggestButton;

    @FindBy(xpath = "//*[@name='name']")
    public WebElement suggestFormName;

    @FindBy(xpath = "//*[@name='email']")
    public WebElement suggestFormEmail;
    @FindBy(xpath = "//select[@name='subject']")
    public WebElement subjectDDM;
    @FindBy(xpath = "//*[@name='enquiry']")
    public WebElement gorus;
    @FindBy(id= "feedback_captcha")
    public WebElement feedbackCaptcha;
    @FindBy(xpath = "(//span[@class='error'])[1]")
    public WebElement errorMessageCommend;
    @FindBy(xpath = "(//span[@class='error'])[2]")
    public WebElement errorMessageCode;

    @FindBy(xpath = "//*[@onclick='submitFeedbackForm(this)']")
    public WebElement submitForm;









}
