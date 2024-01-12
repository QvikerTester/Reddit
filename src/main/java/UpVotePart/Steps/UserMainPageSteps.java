package UpVotePart.Steps;

import Common.Utility.HelperFunctions;
import UpVotePart.Pages.UserMainPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Random;

import static com.codeborne.selenide.Selenide.executeJavaScript;
@SuppressWarnings("All")

public class UserMainPageSteps{
    UserMainPage page=new UserMainPage();
    HelperFunctions helperFunctions=new HelperFunctions();

    public UserMainPageSteps waitForUserIcon(){
        page.userIcon.shouldBe(Condition.visible);
        return this;
    }
    public UserMainPageSteps upvotePosts(int amountOfUpVotes) throws InterruptedException {
        int counter=0;
        page.postsContainer.shouldBe(Condition.exist);
        for (int i = 0; i < page.posts.size(); i++) {
            Random random=new Random();
            int waitTimeMillis=random.nextInt(3000)+1000;
            Thread.sleep(500);
            System.out.println("Size " + page.posts.size());
            SelenideElement el = page.posts.get(i).$(By.xpath(".//i[@class='icon icon-upvote _2Jxk822qXs4DaXwsN7yyHA']"));
            double scrollDuration = 500 + Math.random() * 500; // Generating a random duration between 500 and 1000 milliseconds
            String scrollScript = "arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center', duration: " + scrollDuration + " });";
            executeJavaScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });",page.posts.get(i));

           // SelenideElement elD=page.posts.get(i).$(By.xpath("//i[@class=\"icon icon-downvote ZyxIIl4FP5gHGrJDzNpUC\"]"));
            if (el.isDisplayed()&&helperFunctions.clickOrNot()){
                Thread.sleep(waitTimeMillis);
                executeJavaScript("arguments[0].click();",el);
                counter++;
                if (counter==amountOfUpVotes){
                    break;
                }
            }
//            if(elD.isDisplayed()&&helperFunctions.clickOrNotForDownVote())
            System.out.println(i);
            Thread.sleep(waitTimeMillis);
            if (i == page.posts.size() -1){
                page.posts.get(i+1).shouldBe(Condition.visible);
            }

        }
        return this;
    }
}
