package com.springboot.addressbook.service;

import java.util.List;

import com.springboot.addressbook.entity.Contact;

/**
 * The Interface ContactService.
 */
public interface ContactService {
	
    Contact createContact(Contact contact);

    List<Contact> findAllContacts();

    Contact updateContact(Contact contact);

    void deleteContact(Long contactId);
}
