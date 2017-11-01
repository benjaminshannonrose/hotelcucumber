package com.hotelapp.cucumber.cucumberTest;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BookingsPage;
import pages.SignUpPage;
import pages.IndexPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class StepDefinitions {

    private WebDriver driver;
    private IndexPage indexPage;
    private SignUpPage signUpPage;
    private LoginPage loginPage;
    private BookingsPage bookingsPage;
    private PageHelper pageHelper;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bjami\\Desktop\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/index");
        indexPage = new IndexPage(driver);
        signUpPage = new SignUpPage(driver);
        loginPage = new LoginPage(driver);
        bookingsPage = new BookingsPage(driver);
        pageHelper = new PageHelper();
    }

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png"); //stick it in the report
        }
        driver.quit();
    }

    @Given("^user '(.*)' the '(.*)'$")
    public void verify_user_on_page(String methodString, String pageString) throws Throwable {
        Object page = pageHelper.createPageObject(pageString, driver);
        pageHelper.getMethodAndInvokeNoArgs(page, methodString);
    }

    @When("^user '(.*)' on the '(.*)'$")
    public void user_clicks_on_something_on_a_page(String methodString, String pageString) throws Throwable {
        Object page = pageHelper.createPageObject(pageString, driver);
        pageHelper.getMethodAndInvokeNoArgs(page, methodString);
    }

    @When("^user enters '(.*)' '(.*)' on the '(.*)'$")
    public void enter_data_into_element_on_a_page(String data, String methodString, String pageString) throws Throwable {
        Object page = pageHelper.createPageObject(pageString, driver);
        pageHelper.getMethodAndInvokeWithArgs(page, methodString, data);
    }

    @Then("^there should be an? '(.*)' on the '(.*)'$")
    public void there_should_be_an_error_message_on_a_page(String methodString, String pageString) throws Throwable {
        Object page = pageHelper.createPageObject(pageString, driver);
        pageHelper.getMethodAndInvokeNoArgs(page, methodString);
    }

    @Then("^user should land on home page with personalized greeting$")
    public void user_should_land_on_home_page_with_personalized_greeting() throws Throwable {
        indexPage.checkSignedIn();
    }

    @Then("^user should see list of hotels$")
    public void they_should_see_list_of_hotels() throws Throwable {
        indexPage.verifyHotelListPopulated();
    }

    @Then("^they should see both bookings$")
    public void they_should_see_both_bookings() throws Throwable {
        bookingsPage.verifyBookingListPopulated();
    }

    @Then("^they should see a google map of the hotel with details$")
    public void they_should_see_a_google_map_of_the_hotel_with_details() throws Throwable {
        bookingsPage.verifyGoogleMapContent();
    }

    @Then("^they should no longer see a booking after they click the button to delete it$")
    public void they_should_no_longer_see_a_booking_after_they_click_the_button_to_delete_it() throws Throwable {
        bookingsPage.clicksDeleteButtonAndVerifiesDeleted();
    }

    @Then("^scenario should fail$")
    public void scenario_should_fail() throws Throwable {
        fail("This scenario is a fail to test the screenshot on fail functionality");
    }

    @And("^they should be able to close the map$")
    public void they_should_be_able_to_close_the_map () throws Throwable {
        bookingsPage.closeGoogleMap();
    }
}