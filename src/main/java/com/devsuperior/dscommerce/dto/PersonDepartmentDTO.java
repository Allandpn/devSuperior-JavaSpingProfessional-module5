package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Person;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public class PersonDepartmentDTO {

    private Long id;

    @NotBlank
    private String name;

    @PositiveOrZero
    private Double salary;

    private DepartmentDTO department;

    public PersonDepartmentDTO() {
    }

    public PersonDepartmentDTO(Long id, DepartmentDTO department, Double salary, String name) {
        this.id = id;
        this.department = department;
        this.salary = salary;
        this.name = name;
    }

    public PersonDepartmentDTO(Person entity) {
        this.id = entity.getId();
        this.salary = entity.getSalary();
        this.name = entity.getName();
        this.department = new DepartmentDTO(entity.getDepartment());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public DepartmentDTO getDepartment() {
        return department;
    }
}
