/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serverside;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author duffy
 */
public class Account {

    private final String accountName;
    private final int accountNum;
    private final String username;
    private final String password;
    private BigDecimal balance;
    private long sessionID;
    private long sessionStart;
    private List<Transaction> transactions;
    private Statement s;

    public Account(String name, String username, String password) {
        this.accountName = name;
        this.username = username;
        this.password = password;
        //Randomly generates AccountNumber
        int leftL = 100000000;
        int rightL = 999999999;
        this.accountNum = leftL + (int) (Math.random() * (rightL - leftL));
    }

    public String getUsername() {
        return username;
    }
    
    public BigDecimal getBalance() {
        return balance;
    }
    
    public void deposit(BigDecimal amount, Date date){
        balance.add(amount);
        transactions.add(new Transaction(username, amount, date, "Deposit"));
    }
    
    public void withdraw(BigDecimal amount, Date date){
        if(balance.subtract(amount).compareTo(new BigDecimal(0)) > 0){
            balance.subtract(amount);
            transactions.add(new Transaction(username, amount, date, "Withdrawal"));
        }

    }

    public boolean checkPassword(String input) {
        //Checks input password against stored password
        if (input.equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public long createSession() {
        //Creates session ID by generating random long value
        long leftL = 100000000L;
        long rightL = 999999999L;
        long sessionID = leftL + (long) (Math.random() * (rightL - leftL));
        //Session Time is tracked by checking time against session Start
        sessionStart = System.currentTimeMillis();
        return sessionID;
    }

    public boolean checkSession(long iSessionID) throws InvalidSession {
        //Checks if Session matches and is currently active
        if (this.sessionID == iSessionID && (System.currentTimeMillis()- sessionStart) < 300000) {
            return true;
        } else {
            throw new InvalidSession();
        }

    }

    public Statement getStatement(long iSessionID, Date from, Date to) throws InvalidSession {
        
        try {
            if (checkSession(iSessionID)) {
                //Creates statment instance
                s = new BankStatement(accountName, accountNum, from, to);
                for(Transaction t: transactions){
                    //Adds transactions to the Statement 
                    if(t.getDate().after(from) && t.getDate().before(to)){
                        s.addTransaction(t);
                    }
                }
                //Returning Statement 
                return s;
            }
        } catch (InvalidSession e) {

        }
        return null;
    }
}
