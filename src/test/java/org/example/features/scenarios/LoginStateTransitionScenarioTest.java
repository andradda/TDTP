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
@UseTestDataFrom("features/function/loginInvalidData.csv")
public class LoginStateTransitionScenarioTest {
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
    public void test_invalid_login_blocking_attempt() {
        int number_of_attempts = 7;
        for (int i = 1; i <= number_of_attempts; i++) {
            user.logsIn(username, password);
            user.checkLoginFailed();
        }
        user.checkBlockLoginAttempts(number_of_attempts, 7);
    }
}
