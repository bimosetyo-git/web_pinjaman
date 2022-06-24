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
import com.kms.katalon.core.webui.common.EUtil as EUtil

//OPEN WEBSITE
WebUI.openBrowser('')

WebUI.navigateToUrl('http://10.253.11.70/microsite')

WebUI.maximizeWindow()

//TAB 1
WebUI.click(findTestObject('KREDIT KENDARAAN/TOMBOL-KREDITKENDARAAN'))

WebUI.click(findTestObject('KREDIT KENDARAAN/RB-MOBIL'))

WebUI.click(findTestObject('KREDIT KENDARAAN/RB-BEKAS'))

WebUI.selectOptionByIndex(findTestObject('KREDIT KENDARAAN/PILIHAN-TAHUNPEMBUATAN'), '2')

//Validasi Maks UP up - dp < 200 juta
WebUI.setText(findTestObject('KREDIT KENDARAAN/TEXT-HARGAKENDARAAN'), '400000001')

WebUI.setText(findTestObject('KREDIT KENDARAAN/TEXT-UANGMUKA'), '200000000')

WebUI.delay(2)

WebUI.verifyElementPresent(findTestObject('KREDIT KENDARAAN/TOMBOL-MENGERTIMAKSUP'), 10)

WebUI.takeFullPageScreenshotAsCheckpoint('Validasi UP Cicil')

WebUI.click(findTestObject('KREDIT KENDARAAN/TOMBOL-MENGERTIMAKSUP'))

//Validasi min DP
WebUI.setText(findTestObject('KREDIT KENDARAAN/TEXT-HARGAKENDARAAN'), '30000000')

WebUI.setText(findTestObject('KREDIT KENDARAAN/TEXT-UANGMUKA'), '1000000')

WebUI.verifyElementPresent(findTestObject('KREDIT KENDARAAN/LABEL-VALIDASIMINDP'), 10)

WebUI.takeFullPageScreenshotAsCheckpoint('Validasi Min DP Cicil')

WebUI.setText(findTestObject('KREDIT KENDARAAN/TEXT-HARGAKENDARAAN'), '30000000')

WebUI.setText(findTestObject('KREDIT KENDARAAN/TEXT-UANGMUKA'), '20000000')

WebUI.selectOptionByIndex(findTestObject('KREDIT KENDARAAN/PILIHAN-TENOR'), '3')

WebUI.delay(5)

WebUI.click(findTestObject('KREDIT KENDARAAN/TOMBOL-SELANJUTNYATSIMULASIKREDIT'))

WebUI.delay(2)

WebUI.click(findTestObject('KREDIT KENDARAAN/RB-BALIKNAMA'))

WebUI.click(findTestObject('KREDIT KENDARAAN/TOMBOL-SELANJUTNYATSIMULASIKREDIT'))

//TAB 2
//Validasi KTP Sesuai
WebUI.click(findTestObject('KREDIT KENDARAAN/RB-SESUAIKTP'))

WebUI.verifyElementPresent(findTestObject('KREDIT KENDARAAN/LABEL-DOMISILI'), 10)

WebUI.takeFullPageScreenshotAsCheckpoint('Text Konfirmasi Tidak Sesuai KTP')

WebUI.setText(findTestObject('KREDIT KENDARAAN/TEXT-NAMA'), 'BIMO SETYO')

int RN = Math.floor(1000 + (Math.random() * 9000))

//Validasi Maks Length KTP
WebUI.setText(findTestObject('KREDIT KENDARAAN/TEXT-NOKTP'), '35191109019642' + RN)

WebUI.click(findTestObject('KREDIT KENDARAAN/TOMBOL-TGLLAHIR'))

WebUI.takeFullPageScreenshotAsCheckpoint('Validasi Lenght KTP')

if (WebUI.verifyElementPresent(findTestObject('KREDIT KENDARAAN/TOMBOL-VALIDASILENGTHKTP'), 10, FailureHandling.OPTIONAL)) {
    WebUI.setText(findTestObject('KREDIT KENDARAAN/TEXT-NOKTP'), '351911090196' + RN)

    println('Validation Is Exist')
} else {
    println('Validation Is Not Exist')
}

WebUI.setText(findTestObject('KREDIT KENDARAAN/TOMBOL-TGLLAHIR'), '29/12/2021')

WebUI.click(findTestObject('KREDIT KENDARAAN/TEXT-NOHP'))

WebUI.takeFullPageScreenshotAsCheckpoint('Validasi Tgl Lahir')

if (WebUI.verifyElementPresent(findTestObject('KREDIT KENDARAAN/TEXT-VALIDASITGLLAHIR'), 10, FailureHandling.OPTIONAL)) {
    WebUI.setText(findTestObject('KREDIT KENDARAAN/TOMBOL-TGLLAHIR'), '09/01/1996')

    println('Validation Is Exist')
} else {
    println('Validation Is Not Exist')
}

//Validasi Maks Length No Hp
WebUI.setText(findTestObject('KREDIT KENDARAAN/TEXT-NOHP'), '0823465789424536564646')

WebUI.click(findTestObject('KREDIT KENDARAAN/TEXT-EMAIL'))

WebUI.takeFullPageScreenshotAsCheckpoint('Validasi Length No HP')

if (WebUI.verifyElementPresent(findTestObject('KREDIT KENDARAAN/TOMBOL-VALIDASINOHP'), 10, FailureHandling.OPTIONAL)) {
    WebUI.setText(findTestObject('KREDIT KENDARAAN/TEXT-NOHP'), '082346578942')

    println('Validation Is Exist')
} else {
    println('Validation Is Not Exist')
}

