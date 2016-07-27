
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Melodii;


public class MelodiiDao {
   
    private EntityManager em;
    
    public MelodiiDao(EntityManager em){
        this.em=em;
    }
    
    public void adaugaMelodie(Melodii m){
        em.persist(m);
    }
    
    public void removeMelodie(Melodii m){
    
        em.remove(m);
    }
    public List<Melodii> getAllMelodii(){
    
        Query query = this.em.createNamedQuery("MelodiiDB.findAll");
        List<Melodii> lista = query.getResultList();
        return lista;
    }
    
    public List<Melodii> getMelodiiById(int id){
    
        Query query = this.em.createNamedQuery("Melodii.findById");
        query.setParameter("id", id);
        List<Melodii> lista = query.getResultList();
        return lista;
 
    }
}
