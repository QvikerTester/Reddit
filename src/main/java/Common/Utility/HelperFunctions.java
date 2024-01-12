package Common.Utility;


import AccCreatePart.Data.AccCreationData;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class HelperFunctions {

    public String url;
    public String r_url;
    public String u_url;

    AccCreationData data=new AccCreationData();



    public void parseProperties(String path) {
        Properties properties = new Properties();

        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        url = properties.getProperty("url");
        r_url = properties.getProperty("r_url");
        u_url=properties.getProperty("u_url");

    }

    String mainWindowHandle;
    public void
    visitUser(String user){
        open(u_url+user+"/");
    }

    public void switchToNewWindow() {
        mainWindowHandle = getWebDriver().getWindowHandle();
        Set<String> windowHandles = getWebDriver().getWindowHandles();
        String newWindowHandle = "";
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                newWindowHandle = handle;
                break;
            }
        }

        switchTo().window(newWindowHandle);
    }

    public void switchBack() {
        switchTo().window(mainWindowHandle);
    }

    public void pressEnter() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
    public void pressTab(int amountOfPresses) throws AWTException {
        Robot robot = new Robot();
        for (int i=0;i<amountOfPresses;i++){
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        }
    }
    public void switchToCaptcha(){
        WebDriverWait wait ;
        wait=new WebDriverWait(WebDriverRunner.getWebDriver(),Duration.ofMillis(40000));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@title='reCAPTCHA']")));
    }
    public void switchToRecaptcha(){
        WebDriverWait wait;
        wait=new WebDriverWait(WebDriverRunner.getWebDriver(),Duration.ofMillis(40000));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@title='recaptcha challenge expires in two minutes']")));




    }
    public static void clearBrowserCache() {
        Selenide.executeJavaScript("window.localStorage.clear();"); // Clear local storage
        Selenide.executeJavaScript("window.sessionStorage.clear();"); // Clear session storage
        Selenide.clearBrowserCookies();
        clearBrowserCache();
    }
    public void switchToDefault(){
        WebDriverRunner.getWebDriver().switchTo().defaultContent();
    }
    public String generateRandomEmail() {
        String characters = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder randomEmail = new StringBuilder();

        Random rand = new Random();
        int usernameLength = 10;
        for (int i = 0; i < usernameLength; i++) {
            int randomIndex = rand.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            randomEmail.append(randomChar);
        }

        randomEmail.append("@gmail.com");

        return randomEmail.toString();
    }

    public String generatePassword() {
        StringBuilder password = new StringBuilder();
        Random random = new Random();


        for (int i = 0; i < 2; i++) {
            char capitalLetter = (char) (random.nextInt(26) + 'A');
            password.append(capitalLetter);
        }


        for (int i = 0; i < 2; i++) {
            int number = random.nextInt(10);
            password.append(number);
        }


        for (int i = 4; i < 10; i++) {
            char randomChar;
            if (random.nextBoolean()) {
                randomChar = (char) (random.nextInt(26) + 'a');
            } else {
                randomChar = (char) (random.nextInt(10) + '0');
            }
            password.append(randomChar);
        }


        char[] passwordChars = password.toString().toCharArray();
        for (int i = passwordChars.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            char temp = passwordChars[index];
            passwordChars[index] = passwordChars[i];
            passwordChars[i] = temp;
        }

        return new String(passwordChars);
    }

    public String generateUsername() {
        StringBuilder username = new StringBuilder();
        Random random = new Random();

        // Generate 3 random capital letters
        for (int i = 0; i < 3; i++) {
            char capitalLetter = (char) (random.nextInt(26) + 'A');
            username.append(capitalLetter);
        }


        for (int i = 0; i < 3; i++) {
            int number = random.nextInt(10);
            username.append(number);
        }


        for (int i = 6; i < 10; i++) {
            char randomChar;
            if (random.nextBoolean()) {
                randomChar = (char) (random.nextInt(26) + 'a');
            } else {
                randomChar = (char) (random.nextInt(10) + '0');
            }
            username.append(randomChar);
        }


        char[] usernameChars = username.toString().toCharArray();
        for (int i = usernameChars.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            char temp = usernameChars[index];
            usernameChars[index] = usernameChars[i];
            usernameChars[i] = temp;
        }

        return new String(usernameChars);
    }
    public int generateRandomNumber(){
        Random random=new Random();
        return random.nextInt(100);
    }
    public boolean clickOrNot(){
        return generateRandomNumber() % 2 == 0;
    }
    public boolean clickOrNotForDownVote(){
        return generateRandomNumber() % 3==0 && generateRandomNumber()% 2 != 0;
    }
    public void typeCharacter(Robot robot, char character) {
        int keyCode = KeyEvent.getExtendedKeyCodeForChar(character);
        robot.keyPress(keyCode);
        robot.keyRelease(keyCode);
    }
    public static void copyToClipboard(String text) {
        StringSelection selection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, null);
    }
    public void downloadAudio() throws AWTException, InterruptedException {
        Thread.sleep(4444);
        pressTab(5);
        pressEnter();
        pressEnter();
    }
    public void randomWait(int millis) throws InterruptedException {
        Random random=new Random();
        int amount=random.nextInt(millis)+312;
        Thread.sleep(amount);
    }
    public static int getRandomNumber(int bound){
        return new Random().nextInt(bound);
    }
    public void goToAudioToTextConverter(){
        open(data.audioToTextConverterUrl);
    }
    public void DismissPopUpAndUpload(){
        SelenideElement element;

        try {
            element=$x("//*[@id=\"headlessui-dialog-panel-:r2:\"]//button[@class='inline-block rounded-full font-medium transition text-sm sm:text-base px-4 py-1 text-gray-50 bg-purple-500 hover:bg-purple-600 border border-purple-500 hover:border-purple-600']");
            element.click();
        }catch (NoSuchElementException e){

        }
        $x("//div[@class='absolute inset-0']").click();

    }
    public void sendFileToConvert() throws AWTException, InterruptedException {
        Robot robot=new Robot();

        Thread.sleep(2111);


        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        pressEnter();
    }
    public static String textForCaptcha;
    public static String uploadFileAndCopyText() throws InterruptedException {
        $x("//*[@id=\"consent\"]").click();

        $x("//button[@class='self-start w-full font-medium text-xl py-3 rounded-full text-gray-50 bg-purple-500 hover:bg-purple-600 border border-purple-500 hover:border-purple-600 disabled:!opacity-25']").click();


        Thread.sleep(1111);
        String text=$x("//*[@id=\"segment-1\"]").getText();
        copyToClipboard(text);
        textForCaptcha=text;
        return text;
    }
    public void deleteFile(){
        String filePath = "C:\\Users\\sadsteph\\Downloads\\audio.mp3";


        // Create a Path object from the file path string
        Path path = Paths.get(filePath);

        try {
            // Use the Files.delete() method to delete the file
            Files.delete(path);
            System.out.println("File deleted successfully.");
        } catch (IOException e) {
            System.err.println("Unable to delete the file: " + e.getMessage());
        }
    }

}
