package com.nokla.demojsf.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @Override
    public String toString() {
        String sb = "Product: " + "title='" + title + '\'' +
                ", description='" + description + '\'';
        if (manufacturer != null) {
            sb += ", manufacturer=" +  manufacturer.toString() + '\'';
        }
        return sb;
    }
}
