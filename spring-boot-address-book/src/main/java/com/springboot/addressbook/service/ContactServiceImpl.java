package com.springboot.addressbook.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.addressbook.entity.Contact;
import com.springboot.addressbook.repository.ContactRepository;

@Transactional
@Service("contactService")
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;

   

    /**
     * Creates the contact.
     *
     * @param contact the contact
     * @return the contact
     */
    @Override
    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

   
    /**
     * Find all contacts.
     *
     * @return the list
     */
    @Override
    public List<Contact> findAllContacts() {
        return contactRepository.findAll();
    }

    

    /**
     * Update contact.
     *
     * @param contact the contact
     * @return the contact
     */
    @Override
    public Contact updateContact(Contact contact) {
        return contactRepository.save(contact);
    }

   
    /**
     * Delete contact.
     *
     * @param userId the user id
     */
    @Override
    public void deleteContact(Long userId) {
        contactRepository.deleteById(userId);

    }
}
