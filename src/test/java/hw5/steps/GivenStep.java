package hw5.steps;

import io.cucumber.java.en.Given;

public class GivenStep extends AbstractStep {

    @Given("I open JDI GitHub site {string}")
    public void openSite(String url) {
        driver.get(url);
    }

    @Given("I log in with login: {string} and password: {string}")
    public void loginUser(String login, String passwd) {
        homePage.logUser(login, passwd);

    }
}