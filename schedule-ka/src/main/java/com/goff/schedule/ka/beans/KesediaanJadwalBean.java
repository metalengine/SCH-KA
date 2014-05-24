/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.goff.schedule.ka.beans;

import com.goff.schedule.ka.dao.JadwalDosenDAO;
import com.goff.schedule.ka.dao.KalenderDAO;
import com.goff.schedule.ka.data.JadwalDosen;
import com.goff.schedule.ka.data.Jam;
import com.goff.schedule.ka.data.Kalender;
import com.goff.schedule.ka.services.Util;
import java.security.NoSuchAlgorithmException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author ainx
 */
@ManagedBean
@SessionScoped
public class KesediaanJadwalBean{

    /**
     * Creates a new instance of KesediaanJadwalBean
     */
    private Date tanggal;
    private Time jam;
    
    private String stanggal;
    private String sjam;
    
    private Jam[] kJam;
    private List<JadwalDosen> jadwalDosen;
    private JadwalDosen pilihJDosen;
    private Date sDate;
    private Date eDate;
    
    private Kalender kalender;
    
    public KesediaanJadwalBean() throws NoSuchAlgorithmException, ParseException {
        HttpSession session = Util.getSession();
        JadwalDosenDAO jdDAO = new JadwalDosenDAO();
        this.setJadwalDosen(jdDAO.findAllByAttribute(session.getAttribute("inisial").toString()));
        KalenderDAO kdao = new KalenderDAO();
        this.setKalender(kdao.findDate());
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        this.setsDate(ft.parse(kalender.getStartDate()));
        this.seteDate(ft.parse(kalender.getEndDate()));
    }

    public Date getsDate() {
        return sDate;
    }

    public void setsDate(Date sDate) {
        this.sDate = sDate;
    }

    public Date geteDate() {
        return eDate;
    }

    public void seteDate(Date eDate) {
        this.eDate = eDate;
    }
    
    
    
    public Kalender getKalender() {
        return kalender;
    }

    public void setKalender(Kalender kalender) {
        this.kalender = kalender;
    }
    
    
    
    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public Time getJam() {
        return jam;
    }

    public void setJam(Time jam) {
        this.jam = jam;
    }

    public String getStanggal() {
        return stanggal;
    }

    public void setStanggal(String stanggal) {
        this.stanggal = stanggal;
    }

    public String getSjam() {
        return sjam;
    }

    public void setSjam(String sjam) {
        this.sjam = sjam;
    }

    public Jam[] getkJam() {
        return kJam;
    }

    public void setkJam(Jam[] jJam) {
        this.kJam = jJam;
    }

    public List<JadwalDosen> getJadwalDosen() {
        return jadwalDosen;
    }

    public void setJadwalDosen(List<JadwalDosen> jadwalDosen) {
        this.jadwalDosen = jadwalDosen;
    }

    public JadwalDosen getPilihJDosen() {
        return pilihJDosen;
    }

    public void setPilihJDosen(JadwalDosen pilihJDosen) {
        this.pilihJDosen = pilihJDosen;
    }
   
    

        
    public String actionClick() throws NoSuchAlgorithmException{
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        this.setStanggal(""+ft.format(tanggal));
        SimpleDateFormat ft2 = new SimpleDateFormat("HH:mm");
        this.setSjam(""+ft2.format(tanggal));
        JadwalDosen jDosen = new JadwalDosen();
        jDosen.setTanggal(stanggal);
        jDosen.setJam(sjam);
        JadwalDosenDAO jDosenDAO = new JadwalDosenDAO();
        jDosenDAO.save(jDosen);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("kesediaanJadwalBean", null);
        return "kesediaan-jadwal";
    }
    
    public String actionDelete() throws NoSuchAlgorithmException{
        JadwalDosenDAO jDelete = new JadwalDosenDAO();
        jDelete.delete(Integer.parseInt(pilihJDosen.getId()));
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("kesediaanJadwalBean", null);
        return "kesediaan-jadwal";
    }
}
