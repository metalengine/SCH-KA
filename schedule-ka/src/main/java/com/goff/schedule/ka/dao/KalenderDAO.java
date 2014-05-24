/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.goff.schedule.ka.dao;

import com.goff.schedule.ka.data.Kalender;
import com.goff.schedule.ka.services.Database;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ainx
 */
public class KalenderDAO {
    public void save (Kalender kalender) throws NoSuchAlgorithmException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Database.getConnection();
            ps = con.prepareStatement(
                    "insert into kalender (startDate,endDate,jenis) values(?,?,?)");
            ps.setString(1, kalender.getStartDate());
            ps.setString(2, kalender.getEndDate());
            ps.setString(3, kalender.getJenis());
            
  
            ps.execute();
            
        } catch (Exception ex) {
            System.out.println("Error tambah event -->" + ex.getMessage());
            
        } finally {
            Database.close(con);
        }
    }
    
    public List<Kalender> findAll(){
        Connection con = null;
        PreparedStatement ps = null;
        List<Kalender> kldr = new ArrayList<Kalender>();
        try {
            con = Database.getConnection();
            ps = con.prepareStatement(
                    "select * from kalender");
            
            ResultSet rs = ps.executeQuery();
  
            while(rs.next()){
                kldr.add(new Kalender(rs.getInt("id"),rs.getString("startDate"),rs.getString("endDate"),rs.getString("jenis")));
            }
            
        } catch (Exception ex) {
            System.out.println("Error tambah event -->" + ex.getMessage());
            
        } finally {
            Database.close(con);
        }
        
        return kldr;
    }
    
    public Kalender findDate(){
        Connection con = null;
        PreparedStatement ps = null;
        Kalender kldr = new Kalender();
        try {
            con = Database.getConnection();
            ps = con.prepareStatement(
                    "select * from kalender");
            
            ResultSet rs = ps.executeQuery();
  
            while(rs.next()){
                kldr.setStartDate(rs.getString("startDate"));
                kldr.setEndDate(rs.getString("endDate"));
            }
            
        } catch (Exception ex) {
            System.out.println("Error tambah event -->" + ex.getMessage());
            
        } finally {
            Database.close(con);
        }
        
        return kldr;
    }
}
