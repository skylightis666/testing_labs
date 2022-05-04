package hw2.ex1;

import hw2.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class TestExercise1 extends BaseTest {

    @Test
    public void testExercise1(){

        initUser("Home page", "Roman", "Jdi1234","ROMAN IOVLEV");

        //ex1, 5) Assert that there are 4 items on the header section are displayed and they have proper texts
        SoftAssert softAssert1 = new SoftAssert();
        List<WebElement> headerMenuSelectors = driver.findElements(By.cssSelector("header .nav>li"));
        String[] expectedName = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
        for(int i = 0; i < expectedName.length; i++){
            softAssert1.assertEquals(headerMenuSelectors.get(i).getText(), expectedName[i]);
            softAssert1.assertTrue(headerMenuSelectors.get(i).isDisplayed());
        }

        //ex1, 6) Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> iconsSelectors = driver.findElements(By.className("benefit-icon"));
        for(WebElement icon: iconsSelectors){
            softAssert1.assertTrue(icon.isDisplayed());
        }

        //ex1, 7) Assert that there are 4 texts on the Index Page under icons and they have proper text	4 texts below of each image	Texts are displayed and equal to expected
        List<WebElement> benefit = driver.findElements(By.className("benefit-txt"));
        String[] expectedTxt = {"To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"};
        for(int i = 0; i < expectedTxt.length; i++){
            softAssert1.assertEquals(benefit.get(i).getText(), expectedTxt[i]);
        }

        //ex1, 8) Assert that there is the iframe with “Frame Button” exist
        softAssert1.assertTrue(driver.findElement(By.cssSelector("iframe[id=\"frame\"]")).isDisplayed());

        //ex1, 9) Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
        softAssert1.assertTrue(driver.findElement(By.id("frame-button")).isDisplayed());

        //ex1, 10) Switch to original window back
        driver.switchTo().parentFrame();

        //ex1, 11) Assert that there are 5 items in the Left Section are displayed and they have proper text
        String[] expectedLeftMenuItems = {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};
        List<WebElement> leftMenuItems = driver.findElements(By.cssSelector(".sidebar-menu>li"));
        for(int i = 0; i < expectedLeftMenuItems.length; i++){
            softAssert1.assertEquals(leftMenuItems.get(i).getText(),expectedLeftMenuItems[i]);
            softAssert1.assertTrue(leftMenuItems.get(i).isDisplayed());
        }
        softAssert1.assertAll();
    }
}
