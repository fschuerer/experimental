package de.fs.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.ws.rs.FormParam;

/**
 *
 * @author XLKAFR
 */
@Entity
@NamedQueries({
    @NamedQuery(name = Rezept.FIND_ALL, query = "select t from Rezept t")
}
)
public class Rezept {
    public final static String PREFIX = "rezept.";
    public final static String FIND_ALL = PREFIX + "findAll";

    @Id
    @GeneratedValue
    long id;
    
    @FormParam("name")
    String name;
    
    @FormParam("zeitpunkt")
    Zeitpunkt zeitpunkt;
    
    @OneToMany
    List<NahrungMenge> zutaten;
    
    @FormParam("nm")
    public void setNahrungsmittel(List<Nahrungsmittel> nm) {
        System.err.println("Nahrungsmittel " + nm);
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Zeitpunkt getZeitpunkt() {
        return zeitpunkt;
    }

    public void setZeitpunkt(Zeitpunkt zeitpunkt) {
        this.zeitpunkt = zeitpunkt;
    }

    public List<NahrungMenge> getZutaten() {
        return zutaten;
    }

    public void setZutaten(List<NahrungMenge> zutaten) {
        this.zutaten = zutaten;
    }

    @Override
    public String toString() {
        return "Rezept{" + "id=" + id + ", name=" + name + ", zeitpunkt=" + zeitpunkt + ", zutaten=" + zutaten + '}';
    }
}
