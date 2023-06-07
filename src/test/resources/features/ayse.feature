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