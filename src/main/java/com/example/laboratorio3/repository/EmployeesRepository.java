package com.example.laboratorio3.repository;


import com.example.laboratorio3.dto.EmployeeRepositoryDto;
import com.example.laboratorio3.dto.ReportesRepositoryDto1;
import com.example.laboratorio3.dto.ReportesRepositoryDto2;
import com.example.laboratorio3.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeesRepository extends JpaRepository<Employees, String> {

    @Query(value = "select employees.first_name as Nombre, employees.last_name as Apellido, jobs.job_title as Puesto, departments.department_name as Departamento, locations.city as Ciudad, employees.email as Correo\n" +
            "from (((employees\n" +
            "inner join jobs on employees.job_id = jobs.job_id)\n" +
            "inner join departments on employees.department_id = departments.department_id)\n" +
            "inner join locations on departments.location_id = locations.location_id)", nativeQuery = true)

    List<EmployeeRepositoryDto> listarEmpleados();

    @Query(value = "select e.first_name, e.last_name, e.hire_date, jh.end_date, j.job_title\n" +
            "from employees e\n" +
            "inner join job_history jh on (e.employee_id=jh.employee_id)\n" +
            "inner join jobs j on (e.job_id=j.job_id)\n" +
            "where salary > 15000", nativeQuery = true)
    List<ReportesRepositoryDto1> obtenerListaReporte1();

    @Query(value="select country_name, city, count(cantidad) from (select c.country_name, l.city, count(e.employee_id) as cantidad\n" +
            "from countries c\n" +
            "inner join locations l on (c.country_id=l.country_id)\n" +
            "inner join departments d on (d.location_id=l.location_id)\n" +
            "inner join employees e on (e.department_id=d.department_id)\n" +
            "group by d.department_id) as q1 where cantidad > 3 group by city", nativeQuery = true)
    List<ReportesRepositoryDto2> obtenerListaReporte2();

   // @Query(value="select*from ", nativeQuery = true)
    //List<ReportesRepositoryDto3> obtenerListaReporte3();

}
