package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {

    WebDriver driver;
    By username = By.id("username");
    By password = By.id("password");
    By passwordConfirm = By.id("passwordConfirm");
    By signUpSubmit = By.id("signUpSubmit");
    By usernameError = By.id("usernameError");
    By passwordError = By.id("passwordError");
    By confirmPasswordError = By.id("confirmPasswordError");

    public SignUpPage(WebDriver driver){
        this.driver = driver;
    }

    public void intoTheUsernameTextbox(String data){
        driver.findElement(username).sendKeys(data);
    }

    public void intoThePasswordTextbox(String data){
        driver.findElement(password).sendKeys(data);
    }

    public void intoTheConfirmationTextbox(String data){
        driver.findElement(passwordConfirm).sendKeys(data);
    }

    public void clicksSignUpButton(){
        driver.findElement(signUpSubmit).click();
    }

    public void usernameErrorMessage(){
        driver.findElement(usernameError);
    }

    public void passwordErrorMessage(){
        driver.findElement(passwordError);
    }

    public void confirmPasswordErrorMessage(){
        driver.findElement(confirmPasswordError);
    }
}
