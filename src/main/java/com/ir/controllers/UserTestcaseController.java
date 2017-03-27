package com.ir.controllers;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.ir.validator.UserTestcaseValidator;
import com.portal.models.Testcase;

/**
 * This controller class will hold all the request methods for the CRUD
 * operations on the testcase.
 * 
 * @author Sathish1203
 *
 */

@Controller
public class UserTestcaseController extends BasicController {
	@Autowired
	UserTestcaseValidator userTestcaseValidator;
	/**
	 * This method will add or update testcases. It would first list all the
	 * testcases and then allow user to add or update the testcases. 
	 * 
	 * @param Testcase
	 *          -- The testcase value that is tagged to the model. The model form data object is passed to this method.
	 * @return 
	 *          -- Model and view data object  
	 */
	@RequestMapping(value = "/user_add_testcase", method = RequestMethod.GET)
	public ModelAndView add_testcase(@ModelAttribute("command") Testcase testcase) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("currentUser", get_current_user());
		model.put("testcase",get_testcase_with_id(testcase));
		model.put("testcases", testcaseDAOImpl.getTestcases());
		model.put("devices", deviceDAOImpl.getDevices());
		return new ModelAndView("testcase", model);
	}
	
	
	/**
	 * This method will be used to save the testcase. This controller method
	 * would be invoked to save the admin testcase and then the add method would
	 * be called.
	 * 
	 * @param Testcase
	 *          -- The testcase value that is tagged to the model. The model form data object is passed to this method.
	 * @return 
	 *          -- Model and view data object 
	 */
	@RequestMapping(value = "/user_save_testcase", method = RequestMethod.POST)
	public ModelAndView save_testcase(@ModelAttribute("command") Testcase testcase,BindingResult result, SessionStatus status) {
		String currentDir = System.getProperty("user.dir");
		userTestcaseValidator.validate(testcase,result);
		if(result.hasErrors())
		{   	
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("currentUser", get_current_user());
		model.put("testcase",get_testcase_with_id(testcase));
		model.put("testcases", testcaseDAOImpl.getTestcases());
		model.put("devices", deviceDAOImpl.getDevices());
		return new ModelAndView("testcase", model);
		}
        testcaseDAOImpl.addTestcase(testcase);
		return new ModelAndView("redirect:/user_add_testcase");
	}

	
	
	/**
	 * This method will be used to edit the testcase. This controller method
	 * would be invoked to save the admin testcase and then the add method would
	 * be called.
	 * 
	 * @param Testcase
	 *          -- The testcase value that is tagged to the model. The model form data object is passed to this method.
	 * @return 
	 *          -- Model and view data object 
	 */
	@RequestMapping(value = "/user_edit_testcase", method = RequestMethod.GET)
	public ModelAndView edit_testcase(@ModelAttribute("command") Testcase testcase) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("currentUser", get_current_user());
		System.out.println("testcase.getId()->"+ testcase.getId());
	    model.put("testcase", testcaseDAOImpl.getTestcaseById(testcase.getId()));
		model.put("testcases", testcaseDAOImpl.getTestcases());
		model.put("devices", deviceDAOImpl.getDevices());
		return new ModelAndView("testcase", model);
	}

	
	/**
	 * This method will be used to delete the testcase. This controller method
	 * would be invoked to save the admin testcase and then the add page method
	 * would be called.
	 * 
	 * @param Testcase
	 *          -- The testcase value that is tagged to the model. The model form data object is passed to this method.
	 * @return 
	 *          -- Model and view data object 
	 */
	@RequestMapping(value = "/user_delete_testcase", method = RequestMethod.GET)
	public ModelAndView delete_testcase(@ModelAttribute("command") Testcase testcase) {
		testcaseDAOImpl.RemoveTestcase(testcase);
		return new ModelAndView("redirect:/user_add_testcase");
	}
	
	
	
	/**
	 * This method will set the testcase id for the web page.
	 * @param testcase
	 *          -- The model to be sent
	 * @return
	 *          -- The model with id populated
	 */
	public Testcase get_testcase_with_id(Testcase testcase){
		List<Testcase> testcase_list = testcaseDAOImpl.getTestcases();
		int[] indexes = new int[testcase_list.size()];
		int index = 0;
		System.out.println(testcase.getId());
		if(testcase.getId() == null || testcase.getId().isEmpty()){
			for(Testcase searchIndex : testcase_list){
				System.out.println(searchIndex.getId());
				indexes[index] = Integer.parseInt(searchIndex.getId());
				index = index + 1;
			}
			index = 0;
			Arrays.sort(indexes);
			for(int i : indexes){
				if(index==i){
					index = index +1;
					continue;
				}
				else{
					break;
				}
				
			}
			testcase.setId(String.valueOf(index));
		
		}
		return testcase;
	}
	
}// End of the class
