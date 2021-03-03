/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serverside;
import org.joda.money.*;

/**
 *
 * @author duffy
 */
public class Account {
    private String name;
    private Money balance;
    private String username;
    private String password;
    private long sessionID;
    
    public Account(String name, String username, String password){
        
    }
    
    public String getUsername(){
        return username;
    }
    
    public boolean checkPassword(String input){
        if(input.equals(password)){
            return true;
        }
        else
            return false;
    }
    
    public long createSession(){
        long leftL = 100000000L;
        long rightL = 999999999L;
        long sessionID = leftL + (long) (Math.random() * (rightL - leftL));
        //Session timeout TODO
        return sessionID;
    }
    
    public boolean checkSession(long sessionID){
        return true;
    }
}
