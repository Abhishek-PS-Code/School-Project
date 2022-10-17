package com.demo.udemy.eazyschool.controller;

import com.demo.udemy.eazyschool.model.Contact;
import com.demo.udemy.eazyschool.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
public class ContactController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = {"/contact"})
    public String displayContactPage(Model model){

        model.addAttribute("contact",new Contact());
        return "contact.html";
    }

//    @PostMapping(value = "/saveMsg")
//    public ModelAndView saveMessage(@RequestParam String name,
//                                    @RequestParam String mobileNum,
//                                    @RequestParam String email,
//                                    @RequestParam String subject,
//                                    @RequestParam String message){
//
//        log.info("Name = "+name);
//        return new ModelAndView("redirect:/contact");
//
//    }

    @PostMapping(value = "/saveMsg")
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors){

        if(errors.hasErrors())
        {
            log.info("contact for validation failed due to following error : "+errors.toString());
            return "contact.html";
        }
        contactService.saveMessageDetails(contact);

        return "redirect:/contact";

    }
}
