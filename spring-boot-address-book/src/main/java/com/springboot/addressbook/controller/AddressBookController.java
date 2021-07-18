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
        Contact createdUser = contactService.createContact(contact);
        return new ResponseEntity<Object>(createdUser, HttpStatus.CREATED);
    }

    /*** get a USER by ID in GET request, end point is http://hostname:port/api/va1/user/id
     * @param userId
     * @return
     */

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long userId) {
        Contact contact = contactService.findUserById(userId);
        if (contact == null) {
            MessageResponse messageResponse = new MessageResponse();
            messageResponse.setMessage("User not found.");
            return new ResponseEntity<Object>(messageResponse, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Object>(contact, HttpStatus.OK);
    }

    /**get all list of users based on GET request.
     * @return
     */

    @GetMapping(value = "/getContacts")
    public ResponseEntity<?> getAllUsers() {
        List<Contact> userList = contactService.findAllUsers();
        return new ResponseEntity<Object>(userList, HttpStatus.OK);
    }

    /**Update a user based on PUT request.
     * @param userId
     * @param contact
     * @return
     */
    @PutMapping(value = "/updateContact/{id}")
    public ResponseEntity<?> updateContact(@PathVariable("id") Long userId, @RequestBody Contact contact) {
        contact.setId(userId);
        Contact updatedUser = contactService.updateContact(contact);
        return new ResponseEntity<Object>(updatedUser, HttpStatus.OK);
    }

    
    @DeleteMapping(value = "/deleteContact/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable("id") Long userId) {
        contactService.deleteContact(userId);
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setMessage("User has been deleted successfully.");
        return new ResponseEntity<Object>(messageResponse, HttpStatus.OK);
    }
}
