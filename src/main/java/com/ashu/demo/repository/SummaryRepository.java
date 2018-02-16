package com.ashu.demo.repository;

import com.ashu.demo.model.Summary;
import org.springframework.data.repository.CrudRepository;

public interface SummaryRepository extends CrudRepository<Summary, Long> {

}
