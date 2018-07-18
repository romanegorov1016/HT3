package com.epam.ta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Account extends AbstractPage{
	
	private final String BASE_URL = "https://github.com/settings/admin";


	public Account(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath = "/html/body/div[3]/div[1]/div/div[2]/details[3]/summary")
	private WebElement deleteButton;
	
	@FindBy(xpath = "/html/body/div[3]/div[1]/div/div[2]/details[3]/details-dialog/div[1]/h2")
	private WebElement message;
	

	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
	}
	
	public void deleteAccount()
	{	
	    deleteButton.click();		
	}
	
	public String checkMessage()
	{
		String name=message.getText();
		return name;
	}
	

}

