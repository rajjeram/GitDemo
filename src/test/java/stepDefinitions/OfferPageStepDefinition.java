package stepDefinitions;

import java.util.Iterator;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContextSetup;

public class OfferPageStepDefinition {
public String offerPageProductName;
TestContextSetup testContextSetup;

//Single responsibility Principle
//Loosely  coupled


public OfferPageStepDefinition(TestContextSetup testContextSetup)
{
	this.testContextSetup=testContextSetup;
}
//Sprint framework, EJB, 
	
	@Then("User searched for {string} shortname in offers page")
	public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exists(String shortName) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		
		switchToOffersPage();
		testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(2000);
		offerPageProductName =testContextSetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
		
		
	}
	public void switchToOffersPage()
	{
		//Object testContextStep;
		//if switched to offer page->skip below part
		//if(testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"))
		testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
		Set<String> s1= testContextSetup.driver.getWindowHandles();
		Iterator<String> i1 =s1.iterator();
		String parentWindow = i1.next();
		String childWindow = i1.next();
		testContextSetup.driver.switchTo().window(childWindow);
	
	}
		@Then("validate product name in offers page matches with Landing Page")
		public void validate_product_name_in_Offers_page()
		{
		Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
	}	
	
}
