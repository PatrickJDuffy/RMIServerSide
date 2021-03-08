/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serverside;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author duffy
 */
public class Bank implements BankInterface {

    private List<Account> accounts; // users accounts

    public Bank() throws RemoteException {
    }

    @Override
    public long login(String username, String password) throws RemoteException, InvalidLogin {
        for (Account a : accounts) {
            if (a.getUsername().equals(username)) {
                if (a.checkPassword(password)) {
                    return a.createSession(); //Returns the generated SessionID 
                }
            }
        }
        throw new InvalidLogin();
    }

    @Override
    public void deposit(int account, BigDecimal amount, long sessionID) throws RemoteException, InvalidSession {
        Date date = new Date(System.currentTimeMillis());
        //Check for valid session
        for (Account a : accounts) {
            if(a.checkSession(sessionID)){
                a.deposit(amount, date);
            }
        }
        throw new InvalidSession();

    }

    @Override
    public void withdraw(int account, BigDecimal amount, long sessionID) throws RemoteException, InvalidSession {
        Date date = new Date(System.currentTimeMillis());
        //Check for valid session
        for (Account a : accounts) {
            if(a.checkSession(sessionID)){
                a.withdraw(amount, date);
            }
        }
        throw new InvalidSession();
    }

    @Override
    public BigDecimal getBalance(int account, long sessionID) throws RemoteException, InvalidSession {
        for (Account a : accounts) {
            if(a.checkSession(sessionID)){
                return a.getBalance();
            }
        }
        
        throw new InvalidSession();
    }

    @Override
    public Statement getStatement(Date from, Date to, long sessionID) throws RemoteException, InvalidSession {
        
        Statement s;
        try {
            s = accounts.get(0).getStatement(sessionID, from, to);
            return s;
        } catch (InvalidSession e) {
            System.out.print(e.toString());
        }
        return null;
    }

    public static void main(String args[]) throws Exception {
// initialise Bank server - see sample code in the notes and online RMI tutorials for details
        try {
            // First reset our Security manager
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
                System.out.println("Security manager set");
            }

            // Create an instance of the local object
            BankInterface bankServer = new Bank();
            System.out.println("Instance of Bank Server created");
            BankInterface stub = (BankInterface) UnicastRemoteObject.exportObject(bankServer, 0);

            // Put the server object into the Registry
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("ATM", stub);
            System.out.println("Name rebind completed");
            System.out.println("Server ready for requests!");
        } catch (Exception exc) {
            System.out.println("Error in main - " + exc.toString());
        }
    }
}
