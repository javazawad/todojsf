package com.nokla.demojsf.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductCardDTO {
    private Long id;
    private @NotNull String title;
    private @NotNull double price;

    @Override
    public String toString() {
        return "ProductCardDTO{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
