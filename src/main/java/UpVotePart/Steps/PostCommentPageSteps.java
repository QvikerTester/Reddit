package UpVotePart.Steps;

import UpVotePart.Pages.PostCommentPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Random;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PostCommentPageSteps {
    PostCommentPage page = new PostCommentPage();


    public PostCommentPageSteps comment() {
        page.commentLabel.shouldBe(Condition.exist);
        page.commentLabel.click();
        page.commentLabel.sendKeys("gamarjoba kurdgelo");
        return this;
    }

    public PostCommentPageSteps clickSubmit() {
        page.commentSubmitBtn.click();
        return this;
    }


    public PostCommentPageSteps upvoteAllComms(int amountOfComment) throws InterruptedException {
        int counter = 0;
        page.contentContainer.shouldBe(Condition.exist);
        System.out.print(page.comments.size());


        for (int i = 0; i < page.comments.size(); i++) {
            Random random = new Random();
            int waitTimeMillis = random.nextInt(3000) + 1000;
            Thread.sleep(500);
            if (i % 2 == 0) {
                SelenideElement el = page.comments.get(i).$(By.xpath(".//i[@class='icon icon-upvote _2Jxk822qXs4DaXwsN7yyHA']"));
                executeJavaScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });", page.comments.get(i));

                Thread.sleep(waitTimeMillis);
                if (el.isDisplayed()) {
                    executeJavaScript("arguments[0].click();", el);
                    counter++;
                } else {
                    continue;
                }
                Thread.sleep(waitTimeMillis);

            } else {
                SelenideElement el = page.comments.get(i).$(By.xpath(".//i[@class='icon icon-downvote ZyxIIl4FP5gHGrJDzNpUC']"));
                executeJavaScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });", page.comments.get(i));

                Thread.sleep(waitTimeMillis);
                if (el.isDisplayed()) {
                    executeJavaScript("arguments[0].click();", el);
                    counter++;
                } else {
                    continue;
                }
                System.out.println(i);

            }
            if (i == page.comments.size() - 1) {
                page.comments.get(i + 1).shouldBe(Condition.visible);
            }
            if (counter == amountOfComment) {
                break;
            }
        }

        return this;
    }

    public PostCommentPageSteps clickClose() {
        page.closeBtn.click();
        return this;
    }


}
