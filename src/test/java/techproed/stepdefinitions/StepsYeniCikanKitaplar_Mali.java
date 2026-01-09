package techproed.stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.postgresql.util.PSQLException;
import techproed.pages.LocatesMali_yeniCikanKitaplar;
import techproed.pojo.EdebiyatKitaplariPojo;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.sql.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

import static techproed.utilities.ReusableMethods.bekle;
import static techproed.utilities.ReusableMethods.closeConnection;

public class StepsYeniCikanKitaplar_Mali {
    LocatesMali_yeniCikanKitaplar locate = new LocatesMali_yeniCikanKitaplar();
    Select select;
    Statement st;
    Connection con;



    @Given("Kullanici {string} e gider")
    public void kullaniciEGider(String url) {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        bekle(1);
    }

    @Then("yeni cikan kitaplar linkini tiklar")
    public void yeniCikanKitaplarLinkiniTiklar() {
        locate.yeniCikanKitaplarLink.click();
        bekle(1);
    }

    @Then("haftalik yeni cikan kitaplar linkini tiklar")
    public void haftalikYeniCikanKitaplarLinkiniTiklar() {
        locate.haftalikYeniKitaplar.click();
        bekle(1);
    }

    @Given("Kullanici zaman olarak sonikiay secer")
    public void kullanici_zaman_olarak_sonikiay_secer() {
        select = new Select(locate.haftalikDDM);
        select.selectByIndex(1);
        bekle(1);


    }

    @Given("Kullanici varsayilan olarak pahalidanucuza secer")
    public void kullanici_varsayilan_olarak_pahalidanucuza_secer() {
        select = new Select(locate.varsayilanDDM);
        select.selectByVisibleText("Pahalıdan > Ucuza");
        bekle(1);
    }

    @Given("Kullanici satistaolanlar alanini isaretler")
    public void kullanici_satistaolanlar_alanini_isaretler() {
        locate.satistaOlanCheckBox.click();
        bekle(1);

    }

    @Given("Kullanici stoktaolanlar alanini isaretler")
    public void kullanici_stoktaolanlar_alanini_isaretler() {
        locate.stoktaOlanCheckBox.click();
        bekle(1);
    }

    @Given("Kullanici urun sayfa gorunumunu elli olarak isaretler")
    public void kullanici_urun_sayfa_gorunumunu_elli_olarak_isaretler() {
        select = new Select(locate.sayfadaelliDDM);
        select.selectByVisibleText("50 Ürün");
        bekle(1);
    }

    @Then("kullanici varsayilan olarak {string} aratir")
    public void kullaniciVarsayilanOlarakAratir(String arg0) {
        select = new Select(locate.varsayilanDDM);
        select.selectByVisibleText(arg0);

    }

    @And("{int} saniye bekler")
    public void saniyeBekler(int saniye) throws InterruptedException {
        Thread.sleep(saniye * 1000);

    }

    @Then("basligin {string} icerdigini dogrular")
    public void basliginIcerdiginiDogrular(String arg0) {
        Assert.assertTrue(locate.varsayilanDDM.getText().contains(arg0));
        bekle(3);
    }

    @And("sayfada elli adet urun oldugunu dogrular")
    public void sayfadaElliAdetUrunOldugunuDogrular() {
        Assert.assertEquals(Driver.getDriver().
                findElements(By.xpath("//div[@class='product-cr']")).size(), 50);
        System.out.println("size :" + Driver.getDriver().
                findElements(By.xpath("//div[@class='product-cr']")).size());
    }

    @Given("kullanici ingilizce kitaplar secenegini isaretler")
    public void kullaniciIngilizceKitaplarSeceneginiIsaretler() {
        ReusableMethods.scroll(locate.oylama);
        locate.ingCheckbox.click();
        bekle(2);

    }

    @And("kulanici turkce kitaplar secenegini isaretler")
    public void kulaniciTurkceKitaplarSeceneginiIsaretler() {
        locate.turkceCheckbox.click();
        bekle(1);

    }


    @And("isaretlemelerin goruldugu test edilir")
    public void isaretlemelerinGorulduguTestEdilir() {
        Assert.assertTrue(locate.turkceCheckbox.isSelected());
        Assert.assertTrue(locate.ingCheckbox.isSelected());
    }

