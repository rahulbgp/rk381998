package com.cts.springmvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//import com.cts.EmployeeBean;
import com.cts.springmvc.entity.Employee;
import com.cts.springmvc.service.impl.EmployeeServiceImpl;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeService1;
	@RequestMapping("callproj")
	public String createUser1(Model m) 
	{	
		//employee attribute==modelattribute in register.jsp
		m.addAttribute("employee",new Employee());
		return "register";//register.jsp==form action=register
	}
	/*
	//insertion
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String createUser(@ModelAttribute Employee employee1,Model m)
	{
		employeeService1.createEmployee(employee1);//save(employee)
		 return "redirect:/view"; //redirect to request pattern::view
	       }
	*/
	//insertion
		@RequestMapping(value = "register", method = RequestMethod.POST)
		public String createUser(
				@Valid 
				@ModelAttribute Employee employee1,
				BindingResult br,
				Model m)
		{
			if(br.hasErrors())  
	        {  
	            return "register";  
	        }  
			else
			{
			employeeService1.createEmployee(employee1);//save(employee)
			 return "redirect:/view"; //redirect to request pattern::view
			} 
			}
		
	//selection
	@RequestMapping(value = "view", method = RequestMethod.GET)
	public String view(@ModelAttribute Employee employee1,Model m)
	{
		List<Employee> obj=employeeService1.getemps();
		m.addAttribute("emps",obj);//emps can beaccessin ViewEmp.jsp
			return "ViewEmp";//ViewEmp.jsp
	}
	//deletion
    @RequestMapping(value="/deleteemps/{delno}",method = RequestMethod.GET)    
    public String delemp(
    		@PathVariable 
    		int delno)
    {    
        employeeService1.deleteemps(delno);
        return "redirect:/view"; //call req pattern /view
    } 

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView viewLogin(@ModelAttribute Employee employee) {
		return new ModelAndView("login");//login.jsp
	}


	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView processLogin(@ModelAttribute Employee employee) 
	{
		boolean emp = employeeService1.checkLogin(employee.getUsername(),employee.getPassword());
		ModelAndView model = null;
		if (emp) 
		{
			model = new ModelAndView("loginsuccess");//loginsuccess.jsp
			model.addObject("emp", employee.getUsername());//access in jsp
			
		} else {
			model = new ModelAndView("login");//login.jsp
			model.addObject("result", "Invalid Username or Password!!");
		}
		return model;
	}

        

}

