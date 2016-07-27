
package service;

import dao.PlaylistDao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Melodii;
import model.Playlist;


public class PlaylistService {
    
    private EntityManagerFactory emf;
   
    
    private PlaylistService(){
        emf = Persistence.createEntityManagerFactory("ExPartialPU");
    }
    
    private static final class SingletonHolder{
    
        private static final PlaylistService SINGLETON = new PlaylistService();
    
    }
    
    public static final PlaylistService getInstace(){
        return SingletonHolder.SINGLETON;
    }
    
    public List<Playlist> afisareMelByArtist(int id){
        EntityManager em = emf.createEntityManager();
        PlaylistDao pDao = new PlaylistDao(em);
        List<Playlist> lista = pDao.getMelByArtist(id);
        return lista;
    }
    
    
}
