import Common.Data.DataProviderForDB;
import Common.Utility.MyRetryAnalyzer;
import UpVotePart.Data.FilePaths;
import UpVotePart.Steps.LoginPopupSteps;
import UpVotePart.Steps.RedditMainPageSteps;
import UpVotePart.Steps.SearchedUserPageSteps;
import UpVotePart.Steps.UserMainPageSteps;
import Common.Utility.HelperFunctions;
import Common.Utility.TestConfig;
import org.testng.annotations.*;


import java.awt.*;

import static com.codeborne.selenide.Selenide.open;
@SuppressWarnings("All")
public class TestRun extends TestConfig {
    HelperFunctions hf = new HelperFunctions();
    FilePaths fp = new FilePaths();
    RedditMainPageSteps stepsForMainPage = new RedditMainPageSteps();
    LoginPopupSteps stepsForLoginPopup = new LoginPopupSteps();
    UserMainPageSteps stepsForUserMainPage = new UserMainPageSteps();
    SearchedUserPageSteps stepsForSearchedUser = new SearchedUserPageSteps();

    @BeforeMethod
    public void setUpConfigs() {
        hf.parseProperties(fp.configFilePath);
        setUp(hf.url);
    }
    @Test(retryAnalyzer = MyRetryAnalyzer.class,dataProvider = "loginData", dataProviderClass = DataProviderForDB.class)
    public void engine(String userName,String password) throws AWTException, InterruptedException {
        stepsForMainPage.clickOnLogin();
        stepsForLoginPopup.fillUserName(userName).fillPassword(password);
        hf.pressEnter();
        stepsForUserMainPage.waitForUserIcon();

        open(hf.url);
        stepsForUserMainPage.upvotePosts(3);


    }


    @AfterMethod
    public void cleanUp(){
        tearDown();
    }

}
