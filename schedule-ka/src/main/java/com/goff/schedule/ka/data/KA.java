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
public class KA {
    
    private String id;
    private String nim;
    private String pembimbing1;
    private String pembimbing2;
    private String judul;
    private String topik;
    private String bidang;
    private String nilai;

    public KA(String id, String nim, String pembimbing1, String pembimbing2, String judul) {
        this.id = id;
        this.nim = nim;
        this.pembimbing1 = pembimbing1;
        this.pembimbing2 = pembimbing2;
        this.judul = judul;
    }
    
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
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

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTopik() {
        return topik;
    }

    public void setTopik(String topik) {
        this.topik = topik;
    }

    public String getBidang() {
        return bidang;
    }

    public void setBidang(String bidang) {
        this.bidang = bidang;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }
    
    
    
}
