package pl.pollub.contacts.contacts.rest.service;

import pl.pollub.contacts.contacts.rest.dto.ContactDTO;
import pl.pollub.contacts.contacts.rest.dto.UserDTO;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface ContactService {
    ContactDTO add(ContactDTO contactDTO) throws ParseException;
    List<ContactDTO> getAll();
    ContactDTO get(Long id);
    void delete(Long id);

}