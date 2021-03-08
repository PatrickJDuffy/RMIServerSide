/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serverside;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;
/**
 *
 * @author duffy
 */
public class Transaction implements Serializable {
    
    private final String username;
    private final BigDecimal amount;
    private final Date date;
    public final String description;
    
    public Transaction(String username, BigDecimal amount, Date date, String description){
        this.username = username;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    public String getType(){
        return description;
    }
    
    public BigDecimal getAmount(){
        return amount;
    }

    public Date getDate(){
        return date;
    }

    public String getUsername(){
        return username;
    }
}
