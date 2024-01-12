package UpVotePart.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$x;

public class UserMainPage {
    public SelenideElement userIcon = $x("//*[@id=\"email-collection-tooltip-id\"]"),

    postsContainer =
            $x("//*[@id='AppRouter-main-content']//div[@class='rpBJOHq2PR60pnwJlUyP0']");


    public ElementsCollection posts = postsContainer.
            findAll(By.xpath(".//div[contains(@class ,'_1oQyIsiPHYt6nx7VOmd1sz _1RYN-7H8gYctjOQeL8p2Q7 scrollerItem _3Qkp11fjcAw9I9wtLo8frE')]"));


}
