package jib.no.app.bsubstitutionc.domain;

public class HopsCountry {
    private String name = new String();
    private String country = new String();

    public HopsCountry(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }
}
