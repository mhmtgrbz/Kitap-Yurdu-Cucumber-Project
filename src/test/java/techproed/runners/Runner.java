package techproed.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/*
Runner class; testNG deki .xml file larda belirttiğimiz class'ları,packageları veya methodları nasıl
çalıştırıyorsak, Cucumber frameworkundede Runner class'ındaki tags parametresi ile belirttiğimiz
senaryoyu çalıştırabiliriz
 */
//Cucumber ile JUnit'in entegre olmasını sağlayan test çalıştırıcı notasyonudur
@RunWith(Cucumber.class)
//Seneryoların nerede ve nasıl çalışacağı, hangi raporu kullanacağıyla alakalı seçenekleri ayarlarız
@CucumberOptions(
        plugin = {
                "pretty", //konsolu renklendirir
                "html:target/default-cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",
                "rerun:TestOutput/failed_scenario.txt"

        },
        //rerun->fail olan senaryoları belirtilen yoldaki txt dosya içinde gösterir
        //plugin parametresi ile pretty ifadesi kullanılırsa konsolda scenario.lar ile ilgili bilgi gösterir
        features = "src/test/resources/features",
        glue = {"techproed/stepDefinitions", "techproed/hooks"},
        //Bu parametre ile kodlarımızı yazdığımız stepDefinition
        //class'ının packege'ını belirtiriz
<<<<<<< HEAD
        tags = "@techpro1",
=======




        tags = "@suggestForm",



>>>>>>> master
        dryRun = false,
        //dryRun=false Test adımlarını kontrol eder ve browser'ı çalıştırır
        //dryRun=True Test adımlarını sadece kontrol eder
        //default olarak false'tur
        monochrome = true
        //pretty ifadesinden sonra monochrome = true kullanırsak
        // senerio adımlarını tekrenk olark siyah gösterir
        //monochrome = false kullanırsak renkli gösterir
        //default false
)
/*
features ===> features'ların olduğu packega'ın yolunu ver(ContentRoot)
glue ====> stepDefinition'ların olduğu packega'ın yolunu ver(Source Root)
tags ====> çalıştırmak istediğin grubu yaz
dryRun = true  ===> Missing Strep Definitions(Eksik) tespiti için kullanılır. Testi çalıştırmaz.
 */

public class Runner {
}
