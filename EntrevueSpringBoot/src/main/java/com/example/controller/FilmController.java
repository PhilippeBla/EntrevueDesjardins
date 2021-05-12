/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

import com.example.entities.Acteurs;
import com.example.entities.ActeursNotFound;
import com.example.entities.Film;
import com.example.entities.FilmActeurs;
import com.example.entities.FilmNotFound;
import com.example.repository.ActeursRepository;
import com.example.repository.FilmActeursRepository;
import com.example.repository.FilmRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author sorab
 */
@RestController
@RequestMapping("/api")
public class FilmController {
    
    private final FilmRepository Filmrepository;
    private final ActeursRepository Acteursrepository;
    private final FilmActeursRepository FilmActeursrepository;

    public FilmController(FilmRepository Filmrepository, ActeursRepository Acteursrepository, FilmActeursRepository FilmActeursrepository) {
        this.Filmrepository = Filmrepository;
        this.Acteursrepository = Acteursrepository;
        this.FilmActeursrepository = FilmActeursrepository;
    }
    
    @GetMapping("/film/{id}")
    Film findById(@PathVariable("id") Long id)
    {
        List<Acteurs> acteurs = new ArrayList<Acteurs>();
        Film film = Filmrepository.findById(id).orElseThrow((Supplier<? extends FilmNotFound>) new FilmNotFound(id));
        FilmActeurs[] fa = FilmActeursrepository.findAllById(id);
        for (FilmActeurs x : fa)
        {
            acteurs.add(Acteursrepository.findById(x.getIdActeurs()).orElseThrow((Supplier<? extends ActeursNotFound>) new ActeursNotFound(id)));
        }
        film.setActeurs(acteurs);
        return film;
    }
    
    @PostMapping("/film")
    Film newFilm(@RequestBody Film newFilm)
    {
        Acteursrepository.saveAll(newFilm.getActeurs());
        for (Acteurs x : newFilm.getActeurs())
        {
            FilmActeursrepository.save(new FilmActeurs(newFilm.getId(),x.getId()));
        }
        return Filmrepository.save(newFilm);
    }
}
