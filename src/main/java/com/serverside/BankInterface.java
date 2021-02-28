/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serverside;

import java.rmi.*;

/**
 *
 * @author duffy
 */
public interface BankInterface extends Remote {

// The login method returns a token that is valid for some time period that must be passed to the other methods as a session identifier
    public long login(String username, String password) throws RemoteException, InvalidLogin;

    public void deposit(int accountnum, Money amount, long sessionID) throws RemoteExcept, InvalidSession;

    public void withdraw(int accountnum, Money amount, long sessionID) throws RemoteException, InvalidSession;

    public Money getBalance(int accountnum, long sessionID) throws RemoteException, InvalidSession;

    public Statement getStatement(Date from, Date to, long sessionID) throws RemoteException, InvalidSession;
}
