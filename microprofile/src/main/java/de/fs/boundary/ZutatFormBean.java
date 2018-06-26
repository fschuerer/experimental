package de.fs.boundary;

import de.fs.entity.Nahrungsmittel;
import javax.ws.rs.BeanParam;
import javax.ws.rs.FormParam;

/**
 *
 * @author XLKAFR
 */
public class ZutatFormBean {
    
    @FormParam("nm")
    long nm;
    
    @FormParam("menge")
    int menge;

    public long getNm() {
        return nm;
    }

    public void setNm(long nm) {
        this.nm = nm;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    @Override
    public String toString() {
        return "ZutatFormBean{" + "nm=" + nm + ", menge=" + menge + '}';
    }
}
