package stepDefinitions;

import com.driverFactory.DriverFactory;
import com.pages.AccountsPage;
import com.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class AccountsPageSteps {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private AccountsPage accountsPage;

    @Given("user has already logged in to the application")
    public void user_has_already_logged_in_to_the_application(DataTable credTable) {
        List<Map<String, String>> credList = credTable.asMaps();
        String userName = credList.get(0).get("username");
        String password = credList.get(0).get("password");

        DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        accountsPage = loginPage.login(userName, password);
    }

    @Given("user is on Accounts page")
    public void user_is_on_accounts_page() {
        String title = accountsPage.getAccountsPageTitle();
        System.out.println(title);
    }

    @Then("user gets accounts section")
    public void user_gets_accounts_section(DataTable sectionsTable) {
        List<String> expectedAccountsSectionList = sectionsTable.asList();
        System.out.println("Expected accounts List: " + expectedAccountsSectionList);

        List<String> actualAccountsSectionList = accountsPage.getAccountsSectionList();
        System.out.println("Actual accounts List: " + actualAccountsSectionList);

        Assert.assertTrue(expectedAccountsSectionList.containsAll(actualAccountsSectionList));
    }

    @Then("accounts section count should be {int}")
    public void accounts_section_count_should_be(Integer expectedCount) {
        Assert.assertEquals(accountsPage.getAccountsSectionCount(), (int) expectedCount);
    }
}