    @Given("Kullanici urun fiyat aralıgını dusuk {int} yuksek {int} TL olarak secer")
    public void kullaniciUrunFiyatAralıgınıDusukYuksekTLOlarakSecer(int min, int max) {
        locate.minprice.sendKeys(String.valueOf(min));
        bekle(1);
        locate.maxprice.sendKeys(String.valueOf(max));
        bekle(1);

    }


    @And("guncelle butonunu tiklar")
    public void guncelleButonunuTiklar() {
        locate.guncelleButton.click();
    }

    @Given("Kullanici searchbox alanında exceldeki kitapları arar")
    public void kullaniciSearchboxAlanındaExceldekiKitaplarıArar() {

        ExcelUtils excelUtils = new ExcelUtils("src/test/resources/kitapyurdu.xlsx", "sayfa1");//excel sayfa yolu ve işlem yapılacak sayfa ismi
        for (int i = 1; i <= excelUtils.rowCount(); i++) {
            String kitapadi = excelUtils.getCellData(i, 0);
            locate.searchBox.sendKeys(kitapadi, Keys.ENTER);
            bekle(1);
            locate.searchBox.clear();
            bekle(2);

        }
    }

    @And("kullanici searchbox alaninda exceldeki yayinevlerini arar")
    public void kullaniciSearchboxAlanindaExceldekiYayinevleriniArar() {
        ExcelUtils excelUtils = new ExcelUtils("src/test/resources/kitapyurdu.xlsx", "sayfa1");//excel sayfa yolu ve işlem yapılacak sayfa ismi
        for (int i = 1; i <= excelUtils.rowCount(); i++) {

            String yayinevi = excelUtils.getCellData(i, 2);

            locate.searchBox.sendKeys(yayinevi, Keys.ENTER);
            bekle(1);
            locate.searchBox.clear();
            bekle(1);


        }


    }

    @And("kullanici searchbox alaninda exceldeki yazarlari arar")
    public void kullaniciSearchboxAlanindaExceldekiYazarlariArar() {
        ExcelUtils excelUtils = new ExcelUtils("src/test/resources/kitapyurdu.xlsx", "sayfa1");//excel sayfa yolu ve işlem yapılacak sayfa ismi
        for (int i = 1; i <= excelUtils.rowCount(); i++) {
            String yazaradi = excelUtils.getCellData(i, 1);
            locate.searchBox.sendKeys(yazaradi, Keys.ENTER);
            bekle(1);
            locate.searchBox.clear();
            bekle(1);
        }
    }


    @And("goruntulenen tum kitaplarin fiyatinin {int} ile {int}  TL araliginda oldugu test edilir")
    public void goruntulenenTumKitaplarinFiyatininIleTLAraligindaOlduguTestEdilir(double min, double max) {

        //bütün ürünler için
        List<WebElement> prices=Driver.getDriver().findElements(By.xpath("//span[@class='value']"));
        System.out.println("ürün sayisi : "+prices.size());
        for (int i = 0; i < prices.size(); i++) {
            if(prices.get(i).getText().isEmpty()){continue;}
            Double priceS=Double.valueOf(prices.get(i).getText().replace(",","."));
            System.out.println("urunler :"+priceS);
            Assert.assertTrue(min <= priceS && max >= priceS);
        }
    }

    @Given("Kullanici sayfa sonuna kaydirma butonuna tiklar")
    public void kullaniciSayfaSonunaKaydirmaButonunaTiklar() {
        locate.goPageDownButton.click();
    }

    @And("sayfa resmini alir")
    public void sayfaResminiAlir() {
        ReusableMethods.tumSayfaResmi();
    }

    @Given("Kullanici oneri form ikonunu tiklar")
    public void kullaniciOneriFormIkonunuTiklar() {
        bekle(1);
        locate.suggestButton.click();
    }

    @And("Acilan pencerede isim alanını doldurur")
    public void acilanPenceredeIsimAlanınıDoldurur() {
        locate.suggestFormName.sendKeys(Faker.instance().name().fullName());
        bekle(1);

    }

