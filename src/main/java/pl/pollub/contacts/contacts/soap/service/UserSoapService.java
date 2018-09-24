package pl.pollub.contacts.contacts.soap.service;

import pl.pollub.contacts.contacts.rest.dto.UserDTO;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.Date;
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface UserSoapService {
    @WebMethod
    UserDTO findByBirthDateBetween(Date from, Date to);
    @WebMethod
    UserDTO findByEmailContaining(String email);
}