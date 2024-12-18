package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

import java.util.List;

public class ShoppingCartPage extends PageObject {
    @FindBy(css = "[data-test='inventory-item']")
    private List<WebElementFacade> shoppingCartItems;
    @FindBy(id = "checkout")
    private WebElementFacade checkoutButton;

    public int getQuantityOfShoppingCart() {
        return shoppingCartItems.size();
    }
    public void clickCheckOutButton() {
        checkoutButton.click();
    }
}
