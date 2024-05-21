package org.example.features.scenarios;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.example.steps.serenity.EndUserSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("features/function/loginValidData.csv")
public class AddToCartUIScenarioTest {
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
    public void test_valid_add_to_cart_ui() {
        // Login
        user.logsIn(username, password);
        user.checkLoginSuccessful();

        // Add to cart
        user.checkAddToCartButtonsProperties();
        user.addAllItemsToCart();
        user.checkAddedToCartButtonsProperties();

        // Logout
        user.logsOut();
        user.checkLogoutSuccessful();
    }
}
