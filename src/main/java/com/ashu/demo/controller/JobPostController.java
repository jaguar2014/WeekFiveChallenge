package com.ashu.demo.controller;

import com.ashu.demo.model.JobPost;
import com.ashu.demo.repository.JobPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/jobs")
public class JobPostController {

    @Autowired
    JobPostRepository jobPostRepository;

    @GetMapping("/postjob")
    private String jobPost(Model model){
        model.addAttribute("jobpost", new JobPost());

        return "jobpost";

    }

    @PostMapping("/postjob")
    private String processJobPost(@Valid JobPost jobPost, BindingResult result, Model model){

        if (result.hasErrors()){
            return "jobpost";
        }
        jobPostRepository.save(jobPost);

        return "jobpostlist";

    }



}
