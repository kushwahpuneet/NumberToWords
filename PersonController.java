package com.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.Person;
import com.service.NumberWordConverterService;


@RestController
public class PersonController {
	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
	@Autowired
	NumberWordConverterService numberWordConverterService;
	@RequestMapping(value = "/convert", method = RequestMethod.GET)
	public Person getPersonInfo(@ModelAttribute("name") String name,@ModelAttribute("money") String money) {
		logger.info("Start getPersonInfo. name="+name +"money "+money);
		String moneyInWord=numberWordConverterService.getMoneyIntoWords(money);
		Person person=new Person();
		person.setName(name);
		person.setMoney(moneyInWord);

		return person;
	}

}
