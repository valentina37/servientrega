package com.servientrega.app.controllers;

import com.servientrega.app.variables.Cliente;
import com.servientrega.app.variables.Paquete;
import com.servientrega.app.services.ClienteService;
import com.servientrega.app.services.PaqueteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private PaqueteService paqueteService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/")
    public String index(Model model) {
        List<Paquete> paquetes = paqueteService.getAllPaquetes();
        List<Cliente> clientes = clienteService.getAllClientes();

        model.addAttribute("paquetes", paquetes);
        model.addAttribute("clientes", clientes);

        return "index";
    }
}
