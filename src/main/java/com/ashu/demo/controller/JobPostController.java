package com.ashu.demo.controller;

import com.ashu.demo.model.JobPost;
import com.ashu.demo.model.Skill;
import com.ashu.demo.repository.JobPostRepository;
import com.ashu.demo.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/jobs")
public class JobPostController {

    @Autowired
    JobPostRepository jobPostRepository;

    @Autowired
    SkillRepository skillRepository;


    @GetMapping("/index")
    private String jobsIndex() {

        return "jobsindex";

    }

    @GetMapping("/postjob")
    private String jobPost(Model model) {
        model.addAttribute("jobpost", new JobPost());

        model.addAttribute("skills", skillRepository.findAll());

        return "jobpost";

    }

    @PostMapping("/postjob")
    private String processJobPost(@Valid JobPost jobPost, BindingResult result, HttpServletRequest request, Model model) {

        if (result.hasErrors()) {
            return "jobpost";

        }
        jobPostRepository.save(jobPost);

        return "redirect:/jobs/addSkill";




}

        @GetMapping("/addSkill")
        private String addSkill (Model model){

            model.addAttribute("jobpost", new Skill());


            return "skillform";

        }

        @PostMapping("/addJobPostSkill")
        private String addSkill1 (@Valid Skill skill, BindingResult result, HttpServletRequest request, Model model){
            if (result.hasErrors()) {
                return "skillform";
            }




            skillRepository.save(skill);


            return "redirect:/jobs/index";
        }


    }

