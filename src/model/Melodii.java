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
@Table(name = "melodii")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Melodii.findAll", query = "SELECT m FROM Melodii m"),
    @NamedQuery(name = "Melodii.findById", query = "SELECT m FROM Melodii m WHERE m.id = :id"),
    @NamedQuery(name = "Melodii.findByNume", query = "SELECT m FROM Melodii m WHERE m.nume = :nume"),
    @NamedQuery(name = "Melodii.findByGen", query = "SELECT m FROM Melodii m WHERE m.gen = :gen")})
    
public class Melodii implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nume")
    private String nume;
    @Basic(optional = false)
    @Column(name = "gen")
    private String gen;

    public Melodii() {
    }

    public Melodii(Integer id) {
        this.id = id;
    }

    public Melodii(Integer id, String nume, String gen) {
        this.id = id;
        this.nume = nume;
        this.gen = gen;
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

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
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
        if (!(object instanceof Melodii)) {
            return false;
        }
        Melodii other = (Melodii) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nume;
    }
    
}
