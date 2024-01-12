import AccCreatePart.Steps.RegistrationPageSteps;
import Common.Utility.HelperFunctions;
import Common.Utility.TestConfig;
import UpVotePart.Data.FilePaths;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class Dummy extends TestConfig {
    HelperFunctions hf=new HelperFunctions();
    FilePaths fp=new FilePaths();
    RegistrationPageSteps stepsForRegistrationPage=new RegistrationPageSteps();
    @BeforeClass
    public void setUpConfigs() {
        hf.parseProperties(fp.configFilePath);
        setUp(hf.r_url);
    }
    @Test
    public void test() throws InterruptedException, AWTException {
        open("https://www.google.com/");
        $x("//*[@id=\"APjFqb\"]").setValue("Where am i?");
        hf.pressEnter();


        Thread.sleep(24444);


    }
}
