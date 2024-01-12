package Common.Utility;

import Common.Data.ProxyData;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.proxy.SelenideProxyServer;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class TestConfig extends ProxyData {

    public void setUp(String baseUrl) {


//        Configuration.proxyEnabled = true;
        Configuration.timeout = 27777;
        Configuration.screenshots = true;
        Configuration.savePageSource = false;

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-web-security");
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--disable-extensions");

        WebDriverRunner.setWebDriver(new ChromeDriver(chromeOptions));
        open(baseUrl);
    }

    private static String serializeCookies() {
        return getWebDriver().manage().getCookies().toString();
    }

    private static void setCookies(String cookiesString) {
        getWebDriver().manage().deleteAllCookies();
        String[] cookiesArray = cookiesString.split(";");
        for (String cookie : cookiesArray) {
            String[] nameValuePair = cookie.split("=", 2);
            if (nameValuePair.length == 2) {
                getWebDriver().manage().addCookie(new Cookie(nameValuePair[0].trim(), nameValuePair[1].trim()));
            }
        }
    }

    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }
}
