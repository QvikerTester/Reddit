package AccCreatePart.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CreatedAccPage {
    SelenideElement preferencesFrame=$x("//*[@id=\"SHORTCUT_FOCUSABLE_DIV\"]//div[@class='_2aK1Wp37TOccNSDJhJiDXo _3K5ph7yQ6HVMc8yArX6a0R']");
    public ElementsCollection genders=preferencesFrame.findAll(By.xpath(".//*[@class='T95_VBp5gV76hGtM3JdZS _2Rf2QhiOOcpOJ0rzit27GL']")),

    interests=$$x("//*[@id=\"SHORTCUT_FOCUSABLE_DIV\"]//*[@class='_3oCL2oMbe3H81mue3bR1CQ  _2iuoyPiKHN3kfOoeIQalDT _10BQ7pjWbeYP63SAPNS8Ts HNozj_dKjQZ59ZsfEegz8 ']"),
    communities=$$x("//*[@id=\"SHORTCUT_FOCUSABLE_DIV\"]//*[@class='_2h_rraB53rhUmsB6cnedRY ']");

    public SelenideElement continueButton=$x("//*[@id=\"SHORTCUT_FOCUSABLE_DIV\"]//button[@class='dK60vCQAai2JPR7mVZ4ir']");
}
