package com.nokla.demojsf.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String title;
    private String manufacturerName;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductDTO{");
        sb.append("title='").append(title).append('\'');
        sb.append(", manufacturerName='").append(manufacturerName).append('\'');
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
