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

import com.ir.validator.AdminDeviceValidator;
import com.portal.models.Device;
/**
 * This controller class will hold all the request methods for the CRUD
 * operations on the device.
 * 
 * @author Sathish1203
 *
 */

@Controller
public class AdminDeviceController extends BasicController {
	@Autowired
	AdminDeviceValidator adminDeviceValidator;
	/**
	 * This method will add or update categories. It would first list all the
	 * categories and then allow user to add or update the categories. 
	 * 
	 * @param Device
	 *          -- The device value that is tagged to the model. The model form data object is passed to this method.
	 * @return 
	 *          -- Model and view data object  
	 */
	@RequestMapping(value = "/admin_add_device", method = RequestMethod.GET)
	public ModelAndView add_device(@ModelAttribute("command") Device device) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("device",get_device_id(device));
		model.put("currentUser", get_current_user());
		model.put("devices",  deviceDAOImpl.getDevices());
		return new ModelAndView("add_device", model);
	}

	
	/**
	 * This method will be used to save the device. This controller method
	 * would be invoked to save the admin device and then the add method would
	 * be called.
	 * 
	 * @param Device
	 *          -- The device value that is tagged to the model. The model form data object is passed to this method.
	 * @return 
	 *          -- Model and view data object 
	 */
	@RequestMapping(value = "/admin_save_device", method = RequestMethod.POST)
	public ModelAndView save_device(@ModelAttribute("command") Device device,BindingResult result, SessionStatus status) {
		  adminDeviceValidator.validate(device,result);
			if(result.hasErrors())
			{   		
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("device",get_device_id(device));
			model.put("currentUser", get_current_user());
			model.put("devices", deviceDAOImpl.getDevices());
			return new ModelAndView("add_device", model);
			}
	        
		deviceDAOImpl.addDevice(device);
		return new ModelAndView("redirect:/admin_add_device");
	}

	
	/**
	 * This method will be used to edit the device. This controller method
	 * would be invoked to save the admin device and then the add method would
	 * be called.
	 * 
	 * @param Device
	 *          -- The device value that is tagged to the model. The model form data object is passed to this method.
	 * @return 
	 *          -- Model and view data object 
	 */
	@RequestMapping(value = "/admin_edit_device", method = RequestMethod.GET)
	public ModelAndView edit_device(@ModelAttribute("command") Device device) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("currentUser", get_current_user());
		model.put("device", deviceDAOImpl.getDeviceById(device.getId()));
		model.put("categories", deviceDAOImpl.getDevices());
		return new ModelAndView("add_device", model);
	}

	
	/**
	 * This method will be used to delete the device. This controller method
	 * would be invoked to save the admin device and then the add page method
	 * would be called.
	 * 
	 * @param Device
	 *          -- The device value that is tagged to the model. The model form data object is passed to this method.
	 * @return 
	 *          -- Model and view data object 
	 */
	@RequestMapping(value = "/admin_delete_device", method = RequestMethod.GET)
	public ModelAndView delete_device(@ModelAttribute("command") Device device) {
		deviceDAOImpl.RemoveDevice(device);
		return new ModelAndView("redirect:/admin_add_device");
	}

	/**
	 * This method would get the array index that has to be updated in the web site.
	 * @param device
	 *        -- Device model
	 * @return
	 *        -- Device with id assigned
	 */
	public Device get_device_id(Device device){
		List<Device> device_list = deviceDAOImpl.getDevices();
		int[] indexes = new int[device_list.size()];
		int index = 0;
		System.out.println(device.getId());
		if(device.getId() == null || device.getId().isEmpty()){
			for(Device searchIndex : device_list){
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
			device.setId(String.valueOf(index));
		}
		
		
		return device;
	}
	

	
	
}// End of the class
