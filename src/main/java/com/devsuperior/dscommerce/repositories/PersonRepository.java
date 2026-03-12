package com.devsuperior.dscommerce.repositories;

import com.devsuperior.dscommerce.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
