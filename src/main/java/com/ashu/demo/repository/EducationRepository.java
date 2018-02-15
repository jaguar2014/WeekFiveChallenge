package com.ashu.demo.repository;

import com.ashu.demo.model.Education;
import org.springframework.data.repository.CrudRepository;

public interface EducationRepository extends CrudRepository<Education, Long> {
}
