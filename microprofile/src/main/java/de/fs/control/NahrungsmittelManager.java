package de.fs.control;

import de.fs.entity.Nahrungsmittel;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author XLKAFR
 */
@Stateless
public class NahrungsmittelManager {
    
    @PersistenceContext
    EntityManager em;
    
    public List<Nahrungsmittel> getAll() {
        return em.createNamedQuery(Nahrungsmittel.FIND_ALL, Nahrungsmittel.class).getResultList();
    }

    public Nahrungsmittel save(Nahrungsmittel entity) {
        return em.merge(entity);
    }

    @Override
    public String toString() {
        return "NahrungsmittelManager";
    }

    public Nahrungsmittel getById(long id) {
        return em.find(Nahrungsmittel.class, id);
    }
}
