package pl.pollub.contacts.contacts.soap.service.impl;

import pl.pollub.contacts.contacts.rest.dto.UserDTO;
import pl.pollub.contacts.contacts.soap.service.UserSoapService;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebService(endpointInterface = "pl.pollub.contacts.contacts.soap.service.UserSoapService")
public class UserSoapServiceImpl implements UserSoapService {
    @Override
    public UserDTO findByBirthDateBetween(Date from, Date to) {
        List<UserDTO> users = new ArrayList<>();
        return new UserDTO();
    }
    @Override
    public UserDTO findByEmailContaining(String email) {
        List<UserDTO> users = new ArrayList<>();
        return new UserDTO();
    }

}