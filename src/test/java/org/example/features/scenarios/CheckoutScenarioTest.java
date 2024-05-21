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
@UseTestDataFrom("features/function/valid_checkout_data.csv")
public class CheckoutScenarioTest {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps user;

    public String username, password, firstName, lastName, postalCode;

    @Before
    public void maximize() {
        webdriver.manage().window().maximize();
    }

    @Test
    @Ignore
    public void valid_checkout() {
        user.logsIn(username, password);
        user.checkLoginSuccessful();

        user.addRandomItemToCart();
        user.checkAddItemToCartSuccessful();

        user.checkout(firstName, lastName, postalCode);

        user.logsOut();
        user.checkLogoutSuccessful();
    }
    @Test
    //@Ignore
    public void valid_unfinished_checkout() {
        user.logsIn(username, password);
        user.checkLoginSuccessful();

        user.addRandomItemToCart();
        user.checkAddItemToCartSuccessful();

        user.unfinished_checkout(firstName, lastName, postalCode);

        user.logsOut();
        user.checkLogoutSuccessful();
    }
}

