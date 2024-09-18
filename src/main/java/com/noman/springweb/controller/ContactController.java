package com.noman.springweb.controller;

import com.noman.springweb.model.Contact;
import com.noman.springweb.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Slf4j
@Controller
public class ContactController {
    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping("/contact")
    public String displayContactPage() {
        return "contact";
    }
//    @RequestMapping(value = "/saveMsg", method = RequestMethod.POST)
//    //@PostMapping(value = "/saveMsg")
//    public ModelAndView saveMessage(@RequestParam(name = "name") String username,
//                                    @RequestParam String mobileNum,
//                                    @RequestParam String email,
//                                    @RequestParam String subject,
//                                    @RequestParam String message
//    ) {
//        log.info("Name :" + username);
//        log.info("Mobile Number :" + mobileNum);
//        log.info("Email :" + email);
//        log.info("Subject :" + subject);
//        log.info("Message :" + message);
//
//        return new ModelAndView("redirect:/contact");
//
//    }

    @RequestMapping(value = "/saveMsg", method = RequestMethod.POST)
    public ModelAndView saveMessage(Contact contact) {
        contactService.sameMessageDetails(contact);
//        log.info(contact.toString());
        return new ModelAndView("redirect:/contact");
    }

}
