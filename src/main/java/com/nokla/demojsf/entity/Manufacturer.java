package com.nokla.demojsf.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private @NotNull String name;
    private String phone;
    private String email;
    @Embedded
    private Address address;

    @OneToMany(mappedBy = "manufacturer")
    List<Product> products;

    @Override
    public String toString() {
        return "Manufacturer{" + "name='" + name + '\'' +
                '}';
    }
}
