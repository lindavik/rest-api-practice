package com.lv.restapibase.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@RequiredArgsConstructor
public class Person {

    UUID uuid;
    Boolean survived;
    PassengerClass passengerClass; //eg, 3
    String title;
    String firstName;
    String surname;
    Sex sex;
    Integer age;
    Integer siblingsOrSpousesAboard;
    Integer parentsOrChildrenAboard;
    Double fare;

    public String getFullName() {
        return String.format("%s. %s %s", title, firstName, surname);
    }
}
