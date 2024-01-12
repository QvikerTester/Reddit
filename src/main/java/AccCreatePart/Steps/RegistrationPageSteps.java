package AccCreatePart.Steps;

import AccCreatePart.Pages.RegistrationPage;
import Common.Utility.DBSteps;
import Common.Utility.HelperFunctions;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationPageSteps {
    RegistrationPage page = new RegistrationPage();
    HelperFunctions hf = new HelperFunctions();
    // DBSteps steps=new DBSteps();

    public RegistrationPageSteps fillEmail() {
        page.emailField.setValue(hf.generateRandomEmail());
        return this;
    }

    public RegistrationPageSteps clickOnContinueButton() {
        page.continueButton.click();
        return this;
    }

    public String userName=hf.generateUsername();

    public RegistrationPageSteps fillUserName() {
        page.userNameField.setValue(userName);
        return this;
    }
    public String password=hf.generatePassword();
    public RegistrationPageSteps fillPassword() {
        page.passwordField.setValue(password);
        return this;
    }

    public RegistrationPageSteps clickOnRecaptcha(){
        hf.switchToCaptcha();
        page.recaptcha.click();


        return this;
    }
    public RegistrationPageSteps switchToCaptcha2Frame(){
        switchTo().frame($(page.captcha2FrameLocator));
        return this;
    }

    public RegistrationPageSteps clickOnSignUp(){
        page.signUpButton.click();
        return this;
    }

    public RegistrationPageSteps clickOnAudioButton() {

        SelenideElement audioButton= $x("//button[@class=\"rc-button goog-inline-block rc-button-audio\" and @id=\"recaptcha-audio-button\"]");
        audioButton.hover();
        executeJavaScript("arguments[0].click();",audioButton);
        return this;
    }
    public RegistrationPageSteps clickOnDownloadButton(){
        page.downloadButton.click();
        return this;
    }
    public RegistrationPageSteps sendTextToCaptcha() throws InterruptedException {
        page.audioTxtField.setValue(HelperFunctions.textForCaptcha);


        page.verifyButton.click();
        return this;
    }
}
