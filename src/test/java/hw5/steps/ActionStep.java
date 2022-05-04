package hw5.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class ActionStep extends AbstractStep {

    @When("I click on {string} button in Header")
    public void openHeaderItem(String item) {
        homePage.getHeaderElements().clickHeaderItem(item);
    }

    @And("I click on {string} button in Service dropdown")
    public void openDropdownItem(String item) {
        homePage.getHeaderElements().clickHeaderItem("SERVICE");
        homePage.clickDropdownMenu(item);
    }

    @And("I select {string} checkboxes in main form on Different Elements page")
    public void clickCheckboxDiffEl(String checkbox) {
        diffEl.clickCheckBox(checkbox);
    }

    @And("I select radio buttons {string} in main form on Different Elements page")
    public void clickRadioboxDiffEl(String radiobox) {
        diffEl.clickRadioBox(radiobox);
    }

    @And("I select {string} in dropdown in main form on Different Elements page")
    public void clickDropdownDiffEl(String dropdown) {
        diffEl.clickOption(dropdown);
    }

    @When("I select 'vip' checkbox for {string}")
    public void selectCheckboxOnUserTablePage(String username) {
        userTable.clickCheckboxByUserName(username);
    }
}
