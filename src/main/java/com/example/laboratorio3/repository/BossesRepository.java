package com.example.laboratorio3.repository;

import com.example.laboratorio3.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BossesRepository extends JpaRepository<Employees, Integer> {

    @Query(value = "select concat(employees.first_name, ' ', employees.last_name) as Jefes\n" +
            "from employees\n" +
            "inner join departments on employees.employee_id = departments.manager_id", nativeQuery = true)
    List<Employees> obtenerJefes();

}
