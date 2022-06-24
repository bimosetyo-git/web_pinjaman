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
import com.kms.katalon.core.testobject.ConditionType as ConditionType

//OPEN WEBSITE
WebUI.openBrowser('')

WebUI.navigateToUrl('http://10.253.11.70/microsite')

WebUI.maximizeWindow()

//TAB 1
WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[(text() = \'Alternatif pembiayaan untuk miliki kendaraan impian kamu.\' or . = \'Alternatif pembiayaan untuk miliki kendaraan impian kamu.\')]'))

WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[(text() = \'Mobil\' or . = \'Mobil\')]'))

WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[(text() = \'Baru\' or . = \'Baru\')]'))

WebUI.selectOptionByIndex(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//select[@id=\'tahun-pembuatan\']'), 
    '2')

WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//input[@id=\'hargaKendaraan\']'), GlobalVariable.dp)

//Hitung Min DP
String uangmuka = GlobalVariable.dp

int uangmuka1 = Double.valueOf(uangmuka)

int result = (uangmuka1 * 40) / 100

String mindp = result.toString()

GlobalVariable.minUM = mindp

WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//input[@id=\'uangMuka\']'), GlobalVariable.minUM)

WebUI.selectOptionByIndex(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//select[@id=\'tenor\']'), '3')

WebUI.takeFullPageScreenshotAsCheckpoint('Tab 1 Mobil')

WebUI.delay(5)

WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//button[@type=\'submit\']'))

//TAB 2
WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[(text() = \'Ya, sesuai KTP\' or . = \'Ya, sesuai KTP\')]'))

WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//input[@id=\'namaCustomer\']'), 'BIMO SETYO')

int RN = Math.floor(1000 + (Math.random() * 9000))

WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//input[@id=\'noKtpCustomer\']'), '351911090196' + 
    RN)

WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//input[@id=\'PengajuanTanggalLahirNasabah\']'), 
    '09/01/1996')

WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//input[@id=\'noHpCustomer\']'), '082346578942')

WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//input[@id=\'emailCustomer\']'), 'gajk@gmail.com')

WebUI.selectOptionByIndex(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id = \'pekerjaanCustomer\']'), 
    '4')

WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//div[@id=\'statusPekerjaan\']/div/label'))

for (int i = 1; i < 5; i++) {
    WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@class = \'plus\']'))
}

WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id = \'penghasilan_bulanan\']'), '20000000')

WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id = \'pengeluaran_bulanan\']'), '1000000')

WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@class = \'custom-control-label\' and (text() = \'Belum Menikah\' or . = \'Belum Menikah\')]'))

WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id = \'no_id_pln\']'), '84736273819')

WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//input[@id=\'outlet\']'), 'SALEMBA')

WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//table[@id=\'dataTableList\']/tbody/tr/td/div/label'))

WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="checkOutletDomisili"]/div[1]/label'))

WebUI.takeFullPageScreenshotAsCheckpoint('Tab 2 Mobil')

WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//form[@id=\'formInputTab2\']/section[3]/div/div/div[5]/div[2]/button/b'))

//TAB 3
WebUI.selectOptionByIndex(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id = \'merkKendaraan\']'), '3')

WebUI.setText(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="tipeKendaraan"]'), 'VARIO')

WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id="formInputTab3"]/section/div/div/div[3]/div[2]/button'))

WebUI.delay(5)

WebUI.takeFullPageScreenshotAsCheckpoint('Tab 3 Mobil')

//TAB 4
WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//form[@id="formInputTab4"]/section/div/div/div/div/label/small/b'))

WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[@id = \'btnAjukanPembiayaan\' and (text() = \'Ajukan Pembiayaan\' or . = \'Ajukan Pembiayaan\')]'))

WebUI.takeFullPageScreenshotAsCheckpoint('Tab 4 Mobil')

WebUI.delay(5)

WebUI.takeFullPageScreenshotAsCheckpoint('Ringkasan Pengajuan Mobil')

WebUI.click(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//*[(text() = \'Cek Status Pengajuan\' or . = \'Cek Status Pengajuan\')]'))

WebUI.delay(2)

WebUI.closeBrowser()

