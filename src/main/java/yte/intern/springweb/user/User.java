package yte.intern.springweb.user;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record User(@NotBlank String name,
                   @NotBlank String surname,
                   @Min(12) @Max(100) Long age,
                   @NotBlank @Email String email,
                   String tckn,
                   @PastOrPresent LocalDate birthDate,
                   @Size(min = 10, max = 250) String address,
                   @NotBlank String username) {

    @AssertTrue
    public boolean isUsernameValid() {
        return !username.equals("admin");
    }
}
