package com.addressbookapp.service;

import com.addressbookapp.model.AddressBook;
import com.addressbookapp.model.Contact;
import org.springframework.stereotype.Service;

@Service
public class AddressBookService {

    AddressBook addressBook = new AddressBook();

    // UC2 – Add Contact
    public void addContact(Contact person) {
        addressBook.addContact(person);
        System.out.println("Contact Added Successfully");
    }

    // UC3 – Edit Contact
    public void editContact(String name, String newCity) {

        for(Contact person : addressBook.getContacts()) {
            if(person.getFirstName().equalsIgnoreCase(name)) {
                person.setCity(newCity);
                System.out.println("Contact Updated");
                return;
            }
        }

        System.out.println("Contact Not Found");
    }

    // UC4 – Delete Contact
    public void deleteContact(String name) {

        Contact toRemove = null;

        for(Contact person : addressBook.getContacts()) {
            if(person.getFirstName().equalsIgnoreCase(name)) {
                toRemove = person;
                break;
            }
        }

        if(toRemove != null) {
            addressBook.getContacts().remove(toRemove);
            System.out.println("Contact Deleted");
        } else {
            System.out.println("Contact Not Found");
        }
    }

    // UC5 – Display Multiple Contacts
    public void displayContacts() {

        if(addressBook.getContacts().isEmpty()) {
            System.out.println("No Contacts Found");
            return;
        }

        for(Contact person : addressBook.getContacts()) {
            person.display();
            System.out.println("----------------------");
        }
    }
}