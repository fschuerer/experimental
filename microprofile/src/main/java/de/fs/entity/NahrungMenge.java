package de.fs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.ws.rs.FormParam;

/**
 *
 * @author XLKAFR
 */
@Entity
public class NahrungMenge {

    @Id
    @GeneratedValue
    long id;
    
    @FormParam("menge")
    int menge;

    @ManyToOne
    Rezept rezept;

    @ManyToOne
    Nahrungsmittel nahrungsmittel;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    public Rezept getRezept() {
        return rezept;
    }

    public void setRezept(Rezept rezept) {
        this.rezept = rezept;
    }

    public Nahrungsmittel getNahrungsmittel() {
        return nahrungsmittel;
    }

    public void setNahrungsmittel(Nahrungsmittel nahrungsmittel) {
        this.nahrungsmittel = nahrungsmittel;
    }
}
