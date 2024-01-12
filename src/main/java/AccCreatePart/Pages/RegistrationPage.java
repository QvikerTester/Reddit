package AccCreatePart.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPage {
    public SelenideElement emailField=$x("//*[@id=\"regEmail\"]"),
            continueButton=$x("//button[@class=\"AnimatedForm__submitButton m-full-width\"]"),
            userNameField=$x("//*[@id=\"regUsername\"]"),
            passwordField=$x("//*[@id=\"regPassword\"]"),
            recaptcha=$x("//*[@id=\"recaptcha-anchor-label\"]"),
            signUpButton=$x("//button[@class='AnimatedForm__submitButton SignupButton']"),
            downloadButton=$x("//a[@class='rc-audiochallenge-tdownload-link']"),
            audioTxtField=$x("//*[@id=\"audio-response\"]"),
            verifyButton=$x("//*[@id=\"recaptcha-verify-button\"]");

    public By captcha2FrameLocator=By.xpath("//iframe[@title='recaptcha challenge expires in two minutes']");

}