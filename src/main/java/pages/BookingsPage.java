package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingsPage {

    WebDriver driver;
    By hotelName = By.className("hotelName");
    By view = By.className("view");
    By logOut = By.id("logOut");
    By streetAddress = By.className("street-address");
    By close = By.cssSelector("button.close");
    By delete = By.className("delete");

    public BookingsPage(WebDriver driver){
        this.driver = driver;
    }

    public void verifyBookingListPopulated(){
        int bookingCount = driver.findElements(hotelName).size();
        Assert.assertEquals(2, bookingCount);
    }

    public void clicksLogOutLink(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(logOut));
        driver.findElement(logOut).click();
    }

    public void clicksViewBookingButton(){
        driver.findElements(view).get(0).click();
    }

    public void verifyGoogleMapContent(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(streetAddress));
        driver.findElement(streetAddress);
    }

    public void closeGoogleMap(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(close).click();
        wait.until(ExpectedConditions.attributeToBe(By.id("myModal"),"style", "display: none;"));
    }

    public void clicksDeleteButtonAndVerifiesDeleted(){
        int beforeDelete = driver.findElements(delete).size();
        driver.findElements(delete).get(1).click();
        driver.navigate().refresh();
        int afterDelete = driver.findElements(delete).size();
        Assert.assertEquals(beforeDelete-1,afterDelete);
    }
}
