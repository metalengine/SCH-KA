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
public class JadwalDosen {
    
    private String id;
    private String inisialDosen;
    private int idJadwal;
    private String tanggal;
    private String jam;
    private String status;

    public JadwalDosen(){
        
    }
    public JadwalDosen (String id, String inisial, String tanggal, String jam, String status){
        this.setId(id);
        this.setInisialDosen(inisial);
        this.setTanggal(tanggal);
        this.setJam(jam);
        this.setStatus(status);
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInisialDosen() {
        return inisialDosen;
    }

    public void setInisialDosen(String inisialDosen) {
        this.inisialDosen = inisialDosen;
    }

    public int getIdJadwal() {
        return idJadwal;
    }

    public void setIdJadwal(int idJadwal) {
        this.idJadwal = idJadwal;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
