package hw3.ex2;

import hw3.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.DifferentElementsPage;
import pages.HomePage;

import java.util.List;


public class TestExercise2 extends BaseTest {

    @Test
    public void testEx2() {
        HomePage homePage = new HomePage(driver);

        //ex2, 1) Open test site by URL
        homePage.openURL(properties.getProperty("url"));

        //ex2, 2) Assert Browser title
        SoftAssert softAssert2 = new SoftAssert();
        softAssert2.assertEquals(driver.getTitle(), "Home Page");

        //ex2, 3) Perform login
        homePage.logUser(properties.getProperty("login"), properties.getProperty("passwd"));

        //ex2, 4) Assert Username is loggined
        softAssert2.assertEquals(homePage.getUserName(), "ROMAN IOVLEV");

        //ex2, 5) Open through the header menu Service -> Different Elements Page
        homePage.getHeaderElements().clickHeaderItem("SERVICE");
        homePage.clickDropdownMenu("DIFFERENT ELEMENTS");

        //ex2, 6) Select checkboxes
        DifferentElementsPage diffEl = new DifferentElementsPage(driver);
        diffEl.clickCheckBox("Water");
        diffEl.clickCheckBox("Wind");

        //ex2, 7) Select radio
        diffEl.clickRadioBox("Selen");

        //ex2, 8) Select in dropdown
        diffEl.clickOption("Yellow");

        //ex2, 9
        String[] expectedValue = {
                "Colors: value changed to Yellow",
                "metal: value changed to Selen",
                "Wind: condition changed to true",
                "Water: condition changed to true"
        };

        List<WebElement> logs = diffEl.getLogs();
        for (int i = 0; i < expectedValue.length; i++) {
            softAssert2.assertTrue(logs.get(i).getText().contains(expectedValue[i]));
            softAssert2.assertTrue(logs.get(i).isDisplayed());
        }
        softAssert2.assertAll();
    }
}

