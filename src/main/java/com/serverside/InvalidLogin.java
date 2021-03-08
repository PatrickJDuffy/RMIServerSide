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
public class InvalidLogin extends Exception{
   InvalidLogin() {
   }
   public String toString(){
     return ("Login is Invalid") ;
  }
}
