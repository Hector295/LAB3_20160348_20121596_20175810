package com.example.laboratorio3.repository;


import com.example.laboratorio3.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Integer>{
    @Query(value = "select * from employees e inner join departments d on e.department_id = d.department_id\n" +
            "inner join jobs j on e.job_id = j.job_id inner join locations l on d.location_id = l.location_id;",
    nativeQuery = true)
    List<Employees> listarEmpleados();
}
