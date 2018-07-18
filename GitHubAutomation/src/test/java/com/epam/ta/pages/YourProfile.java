package com.epam.ta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourProfile extends AbstractPage{
	
	private final String BASE_URL = "https://github.com/settings/profile";


	public YourProfile(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"user_profile_name\"]")
	private WebElement nameField;
	
	@FindBy(xpath = "/html/body/div[4]/div[1]/div/div[2]/form[1]/div/p[2]/button")
	private WebElement updateProfile;
	

	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
	}
	
	public void updateName(String username)
	{
		nameField.sendKeys(username);	
		updateProfile.click();		
	}
	
	public String checkEnteredName()
	{
		String name=nameField.getText();
		return name;
	}
	

}
