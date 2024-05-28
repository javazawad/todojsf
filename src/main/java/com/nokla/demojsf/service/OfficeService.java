package com.nokla.demojsf.service;

import com.nokla.demojsf.dto.OfficerDTO;
import com.nokla.demojsf.entity.user.Office;
import com.nokla.demojsf.entity.user.OfficeRole;
import com.nokla.demojsf.entity.user.Officer;
import jakarta.ejb.Stateless;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class OfficeService {
    @PersistenceContext
    EntityManager em;

    public List<Officer> getAllOfficers(){
        return em.createQuery("select o from Officer o", Officer.class).getResultList();
    }

    public List<Office> getAllOffices(){
        return em.createQuery("select o from Office o", Office.class).getResultList();
    }

    public Office getOfficeById(Long id){
        return em.find(Office.class, id);
    }

    public Officer getOfficerById(Long id){
        return em.find(Officer.class, id);
    }

    public List<OfficerDTO> getOfficerDTOS(){
        return em.createQuery("""
    select new com.nokla.demojsf.dto.OfficerDTO(o.officer.name, o.office.name, o.role.name, o.active)
    from OfficeRole o
""", OfficerDTO.class).getResultList();
    }






}
