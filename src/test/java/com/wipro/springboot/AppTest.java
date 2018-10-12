package com.wipro.springboot;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.wipro.springboot.model.Family;

/**
 * Unit test for simple App.
 */
public class AppTest {
	public static final String REST_SERVICE_URI = "http://localhost:2018/family/";
	Family family = new Family();
	Map<String, Object> request= new HashMap<String, Object>();
   
	public AppTest() {
		
		request.put("mobileNo", 1234567890);
		request.put("firstName", "abc");
		request.put("lastName", "xyz");
		request.put("dob", "797920207000");
		request.put("occupation", "project Engineer");
		request.put("income", 25586);
		request.put("rent", 8500);
		request.put("noOfAdults", 2);
		request.put("noOfChildren", 1);
		request.put("adultExpenses", 5000);
		request.put("childExpenses", 1000);
	}
	@Test
	public void getDetailsTest() {
		System.out.println("Testing Family details API-----------");
		RestTemplate restTemplate = new RestTemplate();
		family= restTemplate.postForObject(REST_SERVICE_URI+"details", request, Family.class);
		assertEquals("abc", family.getFirstName());
	}
	
	@Test
	public void getExpenseTest() {
		System.out.println("Testing Family expense API-----------");
		RestTemplate restTemplate = new RestTemplate();
		@SuppressWarnings("unchecked")
		Map<String, Object> response= restTemplate.postForObject(REST_SERVICE_URI+"expense", request, Map.class);
		assertEquals(19500.0, response.get("expense"));
		
		
	}
}
