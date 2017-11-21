package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndexPage {

    private WebDriver driver;
    private By signUpButton = By.id("signUp");
    private By welcome = By.id("welcome");
    private By logOut = By.id("logOut");
    private By logIn = By.id("logIn");
    private By hotelSearchBar = By.id("hotelSearchBar");
    private By findHotel = By.id("findHotel");
    private By book = By.className("book");
    private By viewBookings = By.id("viewBookings");
    private By hotelName = By.className("hotelName");
    private By title = By.tagName("title");

    public IndexPage(WebDriver driver){
        this.driver = driver;
    }

    public void landsOn(){
        String pageTitle = driver.findElement(title).getAttribute("textContent");
        Assert.assertEquals("Index", pageTitle);
    }

    public void clicksSignUpLink(){
        driver.findElement(signUpButton).click();
    }

    public void checkSignedIn(){
        driver.findElement(welcome).getText();
    }

    public void clicksLogOutLink(){
        driver.findElement(logOut).click();
    }

    public void clicksLoginLink(){
        driver.findElement(logIn).click();
    }

    public void intoTheHotelSearchBar(String data){
        driver.findElement(hotelSearchBar).sendKeys(data);
    }

    public void clicksSearchButton(){
        driver.findElement(findHotel).click();
    }

    public void clicksBookHotelButton(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(book).get(1)));
        driver.findElements(book).get(1).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void clicksBookHotelButtonTwice(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(book).get(1)));
        driver.findElements(book).get(1).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(book).get(3)));
        driver.findElements(book).get(3).click();
    }

    public void clicksViewBookingsLink(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(viewBookings));
        driver.findElement(viewBookings).click();
    }

    public void verifyHotelListPopulated(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.numberOfElementsToBe(hotelName, 10));
        driver.findElements(hotelName);
    }
}
