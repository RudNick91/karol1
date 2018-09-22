package pl.pollub.contacts.contacts.rest.repository;

import org.springframework.data.repository.CrudRepository;
import pl.pollub.contacts.contacts.rest.entity.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long> {

}
