package org.example.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.example.pages.*;
import org.example.utils.ColorParser;
import org.example.utils.Configuration;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class EndUserSteps {

    private LoginPage loginPage;
    private HomePage homePage;
    private ShoppingCartPage shoppingCartPage;
    private CheckoutPage checkoutPage;
    private OrderConfirmationPage orderConfirmationPage;
    private PlacedOrderPage placedOrderPage;

    @Step
    public void logsIn(String username, String password) {
        loginPage.open();
        loginPage.setUsernameField(username);
        loginPage.setPasswordField(password);
        loginPage.clickLoginButton();
    }

    @Step
    public void checkLoginSuccessful() {
        Assert.assertTrue(homePage.isVisible());
        Assert.assertEquals(Configuration.BASE_URL + "inventory.html", getDriver().getCurrentUrl());
    }

    @Step
    public void checkLoginFailed() {
        Assert.assertTrue(loginPage.loginErrorMessageIsVisible());
    }

    @Step
    public void addItemToCart() {
        homePage.clickAddToCartButtonOnItem();
    }

    @Step
    public void addAllItemsToCart() {
        homePage.clickAddToCartButtonAllItems();
    }

    @Step
    public void checkAddItemToCartSuccessful() {
        Assert.assertEquals(1, homePage.getNumberOfAddedItemsBadgeCount());
        homePage.clickShoppingCartButton();
        Assert.assertEquals(1, shoppingCartPage.getQuantityOfShoppingCart());
    }

    @Step
    public void checkAddToCartButtonsProperties() {
        List<Map<String, String>> props = homePage.getAddToCartButtonsProperties();
        for (Map<String, String> prop : props) {
            Assert.assertEquals("Add to cart", prop.get("text"));
            String color = ColorParser.parseColor(prop.get("color")).get("red");
            String border_color = ColorParser.parseColor(prop.get("border")).get("red");
            Assert.assertEquals(color, border_color);
            Assert.assertTrue(Integer.parseInt(color) < 200); // means a greater percentage of red
        }
    }

    @Step
    public void checkAddedToCartButtonsProperties() {
        List<Map<String, String>> props = homePage.getAddToCartButtonsProperties();
        for (Map<String, String> prop : props) {
            Assert.assertEquals("Remove", prop.get("text"));
            String color = ColorParser.parseColor(prop.get("color")).get("red");
            String border_color = ColorParser.parseColor(prop.get("border")).get("red");
            Assert.assertEquals(color, border_color);
            Assert.assertTrue(Integer.parseInt(color) > 200); // means a greater percentage of red
        }
    }

    @Step
    public void addRandomItemToCart() {
        homePage.clickAddToCartButtonOnRandomItem();
    }

    @Step
    public void addRandomInvalidItemToCart() {
        homePage.clickAddToCartButtonOnRandomInvalidItem();
    }

    @Step
    public void checkAddItemToCartUnsuccessful() {
        homePage.clickShoppingCartButton();
        Assert.assertEquals(0, shoppingCartPage.getQuantityOfShoppingCart());
    }

    @Step
    public void logsOut() {
        homePage.clickLogoutButton();
    }

    @Step
    public void checkLogoutSuccessful() {
        Assert.assertEquals(Configuration.BASE_URL, getDriver().getCurrentUrl());
    }

    @Step
    public void checkout(String firstName, String lastName, String postalCode) {
        homePage.clickShoppingCartButton();
        shoppingCartPage.clickCheckOutButton();
        checkoutPage.setFirstNameField(firstName);
        checkoutPage.setLastNameField(lastName);
        checkoutPage.setPostalCodeField(postalCode);
        checkoutPage.clickContinueButton();
        orderConfirmationPage.clickFinishButton();
        Assert.assertEquals("Thank you for your order!", placedOrderPage.getConfirmationText());
        placedOrderPage.clickBackHomeButton();
    }

    @Step
    public void unfinished_checkout(String firstName, String lastName, String postalCode) {
        homePage.clickShoppingCartButton();
        shoppingCartPage.clickCheckOutButton();
        checkoutPage.setFirstNameField(firstName);
        checkoutPage.setLastNameField(lastName);
        checkoutPage.setPostalCodeField(postalCode);
        checkoutPage.clickCancelButton();
    }

}