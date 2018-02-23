package com.ashu.demo.repository;

import com.ashu.demo.model.JobPost;
import com.ashu.demo.model.ResumeUser;
import com.ashu.demo.model.Skill;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ResumeUserRepository extends CrudRepository<ResumeUser,Long>{



}
