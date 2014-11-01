/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Damjan
 */
@Entity
@Table(name = "sastanak")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sastanak.findAll", query = "SELECT s FROM Sastanak s"),
    @NamedQuery(name = "Sastanak.findByIdSastanka", query = "SELECT s FROM Sastanak s WHERE s.idSastanka = :idSastanka"),
    @NamedQuery(name = "Sastanak.findByDatumSastanka", query = "SELECT s FROM Sastanak s WHERE s.datumSastanka = :datumSastanka"),
    @NamedQuery(name = "Sastanak.findByTemaSastanka", query = "SELECT s FROM Sastanak s WHERE s.temaSastanka = :temaSastanka"),
    @NamedQuery(name = "Sastanak.findByIzvestaj", query = "SELECT s FROM Sastanak s WHERE s.izvestaj = :izvestaj"),
    @NamedQuery(name = "Sastanak.findByProstorija", query = "SELECT s FROM Sastanak s WHERE s.prostorija = :prostorija"),
    @NamedQuery(name = "Sastanak.countId", query = "SELECT COUNT(s.idSastanka) FROM Sastanak s")
})
public class Sastanak implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idSastanka", insertable = true, updatable = false)
    private Integer idSastanka;
    @Column(name = "datumSastanka")
    @Temporal(TemporalType.DATE)
    private Date datumSastanka;
    @Size(max = 20)
    @Column(name = "temaSastanka")
    private String temaSastanka;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "izvestaj")
    private String izvestaj;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "prostorija")
    private String prostorija;
    @JoinColumn(name = "idProjekta", referencedColumnName = "idProjekta")
    @ManyToOne(optional = false)
    private Projekat idProjekta;

    public Sastanak() {
    }

    public Sastanak(Integer idSastanka) {
        this.idSastanka = idSastanka;
    }

    public Sastanak(Integer idSastanka, String izvestaj, String prostorija) {
        this.idSastanka = idSastanka;
        this.izvestaj = izvestaj;
        this.prostorija = prostorija;
    }

    public Integer getIdSastanka() {
        return idSastanka;
    }

    public void setIdSastanka(Integer idSastanka) {
        this.idSastanka = idSastanka;
    }

    public Date getDatumSastanka() {
        return datumSastanka;
    }

    public void setDatumSastanka(Date datumSastanka) {
        this.datumSastanka = datumSastanka;
    }

    public String getTemaSastanka() {
        return temaSastanka;
    }

    public void setTemaSastanka(String temaSastanka) {
        this.temaSastanka = temaSastanka;
    }

    public String getIzvestaj() {
        return izvestaj;
    }

    public void setIzvestaj(String izvestaj) {
        this.izvestaj = izvestaj;
    }

    public String getProstorija() {
        return prostorija;
    }

    public void setProstorija(String prostorija) {
        this.prostorija = prostorija;
    }

    public Projekat getIdProjekta() {
        return idProjekta;
    }

    public void setIdProjekta(Projekat idProjekta) {
        this.idProjekta = idProjekta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSastanka != null ? idSastanka.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sastanak)) {
            return false;
        }
        Sastanak other = (Sastanak) object;
        if ((this.idSastanka == null && other.idSastanka != null) || (this.idSastanka != null && !this.idSastanka.equals(other.idSastanka))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Sastanak[ idSastanka=" + idSastanka + " ]";
    }
    
}
