package com.capgemini.contorller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.bean.Avatar;
import com.capgemini.dao.AvatarRepo;

@RestController
public class Controller {
	@Autowired
	AvatarRepo repo;
	
	@RequestMapping("/addAvatar")
	public String home()
	
	{
		return "home.jsp";
	}
	
	@GetMapping("/avatar")
	public List<Avatar> getAliens()
	{
	
		
		return repo.findAll();
	
	}
	@PostMapping(path="/avatar")
	public Avatar addAlien(@RequestBody Avatar avatar)
	{
		repo.save(avatar);
		return avatar;
	}
	@DeleteMapping("/avatar/{aid}")
	public String deleteAvatar(@PathVariable int aid) {
		
		Avatar a= repo.getOne(aid);
		repo.delete(a);
		return "deleted";
		
	}
	@RequestMapping("/avatar/{aid}")
	public Optional<Avatar> getAlien(@PathVariable("aid") int aid)
	{
	
		
		return repo.findById(aid);
	
	}
	@RequestMapping("/getAvatar")
	public ModelAndView getAvatar(@RequestParam int aid)
	{
		ModelAndView mv = new ModelAndView("show.jsp");
		Avatar avatar =repo.findById(aid).orElse(new Avatar());
		mv.addObject(avatar);
		System.out.println(repo.findByAidGreaterThan(101));
		
		return mv;
	}

}
