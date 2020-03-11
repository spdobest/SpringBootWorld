package spm.spring.world.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import spm.spring.world.model.City;
import spm.spring.world.service.ICityService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CityController {

    @Autowired
    private ICityService cityService;

    @RequestMapping("/index")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping("/cities")
    public ModelAndView showCities() {

        List<City> cities = cityService.findAll();
        System.out.println("inside cities " + cities.size());
        Map<String, Object> params = new HashMap<>();

//        ModelAndView modelAndView = new ModelAndView("showCities");
//        modelAndView.addObject("cities", cities);
//        return modelAndView;


        params.put("cities", cities);
        System.out.println("inside cities ");

        return new ModelAndView("showCities", params);
    }
}