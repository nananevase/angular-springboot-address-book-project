package com.springboot.addressbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.addressbook.entity.Contact;
import com.springboot.addressbook.model.MessageResponse;
import com.springboot.addressbook.service.ContactService;

@RestController
@RequestMapping("api/addressBook")   //Base Url.
public class AddressBookController {

    @Autowired
    private ContactService contactService;

    /**
     * Creates the contact.
     *
     * @param contact the contact
     * @return the response entity
     */
    @PostMapping(value = "/createContact")
    public ResponseEntity<?> createContact(@RequestBody Contact contact) {
        Contact createdContact = contactService.createContact(contact);
        return new ResponseEntity<Object>(createdContact, HttpStatus.CREATED);
    }

   
    /**
     * Gets the contacts.
     *
     * @return the contacts
     */
    @GetMapping(value = "/getContacts")
    public ResponseEntity<?> getContacts() {
        List<Contact> contactList = contactService.findAllContacts();
        return new ResponseEntity<Object>(contactList, HttpStatus.OK);
    }

    
    
    /**
     * Update contact.
     *
     * @param contactId the contact id
     * @param contact the contact
     * @return the response entity
     */
    @PutMapping(value = "/updateContact/{id}")
    public ResponseEntity<?> updateContact(@PathVariable("id") Long contactId, @RequestBody Contact contact) {
        contact.setId(contactId);
        Contact updatedContact = contactService.updateContact(contact);
        return new ResponseEntity<Object>(updatedContact, HttpStatus.OK);
    }

    
    
    /**
     * Delete contact.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping(value = "/deleteContact/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable("id") Long id) {
        contactService.deleteContact(id);
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setMessage("Contact has been deleted successfully.");
        return new ResponseEntity<Object>(messageResponse, HttpStatus.OK);
    }
}
