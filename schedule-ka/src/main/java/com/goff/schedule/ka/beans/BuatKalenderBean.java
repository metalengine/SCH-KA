/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.goff.schedule.ka.beans;

import com.goff.schedule.ka.dao.KalenderDAO;
import com.goff.schedule.ka.data.Kalender;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ainx
 */
@ManagedBean
@RequestScoped
public class BuatKalenderBean {

    /**
     * Creates a new instance of BuatKalenderBean
     */
    private Date startDate;
    private Date endDate;
    
    private String sStartDate;
    private String sEndDate;
    private String jenis;
    
    public BuatKalenderBean() {
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getsStartDate() {
        return sStartDate;
    }

    public void setsStartDate(String sStartDate) {
        this.sStartDate = sStartDate;
    }

    public String getsEndDate() {
        return sEndDate;
    }

    public void setsEndDate(String sEndDate) {
        this.sEndDate = sEndDate;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    
    
    
    public String actionClick() throws NoSuchAlgorithmException{
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        this.setsStartDate(""+ft.format(startDate));
        this.setsEndDate(""+ft.format(endDate));
        Kalender kld = new Kalender();
        kld.setStartDate(sStartDate);
        kld.setEndDate(sEndDate);
        kld.setJenis(jenis);
        KalenderDAO kldo = new KalenderDAO();
        kldo.save(kld);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("kesediaanKalenderBean", null);
        return "buat-kalender";
    }
}
