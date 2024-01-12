import AccCreatePart.Data.AccCreationData;
import AccCreatePart.Steps.CreatedAccPageSteps;
import AccCreatePart.Steps.RegistrationPageSteps;
import Common.Utility.HelperFunctions;
import Common.Utility.TestConfig;
import UpVotePart.Data.FilePaths;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;


import static com.codeborne.selenide.Selenide.switchTo;

public class AccountCreationRun extends TestConfig {
    HelperFunctions hf=new HelperFunctions();
    FilePaths fp=new FilePaths();
    RegistrationPageSteps stepsForRegistrationPage=new RegistrationPageSteps();
    CreatedAccPageSteps stepsForCreatedAccountPage=new CreatedAccPageSteps();
    @BeforeClass
    public void setUpConfigs() {
        hf.parseProperties(fp.configFilePath);
        setUp(hf.r_url);
    }
    @Test
    public void createAccount() throws InterruptedException, AWTException {
        stepsForRegistrationPage.fillEmail().clickOnContinueButton()
                .fillUserName().fillPassword()
        ;
        hf.pressEnter();
        stepsForRegistrationPage.clickOnRecaptcha();

        Thread.sleep(3333);
        switchTo().defaultContent();

        stepsForRegistrationPage.switchToCaptcha2Frame().clickOnAudioButton().clickOnDownloadButton();
        hf.downloadAudio();
        hf.switchToNewWindow();
        hf.goToAudioToTextConverter();

        hf.DismissPopUpAndUpload();
        Thread.sleep(4333);

        HelperFunctions.copyToClipboard(AccCreationData.downloadedFilePath);
        hf.sendFileToConvert();
        Thread.sleep(4444);
        HelperFunctions.uploadFileAndCopyText();
        hf.switchBack();
        hf.switchToDefault();

        stepsForRegistrationPage.switchToCaptcha2Frame().sendTextToCaptcha();

        Thread.sleep(1111);
        hf.switchBack();
        hf.switchToDefault();
        stepsForRegistrationPage.clickOnSignUp();

        Thread.sleep(3322);

        hf.deleteFile();

        stepsForCreatedAccountPage.chooseGender().chooseInterests().clickOnContinueButton().
                selectCommunities().clickOnContinueButton().clickOnContinueButton();

    }
}