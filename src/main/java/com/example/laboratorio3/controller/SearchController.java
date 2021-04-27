package com.example.laboratorio3.controller;

import com.example.laboratorio3.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reportes")
public class SearchController {

    @Autowired
    EmployeesRepository employeesRepository;

    @GetMapping(value = {"","/"})
    public String indice(){
        return "Search/indice";
    }

    @GetMapping(value = {"/Reporte1"})
    public String verReporte1(Model model){
        model.addAttribute("listaReporte1", employeesRepository.obtenerListaReporte1());
        return "Search/reporte1";
    }

    @GetMapping(value = {"/Reporte2"})
    public String verReporte2(Model model){
        model.addAttribute("listaReporte2", employeesRepository.obtenerListaReporte2());
        return "Search/reporte2";
    }

    @GetMapping(value = {"/Reporte3"})
    public String verReporte3(Model model){
        model.addAttribute("listaReporte3", employeesRepository.obtenerListaReporte3());
        return "Search/reporte3";
    }

}
