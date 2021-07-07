package yte.intern.springweb.controllers.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import yte.intern.springweb.controllers.validators.TcKimlikNo;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
public class User {

    @NotBlank(message = "İsim boş olamaz!")
    private String name;

    @NotBlank
    private String surname;

    @Min(value = 12, message = "Yaş 12'den küçük olamaz")
    @Max(value = 100)
    private Long age;

    @NotBlank
    @Email
    private String email;

    @PastOrPresent
    private LocalDate birthDate;

    @Size(max = 250)
    private String address;

    @NotBlank
    private String userName;

    @TcKimlikNo
    private String tcKimlikNo;

    @AssertTrue
    public boolean isNotAdmin() {
        return !userName.equals("admin");
    }
}
