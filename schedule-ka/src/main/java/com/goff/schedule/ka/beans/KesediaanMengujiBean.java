/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.goff.schedule.ka.beans;

import com.goff.schedule.ka.dao.JadwalDosenDAO;
import com.goff.schedule.ka.dao.JadwalSeminarDAO;
import com.goff.schedule.ka.dao.JadwalSidangDAO;
import com.goff.schedule.ka.data.JadwalDosen;
import com.goff.schedule.ka.data.JadwalSeminar;
import com.goff.schedule.ka.data.JadwalSidang;
import com.goff.schedule.ka.services.Util;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ainx
 */
@ManagedBean
@SessionScoped
public class KesediaanMengujiBean {

    /**
     * Creates a new instance of KesediaanMengujiBean
     */
    
    private List<JadwalSidang> jSidang;
    private JadwalDosen jDosen;
    private JadwalSidang pilihanJSidang;
    private String pSidang;
    private String cariSidang;
    private HttpSession session = Util.getSession();
    
    public KesediaanMengujiBean() throws NoSuchAlgorithmException {
        JadwalSidangDAO jsdao = new JadwalSidangDAO();
        this.setjSidang(jsdao.findSidangByAttribute("open"));
    }

    public List<JadwalSidang> getjSidang() {
        return jSidang;
    }

    public void setjSidang(List<JadwalSidang> jSidang) {
        this.jSidang = jSidang;
    }

    public JadwalDosen getjDosen() {
        return jDosen;
    }

    public void setjDosen(JadwalDosen jDosen) {
        this.jDosen = jDosen;
    }

    public JadwalSidang getPilihanJSidang() {
        return pilihanJSidang;
    }

    public void setPilihanJSidang(JadwalSidang pilihanJSidang) {
        this.pilihanJSidang = pilihanJSidang;
    }

    public String getpSidang() {
        return pSidang;
    }

    public void setpSidang(String pSidang) {
        this.pSidang = pSidang;
    }

    public String getCariSidang() {
        return cariSidang;
    }

    public void setCariSidang(String cariSidang) {
        this.cariSidang = cariSidang;
    }
    
    
    
    public String actionSetuju() throws NoSuchAlgorithmException{
        jDosen = new JadwalDosen();
        jDosen.setInisialDosen(this.session.getAttribute("inisial").toString());
        this.jDosen.setTanggal(this.pilihanJSidang.getTanggal());
        this.jDosen.setJam(this.pilihanJSidang.getJam());
        this.jDosen.setStatus("close");
        JadwalDosenDAO jdosdao = new JadwalDosenDAO();
        jdosdao.update(jDosen);
        this.pilihanJSidang.setStatus("close");
        JadwalSidangDAO jsdao = new JadwalSidangDAO();
        jsdao.update(pilihanJSidang);
        
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("kesediaanMengujiBean", null);
        return "kesediaan-menguji";
    }
    
    public String actionTolak() throws NoSuchAlgorithmException{
        JadwalSeminar jSeminar = new JadwalSeminar();
        jSeminar.setId(Integer.parseInt(this.pilihanJSidang.getIdSeminar()));
        jSeminar.setStatus("close");
        JadwalSeminarDAO jsmdao = new JadwalSeminarDAO();
        jsmdao.update(jSeminar);
        JadwalSidangDAO jsdao = new JadwalSidangDAO();
        jsdao.delete(this.pilihanJSidang.getId());
        jDosen = new JadwalDosen();
        jDosen.setInisialDosen(jsdao.findPembimbing(Integer.parseInt(pilihanJSidang.getIdSeminar())));
        jDosen.setTanggal(pilihanJSidang.getTanggal());
        jDosen.setJam(pilihanJSidang.getJam());
        jDosen.setStatus("open");
        JadwalDosenDAO jddao = new JadwalDosenDAO();
        jddao.update(jDosen);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("kesediaanMengujiBean", null);
        return "kesediaan-menguji";
    }
}
