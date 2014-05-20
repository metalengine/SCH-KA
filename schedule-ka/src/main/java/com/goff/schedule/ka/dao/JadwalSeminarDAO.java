/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.goff.schedule.ka.dao;

import com.goff.schedule.ka.data.JadwalDosen;
import com.goff.schedule.ka.data.JadwalSeminar;
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
public class JadwalSeminarDAO {
    public void save (JadwalSeminar jSeminar) throws NoSuchAlgorithmException {
        Connection con = null;
        PreparedStatement ps = null;
        HttpSession session = Util.getSession();
        try {
            con = Database.getConnection();
            
                ps = con.prepareStatement(
                    "insert into jadwalSeminar (idKA,tanggal,jam,ruang,status) values (?,?,?,?,'open')");
                ps.setInt(1, Integer.parseInt(jSeminar.getIdKA()));
                ps.setString(2, jSeminar.getTanggal());
                ps.setString(3, jSeminar.getJam());
                ps.setString(4, jSeminar.getRuang());
                ps.execute();
            
            
            
        } catch (Exception ex) {
            System.out.println("Error tambah seminar --> " + ex.getMessage());
            
        } finally {
            Database.close(con);
        }
    }
    
    public void update (JadwalSeminar jSeminar) throws NoSuchAlgorithmException {
        Connection con = null;
        PreparedStatement ps = null;
        HttpSession session = Util.getSession();
        try {
            con = Database.getConnection();
            ps = con.prepareStatement(
                    "update jadwalSeminar set status=? where id=?");
            
            ps.setString(1, jSeminar.getStatus());
            ps.setInt(2, jSeminar.getId());
            
            ps.execute();
            
            
        } catch (Exception ex) {
            System.out.println("Error ubah jadwal dosen --> " + ex.getMessage());
            
        } finally {
            Database.close(con);
        }
    }
    
    public List<JadwalSeminar> findAllByAttribute (String status) throws NoSuchAlgorithmException {
        Connection con = null;
        PreparedStatement ps = null;
        List<JadwalSeminar> jSeminar = new ArrayList<JadwalSeminar>();
        HttpSession session = Util.getSession();
        try {
            con = Database.getConnection();
            ps = con.prepareStatement(
                    "select jadwalSeminar.*,ka.id,ka.pembimbing1 from jadwalSeminar,ka where ka.pembimbing1=? and jadwalSeminar.status=? and jadwalSeminar.idKA=ka.id");
            
            ps.setString(1, session.getAttribute("inisial").toString());
            ps.setString(2, status);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                jSeminar.add(new JadwalSeminar(rs.getInt("id"),Integer.toString(rs.getInt("idKA")),rs.getString("tanggal"),rs.getString("jam"),rs.getString("ruang"),rs.getString("status")));
            }
            
        } catch (Exception ex) {
            System.out.println("Error ambil seminar --> " + ex.getMessage());
            
        } finally {
            Database.close(con);
        }
        return jSeminar;
    }
    
    public void delete (int id) throws NoSuchAlgorithmException {
        Connection con = null;
        PreparedStatement ps = null;
        HttpSession session = Util.getSession();
        try {
            con = Database.getConnection();
            ps = con.prepareStatement(
                    "delete from jadwalSeminar where id=?");
            ps.setInt(1, id);
            ps.execute();
            
        } catch (Exception ex) {
            System.out.println("Error tambah event --> " + ex.getMessage());
            
        } finally {
            Database.close(con);
        }
    }
}
