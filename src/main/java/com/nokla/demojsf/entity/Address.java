package com.nokla.demojsf.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter @Setter
public class Address {
    private String city;
    private String country;
    private String zipcode;
}
