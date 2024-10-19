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
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.IntegerField;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author preed
 */
public class BillServiceTest {

    public BillServiceTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

    @org.junit.jupiter.api.Test
    public void testCalculateBillFromTotal() {
        System.out.println("calculateBillFromTotal");

        BillOld aBill = new BillOld();
        
        IntegerField splitBetween = new IntegerField();
        splitBetween.setValue(2);
        NumberField tipPercentNumber = new NumberField();
        tipPercentNumber.setValue(0.10);

        aBill.setSplitBetween(splitBetween);
        aBill.setTipPercent(tipPercentNumber);

        NumberField billTotal = new NumberField();
        billTotal.setValue(100.0);
        
        
        BillService instance = new BillService(aBill);
        
        instance.calculateBillFromTotal(billTotal);
        
        assertEquals(110.0, instance.getTheBill().getBillAndTipTotal().getValue());
        
        assertEquals(55.0, instance.getTheBill().getAmountPerPerson().getValue());
        
        assertEquals(5.0, instance.getTheBill().getSplitTip().getValue());
        
        assertEquals(10, instance.getTheBill().getTip().getValue());
        
        System.out.println(instance.getTheBill().getTipPercentNumber().getValue());
        
       // assertEquals(10, instance.getTheBill().getTipPercentInteger());
        
        
        
        
       
    }
    @org.junit.jupiter.api.Test
    public void testcalculateBillFromTipChange() {
        
        System.out.println("calculateBillFromTipChange");

        BillOld aBill = new BillOld();
        
        IntegerField splitBetween = new IntegerField();
        splitBetween.setValue(2);
        NumberField tipPercentNumber = new NumberField();
        tipPercentNumber.setValue(0.10);

        aBill.setSplitBetween(splitBetween);
        aBill.setTipPercent(tipPercentNumber);
        
        NumberField billTotal = new NumberField();
        billTotal.setValue(100.0);

        
        
        aBill.setBillTotal(billTotal);
        
        BillService instance = new BillService(aBill);
        
        assertEquals(110.0, aBill.getBillAndTipTotal().getValue());
        
        tipPercentNumber.setValue(0.2);
        
        instance.calculateBillFromTipChange(tipPercentNumber);
        
        assertEquals(120.0, aBill.getBillAndTipTotal().getValue());
        
        
        
    }
    
    @org.junit.jupiter.api.Test
    public void testcalculateBillFromSplitChange() {
        
        System.out.println("calculateBillFromTipSplitChange");

        BillOld aBill = new BillOld();
        
        IntegerField splitBetween = new IntegerField();
        splitBetween.setValue(2);
        NumberField tipPercentNumber = new NumberField();
        tipPercentNumber.setValue(0.10);

        aBill.setSplitBetween(splitBetween);
        aBill.setTipPercent(tipPercentNumber);

        NumberField billTotal = new NumberField();
        billTotal.setValue(100.0);
        
        aBill.setBillTotal(billTotal);
        
        BillService instance = new BillService(aBill);
        
         assertEquals(110.0, aBill.getBillAndTipTotal().getValue());
         assertEquals(5.0, aBill.getSplitTip().getValue());
         assertEquals(10, aBill.getTip().getValue());
         
         IntegerField s = new IntegerField();
         s.setValue(1);
        
        instance.calculateBillFromSplitChange(s);
        
        assertEquals(110.0, aBill.getBillAndTipTotal().getValue());
         assertEquals(10.0, aBill.getSplitTip().getValue());
         assertEquals(10, aBill.getTip().getValue());
        
    }
   
    

}
