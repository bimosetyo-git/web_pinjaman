import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW

WebUI.openBrowser('')

WebUI.navigateToUrl('http://10.253.11.70/microsite')

WebUI.maximizeWindow()

//TAB 1
WebUI.click(findTestObject('PEMBIAYAAN/TOMBOL-PEMBIAYAAN'))

WebUI.click(findTestObject('PEMBIAYAAN/LABEL-PUNYAUSAHA'))

WebUI.selectOptionByIndex(findTestObject('PEMBIAYAAN/PILIHAN-AGUNAN'), '1')

WebUI.click(findTestObject('PEMBIAYAAN/RB-JENISKENDARAAN'))

WebUI.selectOptionByIndex(findTestObject('PEMBIAYAAN/PILIHAN-TAHUNPEMBUATAN'), '1')

//VALIDASAI MAKS UP
WebUI.setText(findTestObject('PEMBIAYAAN/TEXT-JUMLAHPINJAMAN'), '200,000,000')

WebUI.delay(2)

if (WebUI.verifyElementPresent(findTestObject('PEMBIAYAAN/TOMBOL-MENGERTINOTIFIKASI'), 10)) {
	WebUI.click(findTestObject('PEMBIAYAAN/TOMBOL-MENGERTINOTIFIKASI'))
	WebUI.takeFullPageScreenshotAsCheckpoint('Validasi UP Pembiayaan')
	println('Validation Max UP Is Exist')
} else {
	println('Validation Max UP Is Not Exist')
}

WebUI.setText(findTestObject('PEMBIAYAAN/TEXT-JUMLAHPINJAMAN'), '9,000,000')

WebUI.click(findTestObject('PEMBIAYAAN/PILIHAN-TENOR'))

WebUI.selectOptionByValue(findTestObject('PEMBIAYAAN/PILIHAN-TENOR'), '36', true)

WebUI.delay(5)

WebUI.click(findTestObject('PEMBIAYAAN/TOMBOL-SELANJUTNYA'))

//TAB 2
WebUI.click(findTestObject('PEMBIAYAAN/RB-KTPTIDAKSESUAI'))

if (WebUI.verifyElementPresent(findTestObject('PEMBIAYAAN/LABEL-DOMISILI'), 10, FailureHandling.OPTIONAL)) {
	WebUI.takeFullPageScreenshotAsCheckpoint('Validasi KTP Tidak Sesuai Domisili')
	println('Validation Domisili Is Exist')
} else {
	println('Validation Domisili Is Not Exist')
}

WebUI.setText(findTestObject('PEMBIAYAAN/TEXT-NAMACUSTOMER'), 'TESTING_IT')

int RN = Math.floor(1000 + Math.random() * 9000);
WebUI.setText(findTestObject('PEMBIAYAAN/TEXT-NOKTPCUSTOMER'), '35191109019673406' + RN)

WebUI.click(findTestObject('PEMBIAYAAN/TOMBOL-TGLLAHIR'))

if (WebUI.verifyElementPresent(findTestObject('PEMBIAYAAN/LABEL-VALIDASILENGTHKTP'), 10, FailureHandling.OPTIONAL)) {
	WebUI.setText(findTestObject('PEMBIAYAAN/TEXT-NOKTPCUSTOMER'), '351911090196' + RN)
	println('Validation Max Length KTP Is Exist')
} else {
	println('Validation MAX Length KTP Is Not Exist')
}

WebUI.setText(findTestObject('PEMBIAYAAN/TOMBOL-TGLLAHIR'), '29/12/2021')

WebUI.click(findTestObject('PEMBIAYAAN/TEXT-NOHPCUSTOMER'))

if (WebUI.verifyElementPresent(findTestObject('PEMBIAYAAN/TEXT-VALIDASITGLLAHIR'), 10, FailureHandling.OPTIONAL)) {
	WebUI.setText(findTestObject('PEMBIAYAAN/TOMBOL-TGLLAHIR'), '09/01/1996')
	println('Validation Tgl Lahir Is Exist')
} else {
	println('Validation Tgl Lahir Is Not Exist')
}

WebUI.setText(findTestObject('PEMBIAYAAN/TEXT-NOHPCUSTOMER'), '0865928364956523495696')

WebUI.click(findTestObject('PEMBIAYAAN/TEXT-EMAILCUSTOMER'))

if (WebUI.verifyElementPresent(findTestObject('PEMBIAYAAN/LABEL-VALIDASINOHP'), 10, FailureHandling.OPTIONAL)) {
	WebUI.setText(findTestObject('PEMBIAYAAN/TEXT-NOHPCUSTOMER'), '083718271381')
	println('Validation Max No Hp Is Exist')
} else {
	WebUI.closeBrowser()
	println('Validation Max No Hp Is Not Exist')
}

WebUI.setText(findTestObject('PEMBIAYAAN/TEXT-EMAILCUSTOMER'), 'ddd@gmail.com')

