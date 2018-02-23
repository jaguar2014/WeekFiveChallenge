package com.ashu.demo.repository;

import com.ashu.demo.model.JobPost;
import com.ashu.demo.model.Skill;
import org.springframework.data.repository.CrudRepository;

public interface JobPostRepository extends CrudRepository<JobPost, Long> {
  Iterable<JobPost> findJobPostByOrganizationCompanyName(String companyName);
  Iterable<JobPost> findJobPostBySkills(Iterable<Skill> skills);


}
