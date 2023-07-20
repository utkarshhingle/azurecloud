package com.utk.azurecloud.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utk.azurecloud.dto.Contact;
import com.utk.azurecloud.dto.ContactForm;
import com.utk.azurecloud.respository.ContactRepository;

@RestController
@RequestMapping("/api")
public class ContactController {
    private final ContactRepository contactRepository;

    @Autowired
    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @PostMapping("/contact")
	@CrossOrigin(origins ="*")
    public ResponseEntity<Contact> contactFormSubmit(@RequestBody ContactForm contactForm) {
        String name = contactForm.getName();
        String email = contactForm.getEmail();
        String message = contactForm.getMessage();

        // Save the form data in the database
        Contact contact = new Contact(name, email, message);
        Contact savedContact = contactRepository.save(contact);

        return ResponseEntity.ok(savedContact);
    }
}
