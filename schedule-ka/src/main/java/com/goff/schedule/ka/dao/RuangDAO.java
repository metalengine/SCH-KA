/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.goff.schedule.ka.dao;

import com.goff.schedule.ka.data.JadwalSeminar;
import com.goff.schedule.ka.data.Ruang;
import com.goff.schedule.ka.services.Database;
import com.goff.schedule.ka.services.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ainx
 */
public class RuangDAO {
    public String getAvailableRuangSeminar(Date date){
        String ruang="";
        
        Connection con = null;
        PreparedStatement ps = null;
        List<Ruang> dRuang = new ArrayList<Ruang>();
        String tgl,jam1,jam2;
        SimpleDateFormat ft;
        ft = new SimpleDateFormat("yyyy-MM-dd");
        tgl=""+ft.format(date);
        ft = new SimpleDateFormat("HH:mm:ss");
        Date date2 = new Date();
        date2.setTime(date.getTime()+3599);
        jam2=""+ft.format(date2);
        date2.setTime(date.getTime()-3599);
        jam1=""+ft.format(date2);
        try {
            con = Database.getConnection();
            ps = con.prepareStatement(
                    "select distinct nama from ruang where nama not in (select ruang from jadwalSeminar where tanggal=? and jam between ? and ?)");
            
            ps.setString(1, tgl);
            ps.setString(2, jam1);
            ps.setString(3, jam2);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                ruang=rs.getString("nama");
            }
            
        } catch (Exception ex) {
            System.out.println("Error ambil seminar --> " + ex.getMessage());
            
        } finally {
            Database.close(con);
        }
        
        return ruang;
    }
    
    public String getAvailableRuangSidang(Date date){
        String ruang="";
        
        Connection con = null;
        PreparedStatement ps = null;
        List<Ruang> dRuang = new ArrayList<Ruang>();
        String tgl,jam1,jam2;
        SimpleDateFormat ft;
        ft = new SimpleDateFormat("yyyy-MM-dd");
        tgl=""+ft.format(date);
        ft = new SimpleDateFormat("HH:mm:ss");
        Date date2 = new Date();
        date2.setTime(date.getTime()+7199);
        jam2=""+ft.format(date2);
        date2.setTime(date.getTime()-7199);
        jam1=""+ft.format(date2);
        try {
            con = Database.getConnection();
            ps = con.prepareStatement(
                    "select distinct nama from ruang where nama not in (select ruang from jadwalSidang where tanggal=? and jam between ? and ?)");
            
            ps.setString(1, tgl);
            ps.setString(2, jam1);
            ps.setString(3, jam2);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                ruang=rs.getString("nama");
            }
            
        } catch (Exception ex) {
            System.out.println("Error ambil seminar --> " + ex.getMessage());
            
        } finally {
            Database.close(con);
        }
        
        return ruang;
    }
}
