package data.json.jackson.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class Application {

    String name;
    @JsonProperty
    String surname;
    int age;
    List<Map<String, String>> phoneNumbers;
    Address addres;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Map<String, String>> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<Map<String, String>> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Address getAddres() {
        return addres;
    }

    public void setAddres(Address addres) {
        this.addres = addres;
    }
}

