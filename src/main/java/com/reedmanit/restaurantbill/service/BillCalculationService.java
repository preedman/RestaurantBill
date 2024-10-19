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
package com.reedmanit.restaurantbill.service;

import com.reedmanit.restaurantbill.model.Bill;
import com.reedmanit.restaurantbill.model.BillOld;
import com.vaadin.flow.component.textfield.NumberField;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author preed
 */
public class BillCalculationService {
    
    private Bill theBill;
    
    public BillCalculationService() {
        
    }
    
    public void setTheBill(Bill aBill) {
        theBill = aBill;
    }
    
    
    public void calculateTheBill() {
        
       calculateTheTip();
       calculateTheTotal();
       calculateAmountPerPerson();
        
        
        
    }
     // turn the tip % into a number
     // tip%
    private void calculateTheTip() {
        
       // Double t = theBill.getTipPercent().getValue() / 100;
       System.out.println("Bill Total " + theBill.getBillTotal().getValue() + " " + "Tip% " + theBill.getTipPercent().getValue());
        Double b = theBill.getBillTotal().getValue() * theBill.getTipPercent().getValue();
        b = b / 100;
        System.out.println("b " + b);
        BigDecimal bd = new BigDecimal(b).setScale(2, RoundingMode.HALF_UP);
        NumberField n = new NumberField();
        n.setValue(bd.doubleValue());
        theBill.setBillTip(n);
        
    }
    // the bill total = Bill Total + the Tip
    private void calculateTheTotal() {
        
        
        Double dBillAndTip = theBill.getBillTotal().getValue() + theBill.getBillTip().getValue();
       
        BigDecimal bd = new BigDecimal(dBillAndTip).setScale(2, RoundingMode.HALF_UP);
        
        NumberField n = new NumberField();
        
        n.setValue(bd.doubleValue());
        
        theBill.setBillAndTipTotal(n);
    }
    
    private void calculateAmountPerPerson() {
        
        Double amtPerson = theBill.getBillAndTipTotal().getValue() / theBill.getSplitBetween().getValue();
        
        BigDecimal bd = new BigDecimal(amtPerson).setScale(2, RoundingMode.HALF_UP);
        
        NumberField n = new NumberField();
        
        n.setValue(bd.doubleValue());
        
        theBill.setAmountPerPerson(n);
        
        
    }
    
    private void validateTheBill() {
        
        
        
    }
    
    public Bill getBill() {
        return theBill;
    }
    
    
    
}
