/**
 * CSCI 3130 - Assignment 3
 * 
 * I have modified the default Vaadin application.
 */

package com.example.email_validator;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
public class EmailValidatorUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        
        final TextField name = new TextField();
        name.setCaption("Enter email address:");

        Button button = new Button("Validate");
        Label label = new Label();
        
        button.addClickListener( e -> {
        	if (EmailValidator.validate(name.getValue()))
            	label.setCaption("Email valid, passed all tests.");
            else
            	label.setCaption("Email invalid, did not pass all tests.");
        });
        
        layout.addComponents(name, button, label);
        layout.setMargin(true);
        layout.setSpacing(true);
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = EmailValidatorUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
