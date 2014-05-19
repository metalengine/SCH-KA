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
public class IndexData {
    
    private String nim;
    private String nama;
    private String pembimbing1;
    private String pembimbing2;
    private String tanggal;
    private String jam;
    private String ruang;
    
    private String penguji1;
    private String penguji2;
    
    public IndexData(){
        
    }
    
    public IndexData(String nim,String nama,String pembimbing1,String pembimbing2,String tanggal,String jam,String ruang){
        this.setNim(nim);
        this.setNama(nama);
        this.setPembimbing1(pembimbing1);
        this.setPembimbing2(pembimbing2);
        this.setTanggal(tanggal);
        this.setJam(jam);
        this.setRuang(ruang);
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPembimbing1() {
        return pembimbing1;
    }

    public void setPembimbing1(String pembimbing1) {
        this.pembimbing1 = pembimbing1;
    }

    public String getPembimbing2() {
        return pembimbing2;
    }

    public void setPembimbing2(String pembimbing2) {
        this.pembimbing2 = pembimbing2;
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
    
    
    
}
