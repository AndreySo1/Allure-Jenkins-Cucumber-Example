package steps;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static steps.helpers.SearchTextInListElements.searchRegistr;

public class VerifySearchResult {

    private final SelenideElement searchField = $x("//input[@id='twotabsearchtextbox']");
    private final SelenideElement resultArea = $x("//div[@id='s-skipLinkTargetForMainSearchResults']");
    private final ElementsCollection searchNoResultElementS = $$x("//span[@data-component-type='s-search-results']//span[@class='a-size-medium a-color-base']");
    private final ElementsCollection infoLineResult = $$x("//span[@data-component-type='s-result-info-bar']//div[@class='a-section a-spacing-small a-spacing-top-small']//span");
    private final ElementsCollection searchCardsProduct = $$x("//div[@data-component-type='s-search-result']//span[@class='a-size-medium a-color-base a-text-normal']");
    @When("Input in search field {string} end click ENTER")
    public void inputInSearchField(String searchData) {
        searchField.sendKeys(searchData, Keys.ENTER);
    }


    @And("Wait page search result")
    public void waitPageSearchResult() {
        resultArea.isDisplayed();
    }

    @Then("Search field include {string}")
    public void searchFieldInclude(String searchData) {
        Assert.assertEquals(searchField.getAttribute("value"), searchData);
    }

    @Then("Line include text {string}")
    public void lineIncludeText(String searchResult) {
        Assert.assertEquals(
                searchNoResultElementS.get(0).getText(),
                searchResult);
    }

    @Then("Line include search data {string}")
    public void lineIncludeSearchData(String searchData) {
        Assert.assertEquals(
                searchNoResultElementS.get(1).getText(),
                searchData);
    }

    @Then("Info-line contain text {string}")
    public void infoLineContainText(String searchData) {
        Assert.assertEquals(searchField.getAttribute("value"), searchData);
        Assert.assertEquals(infoLineResult.get(2).getText(), "\""+searchData+"\"");
    }

    @Then("At least one card product contains {string}")
    public void atLeastOneCardProductContains(String searchData) {
        Assert.assertEquals(searchField.getAttribute("value"), searchData);
        Assert.assertTrue(searchRegistr(searchCardsProduct, searchData, false));
    }
}
