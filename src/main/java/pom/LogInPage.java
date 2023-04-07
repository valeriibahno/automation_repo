package pom;

import elements.Button;
import elements.Input;
import elements.Title;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage {

    @FindBy(xpath = "//div[@class='modal__header']/h3")
    private Title logInHeader;

    @FindBy(xpath = "//input[@id='auth_email']")
    private Input emailInput;

    @FindBy(xpath = "//input[@id='auth_pass']")
    private Input passwordInput;

    @FindBy(xpath = "//button[contains(@class,'auth-modal__submit')]")
    private Button submitButton;

    @FindBy(xpath = "//div[contains(@class,'auth-modal')]//fieldset//p")
    private Title errorMessageInvalidPassword;

    @FindBy(xpath = "//p[contains(@class,'error-message')]")
    private Title errorMessageInvalidEmail;

    public String getLogInHeader() {
        return logInHeader.getTitle();
    }

    public LogInPage clickEmailInput() {
        emailInput.click();
        return this;
    }

    public LogInPage fillEmailInput(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public LogInPage clickPasswordInput() {
        passwordInput.click();
        return this;
    }

    public LogInPage fillPasswordInput(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public LogInPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public String getErrorMessageInvalidPassword() {
        return errorMessageInvalidPassword.getTitle();
    }

    public String getErrorMessageInvalidEmail() {
        return errorMessageInvalidEmail.getTitle();
    }
}
