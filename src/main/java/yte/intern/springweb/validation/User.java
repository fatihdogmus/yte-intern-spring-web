package yte.intern.springweb.validation;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record User(@NotBlank(message = "İsim boş olamaz")
                   String isim,
                   @NotBlank
                   String soyisim,
                   @Min(12)
                   @Max(100)
                   Integer yas,
                   @NotBlank
                   @Email
                   String email,
                   @PastOrPresent
                   LocalDateTime dogumTarihi,
                   @Size(max = 250)
                   String adres,
                   @NotBlank
                   String kullaniciAdi) {


    @AssertTrue
    public boolean isKullaniciAdiGecerliMi() {
        return !kullaniciAdi.equals("admin");
    }

}
