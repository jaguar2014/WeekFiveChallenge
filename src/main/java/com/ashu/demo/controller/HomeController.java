package com.ashu.demo.controller;

import com.ashu.demo.model.Education;
import com.ashu.demo.repository.EducationRepository;
import com.ashu.demo.repository.ExperienceRepository;
import com.ashu.demo.repository.ResumeUserRepository;
import com.ashu.demo.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    ResumeUserRepository resumeUserRepository;

    @Autowired
    EducationRepository educationRepository;

    @Autowired
    ExperienceRepository experienceRepository;

    @Autowired
    SkillRepository skillRepository;

    @GetMapping("/")
    public String showIndex() {


        return "index";
    }

    @GetMapping("/addeducation")
    public String addEducation(Model model) {
        model.addAttribute("education",new Education());
        return "educationform";
    }



}
