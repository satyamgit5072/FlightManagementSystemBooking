package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BookingInformationSteps {

	WebDriver driver;
	
	@Given("^User in Home Page$")
	public void user_in_Home_Page() throws Throwable {
		System.setProperty("webdriver.chrome.driver","E:\\SoftwareSetups\\Selinum Software\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:4200/flightBooking");
		driver.manage().window().maximize();
	}

	@When("^User clicks the ViewAllBookings$")
	public void user_clicks_the_ViewAllBookings() throws Throwable {
		driver.findElement(By.linkText("ViewAllBookings")).click();
	}

	@When("^User clicks on the particular get booking button$")
	public void user_clicks_on_the_particular_get_booking_button() throws Throwable {
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("div.container div.card:nth-child(4) div.card-body div.panel.panel-primary div.panel-body table.table.table-striped tbody:nth-child(2) tr:nth-child(1) td:nth-child(7) > button.btn.btn-info:nth-child(2)")).click();
	}

	@Then("^User should see the complete information of the booking\\.$")
	public void user_should_see_the_complete_information_of_the_booking() throws Throwable {
		System.out.println("complete data of the booking is shown");
	}

}
