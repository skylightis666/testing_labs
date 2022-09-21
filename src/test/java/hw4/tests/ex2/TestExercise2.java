package hw4.tests.ex2;

import hw4.BaseTest;
import hw4.listeners.ScreenshotListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.DifferentElementsPage;

import java.util.List;

@Listeners({ScreenshotListener.class})
@Feature("HomePage and Different elements page tests class")
public class TestExercise2 extends BaseTest{

    @Test
    @Story("HomePage and Different elements page tests method")
    public void testEx2() {

        //ex2, 1) Open test site by URL
        actionStep.openPage();

        //ex2, 2) Assert Browser title
        assertionStep.assertBrowserTitle("Home Page");

        //ex2, 3) Perform login
        actionStep.loginUser(BaseTest.properties.getProperty("login"),
                BaseTest.properties.getProperty("passwd"));

        //ex2, 4) Assert Username is loggined
        assertionStep.assertUsername("ROMAN IOVLEV");

        //ex2, 5) Open through the header menu Service -> Different Elements Page
        actionStep.clickHeaderItem("SERVICE","DIFFERENT ELEMENTS");

        //ex2, 6) Select checkboxes
        actionStep.selectCheckbox("Water");
        actionStep.selectCheckbox("Wind");

        //ex2, 7) Select radio
        actionStep.selectRadio("Selen");

        //ex2, 8) Select in dropdown
        actionStep.selectOption("Yellow");

        //ex2, 9
        String[] expectedValue = {"Colors: value changed to Yellow",
                "metal: value changed to Selen",
                "Wind: condition changed to true",
                "Water: condition changed to true"
        };
        assertionStep.assertLogs(expectedValue);

        assertionStep.assertAll();
    }
}
