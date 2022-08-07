package yte.intern.springweb.validation;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Getter
@Setter
public class User {

    @NotBlank(message = "İsim boş olamaz")
    private String isim;
    @NotBlank
    private String soyisim;
    @Min(12)
    @Max(100)
    private Integer yas;
    @NotBlank
    @Email
    private String email;
    @PastOrPresent
    private LocalDateTime dogumTarihi;
    @Size(max = 250)
    private String adres;
    @NotBlank
    private String kullaniciAdi;

    @AssertTrue
    public boolean isKullaniciAdiGecerliMi() {
        return !kullaniciAdi.equals("admin");
    }

}
