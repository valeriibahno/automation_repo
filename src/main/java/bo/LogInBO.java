package bo;

import org.testng.Assert;
import pom.LogInPage;
import services.Constants;

public class LogInBO extends BaseBO {

    private final LogInPage logInPage = new LogInPage();

    public LogInBO fillEmailAndPassword(String email, String password) {
        logInPage
                .clickEmailInput()
                .fillEmailInput(email)
                .clickPasswordInput()
                .fillPasswordInput(password)
                .clickSubmitButton();
        return this;
    }

    public LogInBO verifyErrorMessageInvalidEmail() {
        LOGGER.info("Verify error message for invalid email");
        Assert.assertEquals(logInPage.getErrorMessageInvalidEmail(), Constants.ERROR_INVALID_EMAIL, "Wrong message for invalid email is displayed");
        return this;
    }

    public LogInBO verifyErrorMessageInvalidPassword() {
        LOGGER.info("Verify error message for invalid password");
        Assert.assertEquals(logInPage.getErrorMessageInvalidPassword(), Constants.ERROR_INVALID_PASSWORD, "Wrong message for invalid password is displayed");
        return this;
    }
}
