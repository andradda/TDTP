package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class OrderConfirmationPage extends PageObject {
    @FindBy(id = "finish")
    private WebElementFacade finishButton;
    @FindBy(id = "cancel")
    private WebElementFacade cancelButton;

    public void clickFinishButton() {
        finishButton.click();
    }
    public void clickCancelButton() {
        cancelButton.click();
    }
}
