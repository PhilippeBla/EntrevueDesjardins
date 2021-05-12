/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.entities;

/**
 *
 * @author sorab
 */
public class FilmNotFound extends RuntimeException{
    
    public FilmNotFound(Long id) {
        super("Film impossible à trouver " + id);
    }
}
