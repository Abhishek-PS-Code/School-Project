package com.demo.udemy.eazyschool.service;

import com.demo.udemy.eazyschool.model.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public boolean saveMessageDetails(Contact contact){

        log.info("Details are "+contact.toString());
        return true;
    }
}
