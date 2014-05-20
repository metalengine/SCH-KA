/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.goff.schedule.ka.dao;

import com.goff.schedule.ka.data.JadwalDosen;
import com.goff.schedule.ka.services.Database;
import com.goff.schedule.ka.services.Util;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ainx
 */
public class JadwalDosenDAO {
    public void save (JadwalDosen jDosen) throws NoSuchAlgorithmException {
        Connection con = null;
        PreparedStatement ps = null;
        HttpSession session = Util.getSession();
        try {
            con = Database.getConnection();
            ps = con.prepareStatement(
                    "select id, inisialDosen, tanggal, jam, status from jadwalDosen where inisialDosen=? and tanggal=? and jam=?");
            
            ps.setString(1, session.getAttribute("inisial").toString());
            ps.setString(2, jDosen.getTanggal());
            ps.setString(3, jDosen.getJam());
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()==false){
                ps = con.prepareStatement(
                    "insert into jadwalDosen (inisialDosen,tanggal,jam,status) values (?,?,?,'open')");
                ps.setString(1, session.getAttribute("inisial").toString());
                ps.setString(2, jDosen.getTanggal());
                ps.setString(3, jDosen.getJam());
                ps.execute();
            }
            else{
                System.out.println("Data udah ada");
            }
            
            
        } catch (Exception ex) {
            System.out.println("Error tambah event --> " + ex.getMessage());
            
        } finally {
            Database.close(con);
        }
    }
    
    public void update (JadwalDosen jDosen) throws NoSuchAlgorithmException {
        Connection con = null;
        PreparedStatement ps = null;
        HttpSession session = Util.getSession();
        try {
            con = Database.getConnection();
            ps = con.prepareStatement(
                    "update jadwalDosen set status=? where inisialDosen=? and tanggal=? and jam=?");
            
            ps.setString(1, jDosen.getStatus());
            ps.setString(2, session.getAttribute("inisial").toString());
            ps.setString(3, jDosen.getTanggal());
            ps.setString(4, jDosen.getJam());
            
            ps.execute();
            
            
        } catch (Exception ex) {
            System.out.println("Error ubah jadwal dosen --> " + ex.getMessage());
            
        } finally {
            Database.close(con);
        }
    }
    
    public List<JadwalDosen> findAllByAttribute (String inisial) throws NoSuchAlgorithmException {
        Connection con = null;
        PreparedStatement ps = null;
        List<JadwalDosen> jDosen = new ArrayList<JadwalDosen>();
        HttpSession session = Util.getSession();
        try {
            con = Database.getConnection();
            ps = con.prepareStatement(
                    "select id, inisialDosen, tanggal, jam, status from jadwalDosen where inisialDosen=? and status='open'");
            
            ps.setString(1, session.getAttribute("inisial").toString());
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                jDosen.add(new JadwalDosen(Integer.toString(rs.getInt("id")),rs.getString("inisialDosen"),rs.getString("tanggal"),rs.getString("jam"),rs.getString("status")));
            }
            
        } catch (Exception ex) {
            System.out.println("Error ambil event --> " + ex.getMessage());
            
        } finally {
            Database.close(con);
        }
        return jDosen;
    }
    
    public List<JadwalDosen> findAllByNonAttribute (String inisial, Date date) throws NoSuchAlgorithmException {
        Connection con = null;
        PreparedStatement ps = null;
        List<JadwalDosen> jDosen = new ArrayList<JadwalDosen>();
        String tanggal,jam;
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        tanggal=""+ft.format(date);
        ft = new SimpleDateFormat("HH:mm:ss");
        jam=""+ft.format(date);
        try {
            con = Database.getConnection();
            ps = con.prepareStatement(
                    "select id, inisialDosen, tanggal, jam, status from jadwalDosen where inisialDosen!=? and tanggal=? and jam=? and status='open'");
            
            ps.setString(1, inisial);
            ps.setString(2, tanggal);
            ps.setString(3, jam);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                jDosen.add(new JadwalDosen(Integer.toString(rs.getInt("id")),rs.getString("inisialDosen"),rs.getString("tanggal"),rs.getString("jam"),rs.getString("status")));
            }
            
        } catch (Exception ex) {
            System.out.println("Error ambil event --> " + ex.getMessage());
            
        } finally {
            Database.close(con);
        }
        return jDosen;
    }
    
    public void delete (int id) throws NoSuchAlgorithmException {
        Connection con = null;
        PreparedStatement ps = null;
        HttpSession session = Util.getSession();
        try {
            con = Database.getConnection();
            ps = con.prepareStatement(
                    "delete from jadwalDosen where id=?");
            ps.setInt(1, id);
            ps.execute();
            
        } catch (Exception ex) {
            System.out.println("Error tambah event --> " + ex.getMessage());
            
        } finally {
            Database.close(con);
        }
    }
}
