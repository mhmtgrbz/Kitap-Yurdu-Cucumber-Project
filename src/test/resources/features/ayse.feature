Feature: US01 Siteye login olma


  Background: Kullanici Kitap Yurdu Sayfasina Gider
    Given Kullanici "url" e gider
    Then sayfada oldugunu dogrular

  Scenario:Sitede hesap acma


    Then Uye ola tiklar
    And Cookiesi kabul eder
    Then uye olmak icin sahte hesaptan mail alir bu yuzden fakemail adresine gider
   # And Hesap olusturmak icin adini ve bilgileri girer
    And Kisisel verilerin korunmasi checkboxini tiklar
    Then Uye olma buttonuna basar
    Then Hesap olusturuldu yazisini gorur
    And Anasayfaya gider
    Then Anasayfada oldugunu dogrular
    And uyari mesajni gorur
    Then Gelen maili onaylamak icin eski pencereye gider
    And gelen maili onaylar
    And yeni pencereye gecer
    Then yeni pencerede oldugunu dogrular
    And Devam kuttonuna basar
    And Kullanici merhaba kitap kurdu yazisini gorur
    Then Kullanici sayfayi kapatir


  Scenario: hesaba giris yapmak
    And Cookiesi kabul eder
    Then giris yap linkini tiklar
    And eposta kutusuna mailini girer
    And sifre kutusuna sifresini girer
    And giris yap butonunu tiklar
    And kullanici cok satan kitaplar menusu ustune gelir
    And cok satan "cocuk kitaplari" linkine tiklar
    Then Cocuk kitaplari yazisini gorur


