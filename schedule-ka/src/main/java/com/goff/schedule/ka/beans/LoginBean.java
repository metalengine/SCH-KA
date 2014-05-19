/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.goff.schedule.ka.beans;

import com.goff.schedule.ka.dao.UserDAO;
import com.goff.schedule.ka.services.Util;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ainx
 */
@ManagedBean
@RequestScoped
public class LoginBean implements Serializable{

    /**
     * Creates a new instance of LoginBean
     */
    private static final long serialVersionUID = 1L;
    private String password;
    private String message;
    private String uname;
    private String inisial, role;
    
    public LoginBean(){
        this.setUname("inge@informatika.org");
        this.setPassword("admin");
    }
 
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getUname() {
        return uname;
    }
 
    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getInisial() {
        return inisial;
    }

    public void setInisial(String inisial) {
        this.inisial = inisial;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
 
    public String loginProject() throws NoSuchAlgorithmException {
        boolean result = UserDAO.login(uname, password);
        if (result) {
            // get Http Session and store username
            this.setInisial(UserDAO.akun.getInisial());
            this.setRole(UserDAO.akun.getRole());
            HttpSession session = Util.getSession();
            session.setAttribute("username", uname);
            session.setAttribute("inisial", inisial);
            session.setAttribute("role", role);
 
            return role+"-dashboard";
        } else {
 
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Invalid Login!",
                    "Please Try Again!"));
 
            // invalidate session, and redirect to other pages
 
            //message = "Invalid Login. Please Try Again!";
            return "login";
        }
    }
 
    public String logout() {
      HttpSession session = Util.getSession();
      session.invalidate();
      return "login";
   }
    
}
