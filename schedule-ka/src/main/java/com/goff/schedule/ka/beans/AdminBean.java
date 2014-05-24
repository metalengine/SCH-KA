/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.goff.schedule.ka.beans;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ainx
 */
@ManagedBean
@RequestScoped
public class AdminBean {

    /**
     * Creates a new instance of AdminBean
     */
    
    public String url;
    
    public AdminBean() {
        this.setUrl(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/"));
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
    
    public String actionGetData() throws IOException, InterruptedException{
        
        Process p;
        String command = "php "+this.getUrl()+"resources/webclient.php";
        try {
        p = Runtime.getRuntime().exec(command);
	p.waitFor();
                
        }
        catch (Exception e){
            System.out.println("gagal : "+e);
        }
        
        return "admin=dashboard";
    }
}
