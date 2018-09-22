package pl.pollub.contacts.contacts.rest.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pollub.contacts.contacts.rest.dto.UserDTO;
import pl.pollub.contacts.contacts.rest.entity.User;
import pl.pollub.contacts.contacts.rest.repository.UserRepository;
import pl.pollub.contacts.contacts.rest.service.UserService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static pl.pollub.contacts.contacts.rest.converter.UserConverter.*;

@Service
public class UserServiceImpl implements UserService {

    public static final String DATE_PATTERN = "dd-MM-yyyy";
    public static final String MIN_DATE = "01-01-1918";
    public static final String MESSAGE_DATE_IS_INCORRECT = "Date is incorrect";

    @Autowired
    private UserRepository userRepository;

    public UserDTO add(UserDTO userDTO) throws ParseException {
        validateDate(userDTO);
        User user = userRepository.save(mapToUser(userDTO));
        userDTO.setId(user.getId());
        return userDTO;
    }

    private void validateDate(UserDTO userDTO) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_PATTERN);
        Date minDate = formatter.parse(MIN_DATE);
        if (userDTO.getBirthDate().before(minDate)) {
            throw new IllegalArgumentException(MESSAGE_DATE_IS_INCORRECT);
        }
    }

    public List<UserDTO> getAll() {
        List<UserDTO> users = new ArrayList<>();
        userRepository.findAll().forEach(user -> users.add(mapToUserDTO(user)));
        return users;
    }

    public UserDTO get(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return mapToUserDTO(user.get());
        }
        return null;
    }

    public void delete(Long id) {
        userRepository.findById(id).ifPresent(u -> userRepository.delete(u));
    }

    public List<UserDTO> findByBirthDateBetween(Date from, Date to) {
        List<UserDTO> users = new ArrayList<>();
        userRepository.findByBirthDateBetween(from, to).forEach(user -> mapToUserDTO(user));
        return users;
    }

    public List<UserDTO> findByEmailContaining(String email) {
        List<UserDTO> users = new ArrayList<>();
        userRepository.findByContactEmailContaining(email).forEach(user -> mapToUserDTO(user));
        return users;
    }

}