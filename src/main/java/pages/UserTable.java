package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class UserTable {

    @FindBy(css = "table select")
    List<WebElement> dropdown;

    @FindBy(css = "table tr")
    List<WebElement> tableLines;

    @FindBy(css = "table a")
    List<WebElement> userNames;

    @FindBy(css = "table .user-descr span")
    List<WebElement> descriptionText;

    @FindBy(css = "table input")
    List<WebElement> checkbox;

    @FindBy(css = "div.info-panel-section")
    WebElement log;

    public UserTable(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getDropdown() {
        return dropdown;
    }

    public List<WebElement> getUserNames() {
        return userNames;
    }

    public List<WebElement> getDescriptionText() {
        return descriptionText;
    }

    public List<WebElement> getCheckbox() {
        return checkbox;
    }

    public List<String> getTableLineContent(int line) {
        List<String> result = new ArrayList<>();
        result.add(tableLines.get(line + 1).findElement(By.tagName("td")).getText());
        result.add(userNames.get(line).getText());
        result.add(descriptionText.get(line).getText());
        return result;
    }

    public List<WebElement> getDropListValues(int line) {
        return dropdown.get(line).findElements(By.tagName("option"));
    }


    public void clickCheckboxByUserName(String name) {
        for (int i = 0; i < 6; i++) {
            if (userNames.get(i).getText().equals(name)) {
                checkbox.get(i).click();
                return;
            }
        }
    }

    public WebElement getLog() {
        return log;
    }
}
