package com.nokla.demojsf.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter @Setter
public class OfficerDTO {
    private String name;
    private String officeName;
    private String roleName;
    private Boolean isActive;

    @Override
    public String toString() {
        return "OfficerDTO{" +
                "name='" + name + '\'' +
                ", officeName='" + officeName + '\'' +
                ", roleName='" + roleName + '\'' +
                ", active='" + isActive + '\'' +
                '}';
    }
}

