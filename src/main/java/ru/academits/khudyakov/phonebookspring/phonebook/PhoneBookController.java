package ru.academits.khudyakov.phonebookspring.phonebook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.academits.khudyakov.phonebookspring.model.Contact;
import ru.academits.khudyakov.phonebookspring.model.ContactValidation;
import ru.academits.khudyakov.phonebookspring.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Controller
@RequestMapping("/phoneBook/rpc/api/v1")

public class PhoneBookController {
    private static final Logger logger = LoggerFactory.getLogger(PhoneBookController.class);

    private final ContactService contactService;

    public PhoneBookController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping(value = "getAllContacts", method = RequestMethod.GET)
    @ResponseBody
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @RequestMapping(value = "addContact", method = RequestMethod.POST)
    @ResponseBody
    public ContactValidation addContact(@RequestBody Contact contact) {
        return contactService.addContact(contact);
    }

    @RequestMapping(value = "removeContact", method = RequestMethod.POST)
    @ResponseBody
    public void removeContact(@RequestBody String phone) {
        phone = phone.replace("\"", "");
        contactService.removeContact(phone);
    }
}


