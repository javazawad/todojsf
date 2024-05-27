package com.nokla.demojsf.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String email;

    @OneToMany(mappedBy = "manufacturer")
    List<Product> products;

    @Override
    public String toString() {
        String sb = "Manufacturer{" + "name='" + name + '\'' +
                '}';
        return sb;
    }
}
