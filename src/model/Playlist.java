/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "playlist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Playlist.findAll", query = "SELECT p FROM Playlist p"),
    @NamedQuery(name = "Playlist.findById", query = "SELECT p FROM Playlist p WHERE p.id = :id"),
    @NamedQuery(name = "Playlist.findByArtistId", query = "SELECT p FROM Playlist p WHERE p.artist_id = :artist_id"),
    @NamedQuery(name = "Playlist.findByMelId", query = "SELECT p FROM Playlist p WHERE p.mel_id = :melId")})
public class Playlist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "artist_id")
    private int artist_id;
    @Basic(optional = false)
    @Column(name = "mel_id")
    private int mel_id;

    public Playlist() {
    }

    public Playlist(Integer id) {
        this.id = id;
    }

    public Playlist(Integer id, int artistId, int melId) {
        this.id = id;
        this.artist_id = artistId;
        this.mel_id = melId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getArtistId() {
        return artist_id;
    }

    public void setArtistId(int artistId) {
        this.artist_id = artistId;
    }

    public int getMelId() {
        return mel_id;
    }

    public void setMelId(int melId) {
        this.mel_id = melId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Playlist)) {
            return false;
        }
        Playlist other = (Playlist) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  id.toString() ;
    }
    
}
