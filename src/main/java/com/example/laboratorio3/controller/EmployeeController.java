package com.example.laboratorio3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/empleado")
public class EmployeeController {

    //COMPLETAR
    @GetMapping(value={"/lista",""})
    public String listaEmployee(   ){
        //COMPLETAR
    }
    @GetMapping("/nuevo")
    public String nuevoEmployeeForm( ) {
        //COMPLETAR
    }

    @PostMapping("/guardar")
    public String guardarEmployee() {
        //COMPLETAR
    }

    @GetMapping("/editar")
    public String editarEmployee() {
        //COMPLETAR
    }

    @GetMapping("/eliminar")
    public String borrarEmpleado() {

       //COMPLETAR

    }

    //COMPLETAR

}
