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
package com.reedmanit.restaurantbill.model;

import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;

/**
 *
 * @author preed
 */
public class Bill {
    
    // The inputs into the bill
    private NumberField billTotal;  // the total amount that is payable
    private NumberField tipPercent; // the % tip  - default is 10%
    private IntegerField splitBetween; // how many people will be splitting the bill - default is 1
    
    // The outputs from the Bill
    
    private NumberField billAndTipTotal; // billTotal + Tip
    private NumberField billTip;  // the bill total * tip percent ( expressed as a decimal )
    private NumberField amountPerPerson; // the amount each person will pay - billAndTipTotal / splitBetween
    
    public Bill() {
        
        billTotal = new NumberField();
        billTotal.setValue(0.0);
        
        tipPercent = new NumberField();
        tipPercent.setValue(0.0);
        
        splitBetween = new IntegerField();
        splitBetween.setValue(1);
        
        billAndTipTotal = new NumberField();
        billAndTipTotal.setValue(0.0);
        
        billTip = new NumberField();
        billTip.setValue(0.0);
        
        amountPerPerson = new NumberField();
        amountPerPerson.setValue(0.0);
        
    }

    /**
     * @return the billTotal
     */
    public NumberField getBillTotal() {
        return billTotal;
    }

    /**
     * @param billTotal the billTotal to set
     */
    public void setBillTotal(NumberField billTotal) {
        this.billTotal = billTotal;
    }

    /**
     * @return the tipPercent
     */
    public NumberField getTipPercent() {
        return tipPercent;
    }

    /**
     * @param tipPercent the tipPercent to set
     */
    public void setTipPercent(NumberField tipPercent) {
        this.tipPercent = tipPercent;
    }

    /**
     * @return the splitBetween
     */
    public IntegerField getSplitBetween() {
        return splitBetween;
    }

    /**
     * @param splitBetween the splitBetween to set
     */
    public void setSplitBetween(IntegerField splitBetween) {
        this.splitBetween = splitBetween;
    }

    /**
     * @return the billAndTipTotal
     */
    public NumberField getBillAndTipTotal() {
        return billAndTipTotal;
    }

    /**
     * @param billAndTipTotal the billAndTipTotal to set
     */
    public void setBillAndTipTotal(NumberField billAndTipTotal) {
        this.billAndTipTotal = billAndTipTotal;
    }

    /**
     * @return the billTip
     */
    public NumberField getBillTip() {
        return billTip;
    }

    /**
     * @param billTip the billTip to set
     */
    public void setBillTip(NumberField billTip) {
        this.billTip = billTip;
    }

    /**
     * @return the amountPerPerson
     */
    public NumberField getAmountPerPerson() {
        return amountPerPerson;
    }

    /**
     * @param amountPerPerson the amountPerPerson to set
     */
    public void setAmountPerPerson(NumberField amountPerPerson) {
        this.amountPerPerson = amountPerPerson;
    }
    
    
    
    
}
