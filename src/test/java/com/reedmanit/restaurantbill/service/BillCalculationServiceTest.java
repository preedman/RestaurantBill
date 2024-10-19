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
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author preed
 */
public class BillCalculationServiceTest {
    
    private static Bill aBill;
    
    public BillCalculationServiceTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        
        
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testCalculateTheBillFirstTest() {
        System.out.println("calculateTheBillFirstTest");
        
        aBill = new Bill();
        
        NumberField aBillTotal = new NumberField();
        aBillTotal.setValue(120.35);
        
        NumberField aTipPercent = new NumberField();
        aTipPercent.setValue(15.0);
        
        IntegerField split = new IntegerField();
        split.setValue(4);
        
        aBill.setBillTotal(aBillTotal);
        aBill.setTipPercent(aTipPercent);
        aBill.setSplitBetween(split);
        
        
        
        BillCalculationService instance = new BillCalculationService();
        
        instance.setTheBill(aBill);
        instance.calculateTheBill();
        
        aBill = instance.getBill();
        
        assertEquals(138.4,aBill.getBillAndTipTotal().getValue() );
        assertEquals(18.05, aBill.getBillTip().getValue());
        assertEquals(34.60, aBill.getAmountPerPerson().getValue());
        
        
       
    }
    
    @Test
    public void testCalculateTheBillSecondTest() {
        System.out.println("calculateTheBillSecondTest");
        
        aBill = new Bill();
        
        NumberField aBillTotal = new NumberField();
        aBillTotal.setValue(120.35);
        
        NumberField aTipPercent = new NumberField();
        aTipPercent.setValue(0.0);
        
        IntegerField split = new IntegerField();
        split.setValue(2);
        
        aBill.setBillTotal(aBillTotal);
        aBill.setTipPercent(aTipPercent);
        aBill.setSplitBetween(split);
        
        
        
        BillCalculationService instance = new BillCalculationService();
        
        instance.setTheBill(aBill);
        
        instance.calculateTheBill();
        
        aBill = instance.getBill();
        
        assertEquals(120.35,aBill.getBillAndTipTotal().getValue() );
        assertEquals(0.0, aBill.getBillTip().getValue());
        assertEquals(60.17, aBill.getAmountPerPerson().getValue());
    }
    
    @Test
    public void testCalculateTheBillThirdTest() {
        System.out.println("calculateTheBillThirdTest");
        
        aBill = new Bill();
        
        NumberField aBillTotal = new NumberField();
        aBillTotal.setValue(120.35);
        
        NumberField aTipPercent = new NumberField();
        aTipPercent.setValue(0.0);
        
        IntegerField split = new IntegerField();
        split.setValue(1);
        
        aBill.setBillTotal(aBillTotal);
        aBill.setTipPercent(aTipPercent);
        aBill.setSplitBetween(split);
        
        
        
        BillCalculationService instance = new BillCalculationService();
        
        instance.setTheBill(aBill);
        
        instance.calculateTheBill();
        
        aBill = instance.getBill();
        
        assertEquals(120.35,aBill.getBillAndTipTotal().getValue() );
        assertEquals(0.0, aBill.getBillTip().getValue());
        assertEquals(120.35, aBill.getAmountPerPerson().getValue());
    }

    @Test
    public void testCalculateTheBillFourthTest() {
        System.out.println("calculateTheBillFourthTest");
        
        aBill = new Bill();
        
        NumberField aBillTotal = new NumberField();
        aBillTotal.setValue(120.35);
        
        NumberField aTipPercent = new NumberField();
        aTipPercent.setValue(10.0);
        
        IntegerField split = new IntegerField();
        split.setValue(1);
        
        aBill.setBillTotal(aBillTotal);
        aBill.setTipPercent(aTipPercent);
        aBill.setSplitBetween(split);
        
        
        
        BillCalculationService instance = new BillCalculationService();
        
        instance.setTheBill(aBill);
        
        instance.calculateTheBill();
        
        aBill = instance.getBill();
        
        assertEquals(132.39,aBill.getBillAndTipTotal().getValue() );
        assertEquals(12.04, aBill.getBillTip().getValue());
        assertEquals(132.39, aBill.getAmountPerPerson().getValue());
    }
    
}
