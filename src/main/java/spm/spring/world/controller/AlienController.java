package spm.spring.world.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import spm.spring.world.model.Alien;
import spm.spring.world.service.AlienService;

import java.util.ArrayList;
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
	@GetMapping(value = "/alians/")
	public List<Alien> getAllAlian() {
		return repo.getAllAlien();
	}


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getdata() {

		List<String> list = getList();

		//return back to index.jsp
		ModelAndView model = new ModelAndView("index");
		model.addObject("lists", list);

		return model;

	}

	private List<String> getList() {

		List<String> list = new ArrayList<String>();
		list.add("List A");
		list.add("List B");
		list.add("List C");
		list.add("List D");
		list.add("List 1");
		list.add("List 2");
		list.add("List 3");

		return list;

	}

}