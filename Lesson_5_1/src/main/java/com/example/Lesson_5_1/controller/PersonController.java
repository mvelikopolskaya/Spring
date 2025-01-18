package com.example.Lesson_5_1.controller;



import com.example.Lesson_5_1.model.Person;
import com.example.Lesson_5_1.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private PersonService service;


    @GetMapping
    public String getAllBook(Model model) {
        model.addAttribute("persons", service.getAllPersons());
        return "persons";
    }

    @GetMapping("/{id}")
    public String findPersonById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("person", service.getPersonById(id));
        return "person_profile";
    }

//    @GetMapping("/add")
//    public String savePerson(@RequestParam(defaultValue = "") String name,
//                             @RequestParam(defaultValue = "") String email,
//                             Model model) {
//        Person person = service.addPerson(name, email);
//        model.addAttribute("person", person);
//        return "person_profile";
//    }

    @GetMapping("/add")
    public String savePerson(Model model) {
        model.addAttribute("person", new Person());
        return "new_profile";
    }

    @PostMapping
    public String savePerson(@ModelAttribute Person person) {
        service.addPerson(person);
        return "redirect:persons";
    }

    @GetMapping("/update/{id}")
    public String updatePerson(@PathVariable("id") Long id,
                               Model model) {
        model.addAttribute("person", service.getPersonById(id));
        return "update_profile";
    }

    @PostMapping("/update/{id}")
    public String updatePerson(@PathVariable("id") Long id,
                                @ModelAttribute Person updatedPerson) {
        service.updatePerson(id, updatedPerson);
        return "redirect:/persons";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable("id") Long id, Model model) {
        service.deletePerson(id);
        return "redirect:/persons";
    }
}
