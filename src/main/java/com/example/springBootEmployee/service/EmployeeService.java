package com.example.springBootEmployee.service;

import com.example.springBootEmployee.entity.EmployeeEntity;
import com.example.springBootEmployee.model.Employee;
import com.example.springBootEmployee.model.EmployeeRespone;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Log4j2

public class EmployeeService
    {
        private List<EmployeeEntity> employeeEntitieslist =new LinkedList<EmployeeEntity>();

        public EmployeeService()
        {
            employeeEntitieslist = List.of();
                    (
                            new EmployeeEntity(101L, "Aditya", "Mhatre"),
                            new EmployeeEntity(102L, "raj", "mhatre"),
                            new EmployeeEntity(103L, "Tzuyu", "Mhatre"),
                            new EmployeeEntity(104L, "Sana", "mhatre"),
                            new EmployeeEntity(105L, "Chou", "Mhatre")
                    );
        }
        public EmployeeEntity getEmployee(Long employeeId)
        {
            EmployeeEntity employeeEntity = null;

            for (EmployeeEntity ex : employeeEntitieslist)
            {
                if (ex.getEmployeeId() == employeeId)
                {
                    employeeEntity = ex;
                    break;
                }
            }
            return employeeEntity;
        }

        public EmployeeEntity getAllEmployees(String firstName, String lastName)
        {
           EmployeeEntity emp= null;
            for (EmployeeEntity r:employeeEntitieslist)
            {
                if (r.getFirstName().equalsIgnoreCase(firstName)  && r.getLastName().equalsIgnoreCase(lastName))
                {
                    emp=r;
                }
            }

            return emp;
        }

        //        Optional<EmployeeEntity> ex = employeeEntitieslist.stream().filter(t-> employeeId == t.getEmployeeId()).findFirst();
        
        public EmployeeRespone createEmployee(Employee employee)
        {
            Long id = (long) (Math.random() * 20);

            EmployeeRespone empRs = new EmployeeRespone(id);
            empRs.setId(id);
            log.debug("Employee name is {} {} ", employee.getFirstName(), employee.getLastName());
            return empRs;
        }

        public Employee updateEmployee(Long employeeId, Employee employee)
        {
            for (EmployeeEntity e : employeeEntitieslist)
            {
                if (employeeId == e.getEmployeeId())
                {
                    e.setFirstName(employee.getFirstName());
                    e.setLastName(employee.getLastName());
                }
            }
            log.debug("Updated Employees are :  {} {}", employee.getFirstName(), employee.getLastName());
            return employee;
        }



        public void deleteEmployee(Long employeeId) {
            //Employee employee=new Employee();
            for (EmployeeEntity e:
                    employeeEntitieslist) {
                if(e.getEmployeeId()==employeeId){
                    employeeEntitieslist.remove(employeeId);
                }
            }
            log.info("successfully deleted");


        }

    }
