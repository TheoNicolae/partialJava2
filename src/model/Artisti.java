/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "artisti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artisti.findAll", query = "SELECT a FROM Artisti a"),
    @NamedQuery(name = "Artisti.findById", query = "SELECT a FROM Artisti a WHERE a.id = :id"),
    @NamedQuery(name = "Artisti.findByNume", query = "SELECT a FROM Artisti a WHERE a.nume = :nume")})
public class Artisti implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nume")
    private String nume;

    /*  private Collection<Melodii> melodiiColection;*/
    
    public Artisti() {
    }

    public Artisti(Integer id) {
        this.id = id;
    }

    public Artisti(Integer id, String nume) {
        this.id = id;
        this.nume = nume;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
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
        if (!(object instanceof Artisti)) {
            return false;
        }
        Artisti other = (Artisti) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nume;
    }

//    public Collection<Melodii> getMelodiiColection() {
//        return melodiiColection;
//    }
//
//    public void setMelodiiColection(Collection<Melodii> melodiiColection) {
//        this.melodiiColection = melodiiColection;
//    }
//    
}
