package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;
public class CocukKitaplari_Ayse {

public CocukKitaplari_Ayse(){
    PageFactory.initElements(Driver.getDriver(),this);
}

    @FindBy(xpath = "//img[@class='desktop-block']")
    public   WebElement logo;
    @FindBy(xpath = "//a[@href='https://www.kitapyurdu.com/index.php?route=product/category&path=5&sort=purchased_365&order=DESC&filter_in_stock=1&limit=100']")
    public WebElement okulOncesi;
    @FindBy(xpath = "//h1")
    public WebElement OkulOncesiText;
    @FindBy(xpath = "//a[@href='https://www.kitapyurdu.com/index.php?route=account/register']")
    public WebElement uyeOl;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement uyeOlButton;
    @FindBy(xpath = "//input[@id='register-name']")
    public WebElement adTextBox;
    @FindBy(xpath = "//input[@id='register-lastname']")
    public WebElement soyadTextBox;
    @FindBy(xpath = "//input[@id='register-email']")
    public WebElement emailTextBox;
    @FindBy(xpath = "//input[@id='register-password']")
    public WebElement sifre1TextBox;
    @FindBy(xpath = "//input[@id='register-password-confirm']")
    public WebElement sifre2TextBox;
    @FindBy(xpath = "//*[@id='header']/div[5]/div")
    public WebElement warning;
    @FindBy(xpath = "//button[@id='js-popup-accept-button']")
    public WebElement cookies;
    @FindBy(xpath = "//h1")
    public WebElement hesabinizOlusturuldu;
    @FindBy(xpath = "//a[text()='Anasayfaya Git']")
    public WebElement anasayfayaGit;
    @FindBy(xpath = "//div[@class='logo-text']")
    public WebElement kitapyurduLogosu;
    @FindBy(xpath = "(//strong[text()='Çocuk'])[2]")
    public WebElement cokSatanCocukKitaplarilinki;
    @FindBy(xpath = "//div[@class='ky-checkbox-input']")
    public WebElement kisiselVerilenKorunmasiCheckbox;
    @FindBy(xpath = "//span[@id='email']")
    public WebElement fakeCopyAlma;
    @FindBy(xpath = "//td[@colspan='2']")
    public WebElement clickMail;
    @FindBy(xpath = "//a[text()='E-posta Adresimi Doğrula →']")
    public WebElement adresiDogrula;
    //@FindBy(xpath = "//div[@class='attention']")
   // public WebElement anasayfayaGit;
    @FindBy(xpath = "//div[@class='success']")
    public WebElement dogrulamaMesaji;
    @FindBy(xpath = "//h1")
    public WebElement cocukKitaplari;
    @FindBy(xpath = "//a[text()='Devam']")
    public WebElement devam;
    @FindBy(xpath = "//a[@class='common-sprite']")
    public WebElement merhaba;
    @FindBy(xpath = "//input[@id='login-email']")
    public WebElement eposta;
    @FindBy(xpath = "//input[@id='login-password']")
    public WebElement password;
    @FindBy(xpath = "(//span[@class='custom-checkmark'])[2]")
    public WebElement stoktaOlanlar;
    @FindBy(linkText = "Genel")
    public WebElement genel;

    @FindBy(xpath = "//h1")
    public WebElement kitap1;

    @FindBy(xpath = "//span[text()='Sepete Ekle']")
    public WebElement sepet;
    @FindBy(xpath = "//h2")
    public WebElement onay;

    @FindBy(xpath = "//div[@class='results']")
    public WebElement kacKitap;
    @FindBy(xpath = "(//span[@class='facet-name'])[20]")
    public WebElement ziya;












}
