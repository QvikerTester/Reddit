package UpVotePart.Steps;

import UpVotePart.Data.UserData;
import UpVotePart.Pages.LoginPopup;
@SuppressWarnings("All")

public class LoginPopupSteps {
    LoginPopup page = new LoginPopup();
    UserData userData = new UserData();

    public LoginPopupSteps fillUserName(String userName) {
        page.userNameField
                .setValue(userName);
        return this;
    }

    public LoginPopupSteps fillPassword(String password) {
        page.userPasswordField
                .setValue(password);
        return this;
    }

}

