package phoneBook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContactCrudService {
    private final List<Contact> contacts = new ArrayList<>();

    public ContactCrudService() {
    }

    public User getByCompany(String email) {
        Iterator<Contact> contacts = this.contacts.iterator();

        Contact contact;
        do {
            if (!contacts.hasNext()) {
                return null;
            }

            contact = contacts.next();
        } while(!contact.getUserName().equals(email));

        return contact.getUser();
    }

    public void create(User user) {
        this.contacts.add(new Contact(user.getCompany(), user));
    }

    public void read() {

        for (Contact contact : this.contacts) {
            System.out.println("Name: " + contact.getUserName());
            System.out.println("PhoneNumbers");
            for (String phoneNumber : contact.getUser().getPhoneNumbers()) {
                System.out.println(phoneNumber);
            }
        }

    }

    public void update(User user) {
        for (Contact contact : this.contacts) {
            if (contact.getUserName().equals(user.getCompany())) {
                this.contacts.remove(contact);
                this.contacts.add(new Contact(user.getCompany(), user));
            }
        }
    }

    public void delete(User user) {
        this.contacts.removeIf((contact) -> {
            return contact.getUser().equals(user);
        });
    }
}
