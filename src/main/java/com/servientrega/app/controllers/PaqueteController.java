package com.servientrega.app.controllers;

import com.servientrega.app.variables.Paquete;
import com.servientrega.app.repositories.PaqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/paquetes")
public class PaqueteController {

    @Autowired
    private PaqueteRepository paqueteRepository;

    @GetMapping
    public String listarPaquetes(Model model) {
        model.addAttribute("paquetes", paqueteRepository.findAll());
        return "index";
    }

    @GetMapping("/form")
    public String mostrarFormularioPaquete(Model model) {
        model.addAttribute("paquete", new Paquete());
        return "paquete-form";
    }

    @GetMapping("/form/{id}")
    public String mostrarFormularioPaquete(@PathVariable Long id, Model model) {
        Paquete paquete = paqueteRepository.findById(id).orElse(null);
        model.addAttribute("paquete", paquete);
        return "paquete-form";
    }

    @PostMapping
    public String guardarPaquete(@ModelAttribute Paquete paquete) {
        paqueteRepository.save(paquete);
        return "redirect:/paquetes";
    }

    @DeleteMapping("/{id}")
    public String eliminarPaquete(@PathVariable Long id) {
        paqueteRepository.deleteById(id);
        return "redirect:/paquetes";
    }
}
