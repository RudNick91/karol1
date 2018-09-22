package pl.pollub.contacts.contacts.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.pollub.contacts.contacts.rest.dto.ContactDTO;
import pl.pollub.contacts.contacts.rest.service.ContactService;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(method = RequestMethod.GET)
    public List<ContactDTO> getAll() {
        return contactService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ContactDTO get(@PathVariable Long id) {
        return contactService.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        contactService.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ContactDTO add(@Valid @RequestBody ContactDTO contactDTO) throws ParseException {
        return contactService.add(contactDTO);
    }
}