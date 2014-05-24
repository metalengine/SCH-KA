/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.goff.schedule.ka.dao;

import com.goff.schedule.ka.data.Akun;
import com.goff.schedule.ka.services.Database;
import com.goff.schedule.ka.services.SHAProcessor;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ainx
 */

public class UserDAO {
    public static Akun akun = new Akun();
    public static boolean login(String user, String password) throws NoSuchAlgorithmException {
        Connection con = null;
        PreparedStatement ps = null;
        SHAProcessor sha = new SHAProcessor(password);
        String pwd=sha.MakeSHA();
        boolean hasil;
        try {
            con = Database.getConnection();
            ps = con.prepareStatement(
                    "select akun.email as email, akun.password as password, akun.inisial as inisial, akun.role as role, dosen.inisial as nip, dosen.nama as namadosen from akun,dosen where akun.email= ? and akun.password= ? and akun.inisial=dosen.inisial");
            ps.setString(1, user);
            ps.setString(2, pwd);
  
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
                System.out.println(rs.getString("email"));
                
                akun.setEmail(rs.getString("email"));
                akun.setInisial(rs.getString("inisial"));
                akun.setRole(rs.getString("role"));
                akun.setNama(rs.getString("namadosen"));
                hasil = true;
            }
            else {
                hasil = false;
            }
        } catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
            hasil = false;
        } finally {
            Database.close(con);
        }
        return hasil;
    }
}
