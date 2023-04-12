package bo;

import io.qameta.allure.Step;
import org.testng.Assert;
import pom.LogInPage;
import services.Constants;

public class LogInBO extends BaseBO {

    private final LogInPage logInPage = new LogInPage();

    @Step("Fill email and password for login")
    public LogInBO fillEmailAndPassword(String email, String password) {
        logInPage
                .clickEmailInput()
                .fillEmailInput(email)
                .clickPasswordInput()
                .fillPasswordInput(password)
                .clickSubmitButton();
        return this;
    }

    @Step("Verify error message for invalid email")
    public LogInBO verifyErrorMessageInvalidEmail() {
        LOGGER.info("Verify error message for invalid email");
        Assert.assertEquals(logInPage.getErrorMessageInvalidEmail(), Constants.ERROR_INVALID_EMAIL, "Wrong message for invalid email is displayed");
        return this;
    }

    @Step("Verify error message with captcha")
    public LogInBO verifyErrorMessageWithCaptcha() {
        LOGGER.info("Verify error message for with captcha");
        Assert.assertEquals(logInPage.getErrorMessageWithCaptcha(), Constants.ERROR_CAPTCHA, "Wrong message for invalid password is displayed");
        return this;
    }
}
