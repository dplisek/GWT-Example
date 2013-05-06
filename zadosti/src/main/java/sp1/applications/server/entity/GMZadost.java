package sp1.applications.server.entity;

import java.sql.Date;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity holding one GMZadost.
 * Source is REST service.
 * 
 * @author JakubPetr
 */

@Entity
@Table(name="GMZadost")
public class GMZadost {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="zadostId", nullable = false)
    private int zadostId;
    
    @Column(name="datum_doruceni", nullable = true)
    private Date datumDoruceni;
    
    @Column(name="datum_odeslani", nullable = true)
    private Date datumOdeslani;
    
    @Column(name="zmena_stavu", nullable = true)
    private Timestamp zmenaStavu;
    
    @Column(name="keDni", nullable = true)
    private Date keDni;
    
    @Column(name="lhuta", nullable = true)
    private int lhuta;
    
    @Column(name="vyrizujeOsoba", nullable = true)
    private String vyrizujeOsoba;
    
    @Column(name="jednaciCislo", nullable = true)
    private String jednaciCislo;
    
    @Column(name="poznamka", nullable = true)
    private String poznamka;
    
    @Column(name="jednaciCisloZadatele", nullable = true)
    private String jednaciCisloZadatele;

    public int getZadostId() {
        return zadostId;
    }

    public void setZadostId(int zadostId) {
        this.zadostId = zadostId;
    }

    public Date getDatumDoruceni() {
        return datumDoruceni;
    }

    public void setDatumDoruceni(Date datumDoruceni) {
        this.datumDoruceni = datumDoruceni;
    }

    public Date getDatumOdeslani() {
        return datumOdeslani;
    }

    public void setDatumOdeslani(Date datumOdeslani) {
        this.datumOdeslani = datumOdeslani;
    }

    public Timestamp getZmenaStavu() {
        return zmenaStavu;
    }

    public void setZmenaStavu(Timestamp zmenaStavu) {
        this.zmenaStavu = zmenaStavu;
    }

    public Date getKeDni() {
        return keDni;
    }

    public void setKeDni(Date keDni) {
        this.keDni = keDni;
    }

    public int getLhuta() {
        return lhuta;
    }

    public void setLhuta(int lhuta) {
        this.lhuta = lhuta;
    }

    public String getVyrizujeOsoba() {
        return vyrizujeOsoba;
    }

    public void setVyrizujeOsoba(String vyrizujeOsoba) {
        this.vyrizujeOsoba = vyrizujeOsoba;
    }

    public String getJednaciCislo() {
        return jednaciCislo;
    }

    public void setJednaciCislo(String jednaciCislo) {
        this.jednaciCislo = jednaciCislo;
    }

    public String getPoznamka() {
        return poznamka;
    }

    public void setPoznamka(String poznamka) {
        this.poznamka = poznamka;
    }

    public String getJednaciCisloZadatele() {
        return jednaciCisloZadatele;
    }

    public void setJednaciCisloZadatele(String jednaciCisloZadatele) {
        this.jednaciCisloZadatele = jednaciCisloZadatele;
    }
}
