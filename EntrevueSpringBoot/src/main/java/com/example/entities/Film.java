/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author sorab
 */
@Entity
public class Film implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titre, description;
    @OneToOne(mappedBy ="acteurs")
    private List<Acteurs> acteurs;

    public List<Acteurs> getActeurs() {
        return acteurs;
    }

    public void setActeurs(List<Acteurs> acteurs) {
        this.acteurs = acteurs;
    }

    public String getTitre() {
        return titre;
    }

    public Film(String titre, String description, List<Acteurs> acteurs) {
        this.titre = titre;
        this.description = description;
        this.acteurs = acteurs;
    }
        public Film(String titre, String description) {
        this.titre = titre;
        this.description = description;
    }


    public Film() {
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Film)) {
            return false;
        }
        Film other = (Film) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.entities.Film[ id=" + id + " ]";
    }
    
}
