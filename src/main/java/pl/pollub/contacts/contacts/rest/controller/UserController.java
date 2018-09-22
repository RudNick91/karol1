package pl.pollub.contacts.contacts.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.pollub.contacts.contacts.rest.dto.UserDTO;
import pl.pollub.contacts.contacts.rest.service.UserService;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public UserDTO add(@Valid @RequestBody UserDTO userDTO) throws ParseException {
        return userService.add(userDTO);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<UserDTO> getAll() {
        return userService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserDTO get(@PathVariable Long id) {
       return userService.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @RequestMapping(value = "/search/findByBirthDateBetween", method = RequestMethod.GET)
    public List<UserDTO> findByBirthDateBetween(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date from,
                                                @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date to) {

        return userService.findByBirthDateBetween(from,to);
    }

    @RequestMapping(value = "/search/findByEmail", method = RequestMethod.GET)
    public List<UserDTO> findByEmailContaining(@RequestParam String email) {
        return userService.findByEmailContaining(email);
    }
}