package com.addressbookapp.service;

import com.addressbookapp.model.AddressBook;
import com.addressbookapp.model.Contact;

public class AddressBookService {

    AddressBook addressBook = new AddressBook();

    public void addContact(Contact person) {
        addressBook.getContacts().add(person);
    }

    public void displayContacts() {

        for(Contact person : addressBook.getContacts()) {
            person.display();
            System.out.println("--------------------");
        }
    }
}