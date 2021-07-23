package task3.address;

import java.util.Objects;
import java.util.StringTokenizer;

class Address {
    //Один из возможных наборо полей
    private String country;
    private String region;
    private String city;
    private String street;
    private String house;
    private String building;
    private String flat;

    public Address() {
    }

    public void setFieldsSplit(String data){
        data = data.trim();
        String[] fields = data.split(",");
        if(fields.length != 7){
            throw new IllegalArgumentException();
        }
        country = fields[0];
        region = fields[1];
        city = fields[2];
        street = fields[3];
        house = fields[4];
        building = fields[5];
        flat = fields[6];
    }

    public void setFields(String data){
        data = data.trim();
        StringTokenizer stringTokenizer = new StringTokenizer(data, ",.;-");
        if(stringTokenizer.countTokens() != 7) throw new IllegalArgumentException();
        country = stringTokenizer.nextToken();
        region = stringTokenizer.nextToken();
        city = stringTokenizer.nextToken();
        street = stringTokenizer.nextToken();
        house = stringTokenizer.nextToken();
        building = stringTokenizer.nextToken();
        flat = stringTokenizer.nextToken();
    }

    public Address(String country, String region, String city, String street, String house, String building, String flat) {
        this.country = country;
        this.region = region;
        this.city = city;
        this.street = street;
        this.house = house;
        this.building = building;
        this.flat = flat;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", building='" + building + '\'' +
                ", flat='" + flat + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(country, address.country) && Objects.equals(region, address.region) && Objects.equals(city, address.city) && Objects.equals(street, address.street) && Objects.equals(house, address.house) && Objects.equals(building, address.building) && Objects.equals(flat, address.flat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, region, city, street, house, building, flat);
    }
}
