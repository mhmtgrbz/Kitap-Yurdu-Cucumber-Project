package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

import java.util.List;

public class LocatesMali_yeniCikanKitaplar {
    public LocatesMali_yeniCikanKitaplar(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[text()='Yeni Çıkan Kitaplar']")
    public WebElement yeniCikanKitaplarLink;

    @FindBy(xpath = "//span[text()='Tüm Kitaplar']")
    public WebElement tumKitaplarLink;

    @FindBy(xpath = "//a[@href='kategori/kitap-edebiyat/128.html']")
    public WebElement edebiyat;
    @FindBy(xpath = "//a[@href='kategori/kitap-cocuk-kitaplari/2.html']")
    public WebElement cocuk;
    @FindBy(xpath = "//a[@href='kategori/kitap-tarih/41.html']")
    public WebElement tarih;
    @FindBy(xpath = "//a[@href='kategori/kitap-sinavlar/737.html']")
    public WebElement sinavlar;
    @FindBy(xpath = "//a[@href='kategori/kitap-bilgisayar/31.html']")
    public WebElement bilgisayar;
    @FindBy(xpath = "//a[text()='Kategorinin Tüm Ürünlerini Listele']")
    public WebElement tumlistele;



    @FindBy(xpath = "//a[@href='yeni-cikan-kitaplar/haftalik/2.html']")
    public WebElement haftalikYeniKitaplar;

    @FindBy(xpath = "(//select[@onchange='location = this.value;'])[1]")
    public WebElement haftalikDDM;

    @FindBy(xpath = "(//select[@onchange='location = this.value;'])[2]")
    public WebElement varsayilanDDM;

    @FindBy(xpath = "(//select[@onchange='location = this.value;'])[3]")
    public WebElement sayfadaelliDDM;
    @FindBy(xpath = "(//select[@onchange='location = this.value;'])[2]")
    public WebElement sayfadayuzDDM;

    @FindBy(xpath = "//div[@class='name ellipsis']")
    public List<WebElement> basliklar;
    @FindBy(xpath = "//div[@class='price']")
    public List<WebElement> price;

    @FindBy(xpath = "//div[@class='author compact ellipsis']")
    public List<WebElement> author;



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
