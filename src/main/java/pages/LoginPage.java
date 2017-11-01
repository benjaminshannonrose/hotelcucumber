package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    By username = By.id("username");
    By password = By.id("password");
    By logInSubmit = By.id("logInSubmit");
    By logInError = By.id("logInError");
    By title = By.tagName("title");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void intoTheUsernameTextbox(String data){
        driver.findElement(username).sendKeys(data);
    }

    public void intoThePasswordTextbox(String data){
        driver.findElement(password).sendKeys(data);
    }

    public void clicksLoginButton(){
        driver.findElement(logInSubmit).click();
    }

    public void landsOn(){

        String pageTitle = driver.findElement(title).getAttribute("textContent");
        Assert.assertEquals("Login", pageTitle);
    }

    public void errorMessage(){
        driver.findElement(logInError);
    }

}
