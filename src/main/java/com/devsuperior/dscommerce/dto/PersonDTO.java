package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Person;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public class PersonDTO {
    private Long id;
    @NotBlank
    private String name;
    @PositiveOrZero
    private Double salary;
    private Long departmentId;

    public PersonDTO() {
    }

    public PersonDTO(Long id, String name, Double salary, Long departmentId) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    public PersonDTO(Person entity) {
        this.id = entity.getId();
        this.salary = entity.getSalary();
        this.name = entity.getName();
        this.departmentId = entity.getDepartment().getId();
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

    public Long getDepartmentId() {
        return departmentId;
    }
}
