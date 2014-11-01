/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DamjanZ
 */
@Entity
@Table(name = "ucesce")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ucesce.findAll", query = "SELECT u FROM Ucesce u"),
    @NamedQuery(name = "Ucesce.findByZaduzenja", query = "SELECT u FROM Ucesce u WHERE u.zaduzenja = :zaduzenja"),
    @NamedQuery(name = "Ucesce.findByIdUcesca", query = "SELECT u FROM Ucesce u WHERE u.idUcesca = :idUcesca"),
    @NamedQuery(name = "Ucesce.findByIdProjekta", query = "SELECT u FROM Ucesce u WHERE u.idProjekta.idProjekta = :idProjekta")})
public class Ucesce implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 40)
    @Column(name = "zaduzenja")
    private String zaduzenja;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUcesca")
    private Integer idUcesca;
    @JoinColumn(name = "idProjekta", referencedColumnName = "idProjekta")
    @ManyToOne(optional = false)
    private Projekat idProjekta;
    @JoinColumn(name = "idZaposlenog", referencedColumnName = "idZaposlenog")
    @ManyToOne(optional = false)
    private Zaposleni idZaposlenog;

    public Ucesce() {
    }

    public Ucesce(Integer idUcesca) {
        this.idUcesca = idUcesca;
    }

    public String getZaduzenja() {
        return zaduzenja;
    }

    public void setZaduzenja(String zaduzenja) {
        this.zaduzenja = zaduzenja;
    }

    public Integer getIdUcesca() {
        return idUcesca;
    }

    public void setIdUcesca(Integer idUcesca) {
        this.idUcesca = idUcesca;
    }

    public Projekat getIdProjekta() {
        return idProjekta;
    }

    public void setIdProjekta(Projekat idProjekta) {
        this.idProjekta = idProjekta;
    }

    public Zaposleni getIdZaposlenog() {
        return idZaposlenog;
    }

    public void setIdZaposlenog(Zaposleni idZaposlenog) {
        this.idZaposlenog = idZaposlenog;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUcesca != null ? idUcesca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ucesce)) {
            return false;
        }
        Ucesce other = (Ucesce) object;
        if ((this.idUcesca == null && other.idUcesca != null) || (this.idUcesca != null && !this.idUcesca.equals(other.idUcesca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Ucesce_1[ idUcesca=" + idUcesca + " ]";
    }
    
}
