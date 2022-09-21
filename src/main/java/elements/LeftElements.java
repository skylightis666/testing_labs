package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LeftElements {

    @FindBy(css = "ul[class = 'sidebar-menu left']>li")
    private List<WebElement> leftMenuElements;

    public LeftElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getLeftMenuItems() {
        return this.leftMenuElements;
    }

    public void clickLeftMenuItems(final String item) {
        for (WebElement element : leftMenuElements) {
            if (item.equals(element.getText())) {
                element.click();
                break;
            }
        }
    }
}