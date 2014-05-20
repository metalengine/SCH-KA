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
            ps.setString(3, event.getDuedata());
  
            ps.execute();
            
        } catch (Exception ex) {
            System.out.println("Error tambah event -->" + ex.getMessage());
            
        } finally {
            Database.close(con);
        }
    }
}
