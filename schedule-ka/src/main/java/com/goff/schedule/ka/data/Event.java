/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.goff.schedule.ka.data;

/**
 *
 * @author ainx
 */
public class Event {
    
    private int id;
    private String tanggal;
    private String info;
    private String duedata;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDuedata() {
        return duedata;
    }

    public void setDuedata(String duedata) {
        this.duedata = duedata;
    }
    
        
}
