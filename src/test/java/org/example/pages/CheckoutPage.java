package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class CheckoutPage extends PageObject {
    @FindBy(id = "cancel")
    private WebElementFacade cancelButton;
    @FindBy(id = "continue")
    private WebElementFacade continueButton;
    @FindBy(id = "first-name")
    private WebElementFacade firstNameField;
    @FindBy(id = "last-name")
    private WebElementFacade lastNameField;
    @FindBy(id = "postal-code")
    private WebElementFacade postalCodeField;

    public void clickCancelButton() {
        cancelButton.click();
    }
    public void clickContinueButton() {
        continueButton.click();
    }
    public void setFirstNameField(String firstName) {
        waitFor(firstNameField);
        typeInto(firstNameField, firstName);
    }

    public void setLastNameField(String lastName) {
        waitFor(lastNameField);
        lastNameField.waitUntilClickable();
        typeInto(lastNameField, lastName);
    }

    public void setPostalCodeField(String postalCode) {
        waitFor(postalCodeField);
        postalCodeField.waitUntilClickable();
        typeInto(postalCodeField, postalCode);
    }
}