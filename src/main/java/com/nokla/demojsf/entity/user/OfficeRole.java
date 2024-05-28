package com.nokla.demojsf.entity.user;

import jakarta.persistence.*;

@Entity
public class OfficeRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "officer_id")
    private Officer officer;

    @ManyToOne()
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne()
    @JoinColumn(name = "office_id")
    private Office office;

//    private Date startDate;
//
//    private Date endDate;

    private Boolean active;

    @Override
    public String toString() {
        return "OfficeRole{" +
                "officer=" + officer.getName() +
                ", role=" + role.getName() +
                ", office=" + office.getName() +
                '}';
    }
}
