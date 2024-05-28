package com.nokla.demojsf.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter @Setter @NoArgsConstructor
public class Address {
    String city;
    String Country;
    String zipcode;

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", Country='" + Country + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}
