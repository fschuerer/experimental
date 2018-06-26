package de.fs.control;

import de.fs.entity.Rezept;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author XLKAFR
 */
@Stateless
public class RezeptManager {
    
    @PersistenceContext
    EntityManager em;
    
    public List<Rezept> findAll() {
        return em.createNamedQuery(Rezept.FIND_ALL, Rezept.class).getResultList();
    }
    
    public Rezept save(Rezept entity) {
        return em.merge(entity);
    }
}
