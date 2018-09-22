package pl.pollub.contacts.contacts.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;

@Getter
@Setter
public class ContactDTO {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;
    private String phone;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long userId;
    @Email
    private String email;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
