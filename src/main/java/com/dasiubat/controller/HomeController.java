package com.dasiubat.controller;

import com.dasiubat.domain.Person;
import com.dasiubat.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HomeController {
    @Autowired
    private PersonRepository personRepository;

	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{

        Iterable<Person> persons = personRepository.findAll();
		return new ModelAndView("home");
	}
}
