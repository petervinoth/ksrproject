package com.ksr.Controller;

import java.util.List;
import java.util.Optional;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ksr.Model.Blood;
import com.ksr.Repository.bloodRepository;

@Controller
@RequestMapping("/bloods/")
public class mainController {
	
	@Autowired
	private  bloodRepository repo;
     
	  @Autowired
	    public mainController(bloodRepository repo) {
	        this.repo = repo;
	  }
	
	  @GetMapping("signup")
	  public String showSignUpForm(Blood blood) {
		  return "add-blood";
		  
	  }
	  @GetMapping("about")
	  public String aboutBlood() {
		  return "about";
		  
	  }
	 
	  
	 @GetMapping("list")
	 public String  showUpdateForm(Model model) {
		 
		  model.addAttribute("bloods", repo.findAll());
		  return "home";
		 
	 }
	 
	 @PostMapping("add")
	    public String addBlood(@Valid Blood blood, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "add-blood";
	        }

	        repo.save(blood);
	        return "redirect:list";
	    }
	 @GetMapping("/delete/{id}")
	 public String doDelete(@PathVariable("id") int id ,Model model) {
		Blood blood=repo.findById(id)
				 .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		repo.delete(blood);
	        model.addAttribute("bloods", repo.findAll());
	        return "index";
	 
	 }
	 @GetMapping("edit/{id}")
	    public String showUpdateForm(@PathVariable("id") int id, Model model) {
	        Blood blood = repo.findById(id)
	           .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));

	        model.addAttribute("blood", blood);
	        return "update-blood";
	 }
	 
	 @PostMapping("update/{id}")
	    public String updateBlood(@PathVariable("id") int id, @Valid Blood blood, BindingResult result,
	        Model model) {
	        if (result.hasErrors()) {
	            blood.setId(id);
	            return "update-blood";
	        }

	        repo.save(blood);
	        model.addAttribute("bloods", repo.findAll());
	        return "index";
	 }
	 @GetMapping("select/{bloodgroup}")
	  public String  selectBlood(@RequestParam(name="bloodgroup" ,required = false ) String bloodgroup, Model model ) {
		List<Blood> bloods=repo.findByBloodgroup(bloodgroup);
	
	  System.out.println("select working!!!!");
	  
	 model.addAttribute("bloods", repo.findByBloodgroup(bloodgroup));
	  return "select-blood";
	 }
}

	
	 