for ( int i=1; i<5; i++) {
	WebUI.click(findTestObject('PEMBIAYAAN/TOMBOL-TAMBAHWAKTU'))
}

WebUI.setText(findTestObject('PEMBIAYAAN/TEXT-PENGHASILANBULANAN'), '999000001')

WebUI.delay(1)

WebUI.setText(findTestObject('PEMBIAYAAN/TEXT-PENGHASILANBULANAN'), '15000000')

WebUI.setText(findTestObject('PEMBIAYAAN/TEXT-PENGELUARANBULANAN'), '999000001')

WebUI.delay(1)

WebUI.setText(findTestObject('PEMBIAYAAN/TEXT-PENGELUARANBULANAN'), '3000000')

WebUI.click(findTestObject('PEMBIAYAAN/RB-MENIKAH'))

WebUI.setText(findTestObject('PEMBIAYAAN/TEXT-JUMLAHTANGGUNGAN'), '100')

WebUI.setText(findTestObject('PEMBIAYAAN/TEXT-JUMLAHTANGGUNGAN'), '2')

WebUI.setText(findTestObject('PEMBIAYAAN/TEXT-NOPLN'), '847429382938291')

WebUI.click(findTestObject('PEMBIAYAAN/TEXT-OUTLET'))

if (WebUI.verifyElementPresent(findTestObject('PEMBIAYAAN/LABEL-VALIDASIPLN'), 10, FailureHandling.OPTIONAL)) {
	WebUI.setText(findTestObject('PEMBIAYAAN/TEXT-NOPLN'), '74837483')
	WebUI.click(findTestObject('PEMBIAYAAN/TEXT-OUTLET'))
	println('Validation Max and Min PLN Is Exist')
} else {
	println('Validation Max and Min PLN Is Not Exist')
}

if (WebUI.verifyElementPresent(findTestObject('PEMBIAYAAN/LABEL-VALIDASIPLN'), 10, FailureHandling.OPTIONAL)) {
	WebUI.setText(findTestObject('PEMBIAYAAN/TEXT-NOPLN'), '748374636478')
	println('Validation Max and Min PLN Is Exist')
} else {
	println('Validation Max and Min PLN Is Not Exist')
}

WebUI.setText(findTestObject('PEMBIAYAAN/TEXT-OUTLET'), 'JATINEGARA')

WebUI.delay(2)

WebUI.click(findTestObject('PEMBIAYAAN/RB-OUTLETJATI'))

WebUI.click(findTestObject('PEMBIAYAAN/RB-OUTLETTIDAKSESUAI'))

if (WebUI.verifyElementPresent(findTestObject('PEMBIAYAAN/TOMBOL-VALIDASIOUTLET'), 10, FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('PEMBIAYAAN/TOMBOL-VALIDASIOUTLET'))
	WebUI.click(findTestObject('PEMBIAYAAN/RB-RADIUSYA'))
	println('Validation Outlet Is Exist')
} else {
	println('Validation Outlet Is Not Exist')
}

WebUI.delay(5)

WebUI.click(findTestObject('PEMBIAYAAN/TOMBOL-SELANJUTNYADETAILPENGAJUAN'))

//tab 3
WebUI.selectOptionByIndex(findTestObject('PEMBIAYAAN/PILIHAN-MEREKKENDARAAN'), '3')

WebUI.setText(findTestObject('PEMBIAYAAN/TEXT-TIPEKENDARAAN'), 'MIO')

WebUI.setText(findTestObject('PEMBIAYAAN/TEXT-NOPOL'), 'AE-9839-KKKKK')

WebUI.takeFullPageScreenshotAsCheckpoint('Validasi No POL')

WebUI.click(findTestObject('PEMBIAYAAN/PILIHAN-KEPEMILIKAN'))

if (WebUI.verifyElementPresent(findTestObject('PEMBIAYAAN/LABEL-VALIDASINOPOL'), 10, FailureHandling.OPTIONAL)) {
	WebUI.setText(findTestObject('PEMBIAYAAN/TEXT-NOPOL'), 'AE-9839-KKK')
	println('Validation Nopol Is Exist')
} else {
	println('Validation Nopol Is Not Exist')
}

WebUI.selectOptionByIndex(findTestObject('PEMBIAYAAN/PILIHAN-KEPEMILIKAN'), '2')

WebUI.delay(5)

WebUI.click(findTestObject('PEMBIAYAAN/TOMBOL-SELANJUTNYADETAILAGUNAN'))

//Tab 4
WebUI.click(findTestObject('KREDIT KENDARAAN/CHECK-PERSETUJUAN'))

WebUI.click(findTestObject('KREDIT KENDARAAN/TOMBOL-AJUKAN'))

WebUI.delay(5)

WebUI.click(findTestObject('PEMBIAYAAN/TOMBOL-DAFTARPDS'))

WebUI.closeBrowser()