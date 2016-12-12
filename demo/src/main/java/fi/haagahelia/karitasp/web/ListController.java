package fi.haagahelia.karitasp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.karitasp.domain.CategoryRepository;
import fi.haagahelia.karitasp.domain.Colorlist;
import fi.haagahelia.karitasp.domain.colorRepository;

@Controller
public class ListController {
	@Autowired
	private colorRepository repository; 
	
	@Autowired
	private CategoryRepository crepository; 
	
	@RequestMapping(value="/login")
	public String login() {	
	    return "login";
	    }	
	@RequestMapping(value="/logout")
	public String logout() {	
	    return "login";
	    }	
	

    @RequestMapping(value="/colorlist")
    public String colorList(Model model) {	
        model.addAttribute("colors", repository.findAll());
        return "colorlist";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/add")
    public String addColor(Model model){
    	model.addAttribute("color", new Colorlist());
    	model.addAttribute("category", crepository.findAll());
        return "addcolorspages";
    }    
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editColor(Model model){
    model.addAttribute("color", new Colorlist());
    model.addAttribute("category", crepository.findAll());
     return "edit";
     } 

      
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Colorlist color){
        repository.save(color);
        return "redirect:colorlist";
    }    
    
    @RequestMapping(value = "/save1", method = RequestMethod.POST)
    public String save1(Colorlist color){
        repository.save(color);
        return "redirect:colorlist";
    }  
    
     

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deletecolor(@PathVariable("id") Long colorId, Model model) {
    	repository.delete(colorId);
        return "redirect:../colorlist";
    }   
    
    @RequestMapping(value = "add/edit/{id}", method = RequestMethod.GET)
    public String editcolor(@PathVariable("id") Long colorId, Model model) {
    	repository.delete(colorId);
        return "redirect:../colorlist";
    }   
    
   
    
    
    
     
    
    
        
        
    	
}
