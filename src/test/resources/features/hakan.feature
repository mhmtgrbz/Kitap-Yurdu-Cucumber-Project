@hakan
Feature: US01 Cok satan edebiyat kitapları


  Background: Kullanici Kitap Yurdu Sayfasina Gider
    Scenario:
    Given Kullanici "url" e gider
    Then giris yap linkini tiklar
    And eposta kutusuna mailini girer
    And sifre kutusuna sifresini girer
    And giris yap butonunu tiklar
  And kullanici cok satan kitaplar menusu ustune gelir
    Then acilan menude cok satan edebiyat kitaplari linki oldugunu dogrular
    And cok satan edebiyat kitaplari linkini tiklar
    When kullanici cok satan kitaplar sayfasinda oldugunu dogrular
    And edebiyat butonunun secilmis oldugunu dogrular
    And satista olanlar checkboxinin secili oldugunu dogrular
    Then yirmi urun dropdownina tiklar
    And yuz urunu secer
    And yuz urun seceneginin secildigini dogrular
    And sayfada yuz urun gorundugunu dogrular






