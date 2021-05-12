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
public class ActeursNotFound extends RuntimeException{
    public ActeursNotFound(Long id) {
        super("Acteurs impossible à trouver " + id);
    }
}
