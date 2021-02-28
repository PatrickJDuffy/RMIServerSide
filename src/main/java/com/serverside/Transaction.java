/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serverside;

/**
 *
 * @author duffy
 */
public class Transaction extends Serializable {
// Needs some accessor methods to return information about the transaction

    public Money getAmount();

    public Date getDate();
    public String description;
}
