/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.goff.schedule.ka.beans;

import com.goff.schedule.ka.dao.JadwalDosenDAO;
import com.goff.schedule.ka.dao.JadwalSeminarDAO;
import com.goff.schedule.ka.dao.JadwalSidangDAO;
import com.goff.schedule.ka.dao.KADAO;
import com.goff.schedule.ka.dao.RuangDAO;
import com.goff.schedule.ka.data.JadwalDosen;
import com.goff.schedule.ka.data.JadwalSeminar;
import com.goff.schedule.ka.data.JadwalSidang;
import com.goff.schedule.ka.data.KA;
import com.goff.schedule.ka.services.Util;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ainx
 */
@ManagedBean
@SessionScoped
public class PenjadwalanSidangBean {

    /**
     * Creates a new instance of PenjadwalanSidangBean
     */
    
    private List<JadwalSeminar> jSeminar;
    private JadwalSeminar pilihanSeminar;
    private JadwalSidang jSidang;
    private List<JadwalDosen> jDosen;
    private List<JadwalSidang> jadwalSidang;
    private JadwalDosen[] jadwalDosen;
    private JadwalDosen pilihanJDosen;
    private JadwalSidang pilihanJadwalSidang;
    private String idJDosen;
    private String pilihan,pilihanSidang;
    private String cari,cariSidang;
    private String statusSidang;
    private String penguji1,penguji2;
    private HttpSession session = Util.getSession();
    private JadwalDosenDAO jddao= new JadwalDosenDAO();
    private JadwalSidangDAO jsdao = new JadwalSidangDAO();
    private JadwalSidang JSidang;
    private JadwalSeminarDAO jsmdao = new JadwalSeminarDAO();
    private Date date = new Date();
    
    public PenjadwalanSidangBean() throws NoSuchAlgorithmException {
        
        this.setJadwalSidang(jsdao.findAllByAttribute("open"));
        
        this.setjSeminar(jsmdao.findAllByAttribute("close"));
        
        this.setjDosen(jddao.findAllByAttribute(session.getAttribute("inisial").toString()));
        this.setJadwalDosen(jDosen.toArray(new JadwalDosen[jDosen.size()]));
        
//        this.setJadwalSidang(jsdao.findAllByAttribute("close"));
    }

    public List<JadwalSeminar> getjSeminar() {
        return jSeminar;
    }

    public void setjSeminar(List<JadwalSeminar> jSeminar) {
        this.jSeminar = jSeminar;
    }

    public JadwalSeminar getPilihanSeminar() {
        return pilihanSeminar;
    }

