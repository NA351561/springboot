package com.wipro.springboot.service;

import org.springframework.stereotype.Service;

@Service
public class FamilyServiceImpl implements FamilyService {
	
	public static final double AVG_EXPENSES_ADULT = 100;
	public static final double AVG_EXPENSES_CHILDREN = 50;

	@Override
	public double calculateExpense(double rent, int noOfAdults, double adultExpenses, int noOfChildren,
			double childExpenses) {
		
		double totalExpense = rent + noOfAdults * adultExpenses + noOfChildren * childExpenses;
		
		return totalExpense;
	}

	@Override
	public String validateExpense(double totalExpense, int noOfAdults, double adultExpenses, double income) {
		// TODO Auto-generated method stub
		if(totalExpense > income)
			return "total expense :"+totalExpense+" is greater than income:"+income;
		if(adultExpenses > (noOfAdults * AVG_EXPENSES_ADULT))
			return "adult expense :"+adultExpenses+" is greater than average adult expense:"+(noOfAdults * AVG_EXPENSES_ADULT);
		if(adultExpenses > income)
			return "adult expense :"+adultExpenses+" is greater than income:"+income;
		if(adultExpenses > totalExpense)
			return "adult expense :"+adultExpenses+" is greater than total expense:"+totalExpense;
		else
			return "Healthy and wealthy family";
	}

}
