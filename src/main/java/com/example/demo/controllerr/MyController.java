   package com.example.demo.controllerr;

import java.util.List;
import java.util.Optional;
import java.util.jar.Attributes.Name;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepo;

@Controller
public class MyController {

  @Autowired  
  private  StudentRepo stu;
  
  
    @RequestMapping("/test")
    String myfun(Model m) {
        Student s = new Student();

        System.out.println("Data in	 u object from " + s);
        m.addAttribute("obj", s);

        return "page1.html";
    }

    @RequestMapping("/insert")
    ModelAndView myfun2(@ModelAttribute("obj") Student s1) {
        System.out.println("Data in u object from After " + s1);
        
        stu.save(s1);
        
        List<Student> slist = stu.findAll();
        
        
        ModelAndView mv = new ModelAndView("welcome.html");
        mv.addObject("ob", s1);
        mv.addObject("show", slist);

        return mv; 
    }
    
    
    
    
    
    

	/*
	 * @RequestMapping("/show") ModelAndView myfun24(@ModelAttribute("obj") Student
	 * s1) { System.out.println("Data in u object from After " + s1);
	 * 
	 * 
	 * List<Student> slist = stu.findAll();
	 * 
	 * 
	 * ModelAndView mv = new ModelAndView("welcome.html"); mv.addObject("show",
	 * slist);
	 * 
	 * return mv; }
	 */
    
    @RequestMapping("/show")
    ModelAndView myfun246(@ModelAttribute("obj") Student s1) {
        System.out.println("Data in u object from After " + s1);

        // Assuming stu.findAll() returns a List of Students
        List<Student> slist = stu.findAll(Sort.by(Sort.Direction.DESC, "id"));

        ModelAndView mv = new ModelAndView("welcome.html");
        mv.addObject("show", slist);

        return mv; 
    }

    
    
    
    @RequestMapping("/search")
    public ModelAndView myfun3(@RequestParam("name") String name) {
        List<Student> searchResults = stu.findByNameContaining(name);

    //    List<Student> searchResults = stu.findByNameContaining("%" + name + "%");

        
        
        ModelAndView mv = new ModelAndView("welcome.html");
        mv.addObject("searchob", searchResults);
        return mv;
    }
    
@GetMapping("/delete/{id}")
    public String myfun4(@PathVariable("id") Integer id) {

        stu.deleteById(id);

      
        return "redirect:/show";
    }
    




@RequestMapping("/update/{id}")
public ModelAndView showUpdateForm(@PathVariable("id") Integer id) {
    Optional<Student> student = stu.findById(id);

    ModelAndView mv = new ModelAndView("update.html");
    mv.addObject("student", student.orElse(null)); // Pass the student to the update form
    return mv;
}


@PostMapping("/updatee")
public String updateStudent(@ModelAttribute Student updatedStudent) {
    stu.save(updatedStudent); // Save the updated student data
    return "redirect:/show"; // Redirect to the student list page after update
}

    
}
