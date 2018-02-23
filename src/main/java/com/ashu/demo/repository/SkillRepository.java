package com.ashu.demo.repository;

import com.ashu.demo.model.Skill;
import org.springframework.data.repository.CrudRepository;

public interface SkillRepository extends CrudRepository<Skill, Long> {
    Skill findSkillById(Long id);



}
