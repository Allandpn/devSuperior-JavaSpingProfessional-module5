package com.devsuperior.dscommerce.servicies;

import com.devsuperior.dscommerce.dto.PersonDTO;
import com.devsuperior.dscommerce.dto.PersonDepartmentDTO;
import com.devsuperior.dscommerce.entities.Department;
import com.devsuperior.dscommerce.entities.Person;
import com.devsuperior.dscommerce.repositories.DepartmentRepository;
import com.devsuperior.dscommerce.repositories.PersonRepository;
import com.devsuperior.dscommerce.servicies.exceptions.ResourceNotFoundException;
import org.hibernate.LazyInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private DepartmentRepository departmentRepository;


    public PersonDepartmentDTO insert(PersonDepartmentDTO dto){
        Person entity = new Person();

        entity.setName(dto.getName());
        entity.setSalary(dto.getSalary());

        Department department = departmentRepository.findById(dto.getDepartment().getId()).orElseThrow(() -> new ResourceNotFoundException("Departamento não encontrado"));
        entity.setDepartment(department);
        entity = personRepository.save(entity);


        return new PersonDepartmentDTO(entity);
    }

    public PersonDTO insert(PersonDTO dto){
        Person entity = new Person();

        entity.setName(dto.getName());
        entity.setSalary(dto.getSalary());

        Department department = departmentRepository.findById(dto.getDepartmentId()).orElseThrow(() -> new ResourceNotFoundException("Departamento não encontrado"));
        entity.setDepartment(department);
        entity = personRepository.save(entity);


        return new PersonDTO(entity);
    }




}
