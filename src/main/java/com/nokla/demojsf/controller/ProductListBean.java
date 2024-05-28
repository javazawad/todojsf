package com.nokla.demojsf.controller;

import com.nokla.demojsf.dto.ProductCardDTO;
import com.nokla.demojsf.entity.Product;
import com.nokla.demojsf.service.ProductService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Named
@RequestScoped
public class ProductListBean {

    @Inject
    ProductService productService;
    @Getter
    private List<Product> products;
    @Getter
    private List<ProductCardDTO> productDTOs;


    @PostConstruct
    public void init(){
        try {
            products = productService.getProducts();
            productDTOs= productService.getProductDTOs();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void viewProduct(Long id){
        System.out.println("product id; "+ id);
        Optional<Product> product = productService.getById(id);
        if(product.isPresent()){
            System.out.println(product.get());
        } else {
            System.out.println("Product not found of id: "+id);
        }

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("productPage.xhtml");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

//        return "productPage.xhtml?faces-redirect=true";
    }




}
