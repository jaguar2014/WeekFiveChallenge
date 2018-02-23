package com.ashu.demo.repository;

import com.ashu.demo.model.JobPost;
import org.springframework.data.repository.CrudRepository;

public interface JobPostRepository extends CrudRepository<JobPost, Long> {



}
