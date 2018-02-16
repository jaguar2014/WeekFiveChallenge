package com.ashu.demo.controller;

import com.ashu.demo.model.*;
import com.ashu.demo.repository.*;
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


    @Autowired
    SummaryRepository summaryRepository;

    @Autowired
    ReferenceRepository referenceRepository;



    @GetMapping("/")
    public String showIndex(Model model) {










        return "index";
    }

    @GetMapping("/contact")
    public String contact(Model model)
    {

        model.addAttribute("contact", resumeUserRepository.findAll());

        return "contact";

    }
    @GetMapping("/education")
    public String education(Model model)
    {

        model.addAttribute("educations", educationRepository.findAll());


        return "education";

    }


   @GetMapping("/experience")
    public String experience(Model model)
    {

        model.addAttribute("experiences", experienceRepository.findAll());



        return "experience";

    }
   @GetMapping("/skill")
    public String skill(Model model)
    {

        model.addAttribute("skills", skillRepository.findAll());



        return "skill";



    }

    @GetMapping("/summary")
    public String summary(Model model)
    {

        model.addAttribute("summary", summaryRepository.findAll());



        return "summary";

    }


  @GetMapping("/reference")
    public String reference(Model model)
    {


        model.addAttribute("references", referenceRepository.findAll());



        return "reference";

    }



    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/logout")
    public String logout() {
        return "login";
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

        return "redirect:/addsummary";

    }


    @GetMapping("/addeducation")
    public String addEducation(Model model) {
        model.addAttribute("education",new Education());
        return "educationform";
    }


 @PostMapping("/addeducation")
    public String addEducation(@Valid Education education , BindingResult result){

        if(result.hasErrors()){
            return "educationform";
        }

        educationRepository.save(education);

        return "redirect:/addeducation";
    }


  @GetMapping("/addsummary")
    public String addSummary(Model model) {
        model.addAttribute("summary",new Summary());
        return "summaryform";
    }



    @PostMapping("/addsummary")
    public String addEducation(@Valid Summary summary , BindingResult result){

        if(result.hasErrors()){
            return "summaryform";
        }

        summaryRepository.save(summary);

        return "redirect:/addeducation";
    }



    @GetMapping("/addexperience")
    public String addExperience(Model model)
    {
        model.addAttribute("experience", new Experience());

        return "experienceform";
    }

    @PostMapping("/addexperience")
    public String addUser(@Valid Experience experience , BindingResult result){

        if(result.hasErrors()){
            return "experienceform";
        }

        experienceRepository.save(experience);

        return "redirect:/addexperience";
    }



    @GetMapping("/addskill")
    public String addSkill(Model model)
    {
        model.addAttribute("skill", new Skill());

        return "skillform";
    }


    @PostMapping("/addskill")
    public String addEducation(@Valid Skill skill , BindingResult result){

        if(result.hasErrors()){
            return "skillform";
        }

        skillRepository.save(skill);

        return "redirect:/addskill";
    }


    @GetMapping("/addreference")
    public String addReference(Model model)
    {
        model.addAttribute("reference", new Reference());

        return "referenceform";
    }


    @PostMapping("/addreference")
    public String addReference(@Valid Reference reference , BindingResult result){

        if(result.hasErrors()){
            return "referenceform";
        }

       referenceRepository.save(reference);

        return "redirect:/addreference";
    }



    @GetMapping("/displaycompletedresume")
    public String display(Model model)
    {

        model.addAttribute("contact", resumeUserRepository.findAll());

        model.addAttribute("educations", educationRepository.findAll());

        model.addAttribute("experiences", experienceRepository.findAll());


        model.addAttribute("skills", skillRepository.findAll());

        model.addAttribute("summary", summaryRepository.findAll());

        model.addAttribute("references", referenceRepository.findAll());

        return "finalresume";
    }

    @GetMapping("/displaycontact")
    public String displayContact(Model model)
    {

        model.addAttribute("contact", resumeUserRepository.findAll());

        return "displayresume";
    }


    @GetMapping("/disaplyeducation")
    public String displayEducation(Model model)
    {

        model.addAttribute("educations", educationRepository.findAll());
        return "displayresume";
    }
    @GetMapping("/disaplayexperience")
    public String displayExperience(Model model)
    {

        model.addAttribute("experiences", experienceRepository.findAll());
        return "displayresume";
    }
     @GetMapping("/dsiplayskill")
    public String displaySkill(Model model)
    {

        model.addAttribute("skills", skillRepository.findAll());
        return "displayresume";
    }

        @GetMapping("/displaysummary")
    public String displaySummary(Model model)
    {

        model.addAttribute("summary", summaryRepository.findAll());
        return "displayresume";
    }


         @GetMapping("/displayreference")
    public String displayReference(Model model)
    {

        model.addAttribute("references", referenceRepository.findAll());
        return "displayresume";
    }







}
