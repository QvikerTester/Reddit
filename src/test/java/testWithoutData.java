import Common.Data.DataProviderForDB;
import Common.Utility.MyRetryAnalyzer;
import UpVotePart.Data.FilePaths;
import UpVotePart.Data.ScriptData;
import UpVotePart.Steps.*;
import Common.Utility.HelperFunctions;
import Common.Utility.TestConfig;
import org.testng.annotations.*;


import java.awt.*;



@SuppressWarnings("All")
public class testWithoutData extends TestConfig {
    HelperFunctions hf = new HelperFunctions();
    FilePaths fp = new FilePaths();
    ScriptData data=new ScriptData();
    RedditMainPageSteps stepsForMainPage = new RedditMainPageSteps();
    LoginPopupSteps stepsForLoginPopup = new LoginPopupSteps();
    UserMainPageSteps stepsForUserMainPage = new UserMainPageSteps();
    SearchedUserPageSteps stepsForSearchedUser = new SearchedUserPageSteps();
    PostCommentPageSteps postCommentPageSteps = new PostCommentPageSteps();

    @BeforeMethod
    public void setUpConfigs() {
        hf.parseProperties(fp.configFilePath);
        setUp(hf.url);
    }
    @Test()
    public void engine() throws AWTException, InterruptedException {
        stepsForMainPage.clickOnLogin();
        stepsForLoginPopup.fillUserName("Sad_Aardvark5269").fillPassword("Kurdgeli123");
        hf.pressEnter();
        stepsForUserMainPage.waitForUserIcon();


        hf.visitUser(data.user);
        stepsForSearchedUser.clickOnPostsButton().upvoteAllPosts(2)

                .clickComment(1);
        postCommentPageSteps
                .comment()
                .clickSubmit()
                .upvoteAllComms(2)
                .clickClose();

        stepsForSearchedUser.
                clickComments();
    }


//    @AfterMethod
//    public void cleanUp(){
//        tearDown();
//    }

}

