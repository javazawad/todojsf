package com.nokla.demojsf.entity.user;

import com.nokla.demojsf.entity.Address;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    @OneToMany(mappedBy = "office")
    private List<OfficeRole> officerRoles;

    @Override
    public String toString() {
        return "Office{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", officerRole=" + officerRoles.stream().map(Objects::toString).collect(Collectors.joining(", ", "[ "," ]")) +
                '}';
    }
}
