package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HeaderElements {

    @FindBy(css = "ul[class = 'uui-navigation nav navbar-nav m-l8']>li")
    private List<WebElement> headerMenuElements;

    public HeaderElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getHeaderItems() {
        return this.headerMenuElements;
    }

    public void clickHeaderItem(final String item) {
        for (WebElement headerElement : headerMenuElements) {
            if (item.equals(headerElement.getText())) {
                headerElement.click();
                break;
            }
        }
    }


}