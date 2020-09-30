package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AvailableFlightsStep {
	WebDriver driver;
	
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		System.setProperty("webdriver.chrome.driver","E:\\SoftwareSetups\\Selinum Software\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:4200/flightBooking");
		driver.manage().window().maximize();
	}

	@When("^User clicks on the FlightBooking$")
	public void user_clicks_on_the_FlightBooking() throws Throwable {
		driver.findElement(By.linkText("FlightBooking")).click();    
		
	}

	@When("^User selects the Source Airport$")
	public void user_selects_the_Source_Airport() throws Throwable {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement element=driver.findElement(By.name("source")); 
		Select se=new Select(element); 
		se.selectByIndex(1);

	}

	@When("^User selects the Destination Airport$")
	public void user_selects_the_Destination_Airport() throws Throwable {
		WebElement element=driver.findElement(By.name("destination")); 
		Select se=new Select(element); 
		se.selectByIndex(3);
	}

	@When("^User selects the date on which he wants to travel$")
	public void user_selects_the_date_on_which_he_wants_to_travel() throws Throwable {
		WebElement element =driver.findElement(By.name("date"));
		element.sendKeys("02-10-2020");
		
	}
	
	@When("^User click the search button$")
	public void user_click_the_search_button() throws Throwable {
		driver.findElement(By.cssSelector("div.container div.card:nth-child(4) div.card-body div.container:nth-child(1) div.row:nth-child(3) form.ng-touched.ng-dirty.ng-valid div.form-group button.btn.btn-sm.btn-info:nth-child(10) > b:nth-child(1)")).click();
	}

	@Then("^User should see a available flights on that day\\.$")
	public void user_should_see_a_available_flights_on_that_day() throws Throwable {
		System.out.println("Flights showed successfully");
	}


}
