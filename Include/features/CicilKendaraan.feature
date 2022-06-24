#Author: bimo.jannatha
Feature: Test Scenario kendaraan Baru

  @positifBaru
  Scenario Outline: Pengajuan Cicil Kendaraan
    Given Saya mengunjungi website microsite
    When saya melakukan pengisian di tab 1 kendaraan<kendaraan> dan kondisi<kondisi>
    When saya melakukan pengisian di tab 2 kendaraan
    When saya melakukan pengisian di tab 3 kendaraan
    Then saya verify pengajuan kendaraan sukses

    Examples: 
      | kendaraan | kondisi |
      | Motor     | Baru    |
      | Mobil     | Baru    |

  @positifBekas
  Scenario Outline: Pengajuan Cicil Kendaraan
    Given Saya mengunjungi website microsite
    When saya melakukan pengisian di tab 1 kendaraan<kendaraan> dan kondisi<kondisi>
    When saya melakukan pengisian di tab 2 kendaraan
    When saya melakukan pengisian di tab 3 kendaraan
    Then saya verify pengajuan kendaraan sukses

    Examples: 
      | kendaraan | kondisi |
      | Motor     | Bekas   |
      | Mobil     | Bekas   |

  @negatifCase
  Scenario: Pengajuan Cicil Kendaraan negative Case
    Given Saya mengunjungi website microsite
    When negative scenario tab 1
    When negative scenario tab 2
    When negative scenario tab 3
