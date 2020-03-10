package spm.spring.world.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spm.spring.world.model.Alien;
import spm.spring.world.model.Student;
import spm.spring.world.repository.AlienRepo;
import spm.spring.world.service.AlienService;

import java.util.List;


@Controller
public class AlienController
{
	@Autowired
	AlienService repo;

	@RequestMapping("/hello")
	public String home1(){
		return "Hello World!";
	}

	@RequestMapping("/")
	public String home()
	{
		return "home";
	}
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien)
	{
		repo.save(alien);
		return "home";
	}

	// Get all students from the h2 database.
	// @GetMapping annotation handles the http get request matched with the given uri.
	@GetMapping(value= "/student/getall")
	public List<Alien> getAllAlian() {
		return repo.getAllAlien();
	}
}