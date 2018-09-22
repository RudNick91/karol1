package pl.pollub.contacts.contacts.rest.service;

import pl.pollub.contacts.contacts.rest.dto.UserDTO;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface UserService {
    UserDTO add(UserDTO userDTO) throws ParseException;
    List<UserDTO> getAll();
    UserDTO get(Long id);
    void delete(Long id);
    List<UserDTO> findByBirthDateBetween(Date from, Date to);
    List<UserDTO> findByEmailContaining(String email);
}