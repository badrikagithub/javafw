package contactTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateMultipleContacts {

	ExcelFileUtility eUtil = new ExcelFileUtility();
	WebDriverUtility wUtil = new WebDriverUtility();
	PropertyFileUtility pUtil = new PropertyFileUtility();

	@Test(dataProvider = "getData")
	public void createMultipleContact(String LASTNAME) throws IOException, InterruptedException {
		
		WebDriver driver = null;

		// Step 1: Read all the required Data
		/* Common Data */
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");

		// Step 2: Launch the browser - PolyMorphism - Run Time - Driver
		if (BROWSER.equalsIgnoreCase("Chrome"))// true f
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("Firefox")) // t f
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("Edge"))// f
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("invalid Browser name");
		}

		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);

		// Step 3: Login To Application
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);

		// Step 4: Navigate to Contacts link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLnk();

		// Step 5: Click on create contact look Up Image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();

		// Step 6: create new Contact
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME);

		// Step 7: Validate
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactheader = cip.getContactHeader();
		if (contactheader.contains(LASTNAME)) {
			System.out.println(contactheader);
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}

		// Step 8: Logout
		hp.logoutOfApp(driver);

		// Step 9: Close the browser
		driver.quit();
	}

	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		return eUtil.readMultipleDataFromExcel("CreateMultipleContacts");
	}
}
