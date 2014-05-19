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
public class JadwalSidang {
    
    private int id;
    private String idSeminar;
    private String idKA;
    private String tanggal;
    private String jam;
    private String ruang;
    private String penguji1;
    private String penguji2;
    private String status;
    
    public JadwalSidang(int id, String idSeminar, String idKA, String tanggal, String jam, String ruang, String penguji1, String penguji2, String status) {
        this.id = id;
        this.idSeminar = idSeminar;
        this.idKA = idKA;
        this.tanggal = tanggal;
        this.jam = jam;
        this.ruang = ruang;
        this.penguji1 = penguji1;
        this.penguji2 = penguji2;
        this.status = status;
    }
    
    public JadwalSidang(){
        
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdSeminar() {
        return idSeminar;
    }

    public void setIdSeminar(String idSeminar) {
        this.idSeminar = idSeminar;
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

    public String getPenguji1() {
        return penguji1;
    }

    public void setPenguji1(String penguji1) {
        this.penguji1 = penguji1;
    }

    public String getPenguji2() {
        return penguji2;
    }

    public void setPenguji2(String penguji2) {
        this.penguji2 = penguji2;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
