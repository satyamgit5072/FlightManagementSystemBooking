package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BookingSteps {
	
	WebDriver driver;
	
	@Given("^User is in the home page of the application$")
	public void user_is_in_the_home_page_of_the_application() throws Throwable {
		System.setProperty("webdriver.chrome.driver","E:\\SoftwareSetups\\Selinum Software\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:4200/flightBooking");
		driver.manage().window().maximize();
	}

	@When("^User clicks FlightBooking$")
	public void user_clicks_FlightBooking() throws Throwable {
		driver.findElement(By.linkText("FlightBooking")).click();  
	}

	@When("^User enters Source Airport$")
	public void user_enters_Source_Airport() throws Throwable {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement element=driver.findElement(By.name("source")); 
		Select se=new Select(element); 
		se.selectByIndex(1);
	}

	@When("^User enters Destination Airport$")
	public void user_enters_Destination_Airport() throws Throwable {
		WebElement element=driver.findElement(By.name("destination")); 
		Select se=new Select(element); 
		se.selectByIndex(3);
	}

	@When("^User enters the date on which he wants to travel$")
	public void user_enters_the_date_on_which_he_wants_to_travel() throws Throwable {
		WebElement element =driver.findElement(By.name("date"));
		element.sendKeys("02-10-2020");
	}

	@When("^User clicks search button$")
	public void user_clicks_search_button() throws Throwable {
		driver.findElement(By.cssSelector("div.container div.card:nth-child(4) div.card-body div.container:nth-child(1) div.row:nth-child(3) form.ng-touched.ng-dirty.ng-valid div.form-group button.btn.btn-sm.btn-info:nth-child(10) > b:nth-child(1)")).click();
	}

	@When("^User clicks repestive available flight for which he want to book$")
	public void user_clicks_repestive_available_flight_for_which_he_want_to_book() throws Throwable {
		driver.findElement(By.cssSelector("div.container div.card:nth-child(4) div.card-body div.container:nth-child(3) div.row:nth-child(3) div.col-sm-4 div.card div.card-body div.row div.col-sm-2 > button.btn.btn-sm.btn-info")).click();
	}

	@When("^User enters the passenger details$")
	public void user_enters_the_passenger_details() throws Throwable {
		driver.findElement(By.name("name")).sendKeys("Anil");
		driver.findElement(By.name("age")).sendKeys("25");
		WebElement element=driver.findElement(By.name("gender")); 
		Select se=new Select(element); 
		se.selectByIndex(1);
		driver.findElement(By.name("uniNumber")).sendKeys("89657456");
	}

	@When("^User clicks the conform booking button$")
	public void user_clicks_the_conform_booking_button() throws Throwable {
		driver.findElement(By.cssSelector("div.container div.card:nth-child(4) div.card-body div.row:nth-child(2) div.col-md-12 div.row div.col-md-3 > button.btn.btn-sm.btn-success.btn-space:nth-child(2)")).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
	}

	@When("^User clicks ok on the alert box showing flight booking successfull$")
	public void user_clicks_ok_on_the_alert_box_showing_flight_booking_successfull() throws Throwable {
		System.out.println("clicked ok on the alert");
	}

	@Then("^User should see the booked ticket deatails\\.$")
	public void user_should_see_the_booked_ticket_deatails() throws Throwable {
		System.out.println("User sees the booked ticket details");
	}

}
