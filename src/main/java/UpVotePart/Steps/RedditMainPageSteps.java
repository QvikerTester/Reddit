package UpVotePart.Steps;

import UpVotePart.Pages.RedditMainPage;
@SuppressWarnings("All")

public class RedditMainPageSteps {
    RedditMainPage page=new RedditMainPage();
    public RedditMainPageSteps clickOnLogin(){
        page.loginButton.
                hover().click();
        return this;
    }
}
