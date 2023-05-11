package ru.academits.khudyakov.phonebookspring.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.academits.khudyakov.phonebookspring.model.Contact;
import ru.academits.khudyakov.phonebookspring.service.ContactService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ContactDao {
    private static final Logger logger = LoggerFactory.getLogger(ContactDao.class);
    private final List<Contact> contactList = new ArrayList<>();
    private final AtomicInteger idSequence = new AtomicInteger(0);

    public ContactDao() {
        Contact contact = new Contact();
        contact.setId(getNewId());
        contact.setFirstName("Иван");
        contact.setLastName("Иванов");
        contact.setPhone("9123456789");
        contactList.add(contact);
    }

    private int getNewId() {
        return idSequence.addAndGet(1);
    }

    public List<Contact> getAllContacts() {
        return contactList;
    }

    public void add(Contact contact) {
        contactList.add(contact);
    }

    public void removeContact(String phone) {
        phone = phone.replace("\"", "");

        for (Contact contact : contactList) {
            if (contact.getPhone().equals(phone)) {
                contactList.remove(contact);
                break;
            }
        }
    }
}
