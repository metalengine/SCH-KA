/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.goff.schedule.ka.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author ainx
 */
public class SHAProcessor {
    String password;
    public SHAProcessor(){
        this.password="password";
    }
    public SHAProcessor(String pwd){
        this.password=pwd;
    }  
    public String MakeSHA () throws NoSuchAlgorithmException{
        String xpwd="";
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.reset();
        byte[] buffer = password.getBytes();
        md.update(buffer);
        byte[] digest = md.digest();
        for(int i=0;i<digest.length;i++){
            xpwd += Integer.toString((digest[i] & 0xff) + 0x100 , 16).substring(1);
        }
        
        return xpwd;
    }
}
