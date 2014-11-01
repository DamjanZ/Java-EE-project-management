/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Damjan
 */
@Entity
@Table(name = "projekat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Projekat.findLastId", query = "SELECT MAX(p.idProjekta) FROM Projekat p"),
    @NamedQuery(name = "Projekat.findAllOrderById", query = "SELECT p FROM Projekat p WHERE p.aktuelan = true ORDER BY p.idProjekta DESC"),
    @NamedQuery(name = "Projekat.findAllById", query = "SELECT p FROM Projekat p WHERE p.korisnikID = :korisnikID"),
    @NamedQuery(name = "Projekat.findAll", query = "SELECT p FROM Projekat p"),
    @NamedQuery(name = "Projekat.findByIdProjekta", query = "SELECT p FROM Projekat p WHERE p.idProjekta = :idProjekta"),
    @NamedQuery(name = "Projekat.findByNazivProjekta", query = "SELECT p FROM Projekat p WHERE p.nazivProjekta = :nazivProjekta"),
    @NamedQuery(name = "Projekat.findByOpisProjekta", query = "SELECT p FROM Projekat p WHERE p.opisProjekta = :opisProjekta"),
    @NamedQuery(name = "Projekat.findByDatumPocetka", query = "SELECT p FROM Projekat p WHERE p.datumPocetka = :datumPocetka"),
    @NamedQuery(name = "Projekat.findByDatumRealizacije", query = "SELECT p FROM Projekat p WHERE p.datumRealizacije = :datumRealizacije"),
    @NamedQuery(name = "Projekat.findByAktuelanAndID", query = "SELECT p FROM Projekat p WHERE p.aktuelan = :aktuelan and p.korisnikID.korisnikID = :korisnikID"),
    @NamedQuery(name = "Projekat.findByFinansijskaSredstva", query = "SELECT p FROM Projekat p WHERE p.finansijskaSredstva = :finansijskaSredstva")})
public class Projekat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProjekta")
    private Integer idProjekta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nazivProjekta")
    private String nazivProjekta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5000)
    @Column(name = "opisProjekta")
    private String opisProjekta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datumPocetka")
    @Temporal(TemporalType.DATE)
    private Date datumPocetka;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datumRealizacije")
    @Temporal(TemporalType.DATE)
    private Date datumRealizacije;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aktuelan")
    private boolean aktuelan;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "finansijska_sredstva")
    private BigDecimal finansijskaSredstva;
    @JoinColumn(name = "korisnikID", referencedColumnName = "korisnikID")
    @ManyToOne(optional = false)
    private Korisnik korisnikID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProjekta")
    private Collection<Sastanak> sastanakCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProjekta")
    private List<Ucesce> ucesceCollection;
    /*
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projekat")
    private List<Ucesce> ucesceList;
    */
    public Projekat() {
    }

    public Projekat(Integer idProjekta) {
        this.idProjekta = idProjekta;
    }

    public Projekat(Integer idProjekta, String nazivProjekta, String opisProjekta, Date datumPocetka, Date datumRealizacije, boolean aktuelan, BigDecimal finansijskaSredstva) {
        this.idProjekta = idProjekta;
        this.nazivProjekta = nazivProjekta;
        this.opisProjekta = opisProjekta;
        this.datumPocetka = datumPocetka;
        this.datumRealizacije = datumRealizacije;
        this.aktuelan = aktuelan;
        this.finansijskaSredstva = finansijskaSredstva;
    }

    public Integer getIdProjekta() {
        return idProjekta;
    }

    public void setIdProjekta(Integer idProjekta) {
        this.idProjekta = idProjekta;
    }

    public String getNazivProjekta() {
        return nazivProjekta;
    }

    public void setNazivProjekta(String nazivProjekta) {
        this.nazivProjekta = nazivProjekta;
    }

    public String getOpisProjekta() {
        return opisProjekta;
    }

    public void setOpisProjekta(String opisProjekta) {
        this.opisProjekta = opisProjekta;
    }

    public Date getDatumPocetka() {
        return datumPocetka;
    }

    public void setDatumPocetka(Date datumPocetka) {
        this.datumPocetka = datumPocetka;
    }

    public Date getDatumRealizacije() {
        return datumRealizacije;
    }

    public void setDatumRealizacije(Date datumRealizacije) {
        this.datumRealizacije = datumRealizacije;
    }

    public boolean getAktuelan() {
        return aktuelan;
    }

    public void setAktuelan(boolean aktuelan) {
        this.aktuelan = aktuelan;
    }

    public BigDecimal getFinansijskaSredstva() {
        return finansijskaSredstva;
    }

    public void setFinansijskaSredstva(BigDecimal finansijskaSredstva) {
        this.finansijskaSredstva = finansijskaSredstva;
    }

    public Korisnik getKorisnikID() {
        return korisnikID;
    }

    public void setKorisnikID(Korisnik korisnikID) {
        this.korisnikID = korisnikID;
    }

    @XmlTransient
    public Collection<Sastanak> getSastanakCollection() {
        return sastanakCollection;
    }

    public void setSastanakCollection(Collection<Sastanak> sastanakCollection) {
        this.sastanakCollection = sastanakCollection;
    }
    /*
    @XmlTransient
    public List<Ucesce> getUcesceList() {
        return ucesceList;
    }

    public void setUcesceList(List<Ucesce> ucesceList) {
        this.ucesceList = ucesceList;
    }
    */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProjekta != null ? idProjekta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projekat)) {
            return false;
        }
        Projekat other = (Projekat) object;
        if ((this.idProjekta == null && other.idProjekta != null) || (this.idProjekta != null && !this.idProjekta.equals(other.idProjekta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Projekat[ idProjekta=" + idProjekta + " ]";
    }

    @XmlTransient
    public Collection<Ucesce> getUcesceCollection() {
        return ucesceCollection;
    }

    public void setUcesceCollection(List<Ucesce> ucesceCollection) {
        this.ucesceCollection = ucesceCollection;
    }
    
}
