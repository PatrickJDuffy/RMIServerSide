/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serverside;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import org.joda.money.*;
import java.util.Date;
/**
 *
 * @author duffy 
 */
public class Bank implements BankInterface {

    private List<Account> accounts; // users accounts

    public Bank() throws RemoteException {
    }

    
    public long login(String username, String password) throws RemoteException, InvalidLogin{
        
    }
    
    
    public void deposit(int account, Money amount) throws RemoteException, InvalidSession {
// implementation code
    }

    public void withdraw(int account, Money amount) throws RemoteException, InvalidSession {
// implementation code
    }

    public Money getBalance(int account) throws RemoteException, InvalidSession {
// implementation code
    }

    public Statement getStatement(Date from, Date to) throws RemoteException, InvalidSession {
// implementation code
    }

    public static void main(String args[]) throws Exception {
// initialise Bank server - see sample code in the notes and online RMI tutorials for details
 try
    {
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
    }
    catch(Exception exc)
    {
      System.out.println("Error in main - " + exc.toString());
    }
    }
}
