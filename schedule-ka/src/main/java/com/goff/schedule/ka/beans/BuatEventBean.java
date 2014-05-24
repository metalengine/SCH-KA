/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.goff.schedule.ka.beans;

import com.goff.schedule.ka.dao.EventDAO;
import com.goff.schedule.ka.data.Event;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ainx
 */
@ManagedBean
@SessionScoped
public class BuatEventBean {

    /**
     * Creates a new instance of BuatEventBean
     */
   
    private int id;
    private Date tanggal;
    private String info;
    private Date duedate;
    
    private String sTanggal;
    private String sDuedate;
    private List<Event> event;

    public List<Event> getEvent() {
        return event;
    }

    public void setEvent(List<Event> event) {
        this.event = event;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    public String getsTanggal() {
        return sTanggal;
    }

    public void setsTanggal(String sTanggal) {
        this.sTanggal = sTanggal;
    }

    public String getsDuedate() {
        return sDuedate;
    }

    public void setsDuedate(String sDuedate) {
        this.sDuedate = sDuedate;
    }
    
    
    public BuatEventBean() {
        EventDAO edao = new EventDAO();
        this.setEvent(edao.findAll());
    }

   
    
    public String actionClick() throws NoSuchAlgorithmException{
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        this.setsTanggal(""+ft.format(tanggal));
        this.setsDuedate(""+ft.format(duedate));
        Event evt = new Event();
        evt.setTanggal(sTanggal);
        evt.setInfo(info);
        evt.setDuedate(sDuedate);
        EventDAO evd = new EventDAO();
        evd.save(evt);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("buatEventBean", null);
        return "buat-event";
    }
}
