package objectRepository;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;


public class CreateNewOrganizationPage extends WebDriverUtility {

	// Declaration
	@FindBy(name = "accountname")
	private WebElement OrgNameEdt;

	@FindBy(name = "industry")
	private WebElement IndustryDropDwn;
	
	@FindBy(name = "accounttype")
	private WebElement typeDropDown;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	// initializations
	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// utilization
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDwn() {
		return IndustryDropDwn;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}
	
	//Business Library
	/**
	 * This method will create new organization with mandatory fields
	 * @param ORGNAME
	 */
	public void createNewOrganization(String ORGNAME)
	{
		OrgNameEdt.sendKeys(ORGNAME);
		SaveBtn.click();
	}
	
	/**
	 * this method will create new Organization with industry dropdown
	 * @param ORGNAME
	 * @param INDUSTRYNAME
	 */
	public void createNewOrganization(String ORGNAME, String INDUSTRYNAME)
	{
		OrgNameEdt.sendKeys(ORGNAME);
		handleDropdown(IndustryDropDwn, INDUSTRYNAME);
		SaveBtn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
