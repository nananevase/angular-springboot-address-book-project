package com.springboot.addressbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.addressbook.entity.Contact;
import com.springboot.addressbook.repository.ContactRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service("contactService")
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;

    /**
     * Save a new user.
     * @param contact
     * @return
     */

    @Override
    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    /**
     * Find a user based in user ID.
     * @param userId
     * @return
     */

    @Override
    public Contact findUserById(Long id) {
        Optional<Contact> userOptional = contactRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        }
        return null;
    }

    /**
     * find all users in system.
     * @return
     */

    @Override
    public List<Contact> findAllUsers() {
        return contactRepository.findAll();
    }

    /**
     * Update a user based on user ID.
     * @param contact
     * @return
     */

    @Override
    public Contact updateContact(Contact contact) {
        return contactRepository.save(contact);
    }

    /**
     * Delete a user based on User ID.
     * @param userId
     */

    @Override
    public void deleteContact(Long userId) {
        contactRepository.deleteById(userId);

    }
}
