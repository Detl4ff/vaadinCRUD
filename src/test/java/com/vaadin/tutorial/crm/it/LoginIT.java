package com.vaadin.tutorial.crm.it;

import com.vaadin.tutorial.crm.it.elements.login.LoginViewElement;
import org.junit.Assert;
import org.junit.Test;

public class LoginIT extends AbstractTest {
    public LoginIT() {
        super("");
    }

    @Test
    public void loginAsValidUserSucceeds() {
        LoginViewElement loginView = $(LoginViewElement.class).onPage().first();
        Assert.assertTrue(loginView.login("user", "password"));
    }

    @Test
    public void loginAsInvalidUserFails() {
        LoginViewElement loginView = $(LoginViewElement.class).onPage().first();
        Assert.assertFalse(loginView.login("user", "invalid"));
    }

//    @Test
//    public void loginAsValidUserSucceeds() {
//        // Find the LoginForm used on the page
//        LoginFormElement form = $(LoginFormElement.class).first();
//        // Enter the credentials and log in
//        form.getUsernameField().setValue("user");
//        form.getPasswordField().setValue("password");
//        form.getSubmitButton().click();
//        // Ensure the login form is no longer visible
//        Assert.assertFalse($(LoginFormElement.class).exists());
//    }


}