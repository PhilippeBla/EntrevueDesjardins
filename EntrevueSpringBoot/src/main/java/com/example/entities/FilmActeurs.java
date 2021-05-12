/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author sorab
 */
@Entity
public class FilmActeurs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFilm, idActeurs;

    public FilmActeurs(Long idFilm, Long idActeurs) {
        this.idFilm = idFilm;
        this.idActeurs = idActeurs;
    }

    public FilmActeurs() {
    }

    public Long getIdActeurs() {
        return idActeurs;
    }

    public void setIdActeurs(Long idActeurs) {
        this.idActeurs = idActeurs;
    }

    public Long getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(Long id) {
        this.idFilm = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFilm != null ? idFilm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idFilm fields are not set
        if (!(object instanceof FilmActeurs)) {
            return false;
        }
        FilmActeurs other = (FilmActeurs) object;
        if ((this.idFilm == null && other.idFilm != null) || (this.idFilm != null && !this.idFilm.equals(other.idFilm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.entities.FilmActeurs[ idFilm=" + idFilm + " ]";
    }
    
}
