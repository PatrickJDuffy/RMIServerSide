/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serverside;

import java.util.Date;
import java.util.List;

/**
 *
 * @author duffy
 */
public class BankStatement implements Statement{
    
    private final String accountName;
    private final int accountNum;
    private final Date startDate;
    private final Date endDate;
    private List<Transaction> transactions;
    
    
    public BankStatement(String accountName, int accountNum, Date start, Date end){
        this.accountName = accountName;
        this.accountNum = accountNum;
        this.startDate = start;
        this.endDate = end;
    }
    
    public void addTransaction(Transaction t){
    transactions.add(t);
    }
    
    @Override
    public int getAccountnum(){
        return accountNum;
    }

    @Override
    public Date getStartDate(){
        return startDate;
    }

    @Override
    public Date getEndDate(){
        return endDate;
    }

    @Override
    public String getAccoutName(){
        return accountName;
    }

    @Override
    public List<Transaction> getTransactions(){
        return transactions;
    }
    
    

}
