package com.example.laboratorio3.repository;


import com.example.laboratorio3.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<Employees, Integer> {

    @Query(value = "select employees.first_name as Nombre, employees.last_name as Apellido, jobs.job_title as Puesto, " +
            "departments.department_name as Departamento, job_history.start_date as Inicio\n" +
            "from employees\n" +
            "inner join jobs on (employees.job_id = jobs.job_id)\n" +
            "inner join departments on (employees.department_id = departments.department_id)\n" +
            "inner join job_history on (employees.employee_id = job_history.employee_id)", nativeQuery = true)
    List<Historial>


}
