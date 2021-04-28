package com.example.laboratorio3.controller;


import com.example.laboratorio3.entity.Employees;
import com.example.laboratorio3.repository.HistoryRepository;
//import jdk.internal.icu.text.NormalizerBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//COMPLETAR
@Controller
@RequestMapping("/historial")
public class HistoryController {

    @Autowired
    HistoryRepository historyRepository;

    @GetMapping("/listar")
    public String listarHistorial(Model model) {
        model.addAttribute("listaHistorial", historyRepository.historialEmpleado());

        return "history/history";

    }
}
