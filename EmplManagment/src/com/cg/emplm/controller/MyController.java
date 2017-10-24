package com.cg.emplm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.emplm.dtos.Employee;
import com.cg.emplm.service.EmplService;

@Controller
@RequestMapping("/empl")
public class MyController {

	
	@Autowired
	private EmplService empService;


	

	public EmplService getEmpService() {
		return empService;
	}


	public void setEmpService(EmplService empService) {
		this.empService = empService;
	}


	@RequestMapping("/list")
	public ModelAndView getAll(){
		
	List<Employee> empList = empService.getAllItems();
		
	for(Employee emp : empList){
		System.out.println(emp);
	}
		return new ModelAndView("pages/AllItems","eList",empList);
	}
	
	
	@RequestMapping("/insert")
	public String prepareAddDetails(Model model){
		// Before Going to addpage make employee object NULL 
		model.addAttribute("emp",new Employee());
		
		return "pages/addEmployee";
	}
	
	
	//name in ModeAttribute and commandName must match "emp" 
	
	@RequestMapping("/addDetails")
	public String addEmployeeDetails(@ModelAttribute("emp")@Valid Employee emp,BindingResult result,Model m){
		
		if(result.hasErrors()){
			return "pages/addEmployee";
		}
		else{
			
			System.out.println("Before  "+emp);
			emp = empService.addEmployeeDetails(emp);
			System.out.println("After  "+emp);	
			return "pages/successInsert";
		}	
	}
	@RequestMapping("/getById")
	public String prepareEmpById(){
		return "pages/getById";
	}
	
	@RequestMapping("/getEmplById")
	public ModelAndView getEmpByID(@RequestParam("employeeId") long employeeId){
		System.out.println("Employee Id is "+employeeId);
		Employee emp = new Employee();
		emp = empService.getEmpById(employeeId);
		return new ModelAndView("pages/EmpDetails","employee",emp);

	}
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public ModelAndView showEdit(@RequestParam int employeeId){
		return new ModelAndView("pages/edit","emp",empService.getEmpById(employeeId));
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ModelAndView doUpdate(@ModelAttribute("emp")@Valid Employee emp,BindingResult result){
		
		ModelAndView mv = new ModelAndView("pages/SuccessUpdate");
		if(result.getErrorCount()==0){
			Employee e = empService.updateEmployee(emp);
			System.out.println("in Controller"+e);
			
		}else{
			mv.addObject("emp",emp);
			mv.setViewName("pages/edit");
		}
		return mv;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String doDelete(@RequestParam int employeeId){
		if(empService.delete(employeeId))
			System.out.println("Data Deleted Successfully");
		else
			System.out.println("Not Deleted");
		
		return "redirect:list.obj";
	}
	
	
}
