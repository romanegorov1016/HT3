package com.epam.ta;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.ta.steps.Steps;

public class GitHubAutomationTest
{
	private Steps steps;
	private final String USERNAME = "romanegorov1016@gmail.com";
	private final String PASSWORD = "9745erre5479";
	private final String NAME = "PapinBrodyaga";
	private final String DELETING_ACCOUNT_MESSAGE="Are you sure you want to do this?";
	private final String PASSWORD_CONFIRMING_MESSAGE="Confirm password to continue";

	@BeforeMethod(description = "Init browser")
	public void setUp()
	{
		steps = new Steps();
		steps.initBrowser();
	}

	@Test
	public void oneCanCreateProject()
	{
		steps.loginGithub(USERNAME, PASSWORD);
		Assert.assertTrue(steps.createNewRepository("testRepo", "auto-generated test repo"));
		Assert.assertTrue(steps.currentRepositoryIsEmpty());
		// do not use lots of asserts
	}

	@Test(description = "Login to Github")
	public void oneCanLoginGithub()
	{
		steps.loginGithub(USERNAME, PASSWORD);
		Assert.assertTrue(steps.isLoggedIn(USERNAME));
	}
	
	@Test
	public void updatePrifileName()
	{
		steps.updateName(NAME);
		Assert.assertEquals(NAME,steps.getName());
	}
	
	@Test
	public void deletingAccountMessege()
	{
		steps.deleteAccount();
		Assert.assertEquals(DELETING_ACCOUNT_MESSAGE,steps.getMessage());
	}
	
	@Test
	public void AppsMessage()
	{
		steps.openAunthorizedApps();
		Assert.assertEquals(PASSWORD_CONFIRMING_MESSAGE,steps.getPassConfirmMessage());
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser()
	{
		steps.closeDriver();
	}

}
