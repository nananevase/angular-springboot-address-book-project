package com.springboot.addressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.addressbook.entity.Contact;


@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
