package UpVotePart.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$x;

public class SearchedUserPage {

    public SelenideElement contentContainer=$x("//*[@id='AppRouter-main-content']//div[@class='rpBJOHq2PR60pnwJlUyP0']"),

    postsButton=$x("//*[@id=\"AppRouter-main-content\"]//a[@class='_1JNzvBgvzSnX27gUBKqqmJ ' and text()='Posts']"),
    commentLabel = $x("//a[normalize-space()='Comments']"),


    youMustBeOverPopUp=$x("//*[@id=\"overlayScrollContainer\"]//*[text()=\"You must be 18+ to view this community\"]"),
    yesButton;
    public ElementsCollection posts=contentContainer.findAll(By.cssSelector("[class^=\"_1oQyIsiPHYt6nx7VOmd1sz bE7JgM2ex7W3aF3zci5bm D3IyhBGwXo9jPwz-Ka0Ve\"]"));


}
