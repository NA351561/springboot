package com.wipro.springboot.service;

public interface FamilyService {
	
	public double calculateExpense(double rent, int noOfAdults, double adultExpenses, int noOfChildren, double childExpenses);
	
	public String validateExpense(double totalExpense, int noOfAdults, double adultExpenses, double income);

}
