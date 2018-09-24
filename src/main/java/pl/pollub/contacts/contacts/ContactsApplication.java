package pl.pollub.contacts.contacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.pollub.contacts.contacts.soap.service.UserSoapService;
import pl.pollub.contacts.contacts.soap.service.impl.UserSoapServiceImpl;

import javax.xml.ws.Endpoint;

@SpringBootApplication
public class ContactsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactsApplication.class, args);
        Endpoint.publish("http://localhost:8090/karol/", new UserSoapServiceImpl());
    }
}
