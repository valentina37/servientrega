package com.servientrega.app.services;

import com.servientrega.app.variables.Paquete;
import com.servientrega.app.repositories.PaqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaqueteService {
    @Autowired
    private PaqueteRepository paqueteRepository;

    public List<Paquete> getAllPaquetes() {
        return paqueteRepository.findAll();
    }

    public Paquete getPaqueteById(Long id) {
        return paqueteRepository.findById(id).orElse(null);
    }

    public Paquete savePaquete(Paquete paquete) {
        return paqueteRepository.save(paquete);
    }

    public void deletePaquete(Long id) {
        paqueteRepository.deleteById(id);
    }
}