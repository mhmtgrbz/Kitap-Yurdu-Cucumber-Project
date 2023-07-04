
Feature: Creating database
  Background:  Kullanici Kitap Yurdu Sayfasina Gider
    Given Kullanici "url" e gider
    And  database kaynagi baglantı saglanir

  Scenario Outline:
    Given kullanici database alaninda_"<baslik>"_alani kaynagi olusturur
    And UI alanında tum kitaplar basligini tiklar
    Then  acilan sayfada_"<baslik>"_alani kitaplarini listeler
    And listelenen sayfada ilk ve son kitaplari "<baslik>" databasede kontrol eder
    Examples:
      | baslik          |
      | Edebiyat        |
      | Cocuk_kitaplari |
      | Sinavlar        |
      | Bilgisayar      |
      | Tarih           |
