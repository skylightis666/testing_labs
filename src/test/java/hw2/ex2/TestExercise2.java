package hw2.ex2;

import hw2.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class TestExercise2 extends BaseTest {
    @Test
    public void testExercise2(){

        initUser("Home Page", "Roman", "Jdi1234","ROMAN IOVLEV");

        //ex2, 5) Open through the header menu Service -> Different Elements Page
        driver.findElement(By.className("dropdown-toggle")).click();
        driver.findElement(By.cssSelector("a[href=\"different-elements.html\"]")).click();

        //ex2, 6) Select checkboxes
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("label.label-checkbox"));
        String[] expectedCheckboxName = {"Water", "Wind"};
        for(WebElement name: checkboxes) {
            for(int i = 0; i < expectedCheckboxName.length; i++) {
                if (name.getText().equals(expectedCheckboxName[i])) {
                    name.findElement(By.tagName("input")).click();
                }
            }
        }

        //ex2, 7) Select radio
        List<WebElement> radioButton = driver.findElements(By.cssSelector("label.label-radio"));
        for(WebElement radio: radioButton) {
            if(radio.getText().equals("Selen")) {
                radio.findElement(By.tagName("input")).click();
            }
        }

        //ex2, 8) Select in dropdown
        String xPath = "//select/option[text()='Yellow']";
        driver.findElement(By.xpath(xPath)).click();

        //ex2, 9
        SoftAssert softAssert = new SoftAssert();
        String[] expectedValue = {
                "Colors: value changed to Yellow",
                "metal: value changed to Selen",
                "Wind: condition changed to true",
                "Water: condition changed to true"
        };
        List<WebElement> logs = driver.findElements(By.cssSelector(".info-panel-body-log li"));
        for(int i = 0; i < expectedValue.length; i++){
            softAssert.assertTrue(logs.get(i).getText().contains(expectedValue[i]));
            softAssert.assertTrue(logs.get(i).isDisplayed());
        }
        softAssert.assertAll();
    }
}
