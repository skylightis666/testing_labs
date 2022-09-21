package hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.stream.Collectors;

public class AssertionStep extends AbstractStep {

    SoftAssert softAssert;

    public AssertionStep(WebDriver driver) {
        super(driver);
        softAssert = new SoftAssert();
    }

    @Step("ex1, 2) Assert Browser title {browserTitle}")
    public void assertBrowserTitle(String browserTitle) {
        softAssert.assertEquals(driver.getTitle(), browserTitle);
    }

    @Step("ex1, 4) Assert Username is loggined {username}")
    public void assertUsername(String username) {
        softAssert.assertEquals(homePage.getUserName(), username);
    }

    @Step("ex1, 5) Assert that there are 4 items on the header section are displayed and they have proper texts")
    public void assertHeaderItems(String[] expectedName) {
        List<WebElement> headerItem = homePage.getHeaderElements().getHeaderItems();
        for(int i = 0; i < expectedName.length; i++){
            softAssert.assertEquals(headerItem.get(i).getText(), expectedName[i]);
            softAssert.assertTrue(headerItem.get(i).isDisplayed());
        }
    }

    @Step("ex1, 6) Assert that there are 4 images on the Index Page and they are displayed")
    public void assertIcons() {
        List<WebElement> icons = homePage.getIcon();
        for(WebElement icon: icons){
            softAssert.assertTrue(icon.isDisplayed());
        }
    }

    @Step("ex1, 7) Assert that there are 4 texts on the Index Page under icons and they have proper text 4 texts below of each image Texts are displayed and equal to expected")
    public void assertIconText(String[] expectedTxt) {
        List<WebElement> benefit = homePage.getBenefitTxt();
        for(int i = 0; i < expectedTxt.length; i++){
            softAssert.assertEquals(benefit.get(i).getText(), expectedTxt[i]);
        }
    }

    @Step("ex1, 8) Assert that there is the iframe with “Frame Button” exist")
    public void assertFrame() {
        softAssert.assertTrue(homePage.getFrame().isDisplayed());
    }

    @Step("ex1, 9) Switch to the iframe and check that there is “Frame Button” in the iframe")
    public void assertFrameButton() {
        softAssert.assertTrue(homePage.getFrameButton().isDisplayed());
    }

    @Step("ex1, 10) Switch to original window back")
    public void assertOriginalWindow() {
        softAssert.assertEquals(driver.switchTo().activeElement(), homePage.getBody());
    }

    @Step("ex1, 11) Assert that there are 5 {items} in the Left Section are displayed and they have proper text")
    public void assertLeftItems(String[] items) {
        List<WebElement> nameHeader = homePage.getLeftElements().getLeftMenuItems();
        for(int i =0; i < items.length; i++){
            softAssert.assertEquals(nameHeader.get(i).getText(), items[i]);
            softAssert.assertTrue(nameHeader.get(i).isDisplayed());
        }
    }

    @Step("ex2, 9")
    public void assertLogs(String[] expectedValue) {
        List<WebElement> logs = differentElementsPage.getLogs();
        for (int i = 0; i < expectedValue.length; i++) {
            softAssert.assertTrue(logs.get(i).getText().contains(expectedValue[i]));
            softAssert.assertTrue(logs.get(i).isDisplayed());
        }
    }

    public void assertAll() {
        softAssert.assertAll();
    }
}
