package com.nokla.demojsf.service;

import com.nokla.demojsf.dto.ProductCardDTO;
import com.nokla.demojsf.entity.Manufacturer;
import com.nokla.demojsf.entity.Product;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;

@Stateless
public class ProductService {

    @PersistenceContext
    EntityManager em;


    public List<Product> getProducts(){
        return em.createQuery("select p from Product p", Product.class).getResultList();
    }

    public List<Manufacturer> getManufacturers(){
        return  em.createQuery("select m from Manufacturer m", Manufacturer.class).getResultList();
    }

    public List<ProductCardDTO> getProductDTOs(){
        List<ProductCardDTO> productCardList = em
                .createQuery("select new com.nokla.demojsf.dto.ProductCardDTO(p.id, p.title, p.price)" +
                        "from Product p", ProductCardDTO.class).getResultList();
        productCardList.forEach(System.out::println);
        return productCardList;
    }

    public void create(Product product){
        em.persist(product);
    }

    public Optional<Product> getById(Long id){
        return Optional.ofNullable(em.find(Product.class, id));
    }

}
