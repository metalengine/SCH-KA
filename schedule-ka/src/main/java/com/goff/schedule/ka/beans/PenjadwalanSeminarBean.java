/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.goff.schedule.ka.beans;

import com.goff.schedule.ka.dao.JadwalDosenDAO;
import com.goff.schedule.ka.dao.JadwalSeminarDAO;
import com.goff.schedule.ka.dao.KADAO;
import com.goff.schedule.ka.dao.RuangDAO;
import com.goff.schedule.ka.data.JadwalDosen;
import com.goff.schedule.ka.data.JadwalSeminar;
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
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ainx
 */
@ManagedBean
@SessionScoped
public class PenjadwalanSeminarBean {

    /**
     * Creates a new instance of PenjadwalanSeminarBean
     */
    
    private List<KA> jKA;
    private KA pilihanKA;
    private JadwalSeminar jSeminar;
    private List<JadwalDosen> jDosen;
    private List<JadwalSeminar> jadwalSeminar;
    private JadwalDosen[] jadwalDosen;
    private JadwalDosen pilihanJDosen;
    private JadwalSeminar pilihanJadwalSeminar;
    private String idJDosen;
    private String pilihan,pilihanSeminar;
    private String cari,cariSeminar;
    private String statusSeminar;
    private HttpSession session = Util.getSession();
    private JadwalDosenDAO jddao= new JadwalDosenDAO();
    private JadwalSeminarDAO jsdao = new JadwalSeminarDAO();
    
    public PenjadwalanSeminarBean() throws NoSuchAlgorithmException {
        
       
        KADAO ka = new KADAO();
        this.setjKA(ka.findAllByAttribute(session.getAttribute("inisial").toString()));
        
        this.setjDosen(jddao.findAllByAttribute(session.getAttribute("inisial").toString()));
        this.setJadwalDosen(jDosen.toArray(new JadwalDosen[jDosen.size()]));
        
        this.setJadwalSeminar(jsdao.findAllByAttribute("open"));
    }
    

    public List<KA> getjKA() {
        return jKA;
    }

    public void setjKA(List<KA> jKA) {
        this.jKA = jKA;
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

    public KA getPilihanKA() {
        return pilihanKA;
    }

    public void setPilihanKA(KA pilihanKA) {
        this.pilihanKA = pilihanKA;
    }

    public JadwalSeminar getjSeminar() {
        return jSeminar;
    }

    public void setjSeminar(JadwalSeminar jSeminar) {
        this.jSeminar = jSeminar;
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

    public List<JadwalSeminar> getJadwalSeminar() {
        return jadwalSeminar;
    }

    public void setJadwalSeminar(List<JadwalSeminar> jadwalSeminar) {
        this.jadwalSeminar = jadwalSeminar;
    }

    public JadwalSeminar getPilihanJadwalSeminar() {
        return pilihanJadwalSeminar;
    }

    public void setPilihanJadwalSeminar(JadwalSeminar pilihanJadwalSeminar) {
        this.pilihanJadwalSeminar = pilihanJadwalSeminar;
    }

    public String getPilihanSeminar() {
        return pilihanSeminar;
    }

    public void setPilihanSeminar(String pilihanSeminar) {
        this.pilihanSeminar = pilihanSeminar;
    }

    public String getCariSeminar() {
        return cariSeminar;
    }

    public void setCariSeminar(String cariSeminar) {
        this.cariSeminar = cariSeminar;
    }

    public String getStatusSeminar() {
        return statusSeminar;
    }

    public void setStatusSeminar(String statusSeminar) {
        this.statusSeminar = statusSeminar;
    }
    
    
    
    public String actionSave() throws NoSuchAlgorithmException, ParseException{
        JadwalSeminar JSeminar = new JadwalSeminar();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        date=ft.parse(this.pilihan);
        ft = new SimpleDateFormat("yyyy-MM-dd");
        JSeminar.setTanggal(""+ft.format(date));
        ft = new SimpleDateFormat("HH:mm");
        JSeminar.setJam(""+ft.format(date));
        this.setCari(JSeminar.getTanggal());
        JSeminar.setIdKA(pilihanKA.getId());
        RuangDAO rdao = new RuangDAO();
        if(rdao.getAvailableRuangSeminar(date)!=""){
            JSeminar.setRuang(rdao.getAvailableRuangSeminar(date));
            JSeminar.setStatus("open");
            
            jsdao.save(JSeminar);
            JadwalDosen jdos = new JadwalDosen();
            jdos.setInisialDosen(session.getAttribute("inisial").toString());
            jdos.setTanggal(JSeminar.getTanggal());
            jdos.setJam(JSeminar.getJam());
            jdos.setStatus("close");
            jddao.update(jdos);
            System.out.println(JSeminar.getTanggal());
        }
        else{
            System.out.println("tidak ada ruang kosong pada jadwal tersebut");
        }
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("penjadwalanSeminarBean", null);
        return "penjadwalan-seminar";
    }
    
    public void actionUpdate() throws NoSuchAlgorithmException{
        this.pilihanJadwalSeminar.setStatus(this.getStatusSeminar());
        jsdao.update(pilihanJadwalSeminar);
    }
    
    public String actionDelete() throws NoSuchAlgorithmException{
        JadwalSeminarDAO jsddao = new JadwalSeminarDAO();
        jsddao.delete(this.pilihanJadwalSeminar.getId());
        
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("penjadwalanSeminarBean", null);
        return "penjadwalan-seminar";
    }
}
