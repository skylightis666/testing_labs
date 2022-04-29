package hw3.ex1;

import hw3.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

import java.util.List;


public class TestExercise1 extends BaseTest {

    @Test
    public void testEx1() {
        HomePage homePage = new HomePage(driver);

        //ex1, 1) Open test site by URL
        homePage.openURL(properties.getProperty("url"));

        //ex1, 2) Assert Browser title
        SoftAssert softAssert1 = new SoftAssert();
        softAssert1.assertEquals(driver.getTitle(), "Home Page");

        //ex1, 3) Perform login
        homePage.logUser(properties.getProperty("login"), properties.getProperty("passwd"));

        //ex1, 4) Assert Username is loggined
        softAssert1.assertEquals(homePage.getUserName(), "ROMAN IOVLEV");

        //ex1, 5) Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> headerItems = homePage.getHeaderElements().getHeaderItems();
        String[] expectedName = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
        for(int i = 0; i < expectedName.length; i++){
            softAssert1.assertEquals(headerItems.get(i).getText(), expectedName[i]);
            softAssert1.assertTrue(headerItems.get(i).isDisplayed());
        }

        //ex1, 6) Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> icons = homePage.getIcon();
        for(WebElement icon: icons){
            softAssert1.assertTrue(icon.isDisplayed());
        }

        //ex1, 7) Assert that there are 4 texts on the Index Page under icons and they have proper text	4 texts below of each image	Texts are displayed and equal to expected
        List<WebElement> benefit = homePage.getBenefitTxt();
        String[] expectedText = {"To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"};
        for(int i = 0; i < expectedText.length; i++){
            softAssert1.assertEquals(benefit.get(i).getText(), expectedText[i]);
        }

        //ex1, 8) Assert that there is the iframe with “Frame Button” exist
        softAssert1.assertTrue(homePage.getFrame().isDisplayed());

        //ex1, 9) Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame("frame");
        softAssert1.assertTrue(homePage.getFrameButton().isDisplayed());

        //ex1, 10) Switch to original window back
        driver.switchTo().parentFrame();

        //ex1, 11) Assert that there are 5 items in the Left Section are displayed and they have proper text
        String[] expectedLeftMenuItems = {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};
        List<WebElement> nameHeader = homePage.getLeftElements().getLeftMenuItems();
        for(int i =0; i < expectedLeftMenuItems.length; i++){
            softAssert1.assertEquals(nameHeader.get(i).getText(), expectedLeftMenuItems[i]);
            softAssert1.assertTrue(nameHeader.get(i).isDisplayed());
        }
        softAssert1.assertAll();
    }
}

