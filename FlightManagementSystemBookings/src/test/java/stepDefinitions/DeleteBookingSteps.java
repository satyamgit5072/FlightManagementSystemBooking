package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DeleteBookingSteps {

WebDriver driver;

@Given("^User is in the Home Page$")
public void user_is_in_the_Home_Page() throws Throwable {
	System.setProperty("webdriver.chrome.driver","E:\\SoftwareSetups\\Selinum Software\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("http://localhost:4200/flightBooking");
	driver.manage().window().maximize();
}

@When("^User clicks ViewAllBookings$")
public void user_clicks_ViewAllBookings() throws Throwable {
	driver.findElement(By.linkText("ViewAllBookings")).click();
}

@When("^User clicks on the delete button on the existing bookings$")
public void user_clicks_on_the_delete_button_on_the_existing_bookings() throws Throwable {
	driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	driver.findElement(By.cssSelector("div.container div.card:nth-child(4) div.card-body div.panel.panel-primary div.panel-body table.table.table-striped tbody:nth-child(2) tr:nth-child(1) td:nth-child(7) > button.btn.btn-danger:nth-child(1)")).click();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	Alert alert=driver.switchTo().alert(); 
	String alertmessage=driver.switchTo().alert().getText(); 
	System.out.println(alertmessage); 
	alert.accept();
}

@Then("^User should see the message booking deleted succesfully\\.$")
public void user_should_see_the_message_booking_deleted_succesfully() throws Throwable {
	System.out.println("booking deleted succesfully");
}

}
