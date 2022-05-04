package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeSuite
    public void initDriver(){
        String path = "src/test/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
    }

    @BeforeMethod
    public void init(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod
    public void closeSession(){
        driver.quit();
    }

    public void initUser(String title, String login, String passwd, String userName){
        //ex1, 1) Open test site by URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");

        //ex1, 2) Assert Browser title
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(),title);

        //ex1, 3) Perform login
        driver.findElement(By.cssSelector("a[href = '#']")).click();
        driver.findElement(By.id("name")).sendKeys(login);
        driver.findElement(By.id("password")).sendKeys(passwd);
        driver.findElement(By.id("login-button")).click();

        //ex1, 4) Assert Username is loggined
        softAssert.assertEquals(driver.findElement(By.id("user-name")).getText(), userName);
        softAssert.assertAll();
    }
}
