package com.example.laboratorio3.controller;

import com.example.laboratorio3.entity.Employees;
import com.example.laboratorio3.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/empleado")
public class EmployeeController {
    @Autowired
    EmployeesRepository employeesRepository;
    //COMPLETAR
    @GetMapping(value={"/lista",""})
    public String listaEmployee(Model model){
        List<Employees> lista = employeesRepository.listarEmpleados();
        model.addAttribute("lista",lista);
        return "empleado/list";
    }
    /*@GetMapping("/nuevo")
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
*/
}
