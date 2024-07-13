package com.app.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.api.entity.Carrera;
import com.app.api.entity.Libre;
import com.app.api.repository.LibresRepository;

public class LibresImplService implements LibresService{

    @Autowired
    private LibresRepository libresRepository;

    @Override
    public List<Libre> getAllLibres() {
        return this.libresRepository.findAll();
    }

    @Override
    public Optional<Libre> getLibreById(Long idLibre) {
        return this.libresRepository.findById(idLibre);
    }

    @Override
    public Carrera getCarreraLibre(Long idLibre) {
        return this.libresRepository.getCarreraLibre(idLibre);
    }
}