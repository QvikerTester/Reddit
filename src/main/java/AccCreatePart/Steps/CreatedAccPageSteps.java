package AccCreatePart.Steps;

import AccCreatePart.Pages.CreatedAccPage;
import Common.Utility.HelperFunctions;
import com.codeborne.selenide.Selenide;

import java.util.Random;

public class CreatedAccPageSteps {
    CreatedAccPage page=new CreatedAccPage();
    Random random=new Random();
    HelperFunctions hf=new HelperFunctions();
    public CreatedAccPageSteps chooseGender(){

        int num=random.nextInt(4);
        page.genders.get(num).click();
        return this;
    }
    public CreatedAccPageSteps chooseInterests() throws InterruptedException {
        Thread.sleep(3421);
        int index= random.nextInt(5)+3;
        int indexOfInterest=random.nextInt(page.interests.size());
        for (int i=0;i<index;i++){
            hf.randomWait(111);
            page.interests.get(i).scrollTo();
            Selenide.executeJavaScript("arguments[0].click();",page.interests.get(indexOfInterest));
        }
        return this;
    }
    public CreatedAccPageSteps clickOnContinueButton(){

        page.continueButton.click();
        return this;
    }
    public CreatedAccPageSteps selectCommunities() throws InterruptedException {
        hf.randomWait(2123);
        int indexOfCommunities=random.nextInt(page.communities.size());
        int index=random.nextInt(4);
        for (int i=0;i<index;i++){
            page.communities.get(i).scrollTo();
            Selenide.executeJavaScript("arguments[0].click();",page.communities.get(indexOfCommunities));
        }
        return this;
    }
}