    public void setPilihanSeminar(JadwalSeminar pilihanSeminar) {
        this.pilihanSeminar = pilihanSeminar;
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

    public JadwalSidang getjSidang() {
        return jSidang;
    }

    public void setjSidang(JadwalSidang jSidang) {
        this.jSidang = jSidang;
    }

    public List<JadwalDosen> getjDosen() {
        return jDosen;
    }

    public void setjDosen(List<JadwalDosen> jDosen) {
        this.jDosen = jDosen;
    }

    public JadwalDosen getPilihanJDosen() {
        return pilihanJDosen;
    }

    public void setPilihanJDosen(JadwalDosen pilihanJDosen) {
        this.pilihanJDosen = pilihanJDosen;
    }

    public String getIdJDosen() {
        return idJDosen;
    }

    public void setIdJDosen(String idJDosen) {
        this.idJDosen = idJDosen;
    }

    public JadwalDosen[] getJadwalDosen() {
        return jadwalDosen;
    }

    public void setJadwalDosen(JadwalDosen[] jadwalDosen) {
        this.jadwalDosen = jadwalDosen;
    }

    public List<JadwalSidang> getJadwalSidang() {
        return jadwalSidang;
    }

    public void setJadwalSidang(List<JadwalSidang> jadwalSidang) {
        this.jadwalSidang = jadwalSidang;
    }

    public JadwalSidang getPilihanJadwalSidang() {
        return pilihanJadwalSidang;
    }

    public void setPilihanJadwalSidang(JadwalSidang pilihanJadwalSidang) {
        this.pilihanJadwalSidang = pilihanJadwalSidang;
    }

    public String getPilihanSidang() {
        return pilihanSidang;
    }

    public void setPilihanSidang(String pilihanSidang) {
        this.pilihanSidang = pilihanSidang;
    }

    public String getCariSidang() {
        return cariSidang;
    }

    public void setCariSidang(String cariSidang) {
        this.cariSidang = cariSidang;
    }

    public String getStatusSidang() {
        return statusSidang;
    }

    public void setStatusSidang(String statusSidang) {
        this.statusSidang = statusSidang;
    }
    
    public String pilihPenguji() throws ParseException, NoSuchAlgorithmException{
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date=ft.parse(this.pilihan);
        this.setjDosen(jddao.findAllByNonAttribute(session.getAttribute("inisial").toString(), date));
        this.setCari(this.pilihanSeminar.getIdKA());
        return "pilih-penguji";
    }
    
    public String actionSave() throws NoSuchAlgorithmException, ParseException{
        JSidang = new JadwalSidang();
        
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        JSidang.setTanggal(""+ft.format(date));
        ft = new SimpleDateFormat("HH:mm");
        JSidang.setJam(""+ft.format(date));
        this.setCari(JSidang.getTanggal());
        JSidang.setIdKA(pilihanSeminar.getIdKA());
        JSidang.setIdSeminar(Integer.toString(pilihanSeminar.getId()));
        JSidang.setPenguji1(pilihanJDosen.getInisialDosen());
        RuangDAO rdao = new RuangDAO();
        if(rdao.getAvailableRuangSidang(date)!=""){
            JSidang.setRuang(rdao.getAvailableRuangSidang(date));
            JSidang.setStatus("open");
            
            jsdao.save(JSidang);
            JadwalDosen jdos = new JadwalDosen();
            jdos.setInisialDosen(session.getAttribute("inisial").toString());
            jdos.setTanggal(JSidang.getTanggal());
            jdos.setJam(JSidang.getJam());
            jdos.setStatus("close");
            jddao.update(jdos);
            pilihanSeminar.setStatus("sidang");
            jsmdao.update(pilihanSeminar);
            System.out.println(JSidang.getTanggal());
        }
        else{
            System.out.println("tidak ada ruang kosong pada jadwal tersebut");
        }
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("penjadwalanSidangBean", null);
        return "penjadwalan-sidang";
    }
    
//    public void actionUpdate() throws NoSuchAlgorithmException{
//        this.pilihanJadwalSidang.setStatus(this.getStatusSidang());
//        jsdao.update(pilihanJadwalSidang);
//    }
    
    public String actionDelete() throws NoSuchAlgorithmException{
        JadwalSeminar psmnr = new JadwalSeminar();
        psmnr.setId(Integer.parseInt(this.pilihanJadwalSidang.getIdSeminar()));
        psmnr.setStatus("close");
        jsdao.delete(this.pilihanJadwalSidang.getId());
        jsmdao.update(psmnr);
        JadwalDosen jdsn = new JadwalDosen();
        jdsn.setInisialDosen(session.getAttribute("inisial").toString());
        jdsn.setTanggal(pilihanJadwalSidang.getTanggal());
        jdsn.setJam(pilihanJadwalSidang.getJam());
        jdsn.setStatus("open");
        jddao.update(jdsn);
        if(pilihanJadwalSidang.getPenguji1()!=""){
            jdsn.setInisialDosen(pilihanJadwalSidang.getPenguji1());
            jddao.update(jdsn);
        }
        if(pilihanJadwalSidang.getPenguji2()!=""){
            jdsn.setInisialDosen(pilihanJadwalSidang.getPenguji2());
            jddao.update(jdsn);
        }
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("penjadwalanSidangBean", null);
        return "penjadwalan-sidang";
    }
    
}
