package com.epam.ta.steps;

import com.epam.ta.driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.epam.ta.pages.Account;
import com.epam.ta.pages.Applications;
import com.epam.ta.pages.CreateNewRepositoryPage;
import com.epam.ta.pages.LoginPage;
import com.epam.ta.pages.MainPage;
import com.epam.ta.pages.YourProfile;

public class Steps
{
	private WebDriver driver;

	private final Logger logger = LogManager.getRootLogger();

	public void initBrowser()
	{
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver()
	{
		DriverSingleton.closeDriver();
	}

	public void loginGithub(String username, String password)
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.login(username, password);
	}

	public boolean isLoggedIn(String username)
	{
		LoginPage loginPage = new LoginPage(driver);
		String actualUsername = loginPage.getLoggedInUserName().trim().toLowerCase();
		logger.info("Actual username: " + actualUsername);
		return actualUsername.equals(username);
	}

	public boolean createNewRepository(String repositoryName, String repositoryDescription)
	{
		MainPage mainPage = new MainPage(driver);
		mainPage.clickOnCreateNewRepositoryButton();
		CreateNewRepositoryPage createNewRepositoryPage = new CreateNewRepositoryPage(driver);
		String expectedRepoName = createNewRepositoryPage.createNewRepository(repositoryName, repositoryDescription);
		return expectedRepoName.equals(createNewRepositoryPage.getCurrentRepositoryName());
	}

	public boolean currentRepositoryIsEmpty()
	{
		CreateNewRepositoryPage createNewRepositoryPage = new CreateNewRepositoryPage(driver);
		return createNewRepositoryPage.isCurrentRepositoryEmpty();
	}
	
	public void updateName(String username)
	{
		YourProfile profile = new YourProfile(driver);
		profile.openPage();
		profile.updateName(username);
	}
	
	public String getName()
	{
		YourProfile profile = new YourProfile(driver);
		return profile.checkEnteredName();
	}
	
	public void deleteAccount()
	{
		Account account = new Account(driver);
		account.openPage();
		account.deleteAccount();	
	}
	
	public String getMessage()
	{
		Account account = new Account(driver);
		return account.checkMessage();
	}
	
	public void openAunthorizedApps()
	{
		Applications apps = new Applications(driver);
		apps.openPage();
		apps.openApps();	
	}
	
	public String getPassConfirmMessage()
	{
		Applications apps = new Applications(driver);
		return apps.checkConfirmMessage();
	}
	
			

}
