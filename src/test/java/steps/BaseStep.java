package steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.Given;

public class BaseStep {
    @Given("Open page {string}")
    public void openPage(String url) {
        Configuration.timeout = 10000;
        Selenide.open(url);
    }

    @AfterAll
    public static void tearDown(){
        WebDriverRunner.getWebDriver().close();
        WebDriverRunner.getWebDriver().quit();
    }
}
