package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class PlacedOrderPage extends PageObject {
    @FindBy(id = "back-to-products")
    private WebElementFacade backHomeButton;
    @FindBy(css = "[data-test='complete-header']")
    private WebElementFacade confirmationText;

    public void clickBackHomeButton() {
        backHomeButton.click();
    }

    public String getConfirmationText() {
        return confirmationText.getText();
    }
}
