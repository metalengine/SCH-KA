/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.goff.schedule.ka.beans;

import com.goff.schedule.ka.dao.EventDAO;
import com.goff.schedule.ka.dao.JadwalSeminarDAO;
import com.goff.schedule.ka.dao.JadwalSidangDAO;
import com.goff.schedule.ka.data.Event;
import com.goff.schedule.ka.data.IndexData;
import com.goff.schedule.ka.data.JadwalSeminar;
import com.goff.schedule.ka.data.JadwalSidang;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ainx
 */
@ManagedBean
@RequestScoped
public class IndexBean {

    /**
     * Creates a new instance of IndexBean
     */
    
    private List<JadwalSeminar> jSeminar;
    private JadwalSeminar pilihanJSeminar;
    private List<JadwalSidang> jSidang;
    private JadwalSidang pilihanJSidang;
    private List<Event> event;
    private Event pilihanEvent;
    private String pSeminar;
    private String pSidang;
    private String pEvent;
    private String cariSeminar;
    private String cariSidang;
    private String cariEvent;
    
    
    public IndexBean() throws NoSuchAlgorithmException {
        JadwalSeminarDAO jsmdao = new JadwalSeminarDAO();
        jSeminar = jsmdao.findAllByAttribute("open");
        
        JadwalSidangDAO jsdao = new JadwalSidangDAO();
        jSidang = jsdao.findAllByAttribute("close");
        
        EventDAO edao = new EventDAO();
        event = edao.findAll();
        
    }
    
    private void buatJadwal(List<IndexData> list, int size) {
        for(int i = 0 ; i < size ; i++)
            list.add(new IndexData(RandomValue(),RandomValue(),RandomValue(),RandomValue(),RandomValue(),RandomValue(),RandomValue()));
    }

    public List<JadwalSeminar> getjSeminar() {
        return jSeminar;
    }

    public void setjSeminar(List<JadwalSeminar> jSeminar) {
        this.jSeminar = jSeminar;
    }

    public JadwalSeminar getPilihanJSeminar() {
        return pilihanJSeminar;
    }

    public void setPilihanJSeminar(JadwalSeminar pilihanJSeminar) {
        this.pilihanJSeminar = pilihanJSeminar;
    }

    public List<JadwalSidang> getjSidang() {
        return jSidang;
    }

    public void setjSidang(List<JadwalSidang> jSidang) {
        this.jSidang = jSidang;
    }

    public JadwalSidang getPilihanJSidang() {
        return pilihanJSidang;
    }

    public void setPilihanJSidang(JadwalSidang pilihanJSidang) {
        this.pilihanJSidang = pilihanJSidang;
    }

    public List<Event> getEvent() {
        return event;
    }

    public void setEvent(List<Event> event) {
        this.event = event;
    }

    public Event getPilihanEvent() {
        return pilihanEvent;
    }

    public void setPilihanEvent(Event pilihanEvent) {
        this.pilihanEvent = pilihanEvent;
    }

    public String getpSeminar() {
        return pSeminar;
    }

    public void setpSeminar(String pSeminar) {
        this.pSeminar = pSeminar;
    }

    public String getpSidang() {
        return pSidang;
    }

    public void setpSidang(String pSidang) {
        this.pSidang = pSidang;
    }

    public String getpEvent() {
        return pEvent;
    }

    public void setpEvent(String pEvent) {
        this.pEvent = pEvent;
    }

    public String getCariSeminar() {
        return cariSeminar;
    }

    public void setCariSeminar(String cariSeminar) {
        this.cariSeminar = cariSeminar;
    }

    public String getCariSidang() {
        return cariSidang;
    }

    public void setCariSidang(String cariSidang) {
        this.cariSidang = cariSidang;
    }

    public String getCariEvent() {
        return cariEvent;
    }

    public void setCariEvent(String cariEvent) {
        this.cariEvent = cariEvent;
    }
    
    
    
    public String RandomValue(){
        return UUID.randomUUID().toString().substring(0, 8);
    }

    

    
    
    
    
}
