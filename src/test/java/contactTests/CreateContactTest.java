package contactTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class CreateContactTest extends BaseClass {

	@Test(groups = {"SmokeSuite","RegressionSuite"}) 
	public void createNewContactTest() throws IOException, InterruptedException
	{

		// Step 1: Read all the required Data
		/* Test Data */
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 1, 2);
		
		//Step 4: Navigate to Contacts link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLnk();
		
		//Step 5: Click on create contact look Up Image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();
	
		
		//Step 6: create new Contact
		CreateNewContactPage cncp =new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME);
		
		//Step 7: Validate
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactheader = cip.getContactHeader();
		Assert.assertTrue(contactheader.contains(LASTNAME));
		System.out.println(contactheader);
	

	}
	
	@Test
	public void demo()
	{
		System.out.println("demo");
		System.out.println("HI");
	}

}
