package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DifferentElementsPage {

    @FindBy(css = "label[class='label-checkbox']")
    private List<WebElement> checkBox;

    @FindBy(css = "label[class='label-radio']")
    private List<WebElement> radioBox;

    @FindBy(css = "select[class='uui-form-element'] option")
    private List<WebElement> options;

    @FindBy(css = ".info-panel-body-log li")
    private List<WebElement> logs;

    public DifferentElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickCheckBox(final String item) {
        for (WebElement check : checkBox) {
            if (item.equals(check.getText())) {
                check.click();
                break;
            }
        }
    }

    public void clickRadioBox(final String item) {
        for (WebElement radio : radioBox) {
            if (item.equals(radio.getText())) {
                radio.click();
                break;
            }
        }
    }

    public void clickOption(final String item) {
        for (WebElement option : options) {
            if (item.equals(option.getText())) {
                option.click();
                break;
            }
        }
    }

    public List<WebElement> getLogs() {
        return this.logs;
    }
}