package com.demoblaze.step_Defs;

import com.demoblaze.pages.CartPage;
import com.demoblaze.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Purchase_StepDefs {
    HomePage homePage = new HomePage();
    CartPage cartPage = new CartPage();
    int expectedPurchaseAmount = 0;

    @When("The user adds {string} from {string}")
    public void the_user_adds_from(String product, String category) {
        System.out.println("homePage.addProduct(product, category) = " + homePage.addProduct(product, category));
        System.out.println("expectedPurchaseAmount = " + expectedPurchaseAmount);
        expectedPurchaseAmount += homePage.addProduct(product, category);
        System.out.println("expectedPurchaseAmount = " + expectedPurchaseAmount);

    }

    @When("The user removes {string} from cart")
    public void the_user_removes_from_cart(String removeProduct) {
        System.out.println("cartPage.removerProduct(removeProduct) = " + cartPage.removerProduct(removeProduct));
        System.out.println("expectedPurchaseAmount = " + expectedPurchaseAmount);
        expectedPurchaseAmount -= cartPage.removerProduct(removeProduct);
        System.out.println("expectedPurchaseAmount = " + expectedPurchaseAmount);

    }

    @When("The user places order and captures and log amounts")
    public void the_user_palces_order_and_captures_and_log_amounts() {
        cartPage.finishPurchase_logAmount();

    }

    @Then("The user verifies purchase amount")
    public void the_user_verifies_purchase_amount() {
        cartPage.verifyPurchaseAmount(expectedPurchaseAmount);

    }

}
