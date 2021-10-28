package com.spring.controllers;     
import java.util.List;    
import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.ModelAttribute;    
import org.springframework.web.bind.annotation.PathVariable;    
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.beans.Emp;
import com.spring.dao.EmpDao;    
@Controller
public class EmpController {


	@Autowired  
    EmpDao dao;
	
	@RequestMapping("/index")
	public String index() 
	{
		return "index";	
	}
	
    @RequestMapping("/empform")    
    public String showform(Model m){    
        m.addAttribute("command", new Emp());  
        return "empform";   
    }   
    
    @RequestMapping(value="/save",method = RequestMethod.POST)    
    public String save(@ModelAttribute("p") Emp p){    
        dao.save(p);    
        return "redirect:/viewemp";   
    }    
    
    @RequestMapping("/viewemp")    
    public String viewemp(Model m){    
        List<Emp> list=dao.getEmp();    
        m.addAttribute("list",list);  
        return "viewemp";    
    }   
    
    @RequestMapping(value="/empeditform/{id}")    
    public String edit(@PathVariable int id, Model m){    
        Emp p=dao.getEmpById(id);    
        m.addAttribute("command",p);  
        return "empeditform";    
    }    

    @RequestMapping(value="/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("p") Emp p){    
        dao.update(p);    
        return "redirect:/viewemp";    
    }    
 
    @RequestMapping(value="/deletemp/{id}",method = RequestMethod.GET)    
    public String delete(@ModelAttribute("p") Emp p){    
        dao.delete(p);    
        return "redirect:/viewemp";    
    } 
}