package UpVotePart.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PostCommentPage {
    public SelenideElement contentContainer = $x("//div[@class='_2M2wOqmeoPVvcSsJ6Po9-V _3287nL7j7epK9JmDC3N1VR']"),

    commentLabel = $x("//div[@role='textbox']"),
    commentSubmitBtn = $("button[role='button'][type='submit']"),
    closeBtn=$x("//button[@title='Close']");
    public ElementsCollection comments = contentContainer.findAll(By.cssSelector("[class='_3sf33-9rVAO_v4y0pIW_CH']"))
            ;
}
