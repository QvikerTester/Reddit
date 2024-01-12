import Common.Data.DataProviderForDB;
import Common.Utility.HelperFunctions;
import Common.Utility.MyRetryAnalyzer;
import Common.Utility.TestConfig;
import UpVotePart.Data.FilePaths;
import UpVotePart.Data.ScriptData;
import UpVotePart.Data.UserData;
import UpVotePart.Steps.LoginPopupSteps;
import UpVotePart.Steps.RedditMainPageSteps;
import UpVotePart.Steps.SearchedUserPageSteps;
import UpVotePart.Steps.UserMainPageSteps;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

import static com.codeborne.selenide.Selenide.*;

public class SinglePostUpvote extends TestConfig {

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

        open("https://www.reddit.com/r/darkjokes/comments/17llgd9/what_do_concerts_and_wars_have_in_common/");
        SelenideElement pst=$x("//*[@id=\"AppRouter-main-content\"]//*[@class='uI_hDmU5GSiudtABRz_37 ']");

        pst.$x(".//i[@class='icon icon-upvote _2Jxk822qXs4DaXwsN7yyHA']").click();
        Thread.sleep(1233);



    }


//    @AfterMethod
//    public void cleanUp(){
//        tearDown();
//    }
}
