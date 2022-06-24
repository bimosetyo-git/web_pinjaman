import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.SelectorMethod
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import internal.GlobalVariable
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.util.KeywordUtil
import org.openqa.selenium.Keys as Keys



class cicilKendaraan {

	@Given("Saya mengunjungi website microsite")
	def navigateToUrl() {

		WebUI.openBrowser('')

		WebUI.navigateToUrl(GlobalVariable.url)

		WebUI.maximizeWindow()

		'Screenshot'
		//WebUI.takeFullPageScreenshotAsCheckpoint('Dashboard')

	}

	@When("saya melakukan pengisian di tab 1 kendaraan(.*) dan kondisi(.*)")
	def inputTab1kendaraanBaru(String kendaraan,String kondisi) {

		'Click Menu Cicil Kendaran'
		WebUI.click(new TestObject().addProperty('class', ConditionType.EQUALS, 'landing-action-new-design-text ml-4'))

		'Verify Title'
		WebUI.verifyElementText(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[(text() = "Pengajuan Cicil Kendaraan" or . = "Baru")]'), 'Pengajuan Cicil Kendaraan')

		'Click Lihat Persyaratan'
		WebUI.click(new TestObject().addProperty('class', ConditionType.EQUALS, 'lihat-persyaratan'))

		'Click Close Persyaratan'
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="syarat-pengajuan"]/div/div/div[1]/button/span'))

		'Screenshot'
		//WebUI.takeFullPageScreenshotAsCheckpoint('Tab 1 Motor')

		'Click RB Motor'
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*[(text() = '$kendaraan' or . = '$kendaraan')]"))

		'Click RB Kondisi'
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*[(text() = '$kondisi' or . = '$kondisi')]"))

		if (kondisi == 'Bekas') {
			'Click Checkbox Baliknama'
			WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='bersediaBalikNama']"))
		}

		'Select Option Tahun Pembuatan'
		WebUI.selectOptionByIndex(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="tahun-pembuatan"]'), '2')

