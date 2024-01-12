import AccCreatePart.Steps.RegistrationPageSteps;
import UpVotePart.Data.FilePaths;
import Common.Utility.HelperFunctions;
import Common.Utility.TestConfig;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

import static com.codeborne.selenide.Selenide.*;


@SuppressWarnings("All")
public class TestRunV1 extends TestConfig {
    HelperFunctions hf=new HelperFunctions();
    FilePaths fp=new FilePaths();
    RegistrationPageSteps stepsForRegistrationPage=new RegistrationPageSteps();
    @BeforeClass
    public void setUpConfigs() {
        hf.parseProperties(fp.configFilePath);
        setUp(hf.r_url);
    }
//    @Test(retryAnalyzer = MyRetryAnalyzer.class)
    @Test
    public void createAccount() throws InterruptedException, AWTException {
        stepsForRegistrationPage.fillEmail().clickOnContinueButton()
                .fillUserName().fillPassword()
             ;
        hf.pressEnter();
        // Switch to the iframe that contains the reCAPTCHA checkbox

//        hf.switchToCaptcha();


      stepsForRegistrationPage.clickOnRecaptcha();
      Thread.sleep(3333);
        switchTo().defaultContent();
      switchTo().frame($x("//iframe[@title='recaptcha challenge expires in two minutes']"));
      stepsForRegistrationPage.clickOnAudioButton();
      $x("//a[@class='rc-audiochallenge-tdownload-link']").click();
      Thread.sleep(4444);
      hf.pressTab(5);
      hf.pressEnter();
      hf.pressEnter();








//        Thread.sleep(3333);
//        stepsForRegistrationPage.clickOnAudioButton();
//        Thread.sleep(33444);
//        stepsForRegistrationPage.clickOnSignUp();
//        open(hf.url);
//        stepsForRegistrationPage.sendRegistrationInfoToDb();
    }
//    @AfterClass
//    public void cleanUp() {
//        tearDown();
//    }


}
