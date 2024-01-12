package UpVotePart.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPopup {
    public SelenideElement userNameField=$x("//*[@id=\"login-username\"]"),
            userPasswordField=$x("//*[@id=\"login-password\"]");
}
