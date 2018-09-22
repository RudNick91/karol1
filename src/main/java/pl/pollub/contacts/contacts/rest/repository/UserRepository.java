package pl.pollub.contacts.contacts.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import pl.pollub.contacts.contacts.rest.entity.User;

import java.util.Date;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    public List<User> findByBirthDateBetween(@Param("from") @DateTimeFormat(pattern = "yyyy-MM-dd") Date from,
                                             @Param("to") @DateTimeFormat(pattern = "yyyy-MM-dd") Date to);
    public List<User> findByContactEmailContaining(String email);
}
