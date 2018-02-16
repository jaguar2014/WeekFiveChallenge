package com.ashu.demo.controller;

import com.ashu.demo.model.Education;
import com.ashu.demo.model.ResumeUser;
import com.ashu.demo.repository.EducationRepository;
import com.ashu.demo.repository.ExperienceRepository;
import com.ashu.demo.repository.ResumeUserRepository;
import com.ashu.demo.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

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


    //contain all the links
    @GetMapping("/buildresume")
    public String buildResume(){


        return "buildresumeform";
    }

    @GetMapping("/buildcover")
    public String buildCover(){


        return "buildcoverform";
    }

    @GetMapping("/addcontact")
    public String addContact(Model model){

        model.addAttribute("resumeuser",new ResumeUser());


         return "contactform";

    }

    @PostMapping("/addcontact")
    public String addContact(@Valid ResumeUser resumeUser, BindingResult result){
        if(result.hasErrors()){
            return "contactform";
        }
        resumeUserRepository.save(resumeUser);

        return "redirect:/addmore";

    }


    @GetMapping("/addeducation")
    public String addEducation(Model model) {
        model.addAttribute("education",new Education());
        return "educationform";
    }
  @GetMapping("/addsummary")
    public String addSummary(Model model) {
        model.addAttribute("summary",new Education());
        return "educationform";
    }





}
