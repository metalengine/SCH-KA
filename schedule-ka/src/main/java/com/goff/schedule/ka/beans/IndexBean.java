/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.goff.schedule.ka.beans;

import com.goff.schedule.ka.dao.JadwalSeminarDAO;
import com.goff.schedule.ka.data.Event;
import com.goff.schedule.ka.data.IndexData;
import com.goff.schedule.ka.data.JadwalSeminar;
import com.goff.schedule.ka.data.JadwalSidang;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
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
    private List<JadwalSidang> jSidang;
    private List<Event> event;
    private String pilihan;
    private String cari;
    
    
    public IndexBean() throws NoSuchAlgorithmException {
        JadwalSeminarDAO jsmdao = new JadwalSeminarDAO();
        jSeminar = jsmdao.findAllByAttribute("open");
        
        
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
    
    public String RandomValue(){
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public String getPilihan() {
        return pilihan;
    }

    public void setPilihan(String pilihan) {
        this.pilihan = pilihan;
    }

    public String getCari() {
        return cari;
    }

    public void setCari(String cari) {
        this.cari = cari;
    }

    
    
    
    
}
