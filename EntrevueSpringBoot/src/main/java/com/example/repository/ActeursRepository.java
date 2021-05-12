/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.repository;

import com.example.entities.Acteurs;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sorab
 */
public interface ActeursRepository extends JpaRepository<Acteurs, Long> {
    
    Acteurs findById(long id);
}
