/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.goff.schedule.ka.beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ainx
 */
@Entity
@Table(name = "dosen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dosen.findAll", query = "SELECT d FROM Dosen d"),
    @NamedQuery(name = "Dosen.findByInisial", query = "SELECT d FROM Dosen d WHERE d.inisial = :inisial"),
    @NamedQuery(name = "Dosen.findByNama", query = "SELECT d FROM Dosen d WHERE d.nama = :nama"),
    @NamedQuery(name = "Dosen.findByGelarDepan", query = "SELECT d FROM Dosen d WHERE d.gelarDepan = :gelarDepan"),
    @NamedQuery(name = "Dosen.findByGelarBelakang", query = "SELECT d FROM Dosen d WHERE d.gelarBelakang = :gelarBelakang")})
public class Dosen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "inisial")
    private String inisial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nama")
    private String nama;
    @Size(max = 20)
    @Column(name = "gelarDepan")
    private String gelarDepan;
    @Size(max = 20)
    @Column(name = "gelarBelakang")
    private String gelarBelakang;

    public Dosen() {
    }

    public Dosen(String inisial) {
        this.inisial = inisial;
    }

    public Dosen(String inisial, String nama) {
        this.inisial = inisial;
        this.nama = nama;
    }

    public String getInisial() {
        return inisial;
    }

    public void setInisial(String inisial) {
        this.inisial = inisial;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getGelarDepan() {
        return gelarDepan;
    }

    public void setGelarDepan(String gelarDepan) {
        this.gelarDepan = gelarDepan;
    }

    public String getGelarBelakang() {
        return gelarBelakang;
    }

    public void setGelarBelakang(String gelarBelakang) {
        this.gelarBelakang = gelarBelakang;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inisial != null ? inisial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dosen)) {
            return false;
        }
        Dosen other = (Dosen) object;
        if ((this.inisial == null && other.inisial != null) || (this.inisial != null && !this.inisial.equals(other.inisial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.goff.schedule.ka.beans.Dosen[ inisial=" + inisial + " ]";
    }
    
}
