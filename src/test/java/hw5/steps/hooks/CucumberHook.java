package hw5.steps.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import hw5.context.TestContext;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public class CucumberHook {

    @BeforeAll
    public static void initDriver(){
        String path = "src/test/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
    }


    @Before
    public void init(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Properties properties = new Properties();
        try (FileReader fr = new FileReader("src/test/resources/conf.properties");) {
            properties.load(fr);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        TestContext.getInstance().putObject("driver", driver);
    }

    @After
    public void closeBrowser() {
        WebDriver driver = TestContext.getInstance().getObject("driver");
        if (driver != null) {
            driver.quit();
        }
        TestContext.getInstance().clear();
    }
}
