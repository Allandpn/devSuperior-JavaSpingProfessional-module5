package com.devsuperior.dscommerce.repositories;

import com.devsuperior.dscommerce.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
