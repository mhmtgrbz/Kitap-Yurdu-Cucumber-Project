
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

    Then giris yap linkini tiklar
    And Cookiesi kabul eder
    And "Ayse" eposta kutusuna mailini girer
    And "Ayse" sifre kutusuna sifresini girer
    And giris yap butonunu tiklar
    And kullanici cok satan kitaplar menusu ustune gelir
    And cok satan "cocuk kitaplari" linkine tiklar
    Then Cocuk kitaplari yazisini gorur
   # And Genel kutusuna tiklar
    And Stokta olanlari secer
    Then Stockta kac kitap oldugunu yazdirir
    And 3 . kitaba tiklar
    When Kitabin adini yazdirir
    And Kitabi sepete ekler
    Then Onay yazisini gorur
    And Bir sayfa geri gider
    And 100 temel eser linkine tiklar
    And Ziya Gokalp yazarini secer
    And Nar Cocuk yayinlarini secer
    Then Yazarin adini kontrol eder
    And 1 . kitaba tiklar
    And Sepete ekler
    When 3 sayfa geri gider
    And ingilizce dilini secer
    And Mark Twain i secer
    And Mark Twainin 1. kitabini secer
    Then Yazarin adini kontrol eder
    And Sepete ekler
    Then Onay yazisini gorur
    And 3 sayfa geri gider
    And fiyat araligina minimum 50 yazar
    And fiyat araligina maximum 100 yazar
    And Guncelleye basar
    Then Stockta kac kitap oldugunu yazdirir
    And Sepete ekler
    Then Onay yazisini gorur
    And Sepete gider

    And Son gezdiklerimi listeler
    And Toplam fiyati yazdirir
    And Kazanacaginiz Puani yazdirir
    And Satin Al a basar
    Then Fiyatlari karsilastirir
    And Driveri kapatir
































Feature: US01 Sahte hesapla uye olma
  Background:    Given Kullanici "url" e gider
    Scenario: TC01 hesap acma
      Then Uye ola tiklar
      And Cookiesi kabul eder
      Then uye olmak icin sahte hesaptan mail alir bu yuzden fakemail adresine gider
      And Kisisel verilerin korunmasi checkboxini tiklar
      And sayfada oldugunu dogrular
      And Uye olma buttonuna basar
      Then cok satan cocuk kitaplari linkine tiklar
      And uyari mesajni gorur
      And Gelen maili onaylamak icin eski pencereye gider
      And gelen maili onaylar
      And yeni pencereye gecer
      Then yeni pencerede oldugunu dogrular
      And Anasayfaya gider
      And Hesap olusturuldu yazisini gorur
      And Anasayfada oldugunu dogrular
      And Cocuk kitaplari yazisini gorur
      And Devam kuttonuna basar
      And Kullanici merhaba kitap kurdu yazisini gorur
      Then Kullanici sayfayi kapatir

