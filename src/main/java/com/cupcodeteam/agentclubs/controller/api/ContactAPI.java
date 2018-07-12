package com.cupcodeteam.agentclubs.controller.api;

import com.cupcodeteam.agentclubs.entity.Contact;
import com.cupcodeteam.agentclubs.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContactAPI {

    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping("/get_contact_list")
    public List<Contact> getContactList(){
        List<Contact> contacts = this.contactRepository.findAll();

        return contacts;
    }

    @RequestMapping("/get_contact_by_id/{id}")
    public Contact getContactById(@PathVariable int id){
        Contact contact = this.contactRepository.findOneById(id);

        return contact;
    }

}

