package techproed.utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

/*
    Driver class'indaki mantik extends yontemi ile degil yani TestBase class'ina extend etmek yerine
    Driver classindan static methodlar kullanarak druver olustururuz.Statik oldugu icin class ismi ile
    heryerden methoda ulasabilecegiz.
 */
public class Driver {

    static WebDriver driver;

    public static WebDriver getDriver() {
        /*
        Driver'i her cagirdiginda yeni bir pencere acilmasinin onune gecmek icin
        if blogu icinde Eger driver'a deger atanmamissa deger ata, Eger deger atanmissa Driver'i ayni sayfada Return et.
        Bunun icin sadece yapmamiz gerek if(driver== nul)kullanmaktir.
         */
/*
    Singleton Pattern: Tekli kullanım kalıbı.
        Bir class'tan obje oluşturulmasının önüne geçilmesi için kullanılan ifade
        Bir class'tan obje oluşturmanın önüne geçmek için default constructor'ın kullanımını engellemek için
    private access modifire kullanarak bir constructor oluştururuz
     */

      /*
            Driver'i her çağırdığında yeni bir pencere açılmasının önüne geçmek için
        if bloğu içinde Eğer driver'a değer atanmamışsa(driver doluysa) değer ata, Eğer değer atanmışsa Driver'i aynı
        sayfada RETURN et. Bunun sadece yapmamız gereken if(driver==null) kullanmak
         */
        if (driver == null) {
            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver(new EdgeOptions().addArguments("--remote-allow-origins=*"));
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {//Driver'a değer atanmışşsa
            driver.close();
            driver = null;
        }
    }

    public static void quitDriver() {
        if (driver != null) {//Driver'a değer atanmışşsa
            driver.quit();
            driver = null;
        }
    }
}