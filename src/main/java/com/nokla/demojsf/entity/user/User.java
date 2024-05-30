package com.nokla.demojsf.entity.user;

import com.nokla.demojsf.entity.Address;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter @Setter @NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private @NotNull String username;

    @Column(nullable = false)
    private @NotNull String firstName;

    @Column(nullable = false)
    private @NotNull String lastName;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private @NotNull Date dateOfBirth;

    @Embedded
    private Address address;

    private String fathersName;

    private String mothersName;

    @Column(nullable = false, unique = true)
    @Pattern(regexp = "^01[3-9][0-9]{8}$", message = "Phone number not valid")
    private @NotNull String phoneNumber;

    @Column(nullable = false, unique = true)
    private @NotNull String email;


    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
