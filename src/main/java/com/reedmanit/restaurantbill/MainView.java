package com.reedmanit.restaurantbill;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.reedmanit.restaurantbill.model.Security;
import com.vaadin.flow.component.Text;
import static com.vaadin.flow.component.button.ButtonVariant.LUMO_TERTIARY_INLINE;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;

@Route
public class MainView extends VerticalLayout {

    
    
    private Notification notification;
    
    public MainView() {

        var layout = new HorizontalLayout(new H1("Restaurant Bill"));
        layout.setWidthFull();
        layout.getStyle().set("border", "1px solid");
        layout.setJustifyContentMode(JustifyContentMode.CENTER);

        this.add(layout);
        
        PasswordField passCodeTF = new PasswordField();
        //passCodeTF.setRequiredIndicatorVisible(true);
        
        //TextField passCodeTF = new TextField("Passcode");
        passCodeTF.setRequiredIndicatorVisible(true);
        passCodeTF.setMaxLength(18);
        passCodeTF.setRevealButtonVisible(true);
        passCodeTF.setHelperText("Enter Passcode to use app");

        this.add(passCodeTF);

        Button button = new Button("Login");
        this.add(button);
        //  button.addClickListener(e
        //          -> button.getUI().ifPresent(ui
        //                  -> ui.navigate("billform"))
        //  );

        button.addClickListener(event -> {
            if (checkPasscode(passCodeTF.getValue()) == true) {
                button.getUI().ifPresent(ui -> ui.navigate("billform"));
            } else {
                createErrorNotification();
                notification.open();
            }
        });

        var footer = new HorizontalLayout(new H3("Safe Software - ReedmanIT"));

        footer.setWidthFull();
        footer.getStyle().set("border", "1px solid");
        footer.setJustifyContentMode(JustifyContentMode.CENTER);
        this.add(footer);

        //  return new VerticalLayout(layout, container, footer);
    }

    private Boolean checkPasscode(String userPassCode) {

        Security s = Security.getInstance();

        s.retrievePassCode();

        s.validatePasscode(userPassCode);

        return s.validPassCode;

    }

    private void createErrorNotification() {

        notification = new Notification();
        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);

        Icon icon = VaadinIcon.WARNING.create();
        Button retryBtn = new Button("Retry",
                clickEvent -> notification.close());
        retryBtn.getStyle().setMargin("0 0 0 var(--lumo-space-l)");

        var layout = new HorizontalLayout(icon,
                new Text("Passcode Not Valid !!!"), retryBtn,
                createCloseBtn(notification));
        layout.setAlignItems(FlexComponent.Alignment.CENTER);

        notification.add(layout);
        
        this.add(notification);
        
        

    }

    private Button createCloseBtn(Notification notification) {
        Button closeBtn = new Button(VaadinIcon.CLOSE_SMALL.create(),
                clickEvent -> notification.close());
        closeBtn.addThemeVariants(LUMO_TERTIARY_INLINE);

        return closeBtn;
    }

}
