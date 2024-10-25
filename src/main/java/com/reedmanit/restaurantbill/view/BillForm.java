/*
 * Copyright 2024 preed.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.reedmanit.restaurantbill.view;

import com.reedmanit.restaurantbill.model.Bill;
import com.reedmanit.restaurantbill.service.BillCalculationService;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.data.binder.Binder;

/**
 *
 * @author preed
 */
public class BillForm extends FormLayout {

    private NumberField billTotal;

    private NumberField billTip;

    private NumberField billTotalIncTip;

    private NumberField tipInput;

    private IntegerField splitBetween;

    private NumberField totalTipValue;

    private NumberField amtEachPersonPays;

    private Binder binder;

    private Bill theBill;

    private BillCalculationService billService;

    private NumberField tipPercentNumber;

    private VerticalLayout vl;

    public BillForm() {

        billService = new BillCalculationService();
        theBill = new Bill();

        setUpForm();

    }

    private void setUpForm() {

        layoutTheForm();

        billTotal.addValueChangeListener(event -> {

            setTheBillValues();

            billService.setTheBill(theBill);

            billService.calculateTheBill();

            setOutputvalues();

        });

        tipInput.addValueChangeListener(event -> {

            tipPercentNumber.setValue(event.getValue());

            setTheBillValues();

            billService.setTheBill(theBill);

            billService.calculateTheBill();

            setOutputvalues();

        });

        splitBetween.addValueChangeListener(event -> {

            setTheBillValues();

            billService.setTheBill(theBill);

            billService.calculateTheBill();

            setOutputvalues();

        });

    }

    private void setOutputvalues() {

        billTotalIncTip.setValue(billService.getBill().getBillAndTipTotal().getValue());
        amtEachPersonPays.setValue(billService.getBill().getAmountPerPerson().getValue());
        totalTipValue.setValue(billService.getBill().getBillTip().getValue());

    }

    private void layoutTheForm() {

        billTotal = new NumberField("Bill Total");
        
        billTotal.setRequired(true);
        
        tipPercentNumber = new NumberField();

        billTotalIncTip = new NumberField("Bill Total Inc Tip");
        
        billTotalIncTip.setReadOnly(true);
        
        
       

        tipInput = new NumberField("Tip %");
        tipInput.setValue(10.0);

        tipPercentNumber.setValue(10.0);

        theBill.setTipPercent(tipPercentNumber);
        tipInput.setStepButtonsVisible(true);
        tipInput.setMin(0);
        tipInput.setMax(20);

        splitBetween = new IntegerField("Split Between Number of People");
        splitBetween.setValue(2);

        IntegerField i = new IntegerField();
        i.setValue(1);

        theBill.setSplitBetween(i);

        splitBetween.setStepButtonsVisible(true);
        splitBetween.setMin(1);
        splitBetween.setMax(10);

        totalTipValue = new NumberField("The Total Value of the Tip");
        
        totalTipValue.setReadOnly(true);

        amtEachPersonPays = new NumberField("Amount each person pays");
        
        amtEachPersonPays.setReadOnly(true);

        this.add(billTotal);
        
        this.add(tipInput);
        this.add(splitBetween);

        this.add(billTotalIncTip);
        
        this.add(totalTipValue);
        
        this.add(amtEachPersonPays);
        
        
        
        

        ResponsiveStep small = new ResponsiveStep("0", 1);

        this.setResponsiveSteps(small);

    }

    private void setTheBillValues() {

        theBill = new Bill();

        theBill.setBillTotal(billTotal);
        theBill.setTipPercent(tipPercentNumber);
        theBill.setSplitBetween(splitBetween);

    }

}
