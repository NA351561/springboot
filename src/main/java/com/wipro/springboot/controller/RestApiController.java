package com.wipro.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.springboot.model.Family;
import com.wipro.springboot.service.FamilyService;

@RestController
@RequestMapping("/family/")
public class RestApiController {
	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);
	
	@Autowired
	FamilyService familyService;
	Map<String, Object> result= new HashMap<String, Object>();
	
	//----------------------Family details --------------------
	@RequestMapping(value = "details", method = RequestMethod.POST)
	public ResponseEntity<?> familyDetails(@RequestBody Family family){
		logger.info("Family details");		
		return new ResponseEntity<Family>(family, HttpStatus.OK);
		
	}
	
	//----------------------Family Expense --------------------
	@RequestMapping(value = "expense", method = RequestMethod.POST)
	public ResponseEntity<?> familyExpense(@RequestBody Family family){
		logger.info("Family expense");
		double expense = familyService.calculateExpense(family.getRent(), family.getNoOfAdults(), 
				family.getAdultExpenses(), family.getNoOfChildren(), family.getChildExpenses());
		result.put("name", family.getFirstName());
		result.put("expense",expense);
		String validation = familyService.validateExpense(expense, family.getNoOfAdults(), family.getAdultExpenses(), family.getIncome());
		result.put("message", validation);
		return new ResponseEntity<Map>(result, HttpStatus.OK);
		
	}

}
