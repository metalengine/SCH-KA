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
        try {
            con = Database.getConnection();
            ps = con.prepareStatement(
                    "select email, password, inisial, role from akun where email= ? and password= ? ");
            ps.setString(1, user);
            ps.setString(2, pwd);
  
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
                System.out.println(rs.getString("email"));
                
                akun.setEmail(rs.getString("email"));
                akun.setInisial(rs.getString("inisial"));
                akun.setRole(rs.getString("role"));
                return true;
            }
            else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
            return false;
        } finally {
            Database.close(con);
        }
    }
}