    @And("e posta alanını doldurur")
    public void ePostaAlanınıDoldurur() {
        locate.suggestFormEmail.sendKeys(Faker.instance().internet().emailAddress());
        bekle(1);
    }

    @And("Konu alanına Oneri seklinde giris yapar")
    public void konuAlanınaOneriSeklindeGirisYapar() {
        select=new Select(locate.subjectDDM);
        select.selectByValue("1");

        bekle(1);
    }


    @And("Gorus alanina dokuzchar gorusunu yazar")
    public void gorusAlaninaDokuzcharGorusunuYazar() {
        locate.gorus.sendKeys("Abcdefgh9");
        bekle(1);

    }

    @And("Kabul edilmeyen karakter sayisi uyarisini goruntuler")
    public void kabulEdilmeyenKarakterSayisiUyarisiniGoruntuler() {

        Assert.assertTrue(locate.errorMessageCommend.isDisplayed());
        bekle(1);
    }

    @And("Gorus alanına ONchar gorusunu yazar")
    public void gorusAlanınaONcharGorusunuYazar() {
        locate.gorus.sendKeys(Faker.instance().letterify("Abcdefgh10"));
    }

    @Given("Kullanici dogrulama alanına yanlıs bir deger girer")
    public void kullaniciDogrulamaAlanınaYanlısBirDegerGirer() {
        bekle(1);
        locate.feedbackCaptcha.sendKeys(Faker.instance().code().ean8());

    }

    @And("dogrulama kodu hatalidir mesajini goruntuler")
    public void dogrulamaKoduHatalidirMesajiniGoruntuler() {
        Assert.assertTrue(locate.errorMessageCode.isDisplayed());
    }

    @Then("Kullanici gonder butonunu tiklar")
    public void kullaniciGonderButonunuTiklar() {
        locate.submitForm.click();
    }


    //Database feature

