package pl.pollub.contacts.contacts.rest.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pollub.contacts.contacts.rest.dto.ContactDTO;
import pl.pollub.contacts.contacts.rest.dto.UserDTO;
import pl.pollub.contacts.contacts.rest.entity.Contact;
import pl.pollub.contacts.contacts.rest.entity.User;
import pl.pollub.contacts.contacts.rest.repository.ContactRepository;
import pl.pollub.contacts.contacts.rest.repository.UserRepository;
import pl.pollub.contacts.contacts.rest.service.ContactService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static pl.pollub.contacts.contacts.rest.converter.UserConverter.mapToUser;

@Service
public class ContactServiceImpl implements ContactService {


    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public ContactDTO add(ContactDTO contactDTO) throws ParseException {
        Contact contact = new Contact();
        BeanUtils.copyProperties(contactDTO, contact,"userId");
        userRepository.findById(contactDTO.getUserId()).ifPresent(u -> contact.setUserId(u));
        contactRepository.save(contact);
        return contactDTO;
    }

    @Override
    public List<ContactDTO> getAll() {
        List<ContactDTO> contacts = new ArrayList<>();
        contactRepository.findAll().forEach(contact -> {
            ContactDTO contactDTO = new ContactDTO();
            BeanUtils.copyProperties(contact, contactDTO);
            contacts.add(contactDTO);
        });
        return contacts;
    }

    @Override
    public ContactDTO get(Long id) {
        Optional<Contact> contact = contactRepository.findById(id);
        if (contact.isPresent()) {
            ContactDTO contactDTO = new ContactDTO();
            BeanUtils.copyProperties(contact.get(), contactDTO);
            return contactDTO;
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        contactRepository.findById(id).ifPresent(c -> contactRepository.delete(c));
    }
}