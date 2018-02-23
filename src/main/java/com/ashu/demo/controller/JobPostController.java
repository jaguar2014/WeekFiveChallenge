package com.ashu.demo.controller;

import com.ashu.demo.model.JobPost;
import com.ashu.demo.model.Skill;
import com.ashu.demo.repository.JobPostRepository;
import com.ashu.demo.repository.SkillRepository;
import com.sun.xml.internal.ws.resources.HttpserverMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.nio.channels.SelectableChannel;
import java.util.*;

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
    private String processJobPost(@Valid @ModelAttribute("jobpost") JobPost jobpost, BindingResult result, HttpServletRequest request) {

        if (result.hasErrors()) {
            return "jobpost";

        }
        Set<Skill> skills = new HashSet<>();
        Skill skill = new Skill();

        String[] ids = request.getParameterValues("skill");

        for (String id :
                ids) {
            skill.setId(skillRepository.findSkillById(new Long(id)).getId());
            skill.setSkillName(skillRepository.findSkillById(new Long(id)).getSkillName());
            skill.setRating(skillRepository.findSkillById(new Long(id)).getRating());
            jobpost.addSkill(skill);
            jobPostRepository.save(jobpost);


        }





        return "redirect:/jobs/postjob";

    }

    @GetMapping("/jobsmatchingskill")
    private String jobsMatchingSkill(Model model) {

        //retrive all skills the user have and their corresponding skillId ..
        //retrive all the jobs and associated skill id
        //filter out jobs with matching skill id

        Iterable<Skill> skills = skillRepository.findAll();

        Iterable<JobPost> jobPosts = jobPostRepository.findAll();

        Iterable<JobPost> matchingJobs = new ArrayList<>();


        return "";

    }

    @PostMapping("/searchbyorg")
    private String jobbyorg(HttpServletRequest request,Model model){

        String searchString = request.getParameter("srch-term");
        model.addAttribute("search",searchString);
        model.addAttribute("jobPosts",jobPostRepository.findJobPostByOrganizationCompanyName(searchString));

        return "jobsearchresult";

    }
    @GetMapping("/displayjobs")
    private String displayJob(Model model){
        model.addAttribute("jobPosts",jobPostRepository.findAll());

        return "jobsearchresult";

    }

}

