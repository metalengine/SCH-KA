/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.goff.schedule.ka.dao;

import com.goff.schedule.ka.data.Event;
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
public class EventDAO {
    public void save (Event event) throws NoSuchAlgorithmException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Database.getConnection();
            ps = con.prepareStatement(
                    "insert into event (tanggal,info,duedate) values (?,?,?)");
            ps.setString(1, event.getTanggal());
            ps.setString(2, event.getInfo());
            ps.setString(3, event.getDuedate());
  
            ps.execute();
            
        } catch (Exception ex) {
            System.out.println("Error tambah event -->" + ex.getMessage());
            
        } finally {
            Database.close(con);
        }
    }
    
    public List<Event> findAll(){
        Connection con = null;
        PreparedStatement ps = null;
        List<Event> jEvent = new ArrayList<Event>();
        try {
            con = Database.getConnection();
            ps = con.prepareStatement(
                    "select * from event");
  
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                jEvent.add(new Event(rs.getInt("id"),rs.getString("tanggal"),rs.getString("info"),rs.getString("duedate")));
            }
            
        } catch (Exception ex) {
            System.out.println("Error tambah event -->" + ex.getMessage());
            
        } finally {
            Database.close(con);
        }
        
        return jEvent;
    }
}
