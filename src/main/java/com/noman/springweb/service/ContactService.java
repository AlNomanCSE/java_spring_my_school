package com.noman.springweb.service;

import com.noman.springweb.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ContactService {

    public boolean sameMessageDetails(Contact contact) {
        boolean isSaved = false;
        //TODO
        log.info(contact.toString());
        return isSaved;
    }
}
