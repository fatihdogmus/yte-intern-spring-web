package yte.intern.springweb.controllers.dto;

public class Kisi {
    private String isim;
    private String soyisim;
    private Long yas;

    public String getIsim() {
        return isim;
    }

    public void setIsim(final String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(final String soyisim) {
        this.soyisim = soyisim;
    }

    public Long getYas() {
        return yas;
    }

    public void setYas(final Long yas) {
        this.yas = yas;
    }

    public void yasArtir() {
        yas++;
    }
}
