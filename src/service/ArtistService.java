
package service;

import dao.ArtistDao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Artisti;
import model.Melodii;


public class ArtistService {
   
    private EntityManagerFactory emf ;
    
    private ArtistService(){
    
        this.emf = Persistence.createEntityManagerFactory("ExPartialPU");
    
    }
    
    private static final class SingletonHolder{
    
        private static final ArtistService SINGLETON = new ArtistService();
    
    }
    
    public static final ArtistService getInstance(){
     
        return SingletonHolder.SINGLETON;
    
    }
    
    
    public List<Artisti> getArtisti(){
        EntityManager em = this.emf.createEntityManager();
       
        
        try{
            ArtistDao aDao = new ArtistDao(em);
            List<Artisti> lista = aDao.findAll();
            if(lista!=null) return lista;
            
        
        
        }finally{
        
            if(em!=null) em.close();
        }
        return null;
    }
    
    public void adaugaArtist(String nume){
        EntityManager em = this.emf.createEntityManager();
        
        try{
            em.getTransaction().begin();
            ArtistDao aDao = new ArtistDao(em);
            Artisti a = new Artisti();
            a.setNume(nume);
            aDao.adaugaArtist(a);
            em.getTransaction().commit();
             
        
        }catch(Exception e){
            
            e.printStackTrace();
            em.getTransaction().rollback();
        
        }finally{
        
            if(em!=null)em.close();
        
        }
    
    }
    
    public void removeArtist(Artisti a){
        EntityManager em = this.emf.createEntityManager();
        try{
            em.getTransaction().begin();
            ArtistDao aDao = new ArtistDao(em);
            
            em.detach(a);
            em.clear();
            em.merge(a);
            aDao.removeArtist(a);
            em.getTransaction().commit();
           
       
       
       
            
        }catch(Exception e){
        
        e.printStackTrace();
        em.getTransaction().rollback();
        }finally{
        if (em!=null){
            em.close();
        }
        }
    
    
    }
    
    
    
//    public List<Melodii> getMelodiiArtist(Artisti a){
//        
//        List<Melodii> listaMelodii = (List<Melodii>) a.getMelodiiColection();
//        return listaMelodii;
//    
//    
//    }
//    
    
}
