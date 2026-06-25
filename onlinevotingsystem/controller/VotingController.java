package com.fswt.onlinevotingsystem.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fswt.onlinevotingsystem.entity.Candidate;
import com.fswt.onlinevotingsystem.entity.Citizen;
import com.fswt.onlinevotingsystem.repositories.CandidateRepo;
import com.fswt.onlinevotingsystem.repositories.CitizenRepo;

import org.springframework.ui.Model;


@Controller
public class VotingController {
	
	@Autowired
	CitizenRepo citizenRepo;
	
	@Autowired
	CandidateRepo candidateRepo;
	 
	@RequestMapping("/")
	public String landingPage() {
		return "main";
	}
	
	@RequestMapping("/vote")
	public String goToVote() {
		
		
		return "voted";
	}
   
	@RequestMapping("/doLogin")
	public String doLogin(@RequestParam String name, Model model) {
	    Citizen citizen = citizenRepo.findByName(name);

	    if (citizen == null) {
	        model.addAttribute("error", "Citizen not found");
	        return "error"; 
	    }

	    if (!citizen.getHasVoted()) {
	        List<Candidate> candidates = candidateRepo.findAll();
	        candidates.forEach(candidate -> System.out.println(candidate.getName())); // Log each candidate's name
	        model.addAttribute("candidates", candidates);
	        return "performVoted"; 
	    } else {
	        return "alreadyVoted"; 
	    }
	}

	@RequestMapping("/voteFor")
	public String voteFor(@RequestParam long id) {
		Candidate c = candidateRepo.findById( (long)id);
		c.setNumberOfVotes(c.getNumberOfVotes()+1);
		candidateRepo.save(c);
		
		return "result";
	}
	 @RequestMapping("/result")
	    public String viewResults(Model model) {
	        List<Candidate> candidates = candidateRepo.findAll();
	        model.addAttribute("candidates", candidates);
	        return "result"; // Corresponds to result.html
	    }
	    
	
}
