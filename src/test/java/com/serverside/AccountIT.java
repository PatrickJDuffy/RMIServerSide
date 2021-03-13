/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serverside;

import java.math.BigDecimal;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author duffy
 */
public class AccountIT {
    
    public AccountIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getUsername method, of class Account.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Account instance = new Account("Patrick Duffy", "P.Duffy7", "password");
        String expResult = "P.Duffy7";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBalance method, of class Account.
     */
    @Test
    public void testGetBalance() {
        System.out.println("getBalance");
        Account instance = new Account("Patrick Duffy", "P.Duffy7", "password");
        Date date = new Date(System.currentTimeMillis());
        BigDecimal amount = new BigDecimal(100);
        instance.deposit(amount, date);
        BigDecimal expResult = amount;
        BigDecimal result = instance.getBalance();
        assertEquals(expResult, result);
    }

    /**
     * Test of deposit method, of class Account.
     */
    @Test
    public void testDeposit() {
        System.out.println("deposit");
        Account instance = new Account("Patrick Duffy", "P.Duffy7", "password");
        Date date = new Date(System.currentTimeMillis());
        BigDecimal amount = new BigDecimal(100);
        instance.deposit(amount, date);
        BigDecimal expResult = amount;
        BigDecimal result = instance.getBalance();
        assertEquals(expResult, result);
    }

    /**
     * Test of withdraw method, of class Account.
     */
    @Test
    public void testWithdraw() {
        System.out.println("withdraw");
        Account instance = new Account("Patrick Duffy", "P.Duffy7", "password");
        Date date = new Date(System.currentTimeMillis());
        BigDecimal balance = new BigDecimal(100);
        BigDecimal amount = new BigDecimal(50);
        instance.deposit(balance, date);
        instance.withdraw(amount, date);
        BigDecimal expResult = amount;
        BigDecimal result = instance.getBalance();
        assertEquals(expResult, result);
    }

    /**
     * Test of checkPassword method, of class Account.
     */
    @Test
    public void testCheckPassword() {
        System.out.println("checkPassword");
        String password = "password";
        Account instance = new Account("Patrick Duffy", "P.Duffy7", "password");
        boolean expResult = true; 
        boolean result = instance.checkPassword(password);
        assertEquals(expResult, result);
    }

    /**
     * Test of createSession method does not need to be tested
     */
//    @Test
//    public void testCreateSession() {
////        System.out.println("createSession");
////        Account instance = new Account("Patrick Duffy", "P.Duffy7", "password");
////        long expResult = 0L;
////        long result = instance.createSession();
////        assertEquals(expResult, result);
//
//    }

    /**
     * Test of checkSession method, of class Account.
     */
    @Test
    public void testCheckSession() throws Exception {
        System.out.println("checkSession");
        Account instance = new Account("Patrick Duffy", "P.Duffy7", "password");
        long iSessionID = instance.createSession();
        boolean expResult = true;
        boolean result = instance.checkSession(iSessionID);
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatement method, of class Account.
     */
    @Test
    public void testGetStatement() throws Exception {
        System.out.println("getStatement");
        long iSessionID = 0L;
        Date from = null;
        Date to = null;
        Account instance = null;
        Statement expResult = null;
        Statement result = instance.getStatement(iSessionID, from, to);
        assertEquals(expResult, result);
    }
    
}
