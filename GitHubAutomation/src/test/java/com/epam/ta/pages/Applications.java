package com.epam.ta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Applications extends AbstractPage{
	
	private final String BASE_URL = "https://github.com/settings/installations";


	public Applications(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath = "/html/body/div[4]/div[1]/div/div[2]/div[2]/nav/a[2]")
	private WebElement authorizedAppsButton;
	
	@FindBy(xpath = "/html/body/div[3]/div[1]/div/form/div[1]/h1")
	private WebElement passwordConfirmMessage;
	

	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
	}
	
	public void openApps()
	{	
		authorizedAppsButton.click();		
	}
	
	public String checkConfirmMessage()
	{
		String value=passwordConfirmMessage.getText();
		return value;
	}
	

}


