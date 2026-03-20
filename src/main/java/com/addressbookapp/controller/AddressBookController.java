package com.addressbookapp.controller;

import com.addressbookapp.model.Contact;
import com.addressbookapp.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    AddressBookService service;
    
    @GetMapping("/greet")
    public String greet() {
        return "Welcome to Address Book Application";
    }

    @PostMapping("/create/{name}")
    public String createAddressBook(@PathVariable String name) {
        return service.createAddressBook(name);
    }

    @GetMapping("/select/{name}")
    public String selectAddressBook(@PathVariable String name) {
        return service.selectAddressBook(name);
    }

    @PostMapping("/add")
    public String addContact(@RequestBody Contact person) {
        return service.addContact(person);
    }

    @PutMapping("/edit/{name}")
    public String editContact(@PathVariable String name,
                              @RequestBody Contact updatedPerson) {
        return service.editContact(name, updatedPerson);
    }

    @DeleteMapping("/delete/{name}")
    public String deleteContact(@PathVariable String name) {
        return service.deleteContact(name);
    }

    @GetMapping("/contacts")
    public Object displayContacts() {
        return service.displayContacts();
    }

    @GetMapping("/all")
    public Object displayAddressBooks() {
        return service.displayAddressBooks();
    }
}