package de.fs.entity;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.ws.rs.FormParam;

/**
 *
 * @author XLKAFR
 */
@Entity
@NamedQueries({
    @NamedQuery(name = Nahrungsmittel.FIND_ALL, query = "select t from Nahrungsmittel t")
}
)
public class Nahrungsmittel {

    public final static String PREFIX = "nahrungsmittel.";
    public final static String FIND_ALL = PREFIX + "findAll";

    @Id
    @GeneratedValue
    @FormParam("id")
    long id;

    @FormParam("name")
    String name;

    @FormParam("marke")
    String marke;

    @FormParam("kcal")
    int kcal;

    @FormParam("protein")
    BigDecimal protein;

    @FormParam("carbs")
    BigDecimal carbs;

    @FormParam("fett")
    BigDecimal fett;

    @FormParam("menge")
    int menge;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public BigDecimal getProtein() {
        return protein;
    }

    public void setProtein(BigDecimal protein) {
        this.protein = protein;
    }

    public BigDecimal getCarbs() {
        return carbs;
    }

    public void setCarbs(BigDecimal carbs) {
        this.carbs = carbs;
    }

    public BigDecimal getFett() {
        return fett;
    }

    public void setFett(BigDecimal fett) {
        this.fett = fett;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    @Override
    public String toString() {
        return "Nahrungsmittel{" + "id=" + id + ", name=" + name + ", marke=" + marke + ", kcal=" + kcal + ", protein=" + protein + ", carbs=" + carbs + ", fett=" + fett + ", menge=" + menge + '}';
    }
}
