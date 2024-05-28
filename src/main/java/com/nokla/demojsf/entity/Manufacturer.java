package com.nokla.demojsf.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "manufacturer")
@Getter @Setter @NoArgsConstructor
public class Manufacturer {

    @Id
    @GeneratedValue
    private Long id;

    private @NotNull String name;

    private String phone;

    @Email
    private String email;

    @OneToMany(mappedBy = "manufacturer")
    private Set<Product> products;

    @Embedded
    private Address address;

    @Override
    public String toString() {
        return "Manufacturer{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
