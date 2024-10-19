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
import com.reedmanit.restaurantbill.model.BillOld;
import com.reedmanit.restaurantbill.service.BillCalculationService;
import com.reedmanit.restaurantbill.service.BillService;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.TextFieldVariant;
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
    
    public BillForm() {
        
        billService = new BillCalculationService();
        theBill = new Bill();
        setUpForm();
        
    }
    
    private void setUpForm() {
        billTotal = new NumberField("Bill Total");
        tipPercentNumber = new NumberField();
        
        
        billTotal.addValueChangeListener(event -> { 
            theBill = new Bill();
            
            theBill.setBillTotal(billTotal);
            theBill.setTipPercent(tipPercentNumber);
            theBill.setSplitBetween(splitBetween);
            
            billService.setTheBill(theBill);
            
            billService.calculateTheBill();
            
            setOutputvalues();
            
            
            
            
            
            
        });
        
     //   billTip = new NumberField("Bill Tip");
        billTotalIncTip = new NumberField("Bill Total Inc Tip");
        
        tipInput = new NumberField("Tip %");
        tipInput.setValue(10.0);
       
       tipPercentNumber.setValue(10.0);
        
        theBill.setTipPercent(tipPercentNumber);
        tipInput.setStepButtonsVisible(true);
        tipInput.setMin(0);
        tipInput.setMax(20);
        
        tipInput.addValueChangeListener(event -> { 
             theBill = new Bill();
            
            theBill.setBillTotal(billTotal);
            theBill.setTipPercent(tipInput);
            theBill.setSplitBetween(splitBetween);
            
            billService.setTheBill(theBill);
            
            billService.calculateTheBill();
            
            setOutputvalues();
            
            
            
             
            
        });
        
        splitBetween = new IntegerField("Split Between Number of People");
        splitBetween.setValue(2);
        
        IntegerField i = new IntegerField();
        i.setValue(1);
        
        theBill.setSplitBetween(i);
        
        splitBetween.setStepButtonsVisible(true);
        splitBetween.setMin(1);
        splitBetween.setMax(10);
        
        splitBetween.addValueChangeListener(event -> {
            
             theBill = new Bill();
            
            theBill.setBillTotal(billTotal);
            theBill.setTipPercent(tipInput);
            theBill.setSplitBetween(splitBetween);
            
            billService.setTheBill(theBill);
            
            billService.calculateTheBill();
            
            setOutputvalues();
            
            
            
        });
        
        totalTipValue = new NumberField("The Total Value of the Tip");
        
        
        
        amtEachPersonPays = new NumberField("Amount each person pays");
        
        
        
        billTotal.addThemeVariants(TextFieldVariant.LUMO_ALIGN_CENTER);
        
        this.add(billTotal);
      //  this.add(billTip);
        this.add(billTotalIncTip);
        this.add(tipInput);
        this.add(splitBetween);
        this.add(totalTipValue);
        this.add(amtEachPersonPays);
        
        ResponsiveStep small = new ResponsiveStep("1px", 1);
        ResponsiveStep r1 = new ResponsiveStep("800px", 2);
       // ResponsiveStep r2 = new ResponsiveStep("800px", 3);
        
        this.setResponsiveSteps(small, r1);
        
        
        
    //    splitTip.setValue(theBill.getSplitTip());
    //    amtEachPersonPays.setValue(theBill.getAmountPerPerson());
        

        /**
         * this.addFormItem(billTotal, "Bill Total"); this.addFormItem(billTip,
         * "Tip"); this.addFormItem(billTotalIncTip, "Total (including tip)");
         * this.addFormItem(tip, "Tip %"); this.addFormItem(splitBetween, "Split
         * Between"); this.addFormItem(splitTip, "Split Tip");
         * this.addFormItem(amtEachPersonPays, "Amount Each Person Pays");
        *
         */
    }
    
    private void setOutputvalues() {
        
        billTotalIncTip.setValue(billService.getBill().getBillAndTipTotal().getValue());
        amtEachPersonPays.setValue(billService.getBill().getAmountPerPerson().getValue());
        totalTipValue.setValue(billService.getBill().getBillTip().getValue());
        
        
    }
    
    
    
}
