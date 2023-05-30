Feature: Yeni Cikan Kitaplar Alani

  Background: : Kullanici Kitap Yurdu Sayfasina Gider
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
