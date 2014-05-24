/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.goff.schedule.ka.dao;

import com.goff.schedule.ka.data.JadwalDosen;
import com.goff.schedule.ka.data.JadwalSidang;
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
public class JadwalSidangDAO {
    public void save (JadwalSidang jSidang) throws NoSuchAlgorithmException {
        Connection con = null;
        PreparedStatement ps = null;
        HttpSession session = Util.getSession();
        try {
            con = Database.getConnection();
            
                ps = con.prepareStatement(
                    "insert into jadwalSidang (idKA,idSeminar,tanggal,jam,ruang,penguji1,status) values (?,?,?,?,?,?,'open')");
                ps.setInt(1, Integer.parseInt(jSidang.getIdKA()));
                ps.setInt(2, Integer.parseInt(jSidang.getIdSeminar()));
                ps.setString(3, jSidang.getTanggal());
                ps.setString(4, jSidang.getJam());
                ps.setString(5, jSidang.getRuang());
                ps.setString(6, jSidang.getPenguji1());
                ps.execute();
            
            
            
        } catch (Exception ex) {
            System.out.println("Error tambah sidang --> " + ex.getMessage());
            
        } finally {
            Database.close(con);
        }
    }
    
    public void update (JadwalSidang jSidang) throws NoSuchAlgorithmException {
        Connection con = null;
        PreparedStatement ps = null;
        HttpSession session = Util.getSession();
        try {
            con = Database.getConnection();
            ps = con.prepareStatement(
                    "update jadwalSidang set status=? where id=?");
            
            ps.setString(1, jSidang.getStatus());
            ps.setInt(2, jSidang.getId());
            
            ps.execute();
            
            
        } catch (Exception ex) {
            System.out.println("Error ubah jadwal dosen --> " + ex.getMessage());
            
        } finally {
            Database.close(con);
        }
    }
    
    public List<JadwalSidang> findAllByAttribute (String status) throws NoSuchAlgorithmException {
        Connection con = null;
        PreparedStatement ps = null;
        List<JadwalSidang> jSidang = new ArrayList<JadwalSidang>();
        HttpSession session = Util.getSession();
        try {
            con = Database.getConnection();
            ps = con.prepareStatement(
                    "select jadwalSidang.*,ka.id from jadwalSidang,ka where ka.pembimbing1=? and jadwalSidang.status=? and jadwalSidang.idKA=ka.id");
            
            ps.setString(1, session.getAttribute("inisial").toString());
            ps.setString(2, status);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                jSidang.add(new JadwalSidang(rs.getInt("id"),Integer.toString(rs.getInt("idSeminar")),Integer.toString(rs.getInt("idKA")),rs.getString("tanggal"),rs.getString("jam"),rs.getString("ruang"),rs.getString("penguji1"),rs.getString("penguji2"),rs.getString("status")));
            }
            
        } catch (Exception ex) {
            System.out.println("Error ambil sidang --> " + ex.getMessage());
            
        } finally {
            Database.close(con);
        }
        return jSidang;
    }
    
    public List<JadwalSidang> findSidangByAttribute (String status) throws NoSuchAlgorithmException {
        Connection con = null;
        PreparedStatement ps = null;
        List<JadwalSidang> jSidang = new ArrayList<JadwalSidang>();
        HttpSession session = Util.getSession();
        try {
            con = Database.getConnection();
            ps = con.prepareStatement(
                    "select * from jadwalSidang where penguji1=? and status=?");
            
            ps.setString(1, session.getAttribute("inisial").toString());
            ps.setString(2, status);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                jSidang.add(new JadwalSidang(rs.getInt("id"),Integer.toString(rs.getInt("idSeminar")),Integer.toString(rs.getInt("idKA")),rs.getString("tanggal"),rs.getString("jam"),rs.getString("ruang"),rs.getString("penguji1"),rs.getString("penguji2"),rs.getString("status")));
            }
            
        } catch (Exception ex) {
            System.out.println("Error ambil sidang --> " + ex.getMessage());
            
        } finally {
            Database.close(con);
        }
        return jSidang;
    }
    
    public String findPembimbing(int idSeminar){
        Connection con = null;
        PreparedStatement ps = null;
        String inisial="";
        HttpSession session = Util.getSession();
        try {
            con = Database.getConnection();
            ps = con.prepareStatement(
                    "select ka.pembimbing1 as inisial,ka.id,jadwalSeminar.id,jadwalSeminar.idKA from ka,jadwalSeminar where jadwalSeminar.id=? and ka.id=jadwalSeminar.idKA");
            
            ps.setInt(1, idSeminar);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                inisial=rs.getString("inisial");
            }
            
        } catch (Exception ex) {
            System.out.println("Error ambil pembimbing --> " + ex.getMessage());
            
        } finally {
            Database.close(con);
        }
        
        return inisial;
    }
        
    
    
    public void delete (int id) throws NoSuchAlgorithmException {
        Connection con = null;
        PreparedStatement ps = null;
        HttpSession session = Util.getSession();
        try {
            con = Database.getConnection();
            ps = con.prepareStatement(
                    "delete from jadwalSidang where id=?");
            ps.setInt(1, id);
            ps.execute();
            
        } catch (Exception ex) {
            System.out.println("Error tambah event --> " + ex.getMessage());
            
        } finally {
            Database.close(con);
        }
    }
}
