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
import com.kms.katalon.core.webui.common.EUtil

//OPEN WEBSITE
WebUI.openBrowser('')

WebUI.navigateToUrl('http://10.253.11.70/microsite')

WebUI.maximizeWindow()

//TAB 1
WebUI.click(findTestObject('KREDIT KENDARAAN/TOMBOL-KREDITKENDARAAN'))

WebUI.click(findTestObject('KREDIT KENDARAAN/RB-MOTOR'))

WebUI.click(findTestObject('KREDIT KENDARAAN/RB-BEKAS'))

String val = WebUI.getText(findTestObject('KREDIT KENDARAAN/RB-BEKAS'))

GlobalVariable.Kondisi = val

println('hasil = ' + val)

if (val == 'Bekas') {
    WebUI.click(findTestObject('KREDIT KENDARAAN/RB-BALIKNAMA'))
}

WebUI.selectOptionByIndex(findTestObject('KREDIT KENDARAAN/PILIHAN-TAHUNPEMBUATAN'), '2')

WebUI.setText(findTestObject('KREDIT KENDARAAN/TEXT-HARGAKENDARAAN'), GlobalVariable.dp)

//Hitung Min DP
String uangmuka = GlobalVariable.dp
int uangmuka1 = Double.valueOf(uangmuka) 
int result = uangmuka1 * 30 / 100
String mindp = result.toString()
println('hasil = ' + mindp)
GlobalVariable.minUM = mindp
println('Glob = ' + GlobalVariable.minUM)

WebUI.setText(findTestObject('KREDIT KENDARAAN/TEXT-UANGMUKA'), GlobalVariable.minUM)

WebUI.selectOptionByIndex(findTestObject('KREDIT KENDARAAN/PILIHAN-TENOR'), '3')

WebUI.delay(5)

WebUI.takeFullPageScreenshotAsCheckpoint('Tab 1 Motor')

WebUI.click(findTestObject('KREDIT KENDARAAN/TOMBOL-SELANJUTNYATSIMULASIKREDIT'))

//TAB 2
WebUI.click(findTestObject('KREDIT KENDARAAN/RB-SESUAIKTP'))

WebUI.setText(findTestObject('KREDIT KENDARAAN/TEXT-NAMA'), 'BIMO SETYO')

int RN = Math.floor(1000 + Math.random() * 9000);

WebUI.setText(findTestObject('KREDIT KENDARAAN/TEXT-NOKTP'), '351911090196' + RN)

WebUI.setText(findTestObject('KREDIT KENDARAAN/TOMBOL-TGLLAHIR'), '09/01/1996')

WebUI.setText(findTestObject('KREDIT KENDARAAN/TEXT-NOHP'), '082346578942')

WebUI.setText(findTestObject('KREDIT KENDARAAN/TEXT-EMAIL'), 'gajk@gmail.com')

WebUI.selectOptionByIndex(findTestObject('KREDIT KENDARAAN/PILIHAN_PEKERJAAN'), '4')

WebUI.click(findTestObject('KREDIT KENDARAAN/RB-STATUSTETAP'))

for ( int i=1; i<5; i++) {
	WebUI.click(findTestObject('KREDIT KENDARAAN/TOMBOL-TAMBAHWAKTU'))
}

WebUI.setText(findTestObject('KREDIT KENDARAAN/TEXT-PENGHASILANBULANAN'), '20000000')

WebUI.setText(findTestObject('KREDIT KENDARAAN/TEXT-PENGELUARANBULANAN'), '3000000')

WebUI.click(findTestObject('KREDIT KENDARAAN/RB-MENIKAH'))

WebUI.setText(findTestObject('KREDIT KENDARAAN/TEXT-JUMLAHTANGGUNGAN'), '3')

WebUI.setText(findTestObject('KREDIT KENDARAAN/TEXT-NOPLN'), '84736273819')

WebUI.setText(findTestObject('KREDIT KENDARAAN/TEXT-OUTLET'), 'SALEMBA')

WebUI.click(findTestObject('KREDIT KENDARAAN/RB-OUTLETJATI'))

WebUI.click(findTestObject('KREDIT KENDARAAN/RB-RADIUSYA'))

WebUI.takeFullPageScreenshotAsCheckpoint('Tab 2 Motor')

WebUI.click(findTestObject('KREDIT KENDARAAN/TOMBOL-SELANJUTNYADETAILPENGAJUAN'))

//TAB 3
WebUI.selectOptionByIndex(findTestObject('KREDIT KENDARAAN/PILIHAN-MEREKKENDARAAN'), '3')

WebUI.setText(findTestObject('KREDIT KENDARAAN/TEXT-TIPEKENDARAAN'), 'VARIO')

WebUI.click(findTestObject('KREDIT KENDARAAN/TOMBOL-SELANJUTNYADETAILKENDARAAN'))

WebUI.takeFullPageScreenshotAsCheckpoint('Tab 3 Motor')

WebUI.delay(5)

//TAB 4
WebUI.click(findTestObject('KREDIT KENDARAAN/CHECK-PERSETUJUAN'))

WebUI.takeFullPageScreenshotAsCheckpoint('Tab 4 Motor')

WebUI.click(findTestObject('KREDIT KENDARAAN/TOMBOL-AJUKAN'))

WebUI.delay(5)

WebUI.takeFullPageScreenshotAsCheckpoint('Ringkasan Pengajuan Motor')

WebUI.click(findTestObject('KREDIT KENDARAAN/TOMBOL-DAFTARPDS'))

WebUI.closeBrowser()