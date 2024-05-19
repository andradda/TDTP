package org.example.features.scenarios;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.example.steps.serenity.EndUserSteps;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("features/function/loginProblemUserData.csv")
public class AddToCartInvalidScenarioTest {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps user;

    public String username, password;

    @Before
    public void maximize() {
        webdriver.manage().window().maximize();
    }


    @Test
    @Ignore
    public void test_invalid_add_to_cart() {
        user.logsIn(username, password);
        user.checkLoginSuccessful();

        user.addRandomInvalidItemToCart();
        user.checkAddItemToCartUnsuccessful();

        user.logsOut();
        user.checkLogoutSuccessful();
    }
}
