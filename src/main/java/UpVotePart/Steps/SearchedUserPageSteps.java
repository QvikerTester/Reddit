package UpVotePart.Steps;

import UpVotePart.Pages.SearchedUserPage;
import Common.Utility.HelperFunctions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Random;

import static com.codeborne.selenide.Selenide.executeJavaScript;
@SuppressWarnings("All")
public class SearchedUserPageSteps {
    SearchedUserPage page = new SearchedUserPage();
    HelperFunctions helperFunctions = new HelperFunctions();

    public SearchedUserPageSteps clickOnPostsButton() {
        page.postsButton.click();
        return this;
    }



    public SearchedUserPageSteps upvoteAllPosts(int amountOfUpVotes) throws InterruptedException {
        int counter = 0;
        page.contentContainer.shouldBe(Condition.exist);
        System.out.print(page.posts.size());
        for (int i = 0; i < page.posts.size(); i++) {
            Random random = new Random();
            int waitTimeMillis = random.nextInt(3000) + 1000;
            Thread.sleep(500);
            System.out.println("Size " + page.posts.size());
            SelenideElement el = page.posts.get(i).$(By.xpath(".//i[@class='icon icon-upvote _2Jxk822qXs4DaXwsN7yyHA']"));
            executeJavaScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });", page.posts.get(i));

            Thread.sleep(waitTimeMillis);
            if (el.isDisplayed()) {
                executeJavaScript("arguments[0].click();", el);
                counter++;
            }else {
                continue;
            }
            System.out.println(i);
            Thread.sleep(waitTimeMillis);
            if (i == page.posts.size() - 1) {
                page.posts.get(i + 1).shouldBe(Condition.visible);
            }
            if (counter == amountOfUpVotes) {
                break;
            }
        }
        return this;
    }

    public SearchedUserPageSteps clickComment(int amountOfComment) throws InterruptedException {
        int counter = 0;
        page.contentContainer.shouldBe(Condition.exist);
        System.out.print(page.posts.size());
        for (int i = 0; i < page.posts.size(); i++) {
            Random random = new Random();
            int waitTimeMillis = random.nextInt(3000) + 1000;
            Thread.sleep(500);
            System.out.println("Size " + page.posts.size());
            SelenideElement el = page.posts.get(i).$(By.xpath(".//i[@class='icon icon-comment _3DVrpDrMM9NLT6TlsTUMxC']"));
            executeJavaScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });", page.posts.get(i));

            Thread.sleep(waitTimeMillis);
            if (el.isDisplayed()) {
                executeJavaScript("arguments[0].click();", el);
                counter++;
            }else {
                continue;
            }
            System.out.println(i);
            Thread.sleep(waitTimeMillis);
            if (i == page.posts.size() - 1) {
                page.posts.get(i + 1).shouldBe(Condition.visible);
            }
            if (counter == amountOfComment) {
                break;
            }
        }
        return this;
    }
    SearchedUserPageSteps dissmissPopUp(){
        if(page.youMustBeOverPopUp.isDisplayed()){
            page.yesButton.click();
        }
        return this;
    }
    public  SearchedUserPageSteps clickComments(){
        if(page.commentLabel.isDisplayed()){
            page.commentLabel.click();
        }
        return this;
    }
}
