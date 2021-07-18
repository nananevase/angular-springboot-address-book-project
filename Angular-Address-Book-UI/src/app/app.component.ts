import { Component, OnInit } from '@angular/core';
import { Contacts } from './models/common';
import { ContactService } from './services/contact.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  contacts: Contacts[];
  addContactForm: boolean;
  editContactForm: boolean;
  newContact:any = {};
  isNewContact: boolean;
  editContact:any = {};
  title: string;

  constructor(private contactService: ContactService) { }

  ngOnInit() {
    this.getContacts();
  }

  getContacts() {
    this.contactService.getContacts().subscribe(data => {
      console.log(">>>>", data);
      this.contacts = data;
    })
  }

  showEditContactForm(contact: Contacts) {
    if (!contact) {
      this.addContactForm = false;
      return;
    }
    this.editContactForm = true;
    this.editContact = contact;
  }

  showAddContactForm() {
    // resets form if edited contact
    if (this.newContact.length) {
      this.newContact = {};
    }
    this.addContactForm = true;
    this.isNewContact = true;

  }

  createContact(contact: Contacts) {
    if (this.isNewContact) {
      // add a new contact
      this.contactService.addContacts(contact).subscribe(data =>{
        this.getContacts();
        console.log("Added user", data);
      })

    }
    this.addContactForm = false;
  }

  updateContact() {
    this.contactService.updateContacts(this.editContact).subscribe(data =>{
      this.getContacts();
      console.log("updated user", data);
    })
    this.editContactForm = false;
    this.editContact = {};
  }

  removeContact(contact: Contacts) {
    this.contactService.deleteContact(contact).subscribe(data =>{
      this.getContacts();
      console.log("updated user", data);
    })
  }

  cancelEdits() {
    this.editContact = {};
    this.editContactForm = false;
  }

  cancelNewContact() {
    this.newContact = {};
    this.editContactForm = false;
  }

}