    @Given("database kaynagi baglantı saglanir")
    public void databaseKaynagiBaglantıSaglanir() throws SQLException, ClassNotFoundException {

        //Class.forName("org.postgresql.Driver"); //BU artık kalktı


        //1.adim Database'e baglanma
        con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/kitapyurdu",
                "postgres",
                ConfigReader.getProperty("postgrePswMas"));
        //2. statement
        st = con.createStatement();

    }
        @Given("kullanici database alaninda_{string}_alani kaynagi olusturur")
        public void kullaniciDatabaseAlaninda__alaniKaynagiOlusturur(String baslik) throws ClassNotFoundException, SQLException, InterruptedException {

            Driver.getDriver().navigate().refresh();
        //4. adim edebiyatKitaplari tablosu olusturacagim

            try {
                String sql01 = "CREATE table "+baslik+" (id int primary key, isim varchar(80) ,yazar varchar(40), fiyat varchar(20) )";
                st.execute(sql01);
            } catch (Exception e) {

            }
            try {
                locate.cookies.click();
            }catch (NoSuchElementException e){
                System.out.println("Cookies pop up çıkmadı.");
            }
            locate.tumKatagorilerLink.click();






    switch (baslik){
        case "Edebiyat":

            locate.edebiyat.click();
            saniyeBekler(1);
            locate.tumlistele.click();
            saniyeBekler(2);
            select = new Select(locate.sayfadayuzDDM);
            select.selectByVisibleText("100 Ürün");
            bekle(1);

            for (int i = 0; i < locate.basliklar.size(); i++) {
               System.out.println("kitap ismi, yazar adı : " + locate.basliklar.get(i).getText()+" , "+locate.author.get(i).getText());
               String veri="insert into edebiyat values ("+i+",'"+locate.basliklar.
                       get(i).getText().replaceAll("'","")+"','"+locate.author.get(i).getText()+"', '"+locate.price.get(i).getText()+"')";
               st.executeUpdate(veri);

            }
            break;

        case "Tarih":

            locate.tarih.click();
            saniyeBekler(1);
            locate.tumlistele.click();
            saniyeBekler(2);
            select = new Select(locate.sayfadayuzDDM);
            select.selectByVisibleText("100 Ürün");
            bekle(1);

            for (int i = 0; i < locate.basliklar.size(); i++) {
                System.out.println("kitap ismi, yazar adı : " + locate.basliklar.get(i).getText()+" , "+locate.author.get(i).getText());
                String veri="insert into tarih values ("+i+",'"+locate.basliklar.get(i).getText().replaceAll("'","")+"','"+locate.author.get(i).getText()+"','"+locate.price.get(i).getText()+"')";
                st.executeUpdate(veri);
            }
            break;
        case "Cocuk_kitaplari":

            locate.cocuk.click();
            saniyeBekler(1);
            locate.tumlistele.click();
            saniyeBekler(2);
            select = new Select(locate.sayfadayuzDDM);
            select.selectByVisibleText("100 Ürün");
            bekle(1);

            for (int i = 0; i < locate.basliklar.size(); i++) {
                System.out.println("kitap ismi, yazar adı : " + locate.basliklar.get(i).getText()+" , "+locate.author.get(i).getText());
                String veri="insert into cocuk_kitaplari values ("+i+",'"+locate.basliklar.get(i).getText().replaceAll("'","")+"','"+locate.author.get(i).getText()+"','"+locate.price.get(i).getText()+"')";
                st.executeUpdate(veri);
            }
            break;
        case "Bilgisayar":

            locate.bilgisayar.click();
            saniyeBekler(1);
            locate.tumlistele.click();
            saniyeBekler(2);
            select = new Select(locate.sayfadayuzDDM);
            select.selectByVisibleText("100 Ürün");
            bekle(1);

            for (int i = 0; i < locate.basliklar.size(); i++) {
                System.out.println("kitap ismi, yazar adı : " + locate.basliklar.get(i).getText()+" , "+locate.author.get(i).getText());
                String veri="insert into bilgisayar values ("+i+",'"+locate.basliklar.get(i).getText().replaceAll("'","")+"','"+locate.author.get(i).getText()+"','"+locate.price.get(i).getText()+"')";
                st.executeUpdate(veri);
            }
            break;
        case "Sinavlar":

            locate.sinavlar.click();
            saniyeBekler(1);
            locate.tumlistele.click();
            saniyeBekler(2);
            select = new Select(locate.sayfadayuzDDM);
            select.selectByVisibleText("100 Ürün");
            bekle(1);

            for (int i = 0; i < locate.basliklar.size(); i++) {
                System.out.println("kitap ismi, yazar adı : " + locate.basliklar.get(i).getText()+" , "+locate.author.get(i).getText());
                String veri="insert into sinavlar values ("+i+",'"+locate.basliklar.get(i).getText().replaceAll("'","")+"','"+locate.author.get(i).getText()+"','"+locate.price.get(i).getText()+"')";
                st.executeUpdate(veri);
            }
            break;
        case "Psikoloji":

            locate.psikoloji.click();
            saniyeBekler(1);
            locate.tumlistele.click();
            saniyeBekler(2);
            select = new Select(locate.sayfadayuzDDM);
            select.selectByVisibleText("100 Ürün");
            bekle(1);

            for (int i = 0; i < locate.basliklar.size(); i++) {
                System.out.println("kitap ismi, yazar adı : " + locate.basliklar.get(i).getText()+" , "+locate.author.get(i).getText());
                String veri="insert into psikoloji values ("+i+",'"+locate.basliklar.get(i).getText().replaceAll("'","")+"','"+locate.author.get(i).getText()+"','"+locate.price.get(i).getText()+"')";
                st.executeUpdate(veri);
            }
            break;
        case "Kultur":

            locate.kultur.click();
            saniyeBekler(1);
            locate.tumlistele.click();
            saniyeBekler(2);
            select = new Select(locate.sayfadayuzDDM);
            select.selectByVisibleText("100 Ürün");
            bekle(1);

            for (int i = 0; i < locate.basliklar.size(); i++) {
                System.out.println("kitap ismi, yazar adı : " + locate.basliklar.get(i).getText()+" , "+locate.author.get(i).getText());
                String veri="insert into kultur values ("+i+",'"+locate.basliklar.get(i).getText().replaceAll("'","")+"','"+locate.author.get(i).getText()+"','"+locate.price.get(i).getText()+"')";
                st.executeUpdate(veri);
            }
            break;

    }

            closeConnection(); //con.close ve st.close işlemi birlikte yapıyor

}

    @Given("UI alanında tum katagoriler basligini tiklar")
    public void uı_alanında_tum_katagoriler_basligini_tiklar() {
        bekle(1);
        locate.tumKatagorilerLink.click();
        bekle(1);

    }
    @Then("acilan sayfada_{string}_alani kitaplarini listeler")
    public void acilanSayfada__alaniKitaplariniListeler(String baslik) throws InterruptedException {
        switch (baslik) {
            case "Edebiyat":
                locate.edebiyat.click();
                saniyeBekler(1);
                locate.tumlistele.click();
                saniyeBekler(2);
                select = new Select(locate.sayfadayuzDDM);
                select.selectByVisibleText("100 Ürün");
                bekle(1);
                break;


            case "Tarih":
                locate.tarih.click();
                saniyeBekler(1);
                locate.tumlistele.click();
                saniyeBekler(2);
                select = new Select(locate.sayfadayuzDDM);
                select.selectByVisibleText("100 Ürün");
                bekle(1);
                break;


            case "Cocuk_kitaplari":
                locate.cocuk.click();
                saniyeBekler(1);
                locate.tumlistele.click();
                saniyeBekler(2);
                select = new Select(locate.sayfadayuzDDM);
                select.selectByVisibleText("100 Ürün");
                bekle(1);
                break;


            case "Bilgisayar":
                locate.bilgisayar.click();
                saniyeBekler(1);
                locate.tumlistele.click();
                saniyeBekler(2);
                select = new Select(locate.sayfadayuzDDM);
                select.selectByVisibleText("100 Ürün");
                bekle(1);
                break;


            case "Sinavlar":
                locate.sinavlar.click();
                saniyeBekler(1);
                locate.tumlistele.click();
                saniyeBekler(2);
                select = new Select(locate.sayfadayuzDDM);
                select.selectByVisibleText("100 Ürün");
                bekle(1);
                break;
            case "Psikoloji":
                locate.psikoloji.click();
                saniyeBekler(1);
                locate.tumlistele.click();
                saniyeBekler(2);
                select = new Select(locate.sayfadayuzDDM);
                select.selectByVisibleText("100 Ürün");
                bekle(1);
                break;
            case "Kultur":
                locate.kultur.click();
                saniyeBekler(1);
                locate.tumlistele.click();
                saniyeBekler(2);
                select = new Select(locate.sayfadayuzDDM);
                select.selectByVisibleText("100 Ürün");
                bekle(1);
                break;


        }

    }



    @And("listelenen sayfada ilk ve son kitaplari {string} databasede kontrol eder")
    public void listelenenSayfadaIlkVeSonKitaplariDatabasedeKontrolEder(String baslik) throws SQLException {
        bekle(2);
        System.out.println("locate.author.get(0).getText() = " + locate.author.get(0).getText());
        String actualData=locate.author.get(0).getText();

        System.out.println("locate.author.get(99).getText() = " + locate.author.get(99).getText());
        String actualData2=locate.author.get(99).getText();

        //Database sorgu query
        String sqlQuery1 = "SELECT * FROM "+baslik+" where yazar= '"+actualData+"'  ";
        String sqlQuery2 = "SELECT * FROM "+baslik+" where yazar= '"+actualData2+"'  ";
        System.out.println("sqlQuery1 = " + sqlQuery1);
        System.out.println("sqlQuery2 = " + sqlQuery2);

        ResultSet resultSet1 = st.executeQuery(sqlQuery1);//Query ile çağrılan data resultSet içerisinde yer alacak.
        resultSet1.next();
        System.out.println("resultSet1.getString(\"yazar\") = " + resultSet1.getString("yazar"));
        Assert.assertEquals(actualData,resultSet1.getString("yazar"));

        ResultSet resultSet2 = st.executeQuery(sqlQuery2);
        resultSet2.next();
        System.out.println("resultSet2.getString(\"yazar\") = " + resultSet2.getString("yazar"));
        Assert.assertEquals(actualData2,resultSet2.getString("yazar"));


    }
}



