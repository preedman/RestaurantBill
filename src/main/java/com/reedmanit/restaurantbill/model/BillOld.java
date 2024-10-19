/*
 * Copyright 2023 preed.
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

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;


/**
 *
 * @author Paul 
 * Tip = Bill Total * Tip%
 */
public class BillOld {

    private NumberField billTotal;
    private NumberField tip;
    private NumberField billAndTipTotal;

    private NumberField tipPercent;
    private IntegerField splitBetween;
    private NumberField splitTip;
    private NumberField amountPerPerson;

    private NumberField total;
    
    private static DecimalFormat decFormat; 
    

    public BillOld() {
        
        billTotal = new NumberField();
        tip = new NumberField();
        billAndTipTotal = new NumberField();
        tipPercent = new NumberField();
        splitBetween = new IntegerField();
        splitTip = new NumberField();
        amountPerPerson = new NumberField();
        total = new NumberField();
        
        decFormat = new DecimalFormat("0.00");
        decFormat.setRoundingMode(RoundingMode.DOWN);
        this.billTotal.setValue(0.0);
        this.tip.setValue(0.0);
        this.amountPerPerson.setValue(0.0);
        this.splitBetween.setValue(0);
        this.splitTip.setValue(0.0);
        
        this.tipPercent.setValue(0.0);
        this.total.setValue(0.0);
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
     * @return the tip
     * Tip = Bill Total * Tip Percent
     */
    public NumberField getTip() {
        
        
        
        Double dtip = this.billTotal.getValue() * this.tipPercent.getValue();
        BigDecimal bd = new BigDecimal(dtip).setScale(2, RoundingMode.HALF_UP);
        this.tip.setValue(bd.doubleValue());
        
        return tip;
    }

    /**
     * @param tip the tip to set
     */
    public void setTip(NumberField tip) {
        this.tip = tip;
    }

    /**
     * @return the billAndTipTotal
     * This is the Bill Total + the Tip
     */
    public NumberField getBillAndTipTotal() {
        
        Double dBillAndTip = this.getBillTotal().getValue() + this.getTip().getValue();
       
        BigDecimal bd = new BigDecimal(dBillAndTip).setScale(2, RoundingMode.HALF_UP);
        
        this.billAndTipTotal.setValue(bd.doubleValue());
        
        return billAndTipTotal;
    }

    /**
     * @param billAndTipTotal the tipTotal to set
     */
    public void setBillAndTipTotal(NumberField billAndTipTotal) {
        this.billAndTipTotal = billAndTipTotal;
    }

    /**
     * @return the tipPercent
     */
    public NumberField getTipPercent() {
        return tipPercent;
    }
    
    public NumberField getTipPercentNumber() {
        Double d = null;
        d = this.getTipPercent().getValue() / 100.0;
        NumberField n = new NumberField();
        n.setValue(d);
        return n;
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
     * @return the amountPerPerson
     */
    public NumberField getAmountPerPerson() {
        Double amtPerPerson = this.getBillAndTipTotal().getValue() / this.getSplitBetween().getValue();
        
        BigDecimal bd = new BigDecimal(amtPerPerson).setScale(2, RoundingMode.HALF_UP);
        amountPerPerson.setValue(bd.doubleValue());
        return amountPerPerson;
    }

    /**
     * @param amountPerPerson the amountPerPerson to set
     */
    public void setAmountPerPerson(NumberField amountPerPerson) {
        this.amountPerPerson = amountPerPerson;
    }

    /**
     * @return the total
     */
    public NumberField getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(NumberField total) {
        this.total = total;
    }

    /**
     * @return the splitTip
     */
    public NumberField getSplitTip() {
        
        Double splitTheTip = this.getTip().getValue() / this.getSplitBetween().getValue();
       
       
        BigDecimal bd = new BigDecimal(splitTheTip).setScale(2, RoundingMode.HALF_UP);
        splitTip.setValue(splitTheTip);
        return splitTip;
    }

}
