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
public class JadwalSeminar {
    
    private int id;
    private String idKA;
    private String tanggal;
    private String jam;
    private String ruang;
    private String status;

    public JadwalSeminar(int id, String idKA, String tanggal, String jam, String ruang, String status) {
        this.id = id;
        this.idKA = idKA;
        this.tanggal = tanggal;
        this.jam = jam;
        this.ruang = ruang;
        this.status = status;
    }
    
    public JadwalSeminar(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdKA() {
        return idKA;
    }

    public void setIdKA(String idKA) {
        this.idKA = idKA;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getRuang() {
        return ruang;
    }

    public void setRuang(String ruang) {
        this.ruang = ruang;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
