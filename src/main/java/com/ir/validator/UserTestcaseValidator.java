package com.ir.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.portal.models.Testcase;
 


@Component
public class UserTestcaseValidator implements Validator{

	   public boolean supports(Class<?> clazz) {
	        return Testcase.class.isAssignableFrom(clazz);
	    }	
	
	
	   public void validate(Object target, Errors errors) {
		   System.out.println("VALIDATE");
		   Testcase testcase = (Testcase)target;  

		   String id = testcase.getId(); 
		   String name = testcase.getName();
		   String expectedresults = testcase.getExpectedresults();
		   String deviceid = testcase.getDeviceid();
		   String scenario = testcase.getScenario();
		   String steps = testcase.getSteps();
		   String testdata = testcase.getTestdata();
		 
		   ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "error.id", "Id is required.");
		   ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.name", "Name is required.");
		   ValidationUtils.rejectIfEmptyOrWhitespace(errors, "deviceid", "error.deviceid", "Sub category is required.");
		   ValidationUtils.rejectIfEmptyOrWhitespace(errors, "scenario", "error.scenario", "scenario is required.");
		   ValidationUtils.rejectIfEmptyOrWhitespace(errors, "steps", "error.steps", "steps is required.");
		   ValidationUtils.rejectIfEmptyOrWhitespace(errors, "testdata", "error.testdata", "testdata is required.");
		            
		  // Additional validations on length and type. 
		  Pattern notAlphaNumeric = Pattern.compile("[^a-zA-Z0-9\\s]");
		  
		  if(notAlphaNumeric.matcher(id).find() ||  id.length()>10) errors.rejectValue("id", "id.incorrect","Id should be Alpha Numeric and < 10 characters.");		
		  if(notAlphaNumeric.matcher(name).find() || name.length()>30 || name.length()<3 ) errors.rejectValue("name", "name.incorrect","Name should be Alpha Numeric and 3 - 30 characters.");
		  if(expectedresults.length()>2000 || expectedresults.length()<10) errors.rejectValue("expectedresults", "expectedresults.incorrect","Expectedresults should be 10 - 2000 characters.");
		  if(scenario.length()>20000 || scenario.length()<10) errors.rejectValue("scenario", "scenario.incorrect","Scenario should be 10 - 20000 characters.");
		  if(steps.length()>20000 || steps.length()<10) errors.rejectValue("steps", "steps.incorrect","Steps should be 10 - 20000 characters.");
		  if(testdata.length()>2000 || testdata.length()<10) errors.rejectValue("testdata", "testdata.incorrect","Testdata should be 10 - 2000 characters.");
		   
	   }
	
	
	
	
	
	
	
	
	
	
	
	
}
