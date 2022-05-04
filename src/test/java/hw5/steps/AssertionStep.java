package hw5.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;


public class AssertionStep extends AbstractStep {

    @Then("Browser title equals {string}")
    public void assertBrowserTitle(String browserTitle) {
        Assert.assertEquals(driver.getTitle(), browserTitle);
    }

    @And("Name is displayed and equals to {string}")
    public void assertUsername(String username) {
        Assert.assertEquals(homePage.getUserName(), username);
    }

    @Then("I see that part of logs in right section on Different Elements page")
    public void assertLogs(List<String> logs) {
        List<WebElement> log = diffEl.getLogs();
        for(int i = 0; i < logs.size(); i++) {
            Assert.assertEquals(log.get(i).getText().substring(9), logs.get(i));
        }
    }

    @Then("{string} page should be opened")
    public void assertUserTableOpen(String title) {
        Assert.assertEquals(driver.getTitle(), title);
    }

    @And("6 Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void assertNumberTypeDropdowns() {
        List<WebElement> dropList = userTable.getDropdown();
        for(WebElement element: dropList){
            Assert.assertTrue(element.isDisplayed());
        }
    }

    @And("6 Usernames should be displayed on Users Table on User Table Page")
    public void assertUserNamesUserTable() {
        List<WebElement> userNames = userTable.getUserNames();
        for(WebElement element: userNames){
            Assert.assertTrue(element.isDisplayed());
        }
    }

    @And("6 Description texts under images should be displayed on Users Table on User Table Page")
    public void assertDescriptionText() {
        List<WebElement> descrtxt = userTable.getDescriptionText();
        for(WebElement element: descrtxt){
            Assert.assertTrue(element.isDisplayed());
        }
    }

    @And("6 checkboxes should be displayed on Users Table on User Table Page")
    public void assertCheckboxes() {
        List<WebElement> checkBoxes = userTable.getCheckbox();
        for(WebElement element: checkBoxes){
            Assert.assertTrue(element.isDisplayed());
        }
    }

    @And("User table should contain following values:")
    public void checkTableContent(List<List<String>> expValues) {
        for (int i = 0; i < 6; i++) {
            Assert.assertEquals(userTable.getTableLineContent(i), expValues.get(i + 1));
        }
    }

    @And("droplist should contain values in column Type for user Roman")
    public void assertDroplistForUser(List<String> expValues) {
        Assert.assertEquals(userTable.getDropListValues(0).stream().map(WebElement::getText).toArray(String[]::new), expValues.subList(1, 4).toArray());
    }

    @Then("1 log row has {string} text in log section")
    public void assertVipCheckbox(String log) {
        Assert.assertTrue(userTable.getLog().getText().contains(log));
    }
}