WebUI.setText(findTestObject('KREDIT KENDARAAN/TEXT-EMAIL'), 'gajk@gmail.com')

WebUI.selectOptionByIndex(findTestObject('KREDIT KENDARAAN/PILIHAN_PEKERJAAN'), '4')

//Validasasi Status Kontrak
WebUI.click(findTestObject('KREDIT KENDARAAN/RB-STATUSKONTRAK'))

if (WebUI.verifyElementPresent(findTestObject('KREDIT KENDARAAN/TOMBOL-VALIDASISTATUSKONTRAK'), 10, FailureHandling.OPTIONAL)) {
    WebUI.takeFullPageScreenshotAsCheckpoint('Validasi Status Pekerjaan Kontrak')

    WebUI.click(findTestObject('KREDIT KENDARAAN/TOMBOL-VALIDASISTATUSKONTRAK'))

    WebUI.click(findTestObject('KREDIT KENDARAAN/RB-STATUSTETAP'))

    println('Validation Is Exist')
} else {
    println('Validation Is Not Exist')
}

for (int i = 1; i < 5; i++) {
    WebUI.click(findTestObject('KREDIT KENDARAAN/TOMBOL-TAMBAHWAKTU'))
}

WebUI.setText(findTestObject('KREDIT KENDARAAN/TEXT-PENGHASILANBULANAN'), '999000001')

WebUI.setText(findTestObject('KREDIT KENDARAAN/TEXT-PENGHASILANBULANAN'), '15000000')

WebUI.setText(findTestObject('KREDIT KENDARAAN/TEXT-PENGELUARANBULANAN'), '999000001')

WebUI.setText(findTestObject('KREDIT KENDARAAN/TEXT-PENGELUARANBULANAN'), '3000000')

WebUI.click(findTestObject('KREDIT KENDARAAN/RB-MENIKAH'))

WebUI.setText(findTestObject('KREDIT KENDARAAN/TEXT-JUMLAHTANGGUNGAN'), '100')

WebUI.setText(findTestObject('KREDIT KENDARAAN/TEXT-JUMLAHTANGGUNGAN'), '1')

WebUI.setText(findTestObject('KREDIT KENDARAAN/TEXT-NOPLN'), '84736819')

WebUI.click(findTestObject('KREDIT KENDARAAN/TEXT-OUTLET'))

if (WebUI.verifyElementPresent(findTestObject('KREDIT KENDARAAN/TOMBOL-VALIDASIPLN'), 10, FailureHandling.OPTIONAL)) {
    WebUI.setText(findTestObject('KREDIT KENDARAAN/TEXT-NOPLN'), '84736273816463459')

    WebUI.takeFullPageScreenshotAsCheckpoint('Validasi Length No PLN')

    println('Validation Is Exist')
} else {
    println('Validation Is Not Exist')
}

WebUI.click(findTestObject('KREDIT KENDARAAN/TEXT-OUTLET'))

if (WebUI.verifyElementPresent(findTestObject('KREDIT KENDARAAN/TOMBOL-VALIDASIPLN'), 10, FailureHandling.OPTIONAL)) {
    WebUI.setText(findTestObject('KREDIT KENDARAAN/TEXT-NOPLN'), '75847283728')

    WebUI.takeFullPageScreenshotAsCheckpoint('Validasi Length No PLN')

    println('Validation Is Exist')
} else {
    println('Validation Is Not Exist')
}

WebUI.setText(findTestObject('KREDIT KENDARAAN/TEXT-OUTLET'), 'SALEMBA')

WebUI.delay(2)

WebUI.click(findTestObject('KREDIT KENDARAAN/RB-OUTLETJATI'))

WebUI.click(findTestObject('KREDIT KENDARAAN/RB-OUTLETTIDAKSESUAI'))

WebUI.takeFullPageScreenshotAsCheckpoint('Validasi Outlet Sesuai')

if (WebUI.verifyElementPresent(findTestObject('KREDIT KENDARAAN/TOMBOL-VALIDASIOUTLET'), 10, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('KREDIT KENDARAAN/TOMBOL-VALIDASIOUTLET'))

    WebUI.click(findTestObject('KREDIT KENDARAAN/RB-RADIUSYA'))

    println('Validation Is Exist')
} else {
    println('Validation Is Not Exist')
}

WebUI.click(findTestObject('KREDIT KENDARAAN/TOMBOL-SELANJUTNYADETAILPENGAJUAN'))

//TAB 3
WebUI.selectOptionByIndex(findTestObject('KREDIT KENDARAAN/PILIHAN-MEREKKENDARAAN'), '3')

WebUI.setText(findTestObject('KREDIT KENDARAAN/TEXT-TIPEKENDARAAN'), 'VARIO')

WebUI.click(findTestObject('KREDIT KENDARAAN/TOMBOL-SELANJUTNYADETAILKENDARAAN'))

WebUI.delay(5)

//TAB 4
WebUI.click(findTestObject('KREDIT KENDARAAN/CHECK-PERSETUJUAN'))

WebUI.click(findTestObject('KREDIT KENDARAAN/TOMBOL-AJUKAN'))

WebUI.delay(5)

WebUI.click(findTestObject('KREDIT KENDARAAN/TOMBOL-DAFTARPDS'))

WebUI.delay(5)

WebUI.closeBrowser()

