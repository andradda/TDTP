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
public class SessionTimeoutQuickTestingScenarioTest {
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
    public void test_session_timeout() throws InterruptedException {
        // Step 1: Log in with valid credentials
        user.logsIn(username, password);

        // Step 2: Wait for the session to timeout in a predefined number of minutes (10)
        // Convert minutes to milliseconds (10 * 60 * 1000)
        long sessionTimeoutInMillis = 10 * 60 * 1000;
        Thread.sleep(sessionTimeoutInMillis); // Adding a buffer to ensure timeout

        // Step 3: Attempt to perform an action that requires an active session
        // For example, clicking on an item
        user.addItemToCart();

        // Step 4: Check if it redirects to the login page after 10 minutes
        user.checkRedirectedLoginPage();
    }
}
