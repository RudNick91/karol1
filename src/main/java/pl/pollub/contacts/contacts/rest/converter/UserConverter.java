package pl.pollub.contacts.contacts.rest.converter;

import org.springframework.beans.BeanUtils;
import pl.pollub.contacts.contacts.rest.dto.ContactDTO;
import pl.pollub.contacts.contacts.rest.dto.UserDTO;
import pl.pollub.contacts.contacts.rest.entity.Contact;
import pl.pollub.contacts.contacts.rest.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserConverter {
    public static final String CONTACT = "contact";
    public static UserDTO mapToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO,"contact");
        setContactDTO(user, userDTO);
        return userDTO;
    }

    private static void setContactDTO(User user, UserDTO userDTO) {
        List<ContactDTO> contacts = new ArrayList<>();
        user.getContact().forEach(contact -> {
            ContactDTO contactDto = new ContactDTO();
            BeanUtils.copyProperties(contact, contactDto);
            contactDto.setUserId(userDTO.getId());
            contacts.add(contactDto);
        });
        userDTO.setContact(contacts);
    }

    public static User mapToUser(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user, CONTACT);
        setContacts(userDTO, user);
        return user;
    }

    private static void setContacts(UserDTO userDTO, User user) {
        List<Contact> contacts = new ArrayList<>();
        userDTO.getContact().forEach(contactDTO -> {
            Contact contact = new Contact();
            BeanUtils.copyProperties(contactDTO, contact);
            contact.setUserId(user);
            contacts.add(contact);
        });
        user.setContact(contacts);
    }
}