Feature: Yeni Cikan Kitaplar Alani

  Background:  Kullanici Kitap Yurdu Sayfasina Gider
    Given Kullanici "url" e gider
    Then yeni cikan kitaplar linkini tiklar
    Then haftalik yeni cikan kitaplar linkini tiklar

  @productfilter
  Scenario: TC02 Product Filter Alani
    Given Kullanici zaman olarak sonikiay secer
    And Kullanici varsayilan olarak pahalidanucuza secer
    And Kullanici satistaolanlar alanini isaretler
    And Kullanici stoktaolanlar alanini isaretler
    And Kullanici urun sayfa gorunumunu elli olarak isaretler

  Scenario Outline: TC03 varsayilan ddm elementleri secimi
    Then kullanici varsayilan olarak "<secim>" aratir
    And 3 saniye bekler
    Then basligin "<secim>" icerdigini dogrular
    Examples:
      | secim                    |
      | Satış Miktarı (Az > Çok) |
      | Satış Miktarı (Çok > Az) |
      | Ürün Adı (A - Z)         |
      | Ürün Adı (Z - A)         |
      | Ucuzdan > Pahalıya       |
      | Pahalıdan > Ucuza        |
      | Yüksek Oylama            |
      | Düşük Oylama             |

  Scenario: TC04 Sayfadaki UrunSayisi Alani
    Given Kullanici urun sayfa gorunumunu elli olarak isaretler
    And sayfada elli adet urun oldugunu dogrular

  Scenario: TC05 Sayfadaki Kitap Dil Checkbox Alani
    Given kullanici ingilizce kitaplar secenegini isaretler
    And kulanici turkce kitaplar secenegini isaretler
    And isaretlemelerin goruldugu test edilir

  Scenario: TC06 Sayfadaki Urun Fiyat Aralıgı Alani
    Given Kullanici urun fiyat aralıgını dusuk 20 yuksek 50 TL olarak secer
    And guncelle butonunu tiklar
    And goruntulenen tum kitaplarin fiyatinin 20 ile 50  TL araliginda oldugu test edilir

  @Excel
  Scenario: TC07 Sayfada searcbox alanında arama
    Given Kullanici searchbox alanında exceldeki kitapları arar
    And kullanici searchbox alaninda exceldeki yayinevlerini arar
    And kullanici searchbox alaninda exceldeki yazarlari arar

  @suggestForm
  Scenario: TC08 Sayfa kaydırma butonları
    Given Kullanici sayfa sonuna kaydirma butonuna tiklar
    And 1 saniye bekler
    And sayfa resmini alir

   @suggestForm
  Scenario: TC09 Oneri Dogrulama Alanı Capctha Negatif test
    Given Kullanici oneri form ikonunu tiklar
    And Acilan pencerede isim alanını doldurur
    Then e posta alanını doldurur
    Then Konu alanına Oneri seklinde giris yapar
    And Gorus alanina dokuzchar gorusunu yazar
    And Kullanici dogrulama alanına yanlıs bir deger girer
    Then Kullanici gonder butonunu tiklar
    And Kabul edilmeyen karakter sayisi uyarisini goruntuler
    And dogrulama kodu hatalidir mesajini goruntuler