		'Input Harga Kendaraan'
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="hargaKendaraan"]'), '10000000')

		'Input Uang Muka'
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="uangMuka"]'), '6000000')

		'Select Option Tenor'
		WebUI.selectOptionByIndex(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="tenor"]'), '3')

		'Screenshot'
		//WebUI.takeFullPageScreenshotAsCheckpoint('TAB 1')

		'Click Selanjutnya Tab 1'
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[(text() = "Selanjutnya" or . = "Selanjutnya")]'))
	}

	@When("saya melakukan pengisian di tab 2 kendaraan")
	def inputTab2kendaraanBaru() {
		'Click RB Motor'
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[(text() = "Ya, sesuai KTP" or . = "Ya, sesuai KTP")]'))

		'Input Nama Sesuai KTP'
		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, 'namaCustomer'),'Automation Test')

		'Add random Number for KTP'
		int RN = Math.floor(1000 + Math.random() * 9000);

		'Input No KTP'
		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, 'noKtpCustomer'), '351911090196' + RN)

		'Input Tanggal Lahir'
		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, 'PengajuanTanggalLahirNasabah'), '09/01/1996')

		'Input No HP'
		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, 'noHpCustomer'), '0866543299')

		'Input Email'
		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, 'emailCustomer'), 'automation@testing.com')

		'Select Option Pekerjaan'
		WebUI.selectOptionByIndex(new TestObject().addProperty('id', ConditionType.EQUALS, 'pekerjaanCustomer'),'4')

		'Click Status Pekerjaan'
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//div[@id="statusPekerjaan"]/div/label'))

		'Input Masa Kerja'
		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, 'masa_kerja'), '3')

		'Click Masa Kerja'
		WebUI.click(new TestObject().addProperty('class', ConditionType.EQUALS, 'plus'))

		'Input Pendapatan Perbulan'
		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, 'penghasilan_bulanan'), '10000000')

		'Input Pengeluaran Bulanan'
		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, 'pengeluaran_bulanan'), '6000000')

		'Click Sudah Menikah'
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[(text() = "Menikah" or . = "Menikah")]'))

		'Click Jumlah Tanggungan'
		WebUI.click(new TestObject().addProperty('class', ConditionType.EQUALS, 'jumlah-tanggungan-plus'))

		'Input No Pln'
		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, 'no_id_pln'), '635263956293')

		'Input Cabang'
		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, 'outlet'), 'SALEMBA')

		'Click Cabang'
		WebUI.waitForElementClickable(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//table[@id="dataTableList"]/tbody/tr/td/div/label'), 10)
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//table[@id="dataTableList"]/tbody/tr/td/div/label'))

		'Click Radius Cabang'
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[(text() = "Ya, sudah sesuai" or . = "Ya, sudah sesuai")]'))

		'Screenshot'
		//WebUI.takeFullPageScreenshotAsCheckpoint('TAB 2')

		'Click Selanjutnya Tab 2'
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '/html/body/main/div[2]/form/section[3]/div/div/div[5]/div[2]/button/b'))
	}

	@When("saya melakukan pengisian di tab 3 kendaraan")
	def inputTab3kendaraanBaru() {

		'Select Option Merek Kendaraan'
		WebUI.selectOptionByIndex(new TestObject().addProperty('id', ConditionType.EQUALS, 'merkKendaraan'), '2')

		'Input Tipe Kendaraan'
		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, 'tipeKendaraan'), 'VARIO')

		'Screenshot'
		//WebUI.takeFullPageScreenshotAsCheckpoint('TAB 3')

		'Click Selanjutnya Tab 3'
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '/html/body/main/div[3]/form/section/div/div/div[3]/div[2]/button/b'))
	}

	@Then("saya verify pengajuan kendaraan sukses")
	def verifyTab4() {
		'verify ringkasan nama pengajuan'
		WebUI.verifyElementText(new TestObject().addProperty('id', ConditionType.EQUALS, 'ringkasanNama'), 'Automation Test')

		'verify ringkasan no hp pengajuan'
		WebUI.verifyElementText(new TestObject().addProperty('id', ConditionType.EQUALS, 'ringkasanNoHp'), '0866543299')

		'checkbox persetujuan'
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//form[@id="formInputTab4"]/section/div/div/div/div/label/small/b'))

		'Screenshot'
		//WebUI.takeFullPageScreenshotAsCheckpoint('TAB 4')

		'Click Ajukan Pembiayaan'
		WebUI.click(new TestObject().addProperty('id', ConditionType.EQUALS, 'btnAjukanPembiayaan'))

		'Screenshot'
		//WebUI.takeFullPageScreenshotAsCheckpoint('Submit Sukses')

		'Click Cek Pengajuan'
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[(text() = "Cek Status Pengajuan" or . = "Cek Status Pengajuan")]'))

		WebUI.closeBrowser()
	}

	@When("negative scenario tab 1")
	def negativeScenarioTab1() {

		'Click Menu Cicil Kendaran'
		WebUI.click(new TestObject().addProperty('class', ConditionType.EQUALS, 'landing-action-new-design-text ml-4'))

		'Verify Title'
		WebUI.verifyElementText(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[(text() = "Pengajuan Cicil Kendaraan" or . = "Baru")]'), 'Pengajuan Cicil Kendaraan')

		'Click RB Motor'
		WebUI.waitForElementClickable(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*[(text() = 'Motor' or . = 'Motor')]"), 10)
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*[(text() = 'Motor' or . = 'Motor')]"))

		'Click RB Kondisi'
		WebUI.waitForElementClickable(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*[(text() = 'Bekas' or . = 'Bekas')]"),10)
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*[(text() = 'Bekas' or . = 'Bekas')]"))

		'Select Option Tahun Pembuatan'
		WebUI.waitForElementClickable(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="tahun-pembuatan"]'),10)
		WebUI.selectOptionByIndex(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="tahun-pembuatan"]'), '2')

		'Input Harga Kendaraan'
		WebUI.waitForElementClickable(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="hargaKendaraan"]'),10)
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="hargaKendaraan"]'), '400000001')

		'Input Uang Muka'
		WebUI.waitForElementClickable(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="uangMuka"]'),10)
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="uangMuka"]'), '200000000')

		KeywordUtil.logInfo("VALIDASI UP MAKS")
		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*[(text() = 'Pinjaman Melebihi Batas Maksimal' or . = 'Pinjaman Melebihi Batas Maksimal')]"),5)

		'Click Validasi UP MAKS'
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*[@id = 'modalValidasihargakendaraan' and @style = 'padding-right: 17px; display: block;']"))

		'Input Harga Kendaraan'
		WebUI.waitForElementClickable(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="hargaKendaraan"]'),10)
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="hargaKendaraan"]'), '40000000')

		'Input Uang Muka'
		WebUI.waitForElementClickable(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="uangMuka"]'),10)
		WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="uangMuka"]'), '20000000')

		'Select Option Tenor'
		WebUI.selectOptionByIndex(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="tenor"]'), '3')

		'Screenshot'
		//WebUI.takeFullPageScreenshotAsCheckpoint('TAB 1')

		'Click Selanjutnya Tab 1'
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[(text() = "Selanjutnya" or . = "Selanjutnya")]'))

		KeywordUtil.logInfo("VALIDASI UP CHECKBOX REQUIRED")
		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*[@id = 'agree-balik-nama' and @aria-describedby='bersedia_balik_nama-error']"),5)

		'Click Checkbox Baliknama'
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//div[@id='bersediaBalikNama']"))

		'Click Selanjutnya Tab 1'
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[(text() = "Selanjutnya" or . = "Selanjutnya")]'))

		KeywordUtil.logInfo("VALIDASI TAB 1 SUCCESS")
	}

	@When("negative scenario tab 2")
	def negativeScenarioTab2() {
		
		'Click Selanjutnya Tab 2'
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '/html/body/main/div[2]/form/section[2]/div/div/div[2]/div[2]/button'))
		
		'Validasi Field Required'
		WebUI.verifyElementText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/main/div[2]/form/section[2]/div/div/div[1]/label[2]"),'Layanan hanya tersedia untuk alamat domisili yang sesuai dengan alamat KTP.')
		
		
		'Click RB Tidak Sesuai'
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[(text() = "Tidak sesuai" or . = "Tidak sesuai")]'))
		
		'Verify Confirmation Text'
		WebUI.verifyElementPresent(new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/main/div[2]/form/section[2]/div/div/div[3]/div[1]/div"),10)

		'Input Nama Sesuai KTP'
		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, 'namaCustomer'),'Automation Test')

		'Add random Number for KTP'
		int RN = Math.floor(1000 + Math.random() * 9000);

		'Input No KTP'
		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, 'noKtpCustomer'), '3519110901964564566' + RN)
		
		'Send Keys Text'
		WebUI.sendKeys(new TestObject().addProperty('id', ConditionType.EQUALS, 'noKtpCustomer'), Keys.chord(Keys.TAB))
		
		'Verify Field NIK More Than 16'
		WebUI.verifyElementText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*[@id = 'noKtpCustomer-error']"),'Please enter no more than 16 characters.')
		
		'Input No KTP'
		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, 'noKtpCustomer'), '64566' + RN)
		
		'Send Keys Text'
		WebUI.sendKeys(new TestObject().addProperty('id', ConditionType.EQUALS, 'noKtpCustomer'), Keys.chord(Keys.TAB))
		
		'Verify Field NIK Less Than 16'
		WebUI.verifyElementText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*[@id = 'noKtpCustomer-error']"),'Please enter at least 16 characters.')

		'Input No KTP'
		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, 'noKtpCustomer'), '351911090196' + RN)
		
		'Input Tanggal Lahir'
		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, 'PengajuanTanggalLahirNasabah'), '09/01/1990')
		
		'Verify Tgl Lahir'
		WebUI.verifyElementText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*[@id = 'PengajuanTanggalLahirNasabah-error']"),'Tanggal lahir tidak sesuai dengan data NIK')

		'Input Tanggal Lahir'
		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, 'PengajuanTanggalLahirNasabah'), '09/01/1996')
		
		'Input No HP'
		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, 'noHpCustomer'), '66543299')
		
		'Send Keys Text'
		WebUI.sendKeys(new TestObject().addProperty('id', ConditionType.EQUALS, 'noHpCustomer'), Keys.chord(Keys.TAB))

		'Verify Tgl Lahir'
		//*[@id = 'agree-balik-nama' and @aria-describedby='bersedia_balik_nama-error']
		//html/body/main/div[2]/form/section[2]/div/div/div[3]/div[5]/div
		WebUI.verifyElementText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*[@id = 'noHpCustomer-error' and @class='invalid-feedback']"),'Nomor handphone minimal 10 angka')
		
		'Input No HP'
		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, 'noHpCustomer'), '083456392769')
		
		'Input Email'
		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, 'emailCustomer'), 'automation@testing.com')

		'Select Option Pekerjaan'
		WebUI.selectOptionByIndex(new TestObject().addProperty('id', ConditionType.EQUALS, 'pekerjaanCustomer'),'4')

		'Click Status Pekerjaan'
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//div[@id="statusPekerjaan"]/div/label'))

		'Input Masa Kerja'
		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, 'masa_kerja'), '3')

		'Click Masa Kerja'
		WebUI.click(new TestObject().addProperty('class', ConditionType.EQUALS, 'plus'))

		'Input Pendapatan Perbulan'
		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, 'penghasilan_bulanan'), '10000000')

		'Input Pengeluaran Bulanan'
		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, 'pengeluaran_bulanan'), '6000000')

		'Click Sudah Menikah'
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[(text() = "Menikah" or . = "Menikah")]'))

		'Click Jumlah Tanggungan'
		WebUI.click(new TestObject().addProperty('class', ConditionType.EQUALS, 'jumlah-tanggungan-plus'))

		'Input No Pln'
		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, 'no_id_pln'), '635263956293')

		'Input Cabang'
		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, 'outlet'), 'SALEMBA')

		'Click Cabang'
		WebUI.waitForElementClickable(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//table[@id="dataTableList"]/tbody/tr/td/div/label'), 10)
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//table[@id="dataTableList"]/tbody/tr/td/div/label'))
		
		'Click Radius Cabang'
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[(text() = "Ya, sudah sesuai" or . = "Ya, sudah sesuai")]'))

		'Screenshot'
		//WebUI.takeFullPageScreenshotAsCheckpoint('TAB 2')

		'Click Selanjutnya Tab 2'
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '/html/body/main/div[2]/form/section[3]/div/div/div[5]/div[2]/button/b'))

	}
	
	@When("negative scenario tab 3")
	def negativeScenarioTab3() {
		
		'Click Selanjutnya Tab 1'
		WebUI.waitForElementClickable(new TestObject().addProperty('xpath', ConditionType.EQUALS, '/html/body/main/div[3]/form/section/div/div/div[3]/div[2]/button'),10)
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '/html/body/main/div[3]/form/section/div/div/div[3]/div[2]/button'))
		
		'Verify Field Required'
		WebUI.verifyElementText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*[@id = 'merkKendaraan-error']"),'This field is required.')
		
		WebUI.verifyElementText(new TestObject().addProperty('xpath', ConditionType.EQUALS, "//*[@id = 'tipeKendaraan-error']"),'This field is required.')
		
		KeywordUtil.logInfo("VALIDASI FIELD REQUIRED SUCCESS")
		
		'Select Option Merek Kendaraan'
		WebUI.selectOptionByIndex(new TestObject().addProperty('id', ConditionType.EQUALS, 'merkKendaraan'), '2')

		'Input Tipe Kendaraan'
		WebUI.setText(new TestObject().addProperty('id', ConditionType.EQUALS, 'tipeKendaraan'), 'VARIO')
		
		'Click Selanjutnya Tab 3'
		WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '/html/body/main/div[3]/form/section/div/div/div[3]/div[2]/button/b'))
		
		'verify ringkasan nama pengajuan'
		WebUI.verifyElementText(new TestObject().addProperty('id', ConditionType.EQUALS, 'ringkasanNama'), 'Automation Test')
		
		KeywordUtil.logInfo("ALL VALIDATION HAS BEEN TESTED")
	}
}