package com.app.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.entity.Carrera;
import com.app.api.entity.Libre;
import com.app.api.repository.LibresRepository;

@Service
public class LibresService{

    @Autowired
    private LibresRepository libresRepository;

    public List<Libre> getAllLibres() {
        return this.libresRepository.findAll();
    }

    public Optional<Libre> getLibreById(Long idLibre) {
        return this.libresRepository.findById(idLibre);
    }

    public Carrera getCarreraLibre(Long idLibre) {
        return this.libresRepository.getCarreraLibre(idLibre);
    }
}
