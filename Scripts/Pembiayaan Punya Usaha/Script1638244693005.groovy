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

WebUI.setText(findTestObject('PEMBIAYAAN/TEXT-JUMLAHPINJAMAN'), '7,000,000')

WebUI.click(findTestObject('PEMBIAYAAN/PILIHAN-TENOR'))

WebUI.selectOptionByValue(findTestObject('PEMBIAYAAN/PILIHAN-TENOR'), '36', true)

WebUI.delay(5)

WebUI.takeFullPageScreenshotAsCheckpoint('Tab 1 Usaha')

WebUI.click(findTestObject('PEMBIAYAAN/TOMBOL-SELANJUTNYA'))

//TAB 2
WebUI.click(findTestObject('PEMBIAYAAN/RB-KTPTIDAKSESUAI'))

if (WebUI.verifyElementPresent(findTestObject('PEMBIAYAAN/LABEL-DOMISILI'), 10, FailureHandling.OPTIONAL)) {
	println('Validation Domisili Is Exist')
} else {
	println('Validation Domisili Is Not Exist')
}

WebUI.setText(findTestObject('PEMBIAYAAN/TEXT-NAMACUSTOMER'), 'TESTING_IT')

int RN = Math.floor(1000 + Math.random() * 9000);

WebUI.setText(findTestObject('PEMBIAYAAN/TEXT-NOKTPCUSTOMER'), '351911090196' + RN)

WebUI.setText(findTestObject('PEMBIAYAAN/TOMBOL-TGLLAHIR'), '09/01/1996')

WebUI.setText(findTestObject('PEMBIAYAAN/TEXT-NOHPCUSTOMER'), '0812121212121')

WebUI.setText(findTestObject('PEMBIAYAAN/TEXT-EMAILCUSTOMER'), 'ddd@gmail.com')

for ( int i=1; i<5; i++) {
	WebUI.click(findTestObject('PEMBIAYAAN/TOMBOL-TAMBAHWAKTU'))
}

WebUI.setText(findTestObject('PEMBIAYAAN/TEXT-PENGHASILANBULANAN'), '10000000')

WebUI.setText(findTestObject('PEMBIAYAAN/TEXT-PENGELUARANBULANAN'), '2000000')

WebUI.click(findTestObject('PEMBIAYAAN/RB-MENIKAH'))

WebUI.click(findTestObject('PEMBIAYAAN/TOMBOL-TAMBAHORANG'))

WebUI.setText(findTestObject('PEMBIAYAAN/TEXT-NOPLN'), '441121101343')

WebUI.setText(findTestObject('PEMBIAYAAN/TEXT-OUTLET'), 'JATINEGARA')

WebUI.click(findTestObject('PEMBIAYAAN/RB-OUTLETJATI'))

WebUI.click(findTestObject('PEMBIAYAAN/RB-RADIUSYA'))

WebUI.delay(5)

WebUI.takeFullPageScreenshotAsCheckpoint('Tab 2 Usaha')

WebUI.click(findTestObject('PEMBIAYAAN/TOMBOL-SELANJUTNYADETAILPENGAJUAN'))

//tab 3
WebUI.selectOptionByIndex(findTestObject('PEMBIAYAAN/PILIHAN-MEREKKENDARAAN'), '3')

WebUI.setText(findTestObject('PEMBIAYAAN/TEXT-TIPEKENDARAAN'), 'MIO')

WebUI.setText(findTestObject('PEMBIAYAAN/TEXT-NOPOL'), 'AE-9839-KKK')

WebUI.selectOptionByIndex(findTestObject('PEMBIAYAAN/PILIHAN-KEPEMILIKAN'), '2')

WebUI.takeFullPageScreenshotAsCheckpoint('Tab 3 Usaha')

WebUI.delay(5)

WebUI.click(findTestObject('PEMBIAYAAN/TOMBOL-SELANJUTNYADETAILAGUNAN'))

//Tab 4
WebUI.click(findTestObject('KREDIT KENDARAAN/CHECK-PERSETUJUAN'))

WebUI.takeFullPageScreenshotAsCheckpoint('Tab 4 Usaha')

WebUI.click(findTestObject('KREDIT KENDARAAN/TOMBOL-AJUKAN'))

WebUI.takeFullPageScreenshotAsCheckpoint('Ringkasan Usaha')

WebUI.delay(5)

WebUI.click(findTestObject('PEMBIAYAAN/TOMBOL-DAFTARPDS'))

WebUI.closeBrowser()


