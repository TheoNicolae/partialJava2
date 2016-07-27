/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Artisti;

/**
 *
 * @author user
 */
public class ArtistDao {
    
    
    private EntityManager em;
    
    public ArtistDao(EntityManager em){
        this.em = em;
    }
    
    public void adaugaArtist(Artisti a){
        
        em.persist(a);
    
    }
    
    public List<Artisti> findAll(){
        
        Query query = this.em.createNamedQuery("Artisti.findAll");
        List<Artisti> lista = query.getResultList();
        return lista;
    
    }
    
    public void removeArtist(Artisti a){
        
       a = em.find(Artisti.class, a.getId());
     
        em.remove(a);
       
    }
}
