/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serverside;

import java.util.Date;
/**
 *
 * @author duffy
 */
public interface Statement extends Serializable {

    public int getAccountnum();  // returns account number associated with this statement

    public Date getStartDate(); // returns start Date of Statement

    public Date getEndDate(); // returns end Date of Statement

    public String getAccoutName(); // returns name of account holder

    public List<Transaction> getTransactions(); // return list of transactions included in this statement  
}
