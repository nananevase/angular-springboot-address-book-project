package com.springboot.addressbook.service;

import java.util.List;

import com.springboot.addressbook.entity.Contact;

public interface ContactService {

    Contact createContact(Contact contact);

    Contact findUserById(Long userId);

    List<Contact> findAllUsers();

    Contact updateContact(Contact contact);

    void deleteContact(Long userId);
}
