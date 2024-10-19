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

import com.reedmanit.restaurantbill.model.BillOld;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;

/**
 *
 * @author preed
 */
public class BillService {
    
    private BillOld theBill;
    
    public BillService(BillOld aBill) {
        theBill = aBill;
    }
    
    public void calculateBillFromTotal(NumberField billTotal) {
        
        theBill.setBillTotal(billTotal);
        
        
        
    }
    
    public void calculateBillFromTipChange(NumberField tipPercent) {
        theBill.setTipPercent(tipPercent);
        
        
    }
    
    public void calculateBillFromSplitChange(IntegerField splitChange) {
        theBill.setSplitBetween(splitChange);
        
        
    }
    
    public BillOld getTheBill() {
        return theBill;
    }
    
}
