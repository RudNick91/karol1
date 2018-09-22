package pl.pollub.contacts.contacts.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class UserDTO {

    private Long id;
    private String name;
    private String surname;
    private String gender;

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Past
    private Date birthDate;

    @Size(min = 10, max = 10)
    private String pesel;
    @Valid
    private List<ContactDTO> contact;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ContactDTO> getContact() {
        return contact;
    }

    public void setContact(List<ContactDTO> contact) {
        this.contact = contact;
    }

}
