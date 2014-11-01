/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
 * @author DamjanZ
 */
@Entity
@Table(name = "zaposleni")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zaposleni.findAll", query = "SELECT z FROM Zaposleni z"),
    @NamedQuery(name = "Zaposleni.findByIdZaposlenog", query = "SELECT z FROM Zaposleni z WHERE z.idZaposlenog = :idZaposlenog"),
    @NamedQuery(name = "Zaposleni.findByIme", query = "SELECT z FROM Zaposleni z WHERE z.ime = :ime"),
    @NamedQuery(name = "Zaposleni.findByPrezime", query = "SELECT z FROM Zaposleni z WHERE z.prezime = :prezime"),
    @NamedQuery(name = "Zaposleni.findByZaposlen", query = "SELECT z FROM Zaposleni z WHERE z.zaposlen = :zaposlen"),
    @NamedQuery(name = "Zaposleni.findByPol", query = "SELECT z FROM Zaposleni z WHERE z.pol = :pol"),
    @NamedQuery(name = "Zaposleni.findByPozicija", query = "SELECT z FROM Zaposleni z WHERE z.pozicija = :pozicija"),
    @NamedQuery(name = "Zaposleni.findByDatumZaposlenja", query = "SELECT z FROM Zaposleni z WHERE z.datumZaposlenja = :datumZaposlenja"),
    @NamedQuery(name = "Zaposleni.findByTelefon", query = "SELECT z FROM Zaposleni z WHERE z.telefon = :telefon"),
    @NamedQuery(name = "Zaposleni.findByDatumRodjenja", query = "SELECT z FROM Zaposleni z WHERE z.datumRodjenja = :datumRodjenja"),
    @NamedQuery(name = "Zaposleni.findByUlica", query = "SELECT z FROM Zaposleni z WHERE z.ulica = :ulica"),
    @NamedQuery(name = "Zaposleni.findByBrojUlice", query = "SELECT z FROM Zaposleni z WHERE z.brojUlice = :brojUlice")})
public class Zaposleni implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idZaposlenog")
    private Integer idZaposlenog;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ime")
    private String ime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 17)
    @Column(name = "prezime")
    private String prezime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "zaposlen")
    private boolean zaposlen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "pol")
    private String pol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 220)
    @Column(name = "pozicija")
    private String pozicija;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datumZaposlenja")
    @Temporal(TemporalType.DATE)
    private Date datumZaposlenja;
    @Size(max = 11)
    @Column(name = "telefon")
    private String telefon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datumRodjenja")
    @Temporal(TemporalType.DATE)
    private Date datumRodjenja;
    @Size(max = 30)
    @Column(name = "ulica")
    private String ulica;
    @Size(max = 11)
    @Column(name = "brojUlice")
    private String brojUlice;
    @JoinColumn(name = "ptt", referencedColumnName = "ptt")
    @ManyToOne(optional = false)
    private Mesto ptt;

    public Zaposleni() {
    }

    public Zaposleni(Integer idZaposlenog) {
        this.idZaposlenog = idZaposlenog;
    }

    public Zaposleni(Integer idZaposlenog, String ime, String prezime, boolean zaposlen, String pol, String pozicija, Date datumZaposlenja, Date datumRodjenja) {
        this.idZaposlenog = idZaposlenog;
        this.ime = ime;
        this.prezime = prezime;
        this.zaposlen = zaposlen;
        this.pol = pol;
        this.pozicija = pozicija;
        this.datumZaposlenja = datumZaposlenja;
        this.datumRodjenja = datumRodjenja;
    }

    public Integer getIdZaposlenog() {
        return idZaposlenog;
    }

    public void setIdZaposlenog(Integer idZaposlenog) {
        this.idZaposlenog = idZaposlenog;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public boolean getZaposlen() {
        return zaposlen;
    }

    public void setZaposlen(boolean zaposlen) {
        this.zaposlen = zaposlen;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public String getPozicija() {
        return pozicija;
    }

    public void setPozicija(String pozicija) {
        this.pozicija = pozicija;
    }

    public Date getDatumZaposlenja() {
        return datumZaposlenja;
    }

    public void setDatumZaposlenja(Date datumZaposlenja) {
        this.datumZaposlenja = datumZaposlenja;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getBrojUlice() {
        return brojUlice;
    }

    public void setBrojUlice(String brojUlice) {
        this.brojUlice = brojUlice;
    }

    public Mesto getPtt() {
        return ptt;
    }

    public void setPtt(Mesto ptt) {
        this.ptt = ptt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idZaposlenog != null ? idZaposlenog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zaposleni)) {
            return false;
        }
        Zaposleni other = (Zaposleni) object;
        if ((this.idZaposlenog == null && other.idZaposlenog != null) || (this.idZaposlenog != null && !this.idZaposlenog.equals(other.idZaposlenog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ime+" "+prezime;
    }
    
}
