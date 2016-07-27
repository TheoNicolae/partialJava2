/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Melodii;
import model.Playlist;

/**
 *
 * @author user
 */
public class PlaylistDao {
    
    private EntityManager em;
    
    public PlaylistDao(EntityManager em){
    
        this.em = em;
    }
    
    public List<Playlist> getMelByArtist(int id){
    
        Query query = em.createNamedQuery("Playlist.findByArtistId");
        query.setParameter("artist_id", id);
        List<Playlist> lista = query.getResultList();
        return lista;
    
    }
}
