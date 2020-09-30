package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ViewAllBookingSteps {
	WebDriver driver;
	
	@Given("^User is on the Home Page$")
	public void user_is_on_the_Home_Page() throws Throwable {
		System.setProperty("webdriver.chrome.driver","E:\\SoftwareSetups\\Selinum Software\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:4200/flightBooking");
		driver.manage().window().maximize();		
	}

	@When("^User clicks on the ViewAllBookings$")
	public void user_clicks_on_the_ViewAllBookings() throws Throwable {
		driver.findElement(By.linkText("ViewAllBookings")).click();
	}

	@Then("^User should see all the bookings made\\.$")
	public void user_should_see_all_the_bookings_made() throws Throwable {
		System.out.println("All the booking done are shown here");
		
	}

}
