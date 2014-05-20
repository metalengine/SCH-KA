/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.goff.schedule.ka.dao;

import com.goff.schedule.ka.data.JadwalDosen;
import com.goff.schedule.ka.data.JadwalSeminar;
import com.goff.schedule.ka.data.KA;
import com.goff.schedule.ka.services.Database;
import com.goff.schedule.ka.services.Util;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ainx
 */
public class KADAO {
    
    public List<KA> findAllByAttribute (String inisial) throws NoSuchAlgorithmException {
        Connection con = null;
        PreparedStatement ps = null;
        List<KA> daftarKA = new ArrayList<KA>();
        HttpSession session = Util.getSession();
        try {
            con = Database.getConnection();
            ps = con.prepareStatement(
                    "select distinct * from ka where pembimbing1=? and id not in (select idKA from jadwalSeminar)");
            
            ps.setString(1, session.getAttribute("inisial").toString());
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                daftarKA.add(new KA(Integer.toString(rs.getInt("id")),rs.getString("nim"),rs.getString("pembimbing1"),rs.getString("pembimbing2"),rs.getString("judul")));
            }
            
        } catch (Exception ex) {
            System.out.println("Error ambil KA --> " + ex.getMessage());
            
        } finally {
            Database.close(con);
        }
        return daftarKA;
    }
}
