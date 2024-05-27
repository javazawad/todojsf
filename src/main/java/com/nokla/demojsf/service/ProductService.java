package com.nokla.demojsf.service;

import com.nokla.demojsf.dto.ProductDTO;
import com.nokla.demojsf.entity.Product;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;

@Stateless
public class ProductService {
    @PersistenceContext
    private EntityManager em;


    public List<Product> getAllProducts() {
        return em.createQuery("select p from Product p", Product.class).getResultList();
    }

    public Product getProductById(Long id) {
        return em.find(Product.class, id);
    }

    public List<ProductDTO> getAllProductsDTO() {
        List<ProductDTO> productDTOs = em.createQuery(
                "select new com.nokla.demojsf.dto.ProductDTO(p.id, p.title, p.manufacturer.name)" +
                        "from Product p", ProductDTO.class
        ).getResultList();
        return productDTOs;
    }

    public Optional<ProductDTO> getProductsDTO(Long id) {
        ProductDTO productDTO = em.createQuery("""
                        select new com.nokla.demojsf.dto.ProductDTO(p.id, p.title, p.manufacturer.name) 
                        from Product p where p.id = :id
                        """,
                ProductDTO.class
        ).setParameter("id", id).getSingleResult();
        return Optional.ofNullable(productDTO);
    }
}
