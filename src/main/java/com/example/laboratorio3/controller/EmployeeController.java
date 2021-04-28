package com.example.laboratorio3.controller;

import com.example.laboratorio3.dto.EmployeeRepositoryDto;
import com.example.laboratorio3.entity.Departments;
import com.example.laboratorio3.entity.Employees;
import com.example.laboratorio3.entity.Jobs;
import com.example.laboratorio3.repository.BossesRepository;
import com.example.laboratorio3.repository.DepartmentsRepository;
import com.example.laboratorio3.repository.EmployeesRepository;
import com.example.laboratorio3.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/empleado")
public class EmployeeController {
    @Autowired
    EmployeesRepository employeesRepository;

    @Autowired
    JobsRepository jobsRepository;

    @Autowired
    BossesRepository bossesRepository;

    @Autowired
    DepartmentsRepository departmentsRepository;


    @GetMapping(value = {"/lista", ""})
    public String listaEmployee(Model model) {
        model.addAttribute("listaEmpleados", employeesRepository.listarEmpleados());
        return "employee/lista";
    }

    @GetMapping("/nuevo")
    public String nuevoEmployeeForm(Model model) {
        List<Jobs> listaPuestos = jobsRepository.findAll();
        model.addAttribute("listaPuestos", listaPuestos);

        List<Employees> listaJefes = bossesRepository.findAll();
        model.addAttribute("listaJefes", listaJefes);

        List<Departments> listaDepartamentos = departmentsRepository.findAll();
        model.addAttribute("listaDepartamentos", listaDepartamentos);

        return "employee/newFrm";
    }

    @PostMapping("/guardar")
    public String guardarEmployee(Employees employees, RedirectAttributes attributes) {
        if(employees.getEmail()==null){
            attributes.addFlashAttribute("mensajes","Empleado creado exitosamente");
        }else {
            attributes.addFlashAttribute("mensaje1","Empleado editado exitosamente");
        }
        employeesRepository.save(employees);
        return "redirect:/empleado/lista";
    }

    @GetMapping("/editar")
    public String editarEmployee(Model model, @RequestParam("correo") String correo) {
        List<Employees> lista=employeesRepository.findByEmail(correo);
        List<Jobs> listaPuestos = jobsRepository.findAll();
        model.addAttribute("listaPuestos", listaPuestos);
        List<Employees> listaJefes = bossesRepository.findAll();
        model.addAttribute("listaJefes", listaJefes);
        List<Departments> listaDepartamentos = departmentsRepository.findAll();
        model.addAttribute("listaDepartamentos", listaDepartamentos);
        if(lista.isEmpty()){
            return "redirect:/empleado";
        }else {
            Employees e = lista.get(0);
            model.addAttribute("empleado",e);
            return "employee/editFrm";
        }
    }

    @GetMapping("/eliminar")
    public String borrarEmpleado(@RequestParam("correo") String correo, RedirectAttributes attributes) {
        Optional<Employees> optionalEmployees=employeesRepository.findById(correo);
        if(optionalEmployees.isPresent()){
            employeesRepository.deleteById(correo);
            attributes.addFlashAttribute("mensaje2","Empleado borrado exitosamente");
        }
        return "redirect:/empleado";
    }

}
