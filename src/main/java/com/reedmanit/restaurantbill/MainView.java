package com.reedmanit.restaurantbill;

import com.reedmanit.restaurantbill.view.BillForm;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

    public MainView() {
        
        
        BillForm billForm = new BillForm();
        
        
        
        this.add(new H1("Restaurant Bill"), billForm);
        
        this.setAlignItems(Alignment.CENTER);
    }
}
