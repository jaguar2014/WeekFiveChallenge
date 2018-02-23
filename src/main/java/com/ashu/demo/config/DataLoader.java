package com.ashu.demo.config;

import com.ashu.demo.model.*;
import com.ashu.demo.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {



        @Autowired
        AppRoleRepository roleRepo;

        @Autowired
        AppUserRepository userRepository;

        @Autowired
        EducationRepository educationRepository;

        @Autowired
        SkillRepository skillRepository;

        @Autowired
        ExperienceRepository experienceRepository;

        @Autowired
        ResumeUserRepository resumeUserRepository;

        @Autowired
        ReferenceRepository referenceRepository;

        @Autowired
        SummaryRepository summaryRepository;

        @Override
        public void run(String... strings) throws Exception {

            //Add all data that should be in the database at the beginning of the application
            AppRole role = new AppRole();
            role.setRoleName("EMPLOYER");
            roleRepo.save(role);

            role = new AppRole();
            role.setRoleName("APPLICANT");
            roleRepo.save(role);

            role = new AppRole();
            role.setRoleName("RECRUITER");
            roleRepo.save(role);

            AppUser user = new AppUser();
            user.setUsername("Applicant");
            user.setPassword("password");
            user.addRole(roleRepo.findAppRoleByRoleName("APPLICANT"));
            userRepository.save(user);

            user = new AppUser();
            user.setUsername("Recruiter");
            user.setPassword("password");
            user.addRole(roleRepo.findAppRoleByRoleName("RECRUITER"));

            userRepository.save(user);

            Set<Skill> skills = new HashSet<>();
            Set<Education> educations = new HashSet<>();
            Set<Experience> experiences = new HashSet<>();
            Set<Reference> references = new HashSet<>();
            Summary summary = new Summary();
            summary.setSummarytext("This is the summary");
            summaryRepository.save(summary);




            ResumeUser resumeUser = new ResumeUser();
            resumeUser.setFirstName("Ashenafi");
            resumeUser.setLastName("Mulat");
            resumeUser.setEmail("ashu@gmail.com");
            resumeUser.setPictureUrl("http://www.google.com");
            resumeUser.setSummary(summary);


            Skill aSkill = new Skill();
            aSkill.setRating("proficient");
            aSkill.setSkillName("skill");
            skillRepository.save(aSkill);
            skills.add(aSkill);

            aSkill = new Skill();
            aSkill.setRating("very proficient");
            aSkill.setSkillName("new skill");
            skillRepository.save(aSkill);
            skills.add(aSkill);

            aSkill = new Skill();
            aSkill.setRating("ever more proficient");
            aSkill.setSkillName("newer skill");
            skillRepository.save(aSkill);
            skills.add(aSkill);
            skillRepository.save(skills);

            Education education = new Education();
            education.setDegreeName("Computer science");
            education.setDegreeType("BSc");
            education.setGradYear(new Date("12/20/2005"));
            education.setSchool("BDU");
            educations.add(education);
            educationRepository.save(educations);

            Experience experience = new Experience();
            experience.setCompany("wmata");
            experience.setDutyone("clean");
            experience.setDutytwo("cook");
            experience.setJobTitle("engineer");
            experience.setStartDate(new Date("12/20/30"));
            experience.setEndDate("current");
            experiences.add(experience);
            experienceRepository.save(experiences);

            Reference reference = new Reference();
            reference.setEmail("ashu@yahoo.com");
            reference.setFirstName("tena");
            reference.setLastName("loli");
            references.add(reference);

            referenceRepository.save(references);


            resumeUser.setEducations(educations);
            resumeUser.setExperiences(experiences);
            resumeUser.setEducations(educations);
            resumeUser.setSkills(skills);
            resumeUser.setReferences(references);
            resumeUserRepository.save(resumeUser);






            //Add test data for users
//
//            AppUser user = new AppUser();
//            user.setUsername("applicant");
//            user.setPassword("password");
//            user.setFirstName("John Jacob Jingleheimer");
//            user.setLastName("Schmidt");
//            user.setEmail("jjjschmidt@gmail.com");
//            user.setImage("http://www.nurseryrhymes.org/nursery-rhymes-styles/images/john-jacob-jingleheimer-schmidt.jpg");
//            user.addRole(roleRepo.findAppRoleByRoleName("APPLICANT"));
//            userRepository.save(user);



//
//
//            user = new AppUser();
//            user.setUsername("employer");
//            user.setPassword("password");
//            user.setFirstName("Admin");
//            user.setLastName("User");
//            user.addRole(roleRepo.findAppRoleByRoleName("EMPLOYER"));
//            userRepository.save(user);

//
//            Education e = new Education();
//            e.setCourse("A course");
//            e.setInstitution("Institution");
//            e.setYear(2018);
//            educationRepository.save(e);
//
//            e = new Education();
//            e.setCourse("Another course");
//            e.setInstitution("Another Institution");
//            e.setYear(2018);
//            educationRepository.save(e);
//
//            Experience workexp = new Experience();
//            workexp.setDuties("Duty 1");
//            workexp.setOrganization("An organization");
//            workexp.setPosition("A Position");
//            experienceRepository.save(workexp);
//
//            workexp = new Experience();
//            workexp.setDuties("Duties...so many of them");
//            workexp.setOrganization("Another organization");
//            workexp.setPosition("Aother Position");
//            experienceRepository.save(workexp);
//
//            workexp = new Experience();
//            workexp.setDuties("So many more duties. Real job growth.");
//            workexp.setOrganization("Yet another organization");
//            workexp.setPosition("Yet another Position");
//            experienceRepository.save(workexp);
        }

    }

