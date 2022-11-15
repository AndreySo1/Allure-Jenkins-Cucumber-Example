package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AppTest {
    protected WebDriver driver;

    public AppTest() {
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/chromedriver.exe");
//        this.driver = new ChromeDriver();

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void before() {
        driver.get("https://www.amazon.com/");
        PageFactory.initElements(driver, this);
    }

    @AfterTest
    public void afterTest() {
        driver.close();
        driver.quit();
    }

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchField;

    @FindBy(xpath = "//span[@data-component-type='s-search-results']//span[@class='a-size-medium a-color-base']")
    private List<WebElement> searchNoResultElementS;

    @Test
    public void verifyNoResultsSearch(){
        String searchData = "637176486948segsgsgersbvs";
        String searchResult = "No results for";

        searchField.sendKeys(searchData, Keys.ENTER);

        Assert.assertEquals(searchField.getAttribute("value"), searchData); // value search fild contain searchData
        Assert.assertEquals(
                searchNoResultElementS.get(0).getText(),
                searchResult); // first elem contain text "No results for"
        Assert.assertEquals(
                searchNoResultElementS.get(1).getText(),
                searchData); // second elem contain text searchData
    }

}
