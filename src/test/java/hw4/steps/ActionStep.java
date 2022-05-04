package hw4.steps;

import hw4.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ActionStep extends AbstractStep{

    public ActionStep(WebDriver driver){
        super(driver);
    }

    @Step("ex1, 1) Open test site by URL")
    public void openPage(){
        homePage.openURL(BaseTest.properties.getProperty("url"));
    }

    @Step("ex1, 3) Perform login")
    public void loginUser(String login, String passwd){
        homePage.logUser(login, passwd);
    }

    @Step("ex2, 5) Open through the header menu Service -> Different Elements Page")
    public void clickHeaderItem(String headerItem, String headerSubItem){
        homePage.getHeaderElements().clickHeaderItem(headerItem);
        if (headerItem.equals("SERVICE")){
            homePage.clickDropdownMenu(headerSubItem);
        }
    }

    @Step("ex2, 6) Select checkboxes {checkbox}")
    public void selectCheckbox(String checkbox) {
        differentElementsPage.clickCheckBox(checkbox);
    }

    @Step("ex2, 7) Select radio {radiobox}")
    public void selectRadio(String radiobox) {
        differentElementsPage.clickRadioBox(radiobox);
    }

    @Step("ex2, 8) Select in dropdown {optionItem}")
    public void selectOption(String optionItem) {
        differentElementsPage.clickOption(optionItem);
    }

    @Step("ex1, 9) Switch to the iframe and check that there is “Frame Button” in the iframe {frame}")
    public void switchToFrame(String frame) {
        driver.switchTo().frame(frame);
    }

    @Step("ex1, 10) Switch to original window back")
    public void switchParentFrame() {
        driver.switchTo().parentFrame();
    }
}
